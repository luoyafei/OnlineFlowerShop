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
				<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="tabbable" id="tabs-84074">
							<ul class="nav nav-tabs">
								<li><a href="#panel-703736" data-toggle="tab">新用户注册</a></li>
								<li class="active"><a href="#panel-96404" data-toggle="tab">登录</a>
								</li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane" id="panel-703736">
									<p>
										<div role="from" name="login">

										<div class="form-group">
											<label for="email" class="sm-2 control-label"></label>
											<div class="col-sm-12">
												<input type="email" class="form-control input-lg" id="email"
													name="email" placeholder="请填写您的Email地址" value=""> <br>
											</div>
										</div>
										<br>
										<!-- 密码 -->
										<div class="form-group">
											<label for="password" class="control-label"></label>
											<div class="col-sm-12">
												<input type="password" class="form-control input-lg"
													id="password" name="password" placeholder="请输入密码" /><br>
											</div>
										</div>
										<!-- 重复密码 -->
										<div class="form-group">
											<label for="repassword" class="control-label"></label>
											<div class="col-sm-12">
												<input type="password" class="form-control input-lg" id="repassword"
												naem="repassword" placeholder="请再次输入密码" /><br>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-12">
												<button class="btn btn-primary btn-block"
													id="CZ" name="CZ" onclick="registerFunc()">立即注册</button>
											</div>
										</div>
									</div>
									</p>
								</div>
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

										<!-- 记住账号 -->
										<div class="form-group">

											<div class="checkbox-inline">
												<label><input type="checkbox" />记住账号</label>
											</div>

											<!-- 记住密码 -->
											<div class="checkbox-inline">
												<label><input type="checkbox" />记住密码</label>
											</div>

										</div>
										<!-- 登陆 -->
										<div class="form-group">

											<button onclick="loginFunc()" class="btn btn-primary btn-block"
												name="DL">登陆</button>
										</div>

									</div>
									</p>
								</div>
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
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
	<script>
		function registerFunc() {
			var email = $("#email").val().trim();
			var password = $("#password").val().trim();
			var repassword = $("#repassword").val().trim();
			if (email == "" || password == "" || repassword == "") {
				alert("請將信息填寫完整！");
				return;
			} else if(password != repassword) {
				alert("兩次輸入密碼不一致！");
				return;
			} else {
				$.post('/OnlineFlowerShop/UserRegister', {
					email : email,
					password : password,
					repassword : repassword
				}, function(data, textStatus) {
					//alert(textStatus);
					if(textStatus == "success") {
						if(data.status == "-1") {
							alert("注册失败！");
						} else if(data.status == "0") {
							alert("用户邮箱已被注册！");
						} else {
							alert("注册成功！");
							window.location.href = "/OnlineFlowerShop/pages/main/main.jsp";
						}
					}
				}, 'json');
			}
		}
		
		function loginFunc() {
			
			var email = $("#loginemail").val().trim();
			var password = $("#loginpassword").val().trim();
			if (email == "" || password == "") {
				alert("請將信息填寫完整！");
				return;
			} else {
				$.post('/OnlineFlowerShop/LoginIn', {
					email : email,
					password : password,
				}, function(data, textStatus) {
					//alert(textStatus);
					if(textStatus == "success") {
						if(data.status == "-1") {
							alert("登陆失败！");
						} else if(data.status == "0") {
							alert("用户名或密码错误！");
						} else {
							alert("登陆成功！");
							window.location.href = "/OnlineFlowerShop/pages/main/main.jsp";
						}
					}
				}, 'json');
			}
			
			
		}
		
	</script>
</body>
</html>