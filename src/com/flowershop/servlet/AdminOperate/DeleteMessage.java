package com.flowershop.servlet.AdminOperate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flowershop.bean.Message;
import com.flowershop.factory.ServiceFactory;

/**
 * Servlet implementation class DeleteMessage
 */
@WebServlet("/DeleteMessage")
public class DeleteMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMessage() {
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
		
		String messageId = request.getParameter("item");
		String divideNum = request.getParameter("divideNum");
		
		Message message = new Message();
		message.setMessageId(Integer.valueOf(messageId));
		
		boolean flag = ServiceFactory.createMessageService().deleteMessage(message);
		
		
		/**
		 * 将结果当作返回数返回！
		 * 删除成功，则返回0
		 * 删除失败，返回1
		 * */
		String ok = null;
		
		if(flag)
			ok = "0";
		else
			ok = "1";
		
		response.sendRedirect("/OnlineFlowerShop/pages/amdinOperate/messageOperate.jsp?divideNum="+divideNum+"&ok="+ok);
		
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
