<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
			注册步骤: 1.填写信息 > 2.验证邮箱 >
			<span class="red_bold">3.注册成功</span>
		</div>


		<div class="login_success">
			<div class="login_bj">
				<div class="succ">
					<img src="${pageContext.request.contextPath}/images/login_success.jpg" />
				</div>
				<h5>
					"${user_register.nickname}",欢迎加入当当网
				</h5>
				<h6>
					请牢记您的登录邮件地址："${user_register.email}"
				</h6>

				<ul>
					<li class="nobj">
						您现在可以：
					</li>
					<li>
						进入“
						<a href="#">我的当当</a>”查看并管理您的个人信息
					</li>
					<li>
						<a href="../main/main.jsp">浏览并选购商品</a>
					</li>
				</ul>
			</div>
		</div>
		
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
</body>
</html>