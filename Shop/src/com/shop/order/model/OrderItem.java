package com.shop.order.model;

import com.shop.goods.model.Goods;
import com.shop.user.model.User;

public class OrderItem {
	private long id;
	private User user;
	private String address;
	private java.util.Date time;
	private int goodsNumber;
	private Goods goods;
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public String toString() {
		return "OrderItem [id=" + id + ", user=" + user + ", address=" + address + ", time=" + time + ", goodsNumber="
				+ goodsNumber + ", goods=" + goods + "]";
	}
}