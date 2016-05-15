package com.flowershop.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flowershop.bean.Message;
import com.flowershop.dao.MessageDao;
import com.flowershop.factory.ConnectionFactory;

public class MessageMysqlDao implements MessageDao {

	@Override
	public boolean insertMessage(Message message) {
		// TODO Auto-generated method stub
		
		/**
		 * | messageId      | int(11)  | NO   | PRI | NULL    | auto_increment |
			| userId         | int(11)  | YES  |     | NULL    |                |
			| messageContent | text     | NO   |     | NULL    |                |
			| messageTiem
			
			| messageId | userId | messageContent | messageTiem
		 * */
		boolean flag = false;
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "insert into message() values(null, ?, ?, now())";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, message.getUserId());
			pstmt.setString(2, message.getMessageContent());
			if(pstmt.executeUpdate() >= 1)
				flag = true;
			else
				flag = false;
		} catch(SQLException e) {
System.out.println("数据库插入用户的意见时出现错误！");
			flag = false;
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
		return flag;
	}

	@Override
	public boolean deleteMessage(Message message) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "delete from message where messageId = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, message.getMessageId());
			if(pstmt.executeUpdate() >= 1)
				flag = true;
			else
				flag = false;
		} catch(SQLException e) {
System.out.println("数据库删除用户的意见时出现错误！");
			flag = false;
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
		return flag;
	}

	@Override
	public List<Message> getAllMessage() {
		// TODO Auto-generated method stub
		List<Message> messages = new ArrayList<Message>();
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "select * from message";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Message message = new Message();
				message.setMessageId(rs.getInt("messageId"));
				message.setUserId(rs.getInt("userId"));
				message.setMessageContent(rs.getString("messageContent"));
				message.setMessageTime(rs.getTimestamp("messageTiem"));
				
				messages.add(message);
			}
		} catch(SQLException e) {
System.out.println("获取所有的意见反馈messages出错！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedCSR(conn, stmt, rs);
		}
		
		return messages;
	}
	
}
