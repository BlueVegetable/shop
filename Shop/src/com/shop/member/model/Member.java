package com.shop.member.model;

import com.shop.role.model.Role;
import com.shop.user.model.User;

/**
 * 此类并不在数据库中，只是为了可以更好地将用户于角色关联起来
 * 并且，如果有权限的话，还可以将权限与角色关联，并且封装
 */
public class Member {
	private User user;
	private Role role;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Member [user=" + user + "\nrole=" + role + "]";
	}
}