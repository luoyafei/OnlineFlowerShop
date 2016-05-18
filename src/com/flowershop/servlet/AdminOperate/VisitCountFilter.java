package com.flowershop.servlet.AdminOperate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.flowershop.factory.ConnectionFactory;

/**
 * Servlet Filter implementation class VisitCount
 */
@WebFilter(filterName="/VisitCount", urlPatterns="/*")
public class VisitCountFilter implements Filter {

    /**
     * Default constructor. 
     */
    public VisitCountFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		/**
		 * 
		 * mysql> desc webCount;
			+----------+-------------+------+-----+---------+----------------+
			| Field    | Type        | Null | Key | Default | Extra          |
			+----------+-------------+------+-----+---------+----------------+
			| countId  | int(11)     | NO   | PRI | NULL    | auto_increment |
			| webIp    | varchar(30) | YES  | UNI | NULL    |                |
			| countNum | int(11)     | YES  |     | 0       |                |
			+----------+-------------+------+-----+---------+----------------+
		 * 
		 * */
		
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String webIp = request.getRemoteAddr();
		String sql = "select webIp from webCount where webIp = ?";
		String sqlInsert = "insert into webCount() values(null, ?, 1)";
		String sqlUpdate = "update webCount set countNum = countNum+1 where webIp = ?";
		PreparedStatement pstmt = null;
		PreparedStatement pstmtInsert = null;
		PreparedStatement pstmtUpdate = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, webIp);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pstmtUpdate = conn.prepareStatement(sqlUpdate);
				pstmtUpdate.setString(1, webIp);
				pstmtUpdate.executeUpdate();
			} else {
				pstmtInsert = conn.prepareStatement(sqlInsert);
				pstmtInsert.setString(1, webIp);
				pstmtInsert.executeUpdate();
			}
		} catch(SQLException e) {
		} finally {
			ConnectionFactory.newMysqlInstance().closedCPR(conn, pstmtUpdate, rs);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmtInsert);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmtUpdate);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
