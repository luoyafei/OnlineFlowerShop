package com.flowershop.factory;

import com.flowershop.service.FlowerOrderItemService;
import com.flowershop.service.FlowerOrderService;
import com.flowershop.service.FlowerService;
import com.flowershop.service.MessageService;
import com.flowershop.service.UserService;
import com.flowershop.serviceimp.FlowerMysqlService;
import com.flowershop.serviceimp.FlowerOrderItemMysqlService;
import com.flowershop.serviceimp.FlowerOrderMysqlService;
import com.flowershop.serviceimp.MessageMysqlService;
import com.flowershop.serviceimp.UserMysqlService;

public class ServiceFactory {

	public static UserService createUserService() {
		return new UserMysqlService();
	}
	
	public static FlowerService createFlowerService() {
		return new FlowerMysqlService();
	}
	
	public static MessageService createMessageService() {
		return new MessageMysqlService();
	}
	
	public static FlowerOrderService createOrderService() {
		return new FlowerOrderMysqlService();
	}
	
	public static FlowerOrderItemService createOrderItemService() {
		return new FlowerOrderItemMysqlService();
	}
}
