package com.flowershop.serviceimp;

import java.util.List;

import com.flowershop.bean.User;
import com.flowershop.dao.UserDao;
import com.flowershop.factory.DaoFactory;
import com.flowershop.service.UserService;

public class UserMysqlService implements UserService {

	private UserDao ud;
	
	public UserMysqlService() {
		ud = DaoFactory.createUserDao();
	}
	
	@Override
	public User getUserInId(Integer userId) {
		// TODO Auto-generated method stub
		return ud.getUserInId(userId);
	}

	@Override
	public User getUserInName(String nackName) {
		// TODO Auto-generated method stub
		return ud.getUserInName(nackName);
	}

	@Override
	public boolean validateUserName(String nackName) {
		// TODO Auto-generated method stub
		return ud.validateUserName(nackName);
	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return ud.insertUser(user);
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return ud.deleteUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return ud.getAllUsers();
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return ud.updateUser(user);
	}

}
