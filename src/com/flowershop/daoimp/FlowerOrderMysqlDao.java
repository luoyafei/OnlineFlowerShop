package com.flowershop.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flowershop.bean.Flower;
import com.flowershop.bean.FlowerOrder;
import com.flowershop.bean.User;
import com.flowershop.dao.FlowerOrderDao;
import com.flowershop.factory.ConnectionFactory;

public class FlowerOrderMysqlDao implements FlowerOrderDao {

	@Override
	public boolean insertOrder(FlowerOrder order) {
		
		/**
		 * mysql> desc flowerOrder;
			+------------+--------------+------+-----+-------------------+----------------+
			| Field      | Type         | Null | Key | Default           | Extra          |
			+------------+--------------+------+-----+-------------------+----------------+
			| orderId    | int(11)      | NO   | PRI | NULL              | auto_increment |
			| userId     | int(11)      | YES  |     | NULL              |                |
			| addr       | varchar(255) | NO   |     | NULL              |                |
			| status     | int(11)      | YES  |     | 0                 |                |
			| orderDate  | datetime     | YES  |     | CURRENT_TIMESTAMP |                |
			| totalPrice | varchar(11)  | YES  |     | NULL              |                |
			+------------+--------------+------+-----+-------------------+----------------+
		 * */
		
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "insert into flowerOrder() values(null, ?, ?, ?, now(), ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getUserId());
			pstmt.setString(2, order.getAddr());
			pstmt.setInt(3,  order.getStatus());
			pstmt.setString(4, order.getTotalPrice());
			
			if(pstmt.executeUpdate() >= 1)
				return true;
			else
				return false;
		} catch(SQLException e) {
System.out.println("用户提交订单时，往数据库插入订单的信息时出错！");
			e.printStackTrace();
			return false;
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
	}

	@Override
	public boolean deleteOrder(FlowerOrder order) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "delete from flowerOrder where orderId = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getOrderId());
			if(pstmt.executeUpdate() >= 1)
				flag = true;
			else
				flag = false;
		} catch(SQLException e) {
System.out.println("数据库删除订单时出现错误！");
			flag = false;
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
		return flag;
	}

	@Override
	public boolean updateOrder(FlowerOrder order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FlowerOrder getFlowerOrderInOrderId(FlowerOrder order) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "select * from order where orderId = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FlowerOrder fo = new FlowerOrder();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getOrderId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				order.setOrderId(rs.getInt("orderId"));
				order.setUserId(rs.getInt("userId"));
				order.setAddr(rs.getString("addr"));
				order.setStatus(rs.getInt("status"));
				order.setOrderDate(rs.getTimestamp("orderDate"));
				order.setTotalPrice(rs.getString("totalPrice"));
				
				/**
				 * +------------+--------------+------+-----+-------------------+----------------+
					| orderId    | int(11)      | NO   | PRI | NULL              | auto_increment |
					| userId     | int(11)      | YES  |     | NULL              |                |
					| addr       | varchar(255) | NO   |     | NULL              |                |
					| status     | int(11)      | YES  |     | 0                 |                |
					| orderDate  | datetime     | YES  |     | CURRENT_TIMESTAMP |                |
					| totalPrice | varchar(11)  | YES  |     | NULL              |                |
					+------------+--------------+------+-----+-------------------+-
				 * */
				
			}
		} catch(SQLException e) {
System.out.println("通过订单的Id获取用户信息");
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
		return fo;
	}

	@Override
	public List<FlowerOrder> getFlowerOrders(User user) {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		PreparedStatement pstmt = null;
		String sql = "select orderId from flowerOrder where userId = ? order by orderId desc";
		ResultSet rs = null;
		List<FlowerOrder> orders = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUserId());
			rs = pstmt.executeQuery();
			orders = new ArrayList<FlowerOrder>();
			while(rs.next()) {
				FlowerOrder fo = new FlowerOrder();
				fo.setUserId(rs.getInt(1));
				FlowerOrder flowerorder = getFlowerOrderInOrderId(fo);
				orders.add(flowerorder);
			}
			
		} catch(SQLException e) {
System.out.println("获取某个用户的所有的订单list时出现错误！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedCPR(conn, pstmt, rs);
		}
		
		return orders;
	}

}
