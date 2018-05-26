package com.shop.base.service;

import java.util.LinkedHashMap;

import com.shop.cart.dao.RecorderCart;
import com.shop.cart.dao.RecorderCartItem;
import com.shop.cart.model.Cart;
import com.shop.cart.model.CartItem;
import com.shop.order.OrderStatus;
import com.shop.order.dao.RecorderOrder;
import com.shop.order.dao.RecorderOrderItem;
import com.shop.order.model.Order;
import com.shop.order.model.OrderItem;
import com.shop.shop.dao.RecorderShop;
import com.shop.shop.model.Shop;
import com.shop.user.dao.RecorderUser;
import com.shop.user.model.User;

@SuppressWarnings("unused")
public class Experience {
	public static void main(String[] args) {
		Order order=RecorderOrder.getOrder(1527300173008L);
		order.setStatus(OrderStatus.NO_COMFIRM);
		System.out.println(RecorderOrder.alterOrderStatus(order));
	}
}