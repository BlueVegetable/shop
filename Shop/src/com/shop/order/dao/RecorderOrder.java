package com.shop.order.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.shop.base.dao.Recorder;
import com.shop.order.OrderStatus;
import com.shop.order.model.Order;
import com.shop.order.model.OrderItem;
import com.shop.user.dao.RecorderUser;
import com.shop.user.model.User;

public class RecorderOrder extends Recorder{
	public static boolean addOrder(Order order) {
		boolean success=true;
		LinkedHashMap<Long,OrderItem> orderItems=order.getOrderItems();
		String sql="INSERT INTO orders (orderID,userID,address,TIME,status) VALUES(?,?,?,?,?)";
		List<Object>list=new ArrayList<>();
		list.add(order.getId());
		list.add(order.getUser().getId());
		list.add(order.getAddress());
		list.add(new java.sql.Date(order.getTime().getTime()));
		list.add(OrderStatus.getStatusData(order.getStatus()));
		success=success&&operationDataBase(sql,list);
		
		for(OrderItem orderItem:orderItems.values())
			success=success&&RecorderOrderItem.addOrderItem(orderItem, order.getId());
		
		return success;
	}
	public static boolean deleteOrder(long orderID) {
		String sql="DELETE FROM orders WHERE orderID=?";
		return operationDataBase(sql,orderID);
	}
	public static boolean alterOrder(Order order) {
		String sql="update orders set orderID=?,userID=?,address=?,time=? WHERE orderID=?";
		List<Object>list=new ArrayList<>();
		list.add(order.getId());
		list.add(order.getUser().getId());
		list.add(order.getAddress());
		list.add(new java.sql.Date(order.getTime().getTime()));
		list.add(order.getId());
		return operationDataBase(sql,list);
	}
	public static boolean alterOrderStatus(Order order) {
		String sql="update orders set status=? where orderID=?";
		return operationDataBase(sql, OrderStatus.getStatusData(order.getStatus()),order.getId());
	}
	public static boolean alterOrderItems(Order order) {
		Map<Long,OrderItem> orderItems=order.getOrderItems();
		boolean success=true;
		for(OrderItem orderItem:orderItems.values()) {
			success=success&&RecorderOrderItem.alterOrderItem(orderItem, order.getId());
		}
		return success;
	}
	public static Order getOrder(long orderID) {
		Order order=null;
		String userID=null;
		User user=null;
		
		String sql="SELECT * FROM orders WHERE orderID=?";
		ResultSet rs=getResultSet(sql,orderID);
		try {
			if(rs.next()) {
				order=new Order();
				order.setId(rs.getLong("orderID"));
				order.setAddress(rs.getString("address"));
				order.setTime(rs.getDate("time"));
				order.setStatus(OrderStatus.getStatusKey(rs.getInt("status")));
				userID=rs.getString("userID");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		if(userID!=null)
			user=RecorderUser.getUser(userID);
		order.setUser(user);
		
		//获取订单所包含的所有订单条目
		ArrayList<Long>orderItemIDs=new ArrayList<>();
		LinkedHashMap<Long,OrderItem>orderItems=new LinkedHashMap<>();
		sql="SELECT orderItemID FROM orderItem WHERE orderID=?";
		rs=getResultSet(sql,orderID);
		try {
			while(rs.next()) {
				orderItemIDs.add(rs.getLong("orderItemID"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		
		for(long orderItemID:orderItemIDs) {
			OrderItem orderItem=RecorderOrderItem.getOrderItemsByItemID(orderItemID);
			orderItems.put(orderItemID, orderItem);
		}
		order.setOrderItems(orderItems);
		
		return order;
	}
}