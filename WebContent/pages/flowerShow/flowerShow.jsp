<%@page import="com.flowershop.factory.ServiceFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.flowershop.bean.*" %>
   <%
   		String flag = request.getParameter("flowerId");
   		if(flag == null) {
   			response.sendRedirect("/OnlineFlowerShop/pages/main/main.jsp");
   			return;
   		}
   		
   		Integer allItems = ServiceFactory.createFlowerService().getFlowers(Integer.valueOf(flag)).size();
   		Integer start = 0;
   		if(allItems > 7) {
   			Random rd = new Random();
   	   		start = rd.nextInt(allItems-7);
   		}
   		List<Flower> flowers = ServiceFactory.createFlowerService().getFlowers(start, 8, Integer.parseInt(flag));
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
	var flag = <%=flag%>;
	if(flag == "1") {
		$("#imgLove").attr("src", "love/familylove.jpg");
		$("#loveText").text("亲情鲜花专区");
	} else if(flag == "2") {
		$("#imgLove").attr("src", "love/friendlove.jpg");
		$("#loveText").text("友情鲜花专区");
	}
		
	jQuery.jqsxfg51nav = function(jqsxfg51navhover) {
		$(jqsxfg51navhover).prepend("<span></span>");
		
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
	<jsp:include page="../modul/top.jsp" flush="true"></jsp:include>
<!-- 第二行布局 -->
	<jsp:include page="../modul/content.jsp" flush="true"></jsp:include>

<!-- 第三行布局 -->

<hr>
	<div class="row clearfix">
		<div class="col-md-2 column">
		<img alt="140x140" id="imgLove" src='love/love.jpg' />
		 <button type="button" class="btn btn-default btn-success btn-block" id="loveText">爱情鲜花专区</button>
		</div>
		<div class="col-md-1 column">
		</div>
		<div class="col-md-8 column">
			<table class="table" style="text-align:center">
				
				<tbody>
					<tr class="error">
					
					<%
						Integer flowerNum = 0;
						if(flowers.size() > 4)
							flowerNum = 4;
						else
							flowerNum = flowers.size();
						
						for(int i = 0; i < flowerNum; i++) {
							Flower flower = flowers.get(i);
					%>
					
					<td style="border-left:10px solid #DDDDDD;border-right:10px solid #DDDDDD;">
						<a href="product/buyFlower.jsp?flowerNumber=<%=flower.getFlowerId() %>"><img alt="图片加载失败" style="width: 220px;height: 240px;" src="/onlineFlowerShop/img/<%=flower.getFlowerPicture() %>" />
						<%=flower.getFlowerDescribe() %>
						<br>
						<%=flower.getFlowePrice() %>￥
						</a>
					</td>
					<%
						}
					%>
						
					</tr>
						<tr class="error">
						<%
							Integer otherFlowerNum = flowers.size() - flowerNum;
							if(otherFlowerNum > 0) {
								for(int i = 4; i < flowers.size(); i++) {
									Flower flower = flowers.get(i);
									
						%>
							
							<td style="border-left:10px solid #DDDDDD;border-right:10px solid #DDDDDD;">
								<a href="product/buyFlower.jsp?flowerNumber=<%=flower.getFlowerId() %>"><img alt="图片加载失败" style="width: 220px;height: 240px;" src="/onlineFlowerShop/img/<%=flower.getFlowerPicture() %>" />
								<%=flower.getFlowerDescribe() %>
								<br>
								<%=flower.getFlowePrice() %>￥
								</a>
							</td>
						<%
								}
							}
						%>
						
					</tr>
				</tbody>
				<button class="btn btn-default" onclick="freshFlower()" ><img src="images/refresh.png"/></button>
			</table>
		</div>
		<div class="col-md-1 column">
		</div>
	</div>
<script>
	function freshFlower() {
		window.location.reload();
	}
</script>

<!-- 第四行布局 -->
	<jsp:include page="../modul/footer.jsp" flush="true"></jsp:include>

<!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
        <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
        <!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 

</body>
</html>