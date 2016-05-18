package com.flowershop.servlet.AdminOperate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flowershop.factory.ConnectionFactory;

/**
 * Servlet implementation class GetWebCount
 */
@WebServlet("/GetWebCount")
public class GetWebCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetWebCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "select count(*) from webCount";
		Statement stmt = null;
		ResultSet rs = null;
		Integer status = 0;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			status = rs.getInt(1);
			
		} catch(SQLException e) {
		} finally {
			ConnectionFactory.newMysqlInstance().closedCSR(conn, stmt, rs);
		}
		
		String str = "{\"" + "status" + "\":\"" + status + "\"}";
		out.print(str);
		out.flush();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
