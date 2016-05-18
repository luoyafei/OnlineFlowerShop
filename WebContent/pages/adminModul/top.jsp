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
							User user = (User)session.getAttribute("user");
							if(user != null && user.getUserRole() == 1) {
						%>
							<th><a><%=user.getEmail() %>,欢迎光临！</a></th>
						<%}else{%>
							<script type="text/javascript">window.location.href="/OnlineFlowerShop/index.jsp";</script>
						<%} %>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>