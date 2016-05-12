package com.flowershop.factory;

import com.flowershop.dao.FlowerDao;
import com.flowershop.dao.FlowerOrderDao;
import com.flowershop.dao.FlowerOrderItemDao;
import com.flowershop.dao.MessageDao;
import com.flowershop.dao.UserDao;
import com.flowershop.daoimp.FlowerMysqlDao;
import com.flowershop.daoimp.FlowerOrderItemMysqlDao;
import com.flowershop.daoimp.FlowerOrderMysqlDao;
import com.flowershop.daoimp.MessageMysqlDao;
import com.flowershop.daoimp.UserMysqlDao;

public class DaoFactory {
	
	public static UserDao createUserDao() {
		return new UserMysqlDao();
	}
	
	public static FlowerDao createFlowerDao() {
		return new FlowerMysqlDao();
	}
	
	public static FlowerOrderDao createFlowerOrderDao() {
		return new FlowerOrderMysqlDao();
	}
	
	public static FlowerOrderItemDao createFlowerOrderItemDao() {
		return new FlowerOrderItemMysqlDao();
	}
	
	public static MessageDao createMessageDao() {
		return new MessageMysqlDao();
	}
	
}
