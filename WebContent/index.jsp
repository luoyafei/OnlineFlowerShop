<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="shortcut icon" href="assets/image/1.ico" />
		<link rel="Bookmark" href="assets/image/1.ico"  />
        <title>花乐园</title>
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link href="assets/css/1.css" rel="stylesheet">              
</head>

<body>
<header>
<table border="0" width="100%" >
					<tr>
						<td>
							
						</td>
						<td>
						<div style="margin-top:8px">
							<p align="right"><a href="pages/main/main.jsp">
							<button type="button" class="btn btn-primary">进入系统</button>
							</a></p>
						</div>
						</td>
					</tr>
					
</table>
</header>

<section style="background:url(assets/image/1.jpg) no-repeat;">
	<script type="text/javascript">
		$(function(){
				$('#background').height($(window).height());
				$('#background').width($(window).width());
		});
	</script>
</section>
	
<footer>
	<jsp:include page="pages/modul/footer.jsp" flush="true"></jsp:include>
</footer>

</body>
</html>