package com.flowershop.serviceimp;

import java.util.List;

import com.flowershop.bean.FlowerOrderItem;
import com.flowershop.dao.FlowerOrderItemDao;
import com.flowershop.factory.DaoFactory;
import com.flowershop.service.FlowerOrderItemService;

public class FlowerOrderItemMysqlService implements FlowerOrderItemService {

	private FlowerOrderItemDao foid = null;
	
	public FlowerOrderItemMysqlService() {
		foid = DaoFactory.createFlowerOrderItemDao();
	}
	
	@Override
	public List<FlowerOrderItem> getOrderItemsInFlowerOrderId(Integer flowerOrderId) {
		// TODO Auto-generated method stub
		return foid.getOrderItemsInFlowerOrderId(flowerOrderId);
	}

	@Override
	public boolean deleteOrderItemsInFlowerOrderId(Integer flowerOrderId) {
		// TODO Auto-generated method stub
		return foid.deleteOrderItemsInFlowerOrderId(flowerOrderId);
	}

	@Override
	public boolean insertOrderItem(FlowerOrderItem orderitem) {
		// TODO Auto-generated method stub
		return foid.insertOrderItem(orderitem);
	}

	@Override
	public boolean deleteOrderItem(FlowerOrderItem orderitem) {
		// TODO Auto-generated method stub
		return foid.deleteOrderItem(orderitem);
	}

	@Override
	public boolean updateOrderItem(FlowerOrderItem orderitem) {
		// TODO Auto-generated method stub
		return foid.updateOrderItem(orderitem);
	}

	@Override
	public FlowerOrderItem getOrderItemInOrderItemId(FlowerOrderItem orderitem) {
		// TODO Auto-generated method stub
		return foid.getOrderItemInOrderItemId(orderitem);
	}

}
