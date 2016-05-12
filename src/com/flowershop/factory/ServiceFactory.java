package com.flowershop.factory;

import com.flowershop.service.FlowerService;
import com.flowershop.service.UserService;
import com.flowershop.serviceimp.FlowerMysqlService;
import com.flowershop.serviceimp.UserMysqlService;

public class ServiceFactory {

	public static UserService createUserService() {
		return new UserMysqlService();
	}
	
	public static FlowerService createFlowerService() {
		return new FlowerMysqlService();
	}
	//未完
}
