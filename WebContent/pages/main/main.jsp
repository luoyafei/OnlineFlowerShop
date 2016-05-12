<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="1.ico" />
<link rel="Bookmark" href="image/1.ico" />
<title>花乐园</title>
<link href="bootstrap.min.css" rel="stylesheet">
<!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
<!-- 自定义css应用 -->
<link href="css/2.css" rel="stylesheet">
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

</head>

<body>
	<!-- 第一行布局 -->
	<jsp:include page="../modul/top.jsp" flush="true"></jsp:include>
	
	<!-- 第二行布局 -->
	<jsp:include page="../modul/content.jsp" flush="true"></jsp:include>
	
	<!-- 第三行布局 -->
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="carousel slide" id="carousel-556301">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-556301"></li>
					<li data-slide-to="1" data-target="#carousel-556301"></li>
					<li data-slide-to="2" data-target="#carousel-556301" class="active">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item">
						<img alt="" src="image/001.png" />
					</div>
					<div class="item">
						<img alt="" src="image/002.png" />
					</div>
					<div class="item active">
						<img alt="" src="image/003.png" />
					</div>
				</div>
				<a class="left carousel-control" href="#carousel-556301"
					data-slide="prev"><span
					class="glyphicon glyphicon-chevron-left"></span></a> <a
					class="right carousel-control" href="#carousel-556301"
					data-slide="next"><span
					class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div>
	</div>


	<!-- 第四行布局 -->
	<jsp:include page="../modul/footer.jsp" flush="true"></jsp:include>

	<!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>