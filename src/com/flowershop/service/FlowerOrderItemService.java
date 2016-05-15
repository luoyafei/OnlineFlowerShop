package com.flowershop.service;

import com.flowershop.bean.FlowerOrderItem;

public interface FlowerOrderItemService {

	public boolean insertOrderItem(FlowerOrderItem orderitem);
	public boolean deleteOrderItem(FlowerOrderItem orderitem);
	public boolean updateOrderItem(FlowerOrderItem orderitem);
	public FlowerOrderItem getOrderItemInOrderItemId(FlowerOrderItem orderitem);
}
