<%@page import="com.flowershop.factory.ServiceFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.flowershop.bean.*" %>
<%
		User user = (User)session.getAttribute("user");
		if(user == null) {
			response.sendRedirect("/OnlineFlowerShop/pages/main/main.jsp");
			return;
		}
		
		if(request.getParameter("ok")!=null) {
			String ok = request.getParameter("ok");
			if(ok.equals("0")) {
				out.print("<script type=text/javascript>alert('删除成功！');</script>");
			} else if(ok.equals("1")) {
				out.print("<script type=text/javascript>alert('删除失败!');</script>");
			}
				
		}
		
		List<FlowerOrder> orders = ServiceFactory.createOrderService().getFlowerOrders(user);
		
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="1.ico" />
<link rel="Bookmark" href="1.ico" />
<title>花乐园</title>
<!-- Bootstrap框架应用 -->
<link href="bootstrap.min.css" rel="stylesheet">
<!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
<!-- 自定义css应用 -->
<link href="../../assets/css/1.css" rel="stylesheet">
<!--导航栏所需调用-->
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="http://lib.sinaapp.com/js/jquery/1.4.1/jquery.min.js" type="text/javascript"></script>

<SCRIPT type=text/javascript>
	$(document).ready(function() {

		jQuery.jqsxfg51nav = function(jqsxfg51navhover) {
			$(jqsxfg51navhover).prepend("<span></span>");

			$(jqsxfg51navhover).each(function() {
				var linkText = $(this).find("a").html();
				$(this).find("span").show().html(linkText);
			});

			$(jqsxfg51navhover).hover(function() {
				$(this).find("span").stop().animate({
					marginTop : "-40"
				}, 250);
			}, function() {
				$(this).find("span").stop().animate({
					marginTop : "0"
				}, 250);
			});
		};
		//下面是调用方法，一个页面也可以调用很多次
		$.jqsxfg51nav("#menu1 li");
		$.jqsxfg51nav("#menu2 li");
	});
</SCRIPT>
<style>
section {
	height: 300px;
	text-align: center;
}

aside {
	height: 300px;
	text-align: center;
}

* {
	margin: 0;
	padding: 0;
	list-style: none
}

img {
	border: 0;
}

.lanrenzhijia_service {
	width: 40px;
	height: 200px;
	background:
		url(http://demo.lanrenzhijia.com/2014/service0924/images/lanrenzhijia.png)
		no-repeat;
	position: fixed;
	right: 0px;
	top: 200px;
}

.lanrenzhijia_service ul {
	display: block;
	width: 160px;
	height: 200px;
	float: left;
	position: relative;
}

.lanrenzhijia_service ul .right_bar {
	position: absolute;
	width: 40px;
	height: 200px;
	left: 0;
	top: 0;
	display: block;
}

.lanrenzhijia_service ul .right_qq {
	position: absolute;
	width: 120px;
	height: 85px;
	right: 0;
	top: 0;
	display: block;
}

.lanrenzhijia_service ul .right_phone {
	position: absolute;
	width: 120px;
	height: 105px;
	padding-top: 10px;
	right: 0;
	bottom: 0;
	display: block;
	text-align: center;
	color: #555;
	font-size: 16px;
	font-family: 'Microsoft Yahei';
	text-decoration: none;
}
</style>

</head>

<body>
	<script src="http://www.lanrenzhijia.com/ajaxjs/jquery.min.js"></script>
	<script>
		$(function() {
			$(".lanrenzhijia_service").hover(function() {
				$(this).animate({
					width : '160px'
				});
			}, function() {
				$(this).animate({
					width : '40px'
				});
			});
		});
	</script>
	<!-- 第一行布局 -->
		<jsp:include page="../modul/top.jsp" flush="true"></jsp:include>
	<!-- 第二行布局 -->
		<jsp:include page="../modul/content.jsp" flush="true"></jsp:include>

	<!-- 第三行布局 -->
	
		<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
		
		<%
			for(int i = 0; i < orders.size(); i++) {
				FlowerOrder order = orders.get(i);
		%>
		
		  <div class="panel panel-default">
		    <div class="panel-heading" role="tab" id="headingOne<%=i%>">
		      <h4 class="panel-title">
		        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne<%=i%>" aria-expanded="true" aria-controls="collapseOne<%=i%>">
		          	<div class="row">
					  <div class="col-sm-1">订单号:<%=order.getOrderId() %></div>
					  <div class="col-sm-2" style="color: red;">总价:<%=order.getTotalPrice()%>￥</div>
					  <div class="col-sm-3">地址:<%=order.getAddr() %></div>
					  <div class="col-sm-3">日期:<span><%=order.getOrderDate().substring(0, order.getOrderDate().indexOf(".")) %></span></div>
					  <div class="col-sm-2">订单状态:<%=order.getStatus()==0?"处理中":(order.getStatus()==1?"订单成功":"订单失败")%></div>
					  <div class="col-sm-1"><a class="btn btn-xs btn-danger" href="/OnlineFlowerShop/DeleteOrder?item=<%=order.getOrderId() %>">删除</a></div>
					</div>
		        </a>
		      </h4>
		    </div>
		    <div id="collapseOne<%=i%>" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne<%=i%>">
		      <div class="panel-body">
		        <div class="bs-example" style="color:black;">
				    <table class="table table-hover">
				      <thead>
				        <tr>
				          <th>鲜花</th>
				          <th>种类</th>
				          <th>描述</th>
				          <th>单价</th>
				          <th>个数</th>
				        </tr>
				      </thead>
				      <tbody>
				        
				 		<%
							List<FlowerOrderItem> items = ServiceFactory.createOrderItemService().getOrderItemsInFlowerOrderId(order.getOrderId());
							for(int j = 0; j < items.size(); j++) {
								FlowerOrderItem item = items.get(j);
								Flower flower = ServiceFactory.createFlowerService().getFlowerInId(item.getFlowerId());
				        %>
				        <tr>
				          <td><img alt="图片加载失败！" src="/onlineFlowerShop/img/<%=flower.getFlowerPicture() %>" style="width:60px; heigth: 70px;" /> </td>
				          <td><%=flower.getFlowerCategary()%></td>
				          <td><%=flower.getFlowerDescribe()%></td>
				          <td><%=flower.getFlowePrice()%>￥</td>
				          <td><%=item.getFlowerCount()%></td>
				        </tr>
				         <%
					         	}
				        %>
				       
				      </tbody>
				    </table>
				  </div>
		      </div>
		    </div>
		  </div>
		  
		  <%
			}
		  %>
		  </div>
		  
	<!-- 第四行布局 -->
	<jsp:include page="../modul/footer.jsp" flush="true"></jsp:include>

	<!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>