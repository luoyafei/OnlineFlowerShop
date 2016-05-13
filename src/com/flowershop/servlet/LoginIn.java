package com.flowershop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flowershop.bean.User;
import com.flowershop.factory.ServiceFactory;

/**
 * Servlet implementation class LoginIn
 */
@WebServlet("/LoginIn")
public class LoginIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginIn() {
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
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		
		Integer status = -1;
		boolean flag = false;
		if(!ServiceFactory.createUserService().validateUserName(email)) {
			user = ServiceFactory.createUserService().getUserInName(email);
			if(user.getUserPassword().equals(password)) {
				flag = true;
			} else {
				status = 0;
			}
		} else
			status = 0;
		
		if(flag) {
			status = 1;
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
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
