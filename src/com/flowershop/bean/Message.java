package com.flowershop.bean;

import java.sql.Timestamp;

public class Message {
	Integer messageId = 0;
	Integer userId = 0;
	String messageContent = "";
	Timestamp messageTime = null;
	
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getMessageTime() {
		if(messageTime == null) {
			messageTime = new Timestamp(System.currentTimeMillis());
		}
		return messageTime.toString();
	}
	public Timestamp getTimestamp(){
		getMessageTime();
		return messageTime;
	}
	public void setMessageTime(Timestamp messageTime) {
		this.messageTime = messageTime;
	}
	
	
}
