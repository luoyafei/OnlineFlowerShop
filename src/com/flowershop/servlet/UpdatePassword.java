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
 * Servlet implementation class UpdatePassword
 */
@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePassword() {
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
		String newpassword = request.getParameter("newpassword");
		/**
		 * @param status
		 * @return -1(修改失败) 0(原始密码错误！),1(邮箱不可用！)，2(修改成功)
		 * */
		
		Integer status = -1;
		boolean flag = false;
		User user = new User();
		user.setEmail(email);
		user.setUserPassword(newpassword);
		HttpSession session = request.getSession(false);
		User ulogin = (User)session.getAttribute("user");
		user.setUserId(ulogin.getUserId());
		
		if(ulogin.getUserPassword().equals(password)) {
			if(ServiceFactory.createUserService().validateUserName(email)) {
				flag = ServiceFactory.createUserService().updateUser(user);
				if(flag) {
					status = 2;
					session.removeAttribute("user");
					session.setAttribute("user", user);
				} else {
					status = -1;
				}
			} else
				status = 1;
		} else {
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
