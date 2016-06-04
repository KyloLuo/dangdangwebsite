<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户验证-当当网</title>
<link href="<%=basePath %>css/login.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>css/page_bottom.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath %>js/jquery-2.1.1.js" ></script>
</head>
<body>
	
	<div class="login_top">
	<a href="#" target="_blank"><img class="logo"
			src="http://img35.ddimg.cn/upload_img/00405/luyi/logo-2.jpg" /> </a>
    </div>

	<div class="login_step">
		注册步骤: 1.填写信息 > <span class="red_bold">2.验证邮箱</span> > 3.注册成功
	</div>
	<form action="${pageContext.request.contextPath}/user/verify" method="post">
		<div class="validate_email">
			<h2>感谢您注册当当网！现在请按以下步骤完成您的注册!</h2>
			<div class="look_email">
				<h4>第一步：查看您的电子邮箱</h4>
				<div class="mess reduce_h">
					我们给您发送了验证邮件，邮件地址为：${user_register.email} <span class="red"><span
						id="lblEmail">"${user_register.nickname}"</span> </span> <span class="t1"> 请登录您的邮箱收信。 
				</div>
				<h4>第二步：输入验证码</h4>
				<div class="mess">
					<span class="write_in">输入您收到邮件中的验证码：</span> 
					<input name="verifyCode" type="text" />
						 <input class="finsh" type="submit" value="完 成" id="Button1" /> <span
						id="errorMsg" class="no_right"></span>
				</div>
			</div>
		</div>
		</form>
	<div>
	<center>
		<hr style="height: 1px; width: 972px; color: #cfcfcf" />
		<div class="b_left"></div>
		<div class="publish_bottom_message2">
			<div class="copyright">
				Copyright (C) 当当网 2004-2008, All Rights Reserved
			</div>
			<div class="validate">
				<a
					href="#http://www.hd315.gov.cn/beian/view.asp?bianhao=010202001051000098"
					target="_blank"> <img
						src="${pageContext.request.contextPath}/images/validate.gif"
						border="0" /> </a>
				<p>
					<a href="" target="_blank">京ICP证041189号</a>
				</p>
			</div>
		</div>
	</center>
</div>
	<p>${verify_msg}</p>
	
	<script>
		function vefiry(){
			var json={
				"verifyCode" : $("#txtEmail").val()
			};
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath}/user/verify',
				data : json,
				success : function(data) {
					console.log(data);
				},
				error : function(status) {
					console.log(status);
				}

			});
		}
	</script>
</body>
</html>