package com.flowershop.serviceimp;

import java.util.List;

import com.flowershop.bean.FlowerOrder;
import com.flowershop.bean.User;
import com.flowershop.factory.ServiceFactory;
import com.flowershop.service.FlowerOrderService;

public class FlowerOrderMysqlService implements FlowerOrderService {

	private FlowerOrderService fos = null;
	
	public FlowerOrderMysqlService() {
		fos = ServiceFactory.createOrderService();
	}
	@Override
	public boolean insertOrder(FlowerOrder order) {
		// TODO Auto-generated method stub
		return fos.insertOrder(order);
	}

	@Override
	public boolean deleteOrder(FlowerOrder order) {
		// TODO Auto-generated method stub
		return fos.deleteOrder(order);
	}

	@Override
	public boolean updateOrder(FlowerOrder order) {
		// TODO Auto-generated method stub
		return fos.updateOrder(order);
	}

	@Override
	public FlowerOrder getFlowerOrderInOrderId(FlowerOrder order) {
		// TODO Auto-generated method stub
		return fos.getFlowerOrderInOrderId(order);
	}

	@Override
	public List<FlowerOrder> getFlowerOrders(User user) {
		// TODO Auto-generated method stub
		return fos.getFlowerOrders(user);
	}

}
