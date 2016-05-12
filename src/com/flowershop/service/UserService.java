package com.flowershop.service;

import java.util.List;

import com.flowershop.bean.User;

public interface UserService {
	public User getUserInId(Integer userId);
	public User getUserInName(String nackName);
	public boolean validateUserName(String nackName);
	public boolean insertUser(User user);
	public boolean deleteUser(User user);	
	public List<User> getAllUsers();
	public boolean updateUser(User user);
}
