package com.flowershop.servlet.AdminOperate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flowershop.bean.Flower;
import com.flowershop.factory.ServiceFactory;

/**
 * Servlet implementation class UpdateFlowerInfo
 */
@WebServlet("/UpdateFlowerInfo")
public class UpdateFlowerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFlowerInfo() {
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
		
		String flowerId = request.getParameter("flowerId");
		String flowerDescribe = request.getParameter("flowerDescribe");
		String floweprice = request.getParameter("floweprice");
		
		Flower flower = ServiceFactory.createFlowerService().getFlowerInId(Integer.valueOf(flowerId));
		flower.setFlowerDescribe(flowerDescribe);
		flower.setFlowePrice(floweprice);
		
		boolean flag = ServiceFactory.createFlowerService().updateFlower(flower);
		
		/**
		 * @param status
		 * @return 0(修改失败) 1(修改成功)
		 * */
		Integer status = 0;
		if(flag)
			status = 1;
		
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
