package com.flowershop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flowershop.bean.Message;
import com.flowershop.bean.User;
import com.flowershop.factory.ServiceFactory;

/**
 * Servlet implementation class SaveMessage
 */
@WebServlet("/SaveMessage")
public class SaveMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveMessage() {
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
		String messageContent = new String(request.getParameter("messageContent").getBytes("ISO-8859-1"), "UTF-8");
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("user");
		Message message = new Message();
		message.setMessageContent(messageContent);
		message.setUserId(user.getUserId());
		
		Integer status = -1;
		boolean flag = false;
		flag = ServiceFactory.createMessageService().insertMessage(message);
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
