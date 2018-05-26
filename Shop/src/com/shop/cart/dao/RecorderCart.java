package com.shop.cart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.shop.base.dao.Recorder;
import com.shop.cart.model.Cart;
import com.shop.cart.model.CartItem;
import com.shop.user.dao.RecorderUser;
import com.shop.user.model.User;

public class RecorderCart extends Recorder{
	public static boolean addCart(Cart cart) {
		String sql="insert into cart (cartID,userID,time) values(?,?,?);";
		java.sql.Date time=new java.sql.Date(cart.getTime().getTime());
		return operationDataBase(sql,cart.getId(),cart.getUser().getId(),time);
	}
	public static boolean deleteCart(Cart cart) {
		String sql="delete from cart where cartID=?";
		return operationDataBase(sql,cart.getId());
	}
	public static Cart getCart(long cartID) {
		Cart cart=null;
		String sql="SELECT * FROM cart WHERE cartID=?";
		ResultSet rs=getResultSet(sql,cartID);
		
		String userID=null;
		java.util.Date time=null;
		
		try {
			if(rs.next()) {
				userID=rs.getString("userID");
				time=rs.getDate("time");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		if(userID!=null&&time!=null) {
			User user=RecorderUser.getUser(userID);
			cart=new Cart();
			cart.setId(cartID);
			cart.setUser(user);
			cart.setTime(time);
		}
		//获取购物车内所有的条目
		ArrayList<Long>cartItemIDs=new ArrayList<>();
		Map<Long, CartItem> cartItems=new LinkedHashMap<>();
		sql="SELECT cartItemID FROM cartItem WHERE cartID=?";
		rs=getResultSet(sql,cart.getId());
		try {
			while(rs.next()) {
				cartItemIDs.add(rs.getLong("cartItemID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(long cartItemID:cartItemIDs) {
			CartItem cartItem=RecorderCartItem.getCartItem(cartItemID);
			cartItems.put(cartItemID, cartItem);
		}
		cart.setCartItems(cartItems);
		
		return cart;
	}
	public static boolean alterCart(Cart cart) {
		
		LinkedHashMap<Long,CartItem> cartItems=(LinkedHashMap<Long, CartItem>) cart.getCartItems();
		boolean flag=true;
		
		for(CartItem cartItem:cartItems.values()) {
			if(RecorderCartItem.isExist(cartItem.getId()))
				flag=flag&&RecorderCartItem.alterCartItem(cartItem);
			else
				flag=flag&&RecorderCartItem.addCartItem(cartItem, cart.getId());
		}
		
		return flag;
	}
}