package com.flowershop.dao;

import java.util.List;

import com.flowershop.bean.Message;

public interface MessageDao {
	public boolean insertMessage(Message message);
	public boolean deleteMessage(Message message);
	public List<Message> getAllMessage();
}
