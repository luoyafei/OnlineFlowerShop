package com.flowershop.bean;

import java.sql.Timestamp;

public class FlowerOrder {
	
	private Integer orderId = 0;
	private Integer userId;
	private String addr = "中国";
	private int status = 0;//0:处理中；1：订单成功；2：订单失败；
	private Timestamp orderDate = null;
	private String totalPrice = "0";
	
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getOrderDate() {
		if(orderDate == null) {
			orderDate = new Timestamp(System.currentTimeMillis());
		}
		return orderDate.toString();
	}
	
	public Timestamp getTimestamp() {
		getOrderDate();
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
}
