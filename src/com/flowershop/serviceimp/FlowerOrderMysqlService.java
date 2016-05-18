package com.flowershop.serviceimp;

import java.util.List;

import com.flowershop.bean.FlowerOrder;
import com.flowershop.bean.User;
import com.flowershop.dao.FlowerOrderDao;
import com.flowershop.factory.DaoFactory;
import com.flowershop.service.FlowerOrderService;

public class FlowerOrderMysqlService implements FlowerOrderService {

	private FlowerOrderDao fod;
	
	public FlowerOrderMysqlService() {
		fod = DaoFactory.createFlowerOrderDao();
	}
	
	@Override
	public List<FlowerOrder> getAllFlowerOrdersByStatus(Integer status) {
		// TODO Auto-generated method stub
		return fod.getAllFlowerOrdersByStatus(status);
	}
	
	@Override
	public Integer insertOrder(FlowerOrder order) {
		// TODO Auto-generated method stub
		return fod.insertOrder(order);
	}

	@Override
	public boolean deleteOrder(FlowerOrder order) {
		// TODO Auto-generated method stub
		return fod.deleteOrder(order);
	}

	@Override
	public boolean updateOrder(FlowerOrder order) {
		// TODO Auto-generated method stub
		return fod.updateOrder(order);
	}

	@Override
	public FlowerOrder getFlowerOrderInOrderId(FlowerOrder order) {
		// TODO Auto-generated method stub
		return fod.getFlowerOrderInOrderId(order);
	}

	@Override
	public List<FlowerOrder> getFlowerOrders(User user) {
		// TODO Auto-generated method stub
		return fod.getFlowerOrders(user);
	}

}
