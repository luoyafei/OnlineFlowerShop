package com.flowershop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flowershop.bean.FlowerOrderItem;
import com.flowershop.service.ShopCarService;
import com.flowershop.serviceimp.ShopCarMysqlService;

/**
 * Servlet implementation class DeleteItemInCar
 */
@WebServlet("/DeleteItemInCar")
public class DeleteItemInCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItemInCar() {
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
		
		String flowerId = request.getParameter("item");
//System.out.println("Delete :" + flowerId);
		HttpSession session = request.getSession();
		ShopCarService car = (ShopCarMysqlService)session.getAttribute("car");
		FlowerOrderItem item = new FlowerOrderItem();
		item.setFlowerId(Integer.valueOf(flowerId));
		
		car.deleteOrderItem(item);
		
		response.sendRedirect("/OnlineFlowerShop/pages/myorder/myorder.jsp");
		return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
