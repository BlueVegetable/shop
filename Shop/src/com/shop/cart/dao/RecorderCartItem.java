package com.shop.cart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.shop.base.dao.Recorder;
import com.shop.cart.model.CartItem;
import com.shop.goods.dao.RecorderGoods;
import com.shop.goods.model.Goods;

public class RecorderCartItem extends Recorder{
	public static boolean addCartItem(CartItem cartItem,long cartID) {
		String sql="INSERT INTO cartItem (cartItemID,goodsID,goodsNumber,cartID) VALUES(?,?,?,?)";
		List<Object>list=new ArrayList<>();
		list.add(cartItem.getId());
		list.add(cartItem.getGoods().getId());
		list.add(cartItem.getNumber());
		list.add(cartID);
		return operationDataBase(sql,list);
	}
	public static boolean deleteCartItem(long cartItemID) {
		String sql="delete from cartItem where cartItemID=?";
		return operationDataBase(sql,cartItemID);
	}
	public static CartItem getCartItem(long cartItemID) {
		CartItem cartItem=null;
		long goodsID=0;
		
		String sql="SELECT * FROM cartItem WHERE cartItemID=?";
		ResultSet rs=getResultSet(sql,cartItemID);
		try {
			if(rs.next()) {
				cartItem=new CartItem();
				cartItem.setId(cartItemID);
				cartItem.setNumber(rs.getInt("goodsNumber"));
				goodsID=rs.getLong("goodsID");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		Goods goods=RecorderGoods.getGoods(goodsID);
		cartItem.setGoods(goods);
		
		return cartItem;
	}
	public static boolean alterCartItem(CartItem cartItem) {
		String sql="UPDATE cartItem SET goodsNumber=? WHERE cartItemID=?";
		return operationDataBase(sql,cartItem.getNumber(),cartItem.getId());
	}
	public static boolean isExist(long cartItemID) {
		String sql="SELECT * FROM cartItem WHERE cartItemID=?";
		ResultSet rs=getResultSet(sql,cartItemID);
		try {
			if(rs.next())
				return true;
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		return false;
	}
}