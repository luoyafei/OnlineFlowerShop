package com.flowershop.serviceimp;

import java.util.List;

import com.flowershop.bean.Message;
import com.flowershop.dao.MessageDao;
import com.flowershop.daoimp.MessageMysqlDao;
import com.flowershop.service.MessageService;

public class MessageMysqlService implements MessageService {

	private MessageDao md;
	public MessageMysqlService() {
		// TODO Auto-generated constructor stub
		md = new MessageMysqlDao();
	}
	
	@Override
	public boolean insertMessage(Message message) {
		// TODO Auto-generated method stub
		return md.insertMessage(message);
	}

	@Override
	public boolean deleteMessage(Message message) {
		// TODO Auto-generated method stub
		return md.deleteMessage(message);
	}

	@Override
	public List<Message> getAllMessage() {
		// TODO Auto-generated method stub
		return md.getAllMessage();
	}

}
