package com.flowershop.service;

import java.util.List;

import com.flowershop.bean.FlowerOrderItem;

public interface FlowerOrderItemService {

	public boolean insertOrderItem(FlowerOrderItem orderitem);
	public boolean deleteOrderItem(FlowerOrderItem orderitem);
	public boolean deleteOrderItemsInFlowerOrderId(Integer flowerOrderId);
	public boolean updateOrderItem(FlowerOrderItem orderitem);
	public FlowerOrderItem getOrderItemInOrderItemId(FlowerOrderItem orderitem);
	public List<FlowerOrderItem> getOrderItemsInFlowerOrderId(Integer flowerOrderId);
}
