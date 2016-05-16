package com.flowershop.service;

import java.util.List;

import com.flowershop.bean.FlowerOrderItem;
import com.flowershop.bean.User;

public interface ShopCarService {

	public void setUserId(Integer userId);
	public User getUser(Integer userId);
	public boolean addOrderItem(FlowerOrderItem item);
	public boolean deleteOrderItem(FlowerOrderItem item);
	public boolean updateOrderItem(FlowerOrderItem item);
	public FlowerOrderItem getOrderItemInItemId(FlowerOrderItem item);
	public List<FlowerOrderItem> getOrderItems();
	public String getTotalPrice();
}
