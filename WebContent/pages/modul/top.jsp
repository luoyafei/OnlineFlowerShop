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
							<th><a><%=user.getEmail() %>,欢迎光临！</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="out()" style="color: red;">注销</a></th>
							<th><a href="/OnlineFlowerShop/pages/myorderListShow/myorderList.jsp">订单查询</a></th>
							
							<script>
								function out() {
									if(confirm("退出登录后，您购物车内的物品将无法保留，是否确认退出？")) {
										window.location.href="/OnlineFlowerShop/LoginOut";
										return;
									} else {
										return;
									}
								}
							</script>
							
						<%}else{ %>
							<th><a href="/OnlineFlowerShop/pages/signInOut/reg.jsp">你好,请登录</a></th>
							<th><a href="/OnlineFlowerShop/pages/signInOut/reg.jsp">注册</a></th>
						<%} %>
							<th><a href="/OnlineFlowerShop/index.jsp">花乐园网上花店系统</a></th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>