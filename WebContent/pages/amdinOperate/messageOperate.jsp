<%@page import="com.flowershop.factory.ServiceFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.flowershop.bean.*" %>

	
<%
	String divideNum = "0";
	if(request.getParameter("divideNum") != null) {
		if(Integer.parseInt(request.getParameter("divideNum")) >= 0)
			divideNum = request.getParameter("divideNum");
	}

	List<Message> messages = ServiceFactory.createMessageService().getAllMessage();
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
section{height:300px;text-align:center;}
aside{height:300px;text-align:center;}
*{ margin:0; padding:0; list-style:none}
img{ border:0;}
</style>

</head>

<body>


<!-- 第一行布局 -->
	<jsp:include page="../adminModul/top.jsp" flush="true"></jsp:include>
<!-- 第二行布局 -->
	<jsp:include page="../adminModul/content.jsp" flush="true"></jsp:include>



<!-- 第三行布局 -->
<div class="row clearfix">
	<div class="col-md-12 column">
	<label style="text-align:center;color:red;font-size: 18px">反馈总数：<%=messages.size() %></label>
	 <div class="bs-example" style="color:black;">
			    <table class="table table-hover">
			    
			      <thead>
			        <tr>
			          <th style="text-align: center;">反馈人</th>
			          <th style="text-align: center;">反馈信息</th>
			          <th style="text-align: center;">反馈时间</th>
			          <th style="text-align: center;">操作</th>
			        </tr>
			      </thead>
			      <tbody>
			 		<%
						
						int otherNum = messages.size() - Integer.parseInt(divideNum)*8;
						if(Integer.parseInt(divideNum) == 0)
							out.print("<script type=text/javascript>var flag = 1;</script>");//当是第一页时，隐藏上一页
						
						if(otherNum >= 8) {
							otherNum = 8;
						} else {
							out.print("<script type=text/javascript>var flag = 2;</script>");//当是最后一页时，隐藏下一页
						}
						
						for(int j = Integer.parseInt(divideNum)*8; j < Integer.parseInt(divideNum)*8+otherNum; j++) {
							Message message = messages.get(j);
							
			        %>
			        
			        <tr>
			        	  <td style="text-align: center;"><label><%=ServiceFactory.createUserService().getUserInId(message.getUserId()).getEmail()%></label></td>
			        	  <td style="text-align: center;"><label><%=message.getMessageContent()%></label></td>
			        	  <td style="text-align: center;"><label><%=message.getMessageTime()%></label></td>
				          <td style="text-align: center;">
							<a type="button" class="btn btn-primary btn-xs" href="/OnlineFlowerShop/DeleteMessage?divideNum=<%=divideNum %>&item=<%=message.getMessageId()%>">删除</a>
						  </td>
			        	
			        </tr>
			        
			         <%
				         	}
			        %>
			       
			      </tbody>
			    </table>
			  </div>
	</div>
	<div class="col-md-4 column" style="float: right;">
		<a class="btn btn-info" id="before" href="/OnlineFlowerShop/pages/amdinOperate/messageOperate.jsp?divideNum=<%=Integer.parseInt(divideNum)-1%>">上一页</a>
		<a class="btn btn-info" id="next" href="/OnlineFlowerShop/pages/amdinOperate/messageOperate.jsp?divideNum=<%=Integer.parseInt(divideNum)+1%>">下一页</a>
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