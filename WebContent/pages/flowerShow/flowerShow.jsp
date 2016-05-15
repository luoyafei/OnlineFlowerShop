<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<jsp:include page="../modul/top.jsp" flush="true"></jsp:include>
<!-- 第二行布局 -->
	<jsp:include page="../modul/content.jsp" flush="true"></jsp:include>

<!-- 第三行布局 -->
<hr>
	<div class="row clearfix">
		<div class="col-md-2 column">
		<img alt="140x140" src="love.jpg" />
		 <button type="button" class="btn btn-default btn-success btn-block">爱情鲜花专区</button>
		</div>
		<div class="col-md-1 column">
		</div>
		<div class="col-md-8 column">
			<table class="table" style="text-align:center">
				
				<tbody>
					<tr class="error">
						<td style="border-left:10px solid #DDDDDD;border-right:10px solid #DDDDDD;">
								<a href="product/001.html"><img alt="140x140" src="loveflower/001.jpg" />
								鲜花 用心爱你<br>￥499
								</a>
						</td>
						<td style="border-right:10px solid #DDDDDD;">
								<a href="product/002.html"><img alt="140x140" src="loveflower/002.jpg" />
								鲜花 致美丽的你<br>￥128</a>
						</td>
						<td style="border-right:10px solid #DDDDDD;">
								<a href="product/002.html"><img alt="140x140" src="loveflower/003.jpg" />
								鲜花 苏格兰风情<br>￥189</a>
						</td>
						<td style="border-right:10px solid #DDDDDD;">
								<a href="product/002.html"><img alt="140x140" src="loveflower/004.jpg" />
								鲜花 忘情巴黎<br>￥290</a>
						</td>
						
					</tr>
						<tr class="error">
						<td style="border-left:10px solid #DDDDDD;border-right:10px solid #DDDDDD;">
								<a href="product/002.html"><img alt="140x140" src="loveflower/005.jpg" />
								
								鲜花 真爱如初<br>￥196
								</a>
						</td>
						<td style="border-right:10px solid #DDDDDD;">
								<a href="product/002.html"><img alt="140x140" src="loveflower/006.jpg" />
								鲜花 一往情深<br>￥239</a>
						</td>
						<td style="border-right:10px solid #DDDDDD;">
								<a><img alt="140x140" src="loveflower/007.jpg" />
								鲜花 爱在心头<br>￥348</a>
						</td>
						<td style="border-right:10px solid #DDDDDD;">
								<a href="product/002.html"><img alt="140x140" src="loveflower/008.jpg" />
								鲜花 用心爱你<br>￥499</a>
						</td>
					</tr>
				</tbody>
			</table>
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


</body>
</html>