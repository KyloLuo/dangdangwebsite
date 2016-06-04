<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=basePath %>css/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="head_container">
		<div id="ddnewhead_operate">
			<div id="ddnewhead_welcome">
				<div id="ddnewhead_welcome_inner">
				<span>欢迎光临当当，请先 <a href="${pageContext.request.contextPath}/user/loginForm">登录</a>&nbsp;
				<a href="${pageContext.request.contextPath}/user/registerForm">免费注册</a></span>
				</div>
			</div>
			<div id="ddnewhead_rightinfo">
				<div id="ddnewhead_rightinfo_div">
					<span class="cart_icon">
						<img alt="" src="<%=basePath %>images/cart_icon.png">
					</span>
					<div class="shopping">
					 <a href="${pageContext.request.contextPath}/user/loginForm">购物车</a>
					</div>
					 <a href="./cart/cart_list.jsp">我的当当</a>
				</div>
			</div>
		</div>
	</div>
	<div id="logo_line_out">
		<div id="logo_line">
			<div id="logo">
				<img src="http://img35.ddimg.cn/upload_img/00405/luyi/logo-2.jpg">
			</div>
		</div>
	</div>
	<div id="nav_top">
		<ul >
			<li><a href="">童书</a></li>
			<li><a href="">教辅</a></li>
			<li><a href="">小说</a></li>
			<li><a href="">管理</a></li>
			<li><a href="">成功励志</a></li>
			<li><a href="">历史</a></li>
			<li><a href="">青春文学</a></li>
			<li><a href="">传记</a></li>
			<li><a href="">科技</a></li>
			<li><a href="">工具书</a></li>
		</ul>
	</div>
	<div class="promote_image">

	</div>
</body>
</html>