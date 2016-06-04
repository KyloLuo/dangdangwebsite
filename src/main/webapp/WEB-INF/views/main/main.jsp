<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当当图书</title>
<link href="<%=basePath %>css/layout.css" rel="stylesheet" type="text/css" />
               
</head>
<body>
	<div id="head_content">
				<div id="head_container">
		<div id="ddnewhead_operate">
				<div id="ddnewhead_welcome">
				<div id="ddnewhead_welcome_inner">
				<span>${currentUser.nickname}<a href="${pageContext.request.contextPath}/user/loginForm" >【退出】</a></span>
				</div>
			</div>
			<div id="ddnewhead_rightinfo">
				<div id="ddnewhead_rightinfo_div">
					<span class="cart_icon">
						<img alt="" src="<%=basePath %>images/cart_icon.png">
					</span>
					<div class="shopping">
					 <a href="${pageContext.request.contextPath}/cart/list">购物车</a>
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
	</div>
	<div id="main_content">
		<div id="sidemenu_content">
			<c:import url="/category/sidemenu"></c:import>
		</div>
		<div id="middle_content">
			<c:import url="/category/middle"></c:import>
			<div class="book_online_title">
				<img  src="<%=basePath %>images/book_online_title.png">
			</div>
			<div id="newbooks_content">
			<c:import url="/book/last/8"></c:import>
			</div>
		</div>
		<div id="right_content">
		   <c:import url="/book/hot/10"></c:import>
		</div>
	</div>
	<div class="middle_foot">
		<img alt="" src="<%=basePath %>images/middle_foot.png">
	</div>
	<div id="foot_content">
			<c:import url="/category/foot"></c:import>
	</div>
</body>
</html>