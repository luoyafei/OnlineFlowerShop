package com.flowershop.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		return false;
	}

	@Override
	public List<Message> getAllMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
