package com.shop.order.model;

import java.util.LinkedHashMap;

import com.shop.order.OrderStatus;
import com.shop.user.model.User;

public class Order {
	private long id;
	private User user;
	private String address;
	private java.util.Date time;
	private OrderStatus status;
	private LinkedHashMap<Long,OrderItem>orderItems;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public java.util.Date getTime() {
		return time;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}
	public LinkedHashMap<Long, OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(LinkedHashMap<Long, OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", address=" + address + ", time=" + time + ", status=" + status
				+ ", orderItems=" + orderItems + "]";
	}
}