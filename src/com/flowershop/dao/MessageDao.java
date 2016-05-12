package com.flowershop.dao;

import java.util.List;

import com.flowershop.bean.Message;

public interface MessageDao {
	public boolean insertMessage(Message p);
	public boolean deleteMessage(Message p);
	public List<Message> getAllMessage();
}
