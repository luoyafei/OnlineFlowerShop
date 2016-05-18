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
<title>后台管理</title>

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
<body>
	<section>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-3 column"></div>
			<div class="col-md-6 column">
				<br> <br>

				<!-- 第二行 -->
				<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="tabbable" id="tabs-84074">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#panel-96404" data-toggle="tab">登录</a>
								</li>
							</ul>
								<div class="tab-pane active" id="panel-96404">
									<p>
									<div role="from" name="login">
										<!-- 个人账号 -->
										<div class="form-group">
											<input type="text" class="form-control input-lg"
												id="loginemail" name="loginemail" placeholder="Email地址" />
										</div>
										<!-- 密码 -->
										<div class="form-group">
											<input type="password" class="form-control input-lg"
												id="loginpassword" name="loginpassword"
												placeholder="密码（6-20位，区分大小写）" />
										</div>

										<!-- 登陆 -->
										<div class="form-group">

											<button onclick="loginFunc()"
												class="btn btn-primary btn-block" name="DL">登陆</button>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<div class="col-md-3 column"></div>
		</div>
	</section>
	<!-- 第四行布局 -->

	<!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

	<script>
		/* 
		 *异步发送登陆请求，通过返回的json数据，-1代表登陆失败！0代表用户邮箱或密码错误！1代表用户登陆成功！成功之后将自动跳转到主页！
		 */
		function loginFunc() {
			var email = $("#loginemail").val().trim();
			var password = $("#loginpassword").val().trim();
			if (email == "" || password == "") {
				alert("请将信息填写完整！");
				return;
			} else {
				$.post('/OnlineFlowerShop/AdminLogin',{
					email : email,
					password : password,
				},function(data, textStatus) {
					if (textStatus == "success") {
						if (data.status == "-1") {
							alert("登陆失败！");
						} else if (data.status == "0") {
							alert("用户邮箱或密码错误！");
						} else {
							window.location.href = "/OnlineFlowerShop/pages/amdinOperate/adminUploadFlower.jsp";
						}
					}
				}, 'json');
			}
		}
	</script>
</body>
</html>