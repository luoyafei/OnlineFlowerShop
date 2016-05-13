<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.flowershop.bean.*" %>
<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<table class="table table-condensed">
					<thead>
						<tr>
						<%
							User user;
							if(session.getAttribute("user") != null) {
								user = (User)session.getAttribute("user");
						%>
							<th><a><%=user.getEmail() %>,欢迎光临！</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/OnlineFlowerShop/LoginOut" style="color: red;">注销</a></th>
							<th><a href="#">订单查询</a></th>
						<%}else{ %>
							<th><a href="/OnlineFlowerShop/pages/signInOut/reg.jsp">你好,请登录</a></th>
							<th><a href="/OnlineFlowerShop/pages/signInOut/reg.jsp">注册</a></th>
						<%} %>
							<th><a href="#">客户服务</a></th>
							<th><a href="/OnlineFlowerShop/index.jsp">花乐园网上花店系统</a></th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>