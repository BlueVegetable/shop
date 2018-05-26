package com.shop.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.shop.base.dao.Recorder;
import com.shop.user.model.User;

public class RecorderUser extends Recorder{
	public static User getUser(String userID) {
		String sql="SELECT * FROM USER WHERE id=?";
		ResultSet rs=getResultSet(sql,userID);
		User user=null;
		
		try {
			if(rs!=null&&rs.next()) {
				user=new User();
				user.setId(userID);
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getString("phoneNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		
		return user;
	}
	public static boolean isExit(String userID) {
		String sql="SELECT id FROM USER WHERE id=?";
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
	/**
	 * 增加用户，密码不会加密
	 * @param user
	 * @return
	 */
	public static boolean addUser(User user) {
		String sql="INSERT INTO USER(id,NAME,PASSWORD,gender,email,phoneNumber) VALUES"
				+ "(?,?,?,?,?,?)";
		List<Object>list=new ArrayList<>();
		list.add(user.getId());
		list.add(user.getName());
		list.add(user.getPassword());
		list.add(user.getGender());
		list.add(user.getEmail());
		list.add(user.getPhoneNumber());
		return operationDataBase(sql, list);
	}
	public static boolean deleteUser(String userID) {
		String sql="DELETE FROM USER WHERE id=?";
		return operationDataBase(sql,userID);
	}
	public static boolean alterUser(User user) {
		String sql="UPDATE USER SET id=?,NAME=?,PASSWORD=?,"
				+ "gender=?,email=?,phoneNumber=? WHERE id=?";
		List<Object>list=new ArrayList<>();
		list.add(user.getId());
		list.add(user.getName());
		list.add(user.getPassword());
		list.add(user.getGender());
		list.add(user.getEmail());
		list.add(user.getPhoneNumber());
		list.add(user.getId());
		return operationDataBase(sql, list);
	}
	public static boolean alterPassword(String userID,String password) {
		String sql="UPDATE USER SET PASSWORD=MD5(?) WHERE id=?";
		return operationDataBase(sql,password,userID);
	}
}