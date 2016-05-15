package com.flowershop.serviceimp;

import com.flowershop.bean.FlowerOrderItem;
import com.flowershop.factory.ServiceFactory;
import com.flowershop.service.FlowerOrderItemService;

public class FlowerOrderItemMysqlService implements FlowerOrderItemService {

	private FlowerOrderItemService fois = null;
	
	public FlowerOrderItemMysqlService() {
		fois = ServiceFactory.createOrderItemService();
	}
	
	@Override
	public boolean insertOrderItem(FlowerOrderItem orderitem) {
		// TODO Auto-generated method stub
		return fois.insertOrderItem(orderitem);
	}

	@Override
	public boolean deleteOrderItem(FlowerOrderItem orderitem) {
		// TODO Auto-generated method stub
		return fois.deleteOrderItem(orderitem);
	}

	@Override
	public boolean updateOrderItem(FlowerOrderItem orderitem) {
		// TODO Auto-generated method stub
		return fois.updateOrderItem(orderitem);
	}

	@Override
	public FlowerOrderItem getOrderItemInOrderItemId(FlowerOrderItem orderitem) {
		// TODO Auto-generated method stub
		return fois.getOrderItemInOrderItemId(orderitem);
	}

}
