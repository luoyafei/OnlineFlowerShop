package com.flowershop.bean;

import java.util.List;

public class ShopCar {

	private String totalPrice = "0";
	private List<FlowerOrderItem> items = null;
	
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<FlowerOrderItem> getItems() {
		return items;
	}
	public void setItems(List<FlowerOrderItem> items) {
		this.items = items;
	}
	
}
