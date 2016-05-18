package com.flowershop.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flowershop.bean.Flower;
import com.flowershop.dao.FlowerDao;
import com.flowershop.factory.ConnectionFactory;

public class FlowerMysqlDao implements FlowerDao {

	@Override
	public Flower getFlowerInId(Integer flowerId) {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "select * from flower where flowerId = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Flower flower = new Flower();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, flowerId);
			rs = pstmt.executeQuery();
			rs.next();
			flower.setFlowerId(rs.getInt("flowerId"));
			flower.setFlowerName(rs.getString("flowerName"));
			flower.setFlowerCategary(rs.getString("flowerCategary"));
			flower.setFlowerPicture(rs.getString("flowerPicture"));
			flower.setFlowePrice(rs.getString("flowePrice"));
			flower.setFlowerDescribe(rs.getString("flowerDescribe"));
		} catch(SQLException e) {
System.out.println("通过花朵的Id获取花朵的信息出错！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedCPR(conn, pstmt, rs);
		}
		return flower;
	}

	@Override
	public boolean insertFlower(Flower flower) {
		// TODO Auto-generated method stub
		
		/**
		 * +----------------+--------------+------+-----+---------+----------------+
			| flowerId       | int(11)      | NO   | PRI | NULL    | auto_increment |
			| flowerName     | varchar(255) | YES  | UNI | NULL    |                |
			| flowerCategary | varchar(255) | NO   |     | NULL    |                |
			| flowerPicture  | varchar(255) | NO   |     | NULL    |                |
			| flowePrice     | varchar(11)  | NO   |     | NULL    |                |
			| flowerDescribe | text         | NO   |     | NULL    |                |
			+----------------+--------------+------+-----+---------+----------------+
			insert into flower() values(null, ?, ?, ?, ?, ?);
		 * */
		
		boolean flag = true;
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "insert into flower() values(null, ?, ?, ?, ?, ?);";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, flower.getFlowerName());
			pstmt.setString(2, flower.getFlowerCategary());
			pstmt.setString(3, flower.getFlowerPicture());
			pstmt.setString(4, flower.getFlowePrice());
			pstmt.setString(5, flower.getFlowerDescribe());
			
			int result = pstmt.executeUpdate();
			if(result != 1) {
				flag = false;
System.out.println("花朵插入数据库失败！");
			}
		} catch(SQLException e) {
			flag = false;
System.out.println("花朵插入数据库失败！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
		return flag;
	}

	@Override
	public boolean deleteFlower(Flower flower) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "delete from flower where flowerId = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, flower.getFlowerId());
			if(pstmt.executeUpdate() >= 1)
				flag = true;
			else
				flag = false;
		} catch(SQLException e) {
System.out.println("数据库删除鲜花时出现错误！");
			flag = false;
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
		return flag;
	}

	@Override
	public boolean updateFlower(Flower flower) {
		// TODO Auto-generated method stub

		/**
		 * +----------------+--------------+------+-----+---------+----------------+
			| flowerId       | int(11)      | NO   | PRI | NULL    | auto_increment |
			| flowerName     | varchar(255) | YES  | UNI | NULL    |                |
			| flowerCategary | varchar(255) | NO   |     | NULL    |                |
			| flowerPicture  | varchar(255) | NO   |     | NULL    |                |
			| flowePrice     | varchar(11)  | NO   |     | NULL    |                |
			| flowerDescribe | text         | NO   |     | NULL    |                |
			+----------------+--------------+------+-----+---------+----------------+
			insert into flower() values(null, ?, ?, ?, ?, ?);
		 * */
		
		boolean flag = true;
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "update flower set flowerDescribe = ?, flowePrice = ? where flowerId = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, flower.getFlowerDescribe());
			pstmt.setString(2, flower.getFlowePrice());
			pstmt.setInt(3, flower.getFlowerId());
			
			int result = pstmt.executeUpdate();
			if(result != 1) {
				flag = false;
System.out.println("花朵更新失败！");
			}
		} catch(SQLException e) {
			flag = false;
System.out.println("花朵更新失败！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
		return flag;
	}

	@Override
	public List<Flower> getFlowers(Integer start, Integer length, Integer flowerCategary) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		PreparedStatement pstmt = null;
		String sql = "select flowerId from flower where flowerCategary = ? order by flowerId desc limit ?,?";
		ResultSet rs = null;
		ArrayList<Flower> flowers = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, flowerCategary);
			pstmt.setInt(2, start);
			pstmt.setInt(3, length);
			
			rs = pstmt.executeQuery();
			flowers = new ArrayList<Flower>();
			
			while(rs.next()) {
				Flower flower = getFlowerInId(rs.getInt(1));
				flowers.add(flower);
			}
			
		} catch(SQLException e) {
System.out.println("获取花朵list时出现错误！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedCPR(conn, pstmt, rs);
		}
		
		return flowers;
	}
	
	@Override
	public List<Flower> getFlowers(Integer flowerCategary) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		PreparedStatement pstmt = null;
		String sql = "select count(*) from flower where flowerCategary = ?";
		ResultSet rs = null;
		List<Flower> flowers = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, flowerCategary);
			rs = pstmt.executeQuery();
			rs.next();
			Integer count = rs.getInt(1);
			
			flowers = getFlowers(0, count, flowerCategary);
			
		} catch(SQLException e) {
System.out.println("获取花朵list时出现错误！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedCPR(conn, pstmt, rs);
		}
		
		return flowers;
	}

}
