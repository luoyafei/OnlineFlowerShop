package com.flowershop.bean;

import com.sun.jmx.snmp.Timestamp;

public class FlowerOrder {
/*
	orderId int primary key auto_increment,
	userId int references user(userId),
	addr varchar(255) not null,
	status int default 0,
	orderDate datetime default now()
	*/
	
	private Integer orderId = 0;
	private Integer userId;
	private String addr = "中国";
	private int status = 0;
	private Timestamp orderDate = null;
	
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
	public int getStatus() {
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
