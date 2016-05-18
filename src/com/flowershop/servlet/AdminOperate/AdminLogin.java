package com.flowershop.servlet.AdminOperate;

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
import com.flowershop.service.ShopCarService;
import com.flowershop.serviceimp.ShopCarMysqlService;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		 * 获取从前台传来的数据
		 * */
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		
		Integer status = -1;
		boolean flag = false;
		/**
		 * 先通过服务大工厂生产出用户服务，通过用户服务调用验证用户邮箱是否存在的方法！
		 * */
		if(!ServiceFactory.createUserService().validateUserName(email)) {
			/**
			 * 如果为存在的邮箱，则通过邮箱名，调用用户服务的getUserInName(User user)方法获取到整个user的Bean!
			 * */
			user = ServiceFactory.createUserService().getUserInName(email);
			if(user.getUserPassword().equals(password)) {
				/**
				 * 获取到整个user的Bean后获取到密码与从前台传来的密码对比，如果一致，则登陆成功，反之则失败！
				 * */
				if(user.getUserRole() == 1)/*如果角色是管理员*/
					flag = true;
			} else {
				status = 0;
			}
		} else
			status = 0;
		
		if(flag) {
			/**
			 * 如果登陆成功，则将用户的Bean保存如session,并且直接跳到后台管理员操作页面
			 * */
			status = 1;
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			ShopCarService car = new ShopCarMysqlService();
			session.setAttribute("car", car);
		}
		/**
		 * 失败则，手动拼接json的字符串，然后发送往前台！
		 * */
		String str = "{\"" + "status" + "\":\"" + status + "\"}";
		out.print(str);
		out.flush();
		out.close();
	}
			

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
