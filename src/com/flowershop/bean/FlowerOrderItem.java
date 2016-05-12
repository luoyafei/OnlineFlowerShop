package com.flowershop.bean;

public class FlowerOrderItem {

	
	/*
	 * ItemId int primary key auto_increment,
		flowerId int references flower(flowerId),
		unitPrice varchar(11) default '0',
		flowerCount int default 0,
		flowerOrderId references flowerOrder(orderId)
	 * 
	 * */
	
	private Integer ItemId = 0;
	private Integer flowerId = 0;
	private String unitPrice = "0";
	private Integer flowerCount = 0;
	private Integer flowerOrderId = 0;
	public Integer getItemId() {
		return ItemId;
	}
	public void setItemId(Integer itemId) {
		ItemId = itemId;
	}
	public Integer getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(Integer flowerId) {
		this.flowerId = flowerId;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getFlowerCount() {
		return flowerCount;
	}
	public void setFlowerCount(Integer flowerCount) {
		this.flowerCount = flowerCount;
	}
	public Integer getFlowerOrderId() {
		return flowerOrderId;
	}
	public void setFlowerOrderId(Integer flowerOrderId) {
		this.flowerOrderId = flowerOrderId;
	}
	
	
}
