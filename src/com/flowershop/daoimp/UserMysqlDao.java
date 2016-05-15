package com.flowershop.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flowershop.bean.Message;
import com.flowershop.bean.User;
import com.flowershop.dao.UserDao;
import com.flowershop.factory.ConnectionFactory;

public class UserMysqlDao implements UserDao{

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "select userId from user";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				User user = getUserInId(rs.getInt(1));
				users.add(user);
			}
		} catch(SQLException e) {
System.out.println("获取所有的用户出错！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedCSR(conn, stmt, rs);
		}
		
		return users;
	}

	@Override
	public User getUserInId(Integer userId) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "select * from user where userId = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user.setUserId(rs.getInt("userId"));
				user.setEmail(rs.getString("email"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserRole(rs.getInt("userRole"));
			}
		} catch(SQLException e) {
System.out.println("通过用户Id获取用户信息");
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
		return user;
	}

	@Override
	public User getUserInName(String nackName) {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "select * from user where email = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nackName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user.setUserId(rs.getInt("userId"));
				user.setEmail(rs.getString("email"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserRole(rs.getInt("userRole"));
			}
		} catch(SQLException e) {
System.out.println("通过用户邮箱，获取用户的信息");
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
		return user;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "delete from user where userId = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUserId());
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
	public boolean validateUserName(String nackName) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "select email from user where email = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nackName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return flag = false;
			} else {
				return flag = true;
			}
		} catch(SQLException e) {
System.out.println("数据库验证邮箱是否重复出错！");
			flag = false;
			e.printStackTrace();
		} finally {
			ConnectionFactory.newMysqlInstance().closedCPR(conn, pstmt, rs);
		}
		return flag;
	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "insert into user() values(null, ?, ?, 0)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getUserPassword());
			if(pstmt.executeUpdate() >= 1)
				return true;
			else
				return false;
		} catch(SQLException e) {
System.out.println("用户注册时，往数据库插入用户的信息是出错！");
			e.printStackTrace();
			return false;
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "update user set email = ?, userPassword = ? where userId = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setInt(3, user.getUserId());
			if(pstmt.executeUpdate() >= 1)
				return true;
			else
				return false;
		} catch(SQLException e) {
System.out.println("用户修改密码时，往数据库插入用户的信息时出错！");
			e.printStackTrace();
			return false;
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
	}
}
