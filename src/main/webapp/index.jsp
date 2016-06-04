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
			<c:import url="/category/headpage"></c:import>
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