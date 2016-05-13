<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.flowershop.bean.*" %>
<div class="row clearfix">
		<div id="menu2">
			<ul>
			
			<%
				User user;
				if(session.getAttribute("user") != null) {
					user = (User)session.getAttribute("user");
			%>
				<li><a href="/OnlineFlowerShop/pages/modifyUserInfo/modifyUserInfo.jsp">个人信息</a></li>
			<%}%>
			
			
				<li><a href="/OnlineFlowerShop/pages/main/main.jsp">花店首页</a></li>
				<li><a href="/OnlineFlowerShop/pages/flowerShow/flowerShow.jsp?flowerId=0">爱情鲜花</a></li>
				<li><a href="/OnlineFlowerShop/pages/flowerShow/flowerShow.jsp?flowerId=1">亲情鲜花</a></li>
				<li><a href="/OnlineFlowerShop/pages/flowerShow/flowerShow.jsp?flowerId=2">友情鲜花</a></li>
				<li><a href="/OnlineFlowerShop/pages/commentFeedback/commentFeedback.jsp">意见反馈</a></li>
			</ul>
			<div class="cls"></div>
		</div>
	</div>