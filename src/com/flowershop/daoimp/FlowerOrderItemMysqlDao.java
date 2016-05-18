package com.flowershop.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flowershop.bean.FlowerOrderItem;
import com.flowershop.dao.FlowerOrderItemDao;
import com.flowershop.factory.ConnectionFactory;

public class FlowerOrderItemMysqlDao implements FlowerOrderItemDao {

	/**
	 * +---------------+-------------+------+-----+---------+----------------+
		| ItemId        | int(11)     | NO   | PRI | NULL    | auto_increment |
		| flowerId      | int(11)     | YES  |     | NULL    |                |
		| unitPrice     | varchar(11) | YES  |     | 0       |                |
		| flowerCount   | int(11)     | YES  |     | 0       |                |
		| flowerOrderId | int(11)     | YES  |     | NULL    |                |
		+---------------+-------------+------+-----+---------+----------------+
	 * 
	 * */
	
	@Override
	public boolean insertOrderItem(FlowerOrderItem orderitem) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "insert into flowerOrderItem() values(null, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderitem.getFlowerId());
			pstmt.setString(2, orderitem.getUnitPrice());
			pstmt.setInt(3, orderitem.getFlowerCount());
			pstmt.setInt(4, orderitem.getFlowerOrderId());
			
			if(pstmt.executeUpdate() >= 1)
				return true;
			else
				return false;
		} catch(SQLException e) {
System.out.println("用户购物时，往数据库插入订单Item的信息是出错！");
			e.printStackTrace();
			return false;
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
	}

	@Override
	public List<FlowerOrderItem> getOrderItemsInFlowerOrderId(Integer flowerOrderId) {
		// TODO Auto-generated method stub
		
		List<FlowerOrderItem> items = null;
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "select ItemId from flowerOrderItem where flowerOrderId = ? order by ItemId desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, flowerOrderId);
			rs = pstmt.executeQuery();
			items = new ArrayList<FlowerOrderItem>();
			while(rs.next()) {
				FlowerOrderItem temp = new FlowerOrderItem();
				temp.setItemId(rs.getInt(1));
				FlowerOrderItem item = getOrderItemInOrderItemId(temp);
				items.add(item);
			}
		} catch(SQLException e) {
System.out.println("通过订单Id获取该订单下所有的订单Item的信息出错！");
				e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedCPR(conn, pstmt, rs);
		}
		return items;
	}

	@Override
	public boolean deleteOrderItem(FlowerOrderItem orderitem) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "delete from flowerOrderItem where ItemId = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderitem.getItemId());
			if(pstmt.executeUpdate() >= 1)
				flag = true;
			else
				flag = false;
		} catch(SQLException e) {
System.out.println("数据库删除订单Item时出现错误！");
			flag = false;
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
		return flag;
	}

	
	
	
	@Override
	public boolean deleteOrderItemsInFlowerOrderId(Integer flowerOrderId) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "delete from flowerOrderItem where flowerOrderId = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, flowerOrderId);
			if(pstmt.executeUpdate() >= 1)
				flag = true;
			else
				flag = false;
		} catch(SQLException e) {
System.out.println("数据库通过订单Id 删除该订单下的所有Items时出现错误！");
			flag = false;
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
		return flag;
	}

	@Override
	public boolean updateOrderItem(FlowerOrderItem orderitem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FlowerOrderItem getOrderItemInOrderItemId(FlowerOrderItem orderitem) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "select * from flowerOrderItem where ItemId = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FlowerOrderItem item = new FlowerOrderItem();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderitem.getItemId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				item.setItemId(rs.getInt("ItemId"));
				item.setFlowerId(rs.getInt("flowerId"));
				item.setUnitPrice(rs.getString("unitPrice"));
				item.setFlowerCount(rs.getInt("flowerCount"));
				item.setFlowerOrderId(rs.getInt("flowerOrderId"));
			}
		} catch(SQLException e) {
System.out.println("通过订单Item的Id获取用户信息");
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
		return item;
	}

}
