<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="2.css" rel="stylesheet">
<!--导航栏所需调用-->
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="http://lib.sinaapp.com/js/jquery/1.4.1/jquery.min.js"
	type="text/javascript"></script>

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

	<div class="lanrenzhijia_service">
		<ul>
			<span class="right_bar"></span>
			<a href="http://wpa.qq.com/msgrd?v=3&uin=27864245&site=qq&menu=yes"
				class="right_qq" target="_blank"></a>
			<span class="right_phone">400-XXXXX</span>
		</ul>
	</div>
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
	<div class="row clearfix">
		<div id="menu2">
			<ul>
				<li><a href="#">花店首页</a></li>
				<li><a href="#">个人信息</a></li>
				<li><a href="#">爱情鲜花</a></li>
				<li><a href="#">亲情鲜花</a></li>
				<li><a href="#">友情鲜花</a></li>
				<li><a href="#">意见反馈</a></li>
			</ul>
			<div class="cls"></div>
		</div>
	</div>

	<!-- 第三行布局 -->


	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label for="inputtext3" class="col-sm-2 control-label">您的建议</label><br>
			<div class="col-sm-7">
				<textarea type="text" class="form-control" id="inputtext3" rows="13"></textarea>
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">提交</button>
			</div>
		</div>
	</form>

	<!-- 第四行布局 -->
	<jsp:include page="../modul/footer.jsp" flush="true"></jsp:include>



	<!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


</body>
</html>