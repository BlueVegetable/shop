package com.shop.cart.model;

import java.math.BigDecimal;
import java.util.*;

import com.shop.user.model.User;

public class Cart {
	
	private long id;
	private User user;
	private Map<Long,CartItem>cartItems;
	private java.util.Date time;

	public Cart(User user) {
		this.id=System.currentTimeMillis();
		this.user=user;
		cartItems=new LinkedHashMap<>();
		this.time=new java.util.Date(System.currentTimeMillis());
	}
	public Cart() {
		
	}
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
	public java.util.Date getTime() {
		return time;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}
	public Map<Long, CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Map<Long, CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
//	public void setCartItem(CartItem cartItem) {
//		if(cartItems==null) {
//			cartItems=new LinkedHashMap<>();
//			cartItems.put(cartItem.getId(),cartItem);
//		} else {
//			CartItem cartItemOriginal=null;
//			for(long i=0;i<cartItems.size();i++) {
//				if(cartItem.getId()==cartItems.get(i).getId())
//				{
//					cartItemOriginal=cartItems.get(i);
//					break;
//				}
//			}
//			if(cartItemOriginal!=null) {
//				cartItemOriginal.setNumber(cartItemOriginal.getNumber()+cartItem.getNumber());
//			} else {
//				cartItems.put(cartItem.getId(), cartItem);
//			}
//		}
//	}
	public void removeCartItem(long cartItemID) {
		cartItems.remove(cartItemID);
	}
	public void clearCartItem() {
		cartItems.clear();
	}
	public double getAllPrice() {
		BigDecimal allPrice=new BigDecimal("0");
		for(CartItem cartItem:cartItems.values()) {
			BigDecimal price=new BigDecimal(""+cartItem.getSubtotal());
			allPrice=allPrice.add(price);
		}
		return allPrice.doubleValue();
	}
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", cartItems=" + cartItems + ", time=" + time + "]";
	}
}