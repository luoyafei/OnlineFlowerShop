<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.flowershop.factory.ServiceFactory"%>
<%@ page import="com.flowershop.bean.*" %>    
    
<%
	String flowerId = request.getParameter("flowerNumber");
	if(flowerId == null) {
		out.println("<script type=text/javascript>window.history.go(-1)</script>");
		return;
	}
	Flower flower = ServiceFactory.createFlowerService().getFlowerInId(Integer.valueOf(flowerId));
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!---IE兼容设置----->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!---移动设备兼容设置----->
		<meta name="viewport" content="width=device-width, initial-scale=1">
<!---浏览器 状态栏与收藏栏图标设置----->
		<link rel="shortcut icon" href="1.ico" />
		<link rel="Bookmark" href="1.ico"  />
<!---浏览器状态栏标题设置----->
        <title>花乐园</title>
<!-- Bootstrap框架应用 -->
       <link href="bootstrap.min.css" rel="stylesheet">
<!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
<!-- 自定义css应用 -->
        <link href="2.css" rel="stylesheet">  
<!--导航栏所需调用-->
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="http://lib.sinaapp.com/js/jquery/1.4.1/jquery.min.js" type="text/javascript"></script>

<SCRIPT type=text/javascript>
$(document).ready(function() {	

	jQuery.jqsxfg51nav = function(jqsxfg51navhover) {
		$(jqsxfg51navhover).prepend("<span></span>"); //懒人建站 http://www.51xuediannao.com/
		
		$(jqsxfg51navhover).each(function() { 
			var linkText = $(this).find("a").html(); 
			$(this).find("span").show().html(linkText); 
		}); 
		
		$(jqsxfg51navhover).hover(function() {	
			$(this).find("span").stop().animate({ 
				marginTop: "-40" 
			}, 250);
		} , function() { 
			$(this).find("span").stop().animate({
				marginTop: "0" 
			}, 250);
		});	
	};
	//下面是调用方法，一个页面也可以调用很多次
	$.jqsxfg51nav("#menu1 li");
	$.jqsxfg51nav("#menu2 li");
});
</SCRIPT>
<style>
*{ margin:0; padding:0; list-style:none}
img{ border:0;}


a:hover {color:red;text-decoration: none;}/* 鼠标指针移动到链接上 */

a:active {color:#0000FF;}/* 正在被点击的链接 */

</style>

</head>

<body>

<!-- 第一行布局 -->
	<jsp:include page="../../modul/top.jsp" flush="true"></jsp:include>
<!-- 第二行布局 -->
	<jsp:include page="../../modul/content.jsp" flush="true"></jsp:include>
<!-- 第三行布局 -->
<hr>
<div class="row clearfix">
<div class="col-md-3 column"></div>
		<div class="col-md-2 column">
			<img alt="图片加载失败！" src="/onlineFlowerShop/img/<%=flower.getFlowerPicture() %>" style="width:220px; heigth: 240px;" />   <!--花朵信息动态提取-->
		</div>
		<div class="col-md-3 column">
			
			<div class="row clearfix">
				<div class="col-md-12 column">
			<table class="table table-hover">
			
			<tr class="success">
				<td><font color="black" size="4">名称</font></td>
				<td> <font color="black" size="4"> 
				<%=flower.getFlowerCategary()%>
				</font></td>
			</tr>
			<tr class="success">
				<td><font color="black" size="4">价格</font></td>
				<td> <font color="black" size="4"> 
				<%=flower.getFlowePrice()%>￥
				</font></td>
			</tr>
			
			<tr class="info">
				<td><font color="black" size="4">描述</font></td>
				<td> <font color="black" size="4"> 
				<%=flower.getFlowerDescribe()%>
				</font></td>
			</tr>
			
			<tr class="info">
				<td><font color="black" size="4">数量</font></td>
				<td><input type="number" id="flowerCount" name="flowerCount" style="color:black;width: 80px;"/></td>
			</tr>
					
			</table>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<br>
					<button type="button" onclick="addCar()" class="btn btn-success btn-lg btn-block">加入购物车</button>
				</div>
			</div>
		</div>
		<div class="col-md-4 column"></div>
</div>
<!-- 第四行布局 -->
	<jsp:include page="../../modul/footer.jsp" flush="true"></jsp:include>
<!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
        <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
        <!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 

<script>
	function addCar() {
		var flowerCount = $("#flowerCount").val().trim();
		if(flowerCount != 0 && 0 < flowerCount*1) {
			if(100 < flowerCount*1) {
				alert("请选择你想要买的鲜花的数量！0~99");
				return;
			} else {
				$.post('/OnlineFlowerShop/AddShopCar', {
					flowerCount : flowerCount,
					flowerId : <%=flowerId%>
				}, function(data, textStatus){
					if(textStatus == "success") {
						var result = data.status;
						if(result == "1") {
							alert("成功加入购物车！");
						} else {
							alert("加入失败！请先进行登录操作！");
						}
					}
				}, 'json');
			}
		} else {
			alert("请选择你想要买的鲜花的数量！0~99");
			return;
		}
	}
</script>

</body>
</html>