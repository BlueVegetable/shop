package com.shop.role.model;

public class Role {
	private int id;
	private String name;
	private String title;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public static Role getRole(int roleID) {
		String name="user";
		String title="用户";
		switch(roleID)
		{
		case 2:name="manager";title="商家";break;
		case 3:name="admin";title="管理员";break;
		default:roleID=1;
		}
		Role role=new Role();
		role.setId(roleID);
		role.setName(name);
		role.setTitle(title);
		return role;
	}
	public static Role getRole(String roleTitle) {
		int id=1;
		String name="user";
		switch(roleTitle)
		{
		case "商家":name="manager";id=2;break;
		case "管理员":name="admin";id=3;break;
		default:roleTitle="用户";
		}
		Role role=new Role();
		role.setId(id);
		role.setName(name);
		role.setTitle(roleTitle);
		return role;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", title=" + title + "]";
	}
}