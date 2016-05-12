package com.flowershop.daoimp;

import java.util.List;

import com.flowershop.bean.User;
import com.flowershop.dao.UserDao;

public class UserMysqlDao implements UserDao{

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserInId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserInName(String nackName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateUserName(String nackName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
