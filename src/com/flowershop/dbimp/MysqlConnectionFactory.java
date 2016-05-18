package com.flowershop.dbimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.flowershop.db.ConnectionAdapter;

public class MysqlConnectionFactory implements ConnectionAdapter {

	
	private static String className = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3305/onlineFlowerShop?user=root&password=root";
	
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public void closedCSR(Connection conn, Statement stmt, ResultSet rs) {
		// TODO Auto-generated method stub
		closedConnection(conn);
		closedStatement(stmt);
		closedResultSet(rs);
	}

	@Override
	public void closedCPR(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		// TODO Auto-generated method stub
		closedConnection(conn);
		closedPreparedStatement(pstmt);
		closedResultSet(rs);
	}

	@Override
	public void closedConnection(Connection conn) {
		// TODO Auto-generated method stub
		if(conn != null) {
			try {
				conn.close();
				conn = null;
			} catch(SQLException e) {
System.out.println("关闭数据库connection出错！");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void closedPreparedStatement(PreparedStatement pstmt) {
		// TODO Auto-generated method stub
		if(pstmt != null) {
			try {
				pstmt.close();
				pstmt = null;
			} catch(SQLException e) {
System.out.println("关闭数据库的PreparedStatement出错！");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void closedResultSet(ResultSet rs) {
		// TODO Auto-generated method stub
		if(rs != null) {
			try {
				rs.close();
				rs = null;
			} catch(SQLException e) {
System.out.println("关闭数据库的ResultSet出错！");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void closedStatement(Statement stmt) {
		// TODO Auto-generated method stub
		if(stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch(SQLException e) {
System.out.println("关闭数据库的Statement出错！");
				e.printStackTrace();
			}
		}
	}

}
