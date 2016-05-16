<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.flowershop.bean.*" %>
<%
	String flag = request.getParameter("flag");
	if(flag != null) {
		if(flag == "1") {
			out.print("<script type=text/javascript>alert('上传失败！');</script>");
		} else {
			out.print("<script type=text/javascript>alert('上传成功！');</script>");
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<!---定义字符集，统一用UTF-8----->
		<meta charset="UTF-8">
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
	  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />	
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

a:hover {color:red;text-decoration: none;}/* 鼠标指针移动到链接上 */

a:active {color:#0000FF;}/* 正在被点击的链接 */

</style>
<link rel="stylesheet" type="text/css" href="css/default.css">
<link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />	
</head>

<body>


<!-- 第一行布局 -->
	<jsp:include page="../adminModul/top.jsp" flush="true"></jsp:include>
<!-- 第二行布局 -->
	<jsp:include page="../adminModul/content.jsp" flush="true"></jsp:include>

<!-- 第三行布局 -->
<hr>

<div class="row clearfix">
		<div class="col-md-1 column">
		</div>
		<div class="col-md-10 column">
		<form role="from" name="login" method="post" action="/OnlineFlowerShop/UploadDeal" onsubmit="return checkform();"enctype="multipart/form-data">
		<hr>
<!--上传图片-->
	<div class="row clearfix">
		<div class="col-md-2 column">
			&nbsp;&nbsp;&nbsp;
			<label>
				上传花朵
			</label>
		</div>
		<div class="col-md-8 column">
			<div class="container">
				<input id="file" name="file" type="file" accept="image/*">   
			</div>
		</div>
	</div>
		<hr>
<!--文字描述-->
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="form-group">
				<label for="description"class="col-sm-2 control-label">
					花朵描述
				</label>
				<div class="col-sm-10">
					<input id="description" name="description" class="form-control" type="text" placeholder="请输入物品简介"maxlength="300"/>
				</div>
			</div>
		</div>
	</div>
<hr>
<!--出售价格-->	
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="form-group">
				<label for="price" class="col-sm-2 control-label">
					出售价格
				</label>
				<div class="col-sm-10">
					<input id="price" name="price" class="form-control" type="text" placeholder="请输入想要出售的金额" maxlength="10"/>
				</div>
			</div>
		</div>
	</div>
		<hr>
<!--联系方式-->
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="form-group">
					<label for=" phone" class="col-sm-2 control-label">花朵类型</label>
					<div class="col-sm-10">
						<div class="btn-group" data-toggle="buttons">
						  <label class="btn btn-primary active">
						    <input type="radio" name="flowerCategary" id="flowerCategary1" value="0" autocomplete="off" checked>爱情鲜花
						  </label>
						  <label class="btn btn-primary">
						    <input type="radio" name="flowerCategary" id="flowerCategary2" value="1" autocomplete="off">亲情鲜花
						  </label>
						  <label class="btn btn-primary">
						    <input type="radio" name="flowerCategary" id="flowerCategary3" value="2" autocomplete="off">友情鲜花
						  </label>
						</div>
					</div>
			</div>
		</div>
	</div>
		<hr>
<!--按钮组-->
	<div class="row clearfix">
		<div class="col-md-10 column">
			<button type="submit" class="btn btn-primary">上传物品</button> 
			<button type="reset" class="btn btn-default">重置物品</button> 
		</div>
	</div>
	</form>	

		</div>
		<div class="col-md-1 column">
		</div>
</div>
	
	
	
<!-- 第四行布局 -->
	<jsp:include page="../modul/footer.jsp" flush="true"></jsp:include>

<!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
        <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
        <!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 

<script type="text/javascript" src="check.js"></script>
<script src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js"></script>
<script src="js/fileinput.js" type="text/javascript"></script>
<script src="js/fileinput_locale_zh.js" type="text/javascript"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>