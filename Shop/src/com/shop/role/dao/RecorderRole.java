package com.shop.role.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.base.dao.Recorder;
import com.shop.role.model.Role;
import com.shop.user.model.User;

public class RecorderRole extends Recorder{
	public static boolean addRole(User user,Role role) {
		String sql="INSERT INTO user_role(user_id,role_id) VALUES(?,?)";
		return operationDataBase(sql,user.getId(),role.getId());
	}
	public static boolean deleteRole(String userID) {
		String sql="delete from user_role where user_id=?";
		return operationDataBase(sql,userID);
	}
	public static Role getRole(String userID) {
		String sql="SELECT * FROM role WHERE id IN(SELECT role_id FROM user_role WHERE user_id=?)";
		ResultSet rs=getResultSet(sql,userID);
		Role role=null;
		try {
			if(rs.next()) {
				role=new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				role.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDataBase();
		}
		return role;
	}
	public static boolean alterRole(String userID,Role role) {
		String sql="UPDATE user_role SET role_id=? WHERE user_id=?";
		return operationDataBase(sql,role.getId(),userID);
	}
}