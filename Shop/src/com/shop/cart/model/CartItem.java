package com.shop.cart.model;

import com.shop.goods.model.Goods;

public class CartItem {
	
	private long id;
	private Goods goods;
	private int number;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getSubtotal()
	{
		return goods.getPrice()*number;
	}
//	public CartItem(long id,Goods goods,int number) {
//		this.id=id;
//		this.goods=goods;
//		this.number=number;
//	}
	public String toString() {
		return "CartItem [id=" + id + ", goods=" + goods + ", number=" + number + "]";
	}
}