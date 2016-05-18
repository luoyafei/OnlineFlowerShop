package com.flowershop.dao;

import java.util.List;

import com.flowershop.bean.FlowerOrderItem;

public interface FlowerOrderItemDao {
	public boolean insertOrderItem(FlowerOrderItem orderitem);
	public boolean deleteOrderItem(FlowerOrderItem orderitem);
	
	/**
	 * 通过订单Id删除该订单下所有的订单Item项
	 * @param flowerOrderId
	 * @return true || false
	 * */
	public boolean deleteOrderItemsInFlowerOrderId(Integer flowerOrderId);
	
	public boolean updateOrderItem(FlowerOrderItem orderitem);
	
	/**
	 * 通过订单Item的Id获取该订单Item的信息
	 * @param orderitem
	 * @return FlowerOrderItem
	 * */
	public FlowerOrderItem getOrderItemInOrderItemId(FlowerOrderItem orderitem);
	
	/**
	 * 通过订单的Id获取该订单下所有的订单Item
	 * @param flowerOrderId
	 * @return List<FlowerOrderItem>
	 * */
	public List<FlowerOrderItem> getOrderItemsInFlowerOrderId(Integer flowerOrderId);
}
