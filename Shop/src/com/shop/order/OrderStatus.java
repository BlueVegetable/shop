package com.shop.order;

public enum OrderStatus {
	NO_COMFIRM,COMFIRM,GET;
	public static int getStatusData(OrderStatus orderStatus) {
		switch(orderStatus) {
		case NO_COMFIRM:return 1;
		case COMFIRM:return 2;
		case GET:return 3;
		default:return 1;
		}
	}
	public static OrderStatus getStatusKey(int orderStatus) {
		switch(orderStatus) {
		case 2:return COMFIRM;
		case 3:return GET;
		default:return NO_COMFIRM;
		}
	}
	public static String getStatusString(OrderStatus orderStatus) {
		switch(orderStatus) {
		case NO_COMFIRM:return "NO_COMFIRM";
		case COMFIRM:return "COMFIRM";
		case GET:return "GET";
		default:return "NO_COMFIRM";
		}
	}
}