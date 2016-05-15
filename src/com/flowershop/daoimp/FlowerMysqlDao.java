package com.flowershop.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.flowershop.bean.Flower;
import com.flowershop.dao.FlowerDao;
import com.flowershop.factory.ConnectionFactory;

public class FlowerMysqlDao implements FlowerDao {

	@Override
	public Flower getFlowerInId(Integer flowerId) {
		// TODO Auto-generated method stub
		return null;
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
		return false;
	}

	@Override
	public boolean updateFlower(Flower flower) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Flower> getFlowers(Integer start, Integer length, Integer flowerCategary) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		PreparedStatement pstmt = null;
		String sql = "select flowerId from flower where flowerCategary = ? order by flowerId desc limit ?,?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, flowerCategary);
			pstmt.setInt(2, start);
			pstmt.setInt(3, length);
		}
		ResultSet rs = null;
		
		
		
		return null;
	}

}
