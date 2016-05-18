package com.flowershop.dao;

import java.util.List;

import com.flowershop.bean.FlowerOrder;
import com.flowershop.bean.User;

public interface FlowerOrderDao {
	public Integer insertOrder(FlowerOrder order);
	public boolean deleteOrder(FlowerOrder order);
	public boolean updateOrder(FlowerOrder order);
	public FlowerOrder getFlowerOrderInOrderId(FlowerOrder order);
	public List<FlowerOrder> getFlowerOrders(User user);
	
	
	/**
	 * 通过订单的状态，获取订单list
	 * @param Integer status
	 * @return List<FlowerOrder>
	 * */
	public List<FlowerOrder> getAllFlowerOrdersByStatus(Integer status);
}
