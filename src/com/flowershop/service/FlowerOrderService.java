package com.flowershop.service;

import java.util.List;

import com.flowershop.bean.FlowerOrder;
import com.flowershop.bean.User;

public interface FlowerOrderService {

	public Integer insertOrder(FlowerOrder order);
	public boolean deleteOrder(FlowerOrder order);
	public boolean updateOrder(FlowerOrder order);
	public FlowerOrder getFlowerOrderInOrderId(FlowerOrder order);
	public List<FlowerOrder> getFlowerOrders(User user);
	public List<FlowerOrder> getAllFlowerOrdersByStatus(Integer status);
}
