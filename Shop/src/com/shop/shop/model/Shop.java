package com.shop.shop.model;

import java.util.LinkedHashMap;

import com.shop.goods.model.Goods;
import com.shop.member.model.Member;

public class Shop {
	private long id;
	private String name;
	private Member shopper;
	private LinkedHashMap<Long,Goods> commodities;
	private boolean register;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Member getShopper() {
		return shopper;
	}
	public void setShopper(Member shopper) {
		this.shopper = shopper;
	}
	public LinkedHashMap<Long, Goods> getCommodities() {
		return commodities;
	}
	public void setCommodities(LinkedHashMap<Long, Goods> commodities) {
		this.commodities = commodities;
	}
	public boolean isRegister() {
		return register;
	}
	public void setRegister(boolean register) {
		this.register = register;
	}
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", shopper=" + shopper + ", commodities=" + commodities
				+ ", register=" + register + "]";
	}
}