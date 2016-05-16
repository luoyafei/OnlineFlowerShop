package com.flowershop.bean;

import java.util.List;

public class ShopCar {

	private Integer userId = 0;
	private List<FlowerOrderItem> items = null;
	

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<FlowerOrderItem> getItems() {
		return items;
	}
	public void setItems(List<FlowerOrderItem> items) {
		this.items = items;
	}
	
}
