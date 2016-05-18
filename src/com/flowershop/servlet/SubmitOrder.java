package com.flowershop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flowershop.bean.FlowerOrder;
import com.flowershop.bean.FlowerOrderItem;
import com.flowershop.bean.User;
import com.flowershop.factory.ServiceFactory;
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
		
		String addr = request.getParameter("addr");
		PrintWriter out = response.getWriter();
		
		/**
		 * -1,失败;0,插入订单Item失败;1,成功;
		 * */
		Integer status = -1;
		
		HttpSession session = request.getSession();
		ShopCarService car = (ShopCarMysqlService)session.getAttribute("car");
		User user = (User)session.getAttribute("user");
		if(car.getOrderItems().size() != 0) {
			FlowerOrder order = new FlowerOrder();
			order.setUserId(user.getUserId());
			order.setAddr(addr);
			order.setStatus(0);
			order.setOrderDate(new Timestamp(System.currentTimeMillis()));
			order.setTotalPrice(car.getTotalPrice());
			
			Integer orderId = ServiceFactory.createOrderService().insertOrder(order);
			if(orderId != -1) {
				for(int i = 0; i < car.getOrderItems().size(); i++) {
					FlowerOrderItem item = car.getOrderItems().get(i);
					item.setFlowerOrderId(orderId);
					if(!ServiceFactory.createOrderItemService().insertOrderItem(item)) {
						status = 0;
						break;
					}
					status = 1;
				}
			}
		}
		if(status == 1)
			car.getOrderItems().clear();
		
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
