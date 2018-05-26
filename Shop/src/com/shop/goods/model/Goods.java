package com.shop.goods.model;

public class Goods {
	private long id;
	private String name;
	private double price;
	private String image;
	private String info;
	private String variety;
	private boolean register;
	private int buyNumber;
	private int amount;
	
	public int getBuyNumber() {
		return buyNumber;
	}
	public void setBuyNumber(int buyNumber) {
		this.buyNumber = buyNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public boolean isRegister() {
		return register;
	}
	public void setRegister(boolean register) {
		this.register = register;
	}
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", info=" + info
				+ ", variety=" + variety + ", register=" + register + "]";
	}
}