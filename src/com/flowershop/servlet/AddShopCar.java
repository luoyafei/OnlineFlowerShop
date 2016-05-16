package com.flowershop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flowershop.bean.FlowerOrderItem;
import com.flowershop.bean.User;
import com.flowershop.factory.ServiceFactory;
import com.flowershop.service.ShopCarService;
import com.flowershop.serviceimp.ShopCarMysqlService;

/**
 * Servlet implementation class AddShopCar
 */
@WebServlet("/AddShopCar")
public class AddShopCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShopCar() {
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
		
		/**
		 * -1,失败;0,未登录;1,成功;
		 * */
		Integer status = -1;
		
		String flowerId = request.getParameter("flowerId");
		String flowerCount = request.getParameter("flowerCount");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		ShopCarService car = (ShopCarMysqlService)session.getAttribute("car");
		if(session != null && user != null) {
			
			car.setUserId(user.getUserId());
			FlowerOrderItem item = new FlowerOrderItem();
			item.setFlowerId(Integer.valueOf(flowerId));
			item.setUnitPrice(ServiceFactory.createFlowerService().getFlowerInId(Integer.valueOf(flowerId)).getFlowePrice());
			item.setFlowerCount(Integer.valueOf(flowerCount));
			
			if(car.addOrderItem(item))
				status = 1;
			else
				status = 0;
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
