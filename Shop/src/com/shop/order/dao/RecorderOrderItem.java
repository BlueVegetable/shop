package com.shop.order.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.shop.base.dao.Recorder;
import com.shop.goods.dao.RecorderGoods;
import com.shop.goods.model.Goods;
import com.shop.order.model.OrderItem;
import com.shop.user.dao.RecorderUser;
import com.shop.user.model.User;

public class RecorderOrderItem extends Recorder{
	public static boolean addOrderItem(OrderItem orderItem,long orderID) {
		String sql="INSERT INTO orderItem VALUES(?,?,?,?,?,?,?)";
		List<Object>list=new ArrayList<>();
		list.add(orderItem.getId());
		list.add(orderItem.getTime());
		list.add(orderID);
		list.add(orderItem.getUser().getId());
		list.add(orderItem.getGoods().getId());
		list.add(orderItem.getGoodsNumber());
		list.add(orderItem.getAddress());
		return operationDataBase(sql,list);
	}
	public static boolean deleteOrderItem(long orderItemID) {
		String sql="delete from orderItem where orderItemID=?";
		return operationDataBase(sql,orderItemID);
	}
	public static OrderItem getOrderItemsByItemID(long orderItemID) {
		OrderItem orderItem=null;
		long goodsID=-1;
		String userID=null;
		String sql="SELECT * FROM orderItem WHERE orderItemID=?";
		ResultSet rs=getResultSet(sql,orderItemID);
		try {
			if(rs.next()) {
				orderItem=new OrderItem();
				orderItem.setAddress(rs.getString("address"));
				orderItem.setId(rs.getLong("orderItemID"));
				orderItem.setTime(rs.getDate("time"));
				orderItem.setGoodsNumber(rs.getInt("goodsNumber"));
				goodsID=rs.getLong("goodsID");
				userID=rs.getString("userID");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		
		if(goodsID!=-1&&userID!=null)
		{
			Goods goods=RecorderGoods.getGoods(goodsID);
			User user=RecorderUser.getUser(userID);
			orderItem.setGoods(goods);
			orderItem.setUser(user);
		}
		
		return orderItem;
	}
	public static boolean alterOrderItem(OrderItem orderItem,long orderID){
		String sql="UPDATE orderItem SET TIME=?,orderID=?,userID=?,goodsID=?,goodsNumber=?,address=?" + 
				"WHERE orderItemID=?";
		List<Object>list=new ArrayList<>();
		list.add(orderItem.getTime());
		list.add(orderID);
		list.add(orderItem.getUser().getId());
		list.add(orderItem.getGoods().getId());
		list.add(orderItem.getGoodsNumber());
		list.add(orderItem.getAddress());
		list.add(orderItem.getId());
		return operationDataBase(sql,list);
	}
	public static boolean isExist(OrderItem orderItem) {
		boolean success=false;
		String sql="SELECT orderItemID FROM orderItem WHERE orderItemID=?";
		ResultSet rs=getResultSet(sql,orderItem.getId());
		try {
			if(rs.next()) {
				success=true;
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		return success;
	}
	public static LinkedHashMap<Long,OrderItem> getOrderItemByOrderID(long orderID){
		LinkedHashMap<Long,OrderItem>orderItems=new LinkedHashMap<Long,OrderItem>();
		ArrayList<Long>orderItemIDs=new ArrayList<>();
		
		String sql="SELECT orderItemID FROM orderItem WHERE orderID=?";
		ResultSet rs=getResultSet(sql,orderID);
		try {
			while(rs.next())
				orderItemIDs.add(rs.getLong("orderItemID"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		
		for(Long orderItemID:orderItemIDs) {
			OrderItem orderItem=getOrderItemsByItemID(orderItemID);
			orderItems.put(orderItemID, orderItem);
		}
		
		return orderItems;
	}
}