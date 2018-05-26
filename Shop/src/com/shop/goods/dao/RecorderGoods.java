package com.shop.goods.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.shop.base.dao.Recorder;
import com.shop.goods.model.Goods;
import com.shop.shop.model.Shop;
import com.shop.user.dao.RecorderUser;
import com.shop.user.model.User;

public class RecorderGoods extends Recorder {
	public static boolean addGoods(Shop shop,Goods goods) {
		String sql="INSERT INTO goods(id,NAME,price,image,info,variety,register,amount,buyNumber,shopID)" + 
				"VALUES(?,?,?,?,?,?,?,?,?,0)";
		List<Object>list=new ArrayList<>();
		list.add(goods.getId());
		list.add(goods.getName());
		list.add(goods.getPrice());
		list.add(goods.getImage());
		list.add(goods.getInfo());
		list.add(goods.getVariety());
		list.add(false);
		list.add(goods.getAmount());
		list.add(0);
		list.add(shop.getId());
		return operationDataBase(sql,list);
	}
	public static boolean deleteGoods(long goodsID) {
		String sql="DELETE FROM goods WHERE id=?";
		return operationDataBase(sql,goodsID);
	}
	public static Map<Long,Goods>getAllRegistedGoods(long shopID){
		LinkedHashMap<Long,Goods>allRegistedGoods=new LinkedHashMap<>();
		Goods goods;
		
		String sql="SELECT * FROM goods WHERE shopID=? AND register=TRUE";
		ResultSet rs=getResultSet(sql,shopID);
		try {
			while(rs.next())
			{
				goods=new Goods();
				goods.setId(rs.getLong("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setImage(rs.getString("image"));
				goods.setInfo(rs.getString("info"));
				goods.setVariety(rs.getString("variety"));
				goods.setRegister(rs.getBoolean("register"));
				goods.setBuyNumber(rs.getInt("buyNumber"));
				goods.setAmount(rs.getInt("amount"));
				
				allRegistedGoods.put(goods.getId(), goods);
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		
		return allRegistedGoods;
	}
	/**
	 * 不能够使用父类的方法
	 * @param shopID
	 * @return
	 */
	public static Map<Goods,User>getAllUnRegistedGoods(long shopID){
		LinkedHashMap<Goods,User>allUnRegistedGoods=new LinkedHashMap<>();
		ArrayList<Goods>merchandises=new ArrayList<>();
		ArrayList<String>userIDs=new ArrayList<>();
		
		Goods goods;
		
		linkDataBase();
		String sql="SELECT * FROM goods WHERE register=false";
		
		try {
			psmt=connection.prepareStatement(sql);
			ResultSet rs=psmt.executeQuery();
			
			while(rs.next())
			{
				goods=new Goods();
				goods.setId(rs.getLong("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setImage(rs.getString("image"));
				goods.setInfo(rs.getString("info"));
				goods.setVariety(rs.getString("variety"));
				goods.setRegister(rs.getBoolean("register"));
				goods.setBuyNumber(rs.getInt("buyNumber"));
				goods.setAmount(rs.getInt("amount"));
				merchandises.add(goods);
			}
			rs.close();
			
			/**
			 * 获取商品所属的用户
			 */
			sql="SELECT userID FROM shop WHERE id IN(SELECT shopID FROM goods WHERE id=?)";
			for(Goods merchandise:merchandises) {
				String userID = null;
				psmt=connection.prepareStatement(sql);
				psmt.setLong(1, merchandise.getId());
				rs=psmt.executeQuery();
				if(rs.next())
					userID=rs.getString("userID");
				userIDs.add(userID);
			}
			rs.close();
			closeDataBase();
			
			for(int i=0;i<userIDs.size();i++) {
				String userID=userIDs.get(i);
				User user=RecorderUser.getUser(userID);
				allUnRegistedGoods.put(merchandises.get(i), user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allUnRegistedGoods;
	}
	public static Goods getGoods(long goodsID) {
		String sql="SELECT * FROM goods WHERE id=?";
		Goods goods=null;
		ResultSet rs=getResultSet(sql,goodsID);
		try {
			if(rs.next()) {
				goods=new Goods();
				goods.setId(goodsID);
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setImage(rs.getString("image"));
				goods.setInfo(rs.getString("info"));
				goods.setVariety(rs.getString("variety"));
				goods.setRegister(rs.getBoolean("register"));
				goods.setAmount(rs.getInt("amount"));
				goods.setBuyNumber(rs.getInt("buyNumber"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		return goods;
	}
	public static boolean alterGoods(Goods goods) {
		String sql="UPDATE goods SET NAME=?,price=?,image=?,"
				+ "info=?,variety=?,register=?,amount=?,buyNumber=? WHERE id=?";
		List<Object>list=new ArrayList<>();
		list.add(goods.getName());
		list.add(goods.getPrice());
		list.add(goods.getId());
		list.add(goods.getInfo());
		list.add(goods.getVariety());
		list.add(goods.isRegister());
		list.add(goods.getAmount());
		list.add(goods.getBuyNumber());
		list.add(goods.getId());
		return operationDataBase(sql,list);
	}
	public static boolean setRegister(long goodsID,boolean register) {
		String sql="UPDATE goods SET register=? WHERE id=?";
		return operationDataBase(sql,register,goodsID);
	}
}