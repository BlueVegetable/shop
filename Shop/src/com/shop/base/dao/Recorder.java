package com.shop.base.dao;

import java.sql.*;
import java.util.List;


/**
 * 
 * @author blueVegetable
 * 最基础的dao包
 *
 */
public class Recorder {
	protected static Connection connection=null;
	protected static PreparedStatement psmt=null;
	
	private final static String URL="jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private final static String USER_NAME="root";
	private final static String PASSWORD="Liao145803124.";
	
	protected static boolean linkDataBase() {
		try {
			connection=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection!=null;
	}
	protected static boolean closeDataBase() {
		
		try {
			if(connection!=null) {
				connection.close();
			}
			if(psmt!=null) {
				psmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	protected static boolean operationDataBase(String sql,List<Object>list) {
		linkDataBase();
		try {
			psmt=connection.prepareStatement(sql);
			for(int i=0;i<list.size();i++) {
				psmt.setObject(i+1, list.get(i));
			}
			if(psmt.executeUpdate()>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		return false;
	}
	protected static boolean operationDataBase(String sql,Object...parameter) {
		linkDataBase();
		try {
			psmt=connection.prepareStatement(sql);
			for(int i=0;i<parameter.length;i++)
				psmt.setObject(i+1, parameter[i]);
			if(psmt.executeUpdate()>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		return false;
	}
	protected static ResultSet getResultSet(String sql,List<Object>list) {
		linkDataBase();
		ResultSet rs=null;
		try {
			psmt=connection.prepareStatement(sql);
			for(int i=0;i<list.size();i++) {
				psmt.setObject(i+1, list.get(i));
			}
			rs=psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	protected static ResultSet getResultSet(String sql,Object...parameter) {
		linkDataBase();
		ResultSet rs=null;
		try {
			psmt=connection.prepareStatement(sql);
			for(int i=0;i<parameter.length;i++)
				psmt.setObject(i+1, parameter[i]);
			rs=psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}