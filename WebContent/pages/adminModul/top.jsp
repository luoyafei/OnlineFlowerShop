<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.flowershop.bean.*" %>
<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<table class="table table-condensed">
					<thead>
						<tr>
						<%-- <%
							User user = (User)session.getAttribute("user");
							if(user != null && user.getUserRole() == 1) {
						%>
							<th><a><%=user.getEmail() %>,欢迎光临！</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/OnlineFlowerShop/LoginOut" style="color: red;">注销</a></th>
						<%}else{
							response.sendRedirect("/OnlineFlowerShop/index.jsp");
						} %> --%>
							<th><a href="/OnlineFlowerShop/index.jsp">花乐园网上花店系统</a></th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>