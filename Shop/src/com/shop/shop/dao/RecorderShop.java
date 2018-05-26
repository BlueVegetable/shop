package com.shop.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.shop.base.dao.Recorder;
import com.shop.goods.dao.RecorderGoods;
import com.shop.goods.model.Goods;
import com.shop.member.dao.RecorderMember;
import com.shop.member.model.Member;
import com.shop.shop.model.Shop;
import com.shop.user.model.User;

public class RecorderShop extends Recorder{
	public static boolean addShop(Goods goods,User user) {
		if(isExist(user.getId()))
			return false;
		String sql="INSERT INTO shop (id,NAME,register,userID) VALUES(?,?,?,?)";
		List<Object>list=new ArrayList<>();
		list.set(1, System.currentTimeMillis());
		list.set(2, goods.getName());
		list.set(3, false);
		list.set(4, user.getId());
		return operationDataBase(sql,list);
	}
	public static boolean deleteShop(String userID) {
		String sql="DELETE FROM shop WHERE userID =?";
		return operationDataBase(sql,userID);
	}
	public static Shop getShopByUserID(String userID) {
		String sql="SELECT * FROM shop WHERE userID=? and register=true";
		Shop shop=null;
		ResultSet rs=getResultSet(sql,userID);
		try {
			if(rs.next()) {
				shop=new Shop();
				shop.setId(rs.getLong("id"));
				shop.setName(rs.getString("name"));
				shop.setRegister(rs.getBoolean("register"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		if(shop!=null) {
			shop.setShopper(RecorderMember.getMember(userID));
		}
		
		shop.setCommodities(getAllCommodities(shop.getId()));
		
		return shop;
	}
	private static LinkedHashMap<Long,Goods> getAllCommodities(long shopID){
		ArrayList<Long>goodsIDs=new ArrayList<>();
		LinkedHashMap<Long,Goods> commodities=new LinkedHashMap<>();
		String sql="SELECT * FROM goods WHERE shopID=?";
		ResultSet rs=getResultSet(sql,shopID);
		try {
			while(rs.next()) {
				goodsIDs.add(rs.getLong("shopID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		for(Long goodsID:goodsIDs) {
			commodities.put(goodsID,RecorderGoods.getGoods(goodsID));
		}
		return commodities;
	}
	public static Shop getShop(long shopID) {
		Shop shop=null;
		String sql="SELECT * FROM shop WHERE id=?";
		String userID=null;
		ResultSet rs=getResultSet(sql,shopID);
		try {
			if(rs.next()) {
				shop=new Shop();
				shop.setId(rs.getLong("id"));
				shop.setName(rs.getString("name"));
				shop.setRegister(rs.getBoolean("register"));
				userID=rs.getString("userID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		if(userID!=null)
		{
			Member member=RecorderMember.getMember(userID);
			shop.setShopper(member);
		}
		if(shop!=null)
			shop.setCommodities(getAllCommodities(shop.getId()));
		
		return shop;
	}
	public static boolean alterShop(Shop shop) {
		String sql="UPDATE shop SET NAME=?,register=? WHERE id=?";
		return operationDataBase(sql,shop.getName(),shop.isRegister(),shop.getId());
	}
	public static boolean setRegister(long shopID,boolean register) {
		String sql="update shop set register=? where id=?";
		return operationDataBase(sql,register,shopID);
	}
	public static boolean isExist(String userID) {
		String sql="SELECT id FROM shop WHERE userID=?";
		ResultSet rs=getResultSet(sql,userID);
		try {
			if(rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		return false;
	}
	public static ArrayList<Shop> getAllUnRegisterShop() {
		ArrayList<Shop> shops=new ArrayList<Shop>();
		ArrayList<Long> shopIDs=new ArrayList<>();
		Shop shop=null;
		
		String sql="SELECT id FROM shop WHERE register=FALSE";
		ResultSet rs=getResultSet(sql);
		try {
			while(rs.next()) {
				shopIDs.add(rs.getLong("id"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		
		for(long shopID:shopIDs) {
			shop=getShop(shopID);
			shops.add(shop);
		}
		
		return shops;
	}
}