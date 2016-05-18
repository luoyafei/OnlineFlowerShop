package com.flowershop.servlet.AdminOperate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flowershop.bean.FlowerOrder;
import com.flowershop.factory.ServiceFactory;

/**
 * Servlet implementation class AdminDeleteOrder
 */
@WebServlet("/AdminDealOrder")
public class AdminDealOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDealOrder() {
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
		
		String flag = request.getParameter("flag");	
		String orderId = request.getParameter("item");
		FlowerOrder item = new FlowerOrder();
		item.setOrderId(Integer.valueOf(orderId));
		if(flag.equals("0")) {
			item.setStatus(1);
		} else if(flag.equals("1")) {
			item.setStatus(2);
		}
		boolean result = ServiceFactory.createOrderService().updateOrder(item);
		/**
		 * 将结果当作返回数返回！
		 * 更新成功，则返回0
		 * 更新失败，返回1
		 * */
		String ok = null;
		
		if(result)
			ok = "0";
		else
			ok = "1";
		
		response.sendRedirect("/OnlineFlowerShop/pages/amdinOperate/orderOperate.jsp?ok="+ok);
		
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
