<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!---浏览器 状态栏与收藏栏图标设置----->
<link rel="shortcut icon" href="1.ico" />
<link rel="Bookmark" href="1.ico" />
<!---浏览器状态栏标题设置----->
<title>花乐园</title>

<script src="../../assets/jQuery/2.x/jquery-2.1.4.min.js"></script>


<!-- Bootstrap框架应用 -->
<link href="bootstrap.min.css" rel="stylesheet">
<!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
<!-- 自定义css应用 -->
<link href="1.css" rel="stylesheet">
</head>
<html>
<body>
	<section>
	<div class="container">
		<div class="row clearfix">
			<jsp:include page="../modul/top.jsp" flush="true"></jsp:include>
			<div class="col-md-3 column"></div>
			<div class="col-md-6 column">
				<!-- 第一行 -->

				<br> <br> <br>
				<div align="center">
					<a href="/OnlineFlowerShop/pages/main/main.jsp"><img src="image/1.png"></a>
				</div>
				<br> <br>

				<!-- 第二行 -->
				<div class="row">
				  <div class="col-sm-6 col-md-4">
				    <div class="thumbnail">
				      <img data-src="holder.js/300x300" alt="...">
				      <div class="caption">
				        <h3>Thumbnail label</h3>
				        <p>...</p>
				        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
				      </div>
				    </div>
				  </div>
				</div>

			</div>
			<div class="col-md-3 column"></div>
		</div>
	</div>
	</section>
	<!-- 第四行布局 -->
	<jsp:include page="../modul/footer.jsp" flush="true"></jsp:include>

	<!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		
	/* 
	*   | flowerId       | int(11)      | NO   | PRI | NULL    | auto_increment |
		| flowerName     | varchar(255) | YES  | UNI | NULL    |                |
		| flowerCategary | varchar(255) | NO   |     | NULL    |                |
		| flowerPicture  | varchar(255) | NO   |     | NULL    |                |
		| flowePrice     | varchar(11)  | NO   |     | NULL    |                |
		| flowerDescribe | text         | NO   |     | NULL    |
	*/
	
		$(document).ready(function() {
			var flowerId = <%=request.getParameter("flowerId") %>;
			if(flowerId == null) {
				window.location.href = "/OnlineFlowerShop/pages/main/main.jsp";
			} else {
				//alert(flowerId);
			}
			
		});
	</script>
	
</body>
</html>