package com.flowershop.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flowershop.bean.FlowerOrder;
import com.flowershop.bean.User;
import com.flowershop.dao.FlowerOrderDao;
import com.flowershop.factory.ConnectionFactory;

public class FlowerOrderMysqlDao implements FlowerOrderDao {

	
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
	@Override
	public Integer insertOrder(FlowerOrder order) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "insert into flowerOrder() values(null, ?, ?, ?, now(), ?)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer orderId = -1;
		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, order.getUserId());
			pstmt.setString(2, order.getAddr());
			pstmt.setInt(3,  order.getStatus());
			pstmt.setString(4, order.getTotalPrice());
			
			if(pstmt.executeUpdate() >= 1) {
				rs = pstmt.getGeneratedKeys();
				rs.next();
				orderId = rs.getInt(1);
			}
			
		} catch(SQLException e) {
System.out.println("用户提交订单时，往数据库插入订单的信息时出错！");
			e.printStackTrace();
			orderId = -1;
		} finally {
			ConnectionFactory.newMysqlInstance().closedCPR(conn, pstmt, rs);
		}
		return orderId;
	}

	@Override
	public List<FlowerOrder> getAllFlowerOrdersByStatus(Integer status) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "select orderId from flowerOrder where status = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FlowerOrder> orders = new ArrayList<FlowerOrder>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, status);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FlowerOrder o = new FlowerOrder();
				o.setOrderId(rs.getInt(1));
				FlowerOrder order = getFlowerOrderInOrderId(o);
				orders.add(order);
			}
		} catch(SQLException e) {
System.out.println("获取所有的订单时出错1");
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedCPR(conn, pstmt, rs);
		}
		return orders;
	}

	@Override
	public boolean deleteOrder(FlowerOrder order) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "delete from flowerOrder where orderId = ?";
		PreparedStatement pstmt = null;
		
		if(new FlowerOrderItemMysqlDao().deleteOrderItemsInFlowerOrderId(order.getOrderId())) {
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
		}
		
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.flowershop.dao.FlowerOrderDao#updateOrder(com.flowershop.bean.FlowerOrder)
	 */
	@Override
	public boolean updateOrder(FlowerOrder order) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "update flowerOrder set status = ? where orderId = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getStatus());
			pstmt.setInt(2, order.getOrderId());
			if(pstmt.executeUpdate() >= 1)
				flag = true;
			else
				flag = false;
		} catch(SQLException e) {
System.out.println("数据库更新订单时出现错误！");
			flag = false;
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
		
		return flag;
	}

	@Override
	public FlowerOrder getFlowerOrderInOrderId(FlowerOrder order) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "select * from flowerorder where orderId = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FlowerOrder fo = new FlowerOrder();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getOrderId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				fo.setOrderId(rs.getInt("orderId"));
				fo.setUserId(rs.getInt("userId"));
				fo.setAddr(rs.getString("addr"));
				fo.setStatus(rs.getInt("status"));
				fo.setOrderDate(rs.getTimestamp("orderDate"));
				fo.setTotalPrice(rs.getString("totalPrice"));
				
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
			ConnectionFactory.newMysqlInstance().closedCPR(conn, pstmt, rs);
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
				fo.setOrderId(rs.getInt(1));
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
