package com.flowershop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flowershop.bean.FlowerOrder;
import com.flowershop.bean.User;
import com.flowershop.service.ShopCarService;
import com.flowershop.serviceimp.ShopCarMysqlService;

/**
 * Servlet implementation class SubmitOrder
 */
@WebServlet("/SubmitOrder")
public class SubmitOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitOrder() {
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
		
		String addr = request.getParameter("UTF-8");
		PrintWriter out = response.getWriter();
		
		/**
		 * -1,失败;0,未登录;1,成功;
		 * */
		Integer status = -1;
		
		HttpSession session = request.getSession();
		ShopCarService car = (ShopCarMysqlService)session.getAttribute("car");
		User user = (User)session.getAttribute("user");
		/**
		 * ------------+--------------+------+-----+-------------------+----------------+
			| orderId    | int(11)      | NO   | PRI | NULL              | auto_increment |
			| userId     | int(11)      | YES  |     | NULL              |                |
			| addr       | varchar(255) | NO   |     | NULL              |                |
			| status     | int(11)      | YES  |     | 0                 |                |
			| orderDate  | datetime     | YES  |     | CURRENT_TIMESTAMP |                |
			| totalPrice | varchar(11)  | YES  |     | NULL              |                |
			+------------+--------------+------+-----+-------------------+------------
		 * */
		FlowerOrder order = new FlowerOrder();
		order.setUserId(user.getUserId());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
