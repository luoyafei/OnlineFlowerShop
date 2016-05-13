package com.flowershop.service;

import java.util.List;

import com.flowershop.bean.Message;

public interface MessageService {
	public boolean insertMessage(Message message);
	public boolean deleteMessage(Message message);
	public List<Message> getAllMessage();
}
