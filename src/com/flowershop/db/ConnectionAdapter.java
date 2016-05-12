package com.flowershop.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public interface ConnectionAdapter {
	public Connection getConnection();
	public void closedCSR(Connection conn, Statement stmt, ResultSet rs);
	public void closedCPR(Connection conn, PreparedStatement pstmt, ResultSet rs);
	public void closedConnection(Connection conn);
	public void closedPreparedStatement(PreparedStatement pstmt);
	public void closedResultSet(ResultSet rs);
	public void closedStatement(Statement stmt);
}
