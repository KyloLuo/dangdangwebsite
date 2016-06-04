<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
	<div id="right_info">
		<div class="hotsell">
			图书热卖榜
		</div>
		<div class="hotsellbook">
			<ul>
				<% int i=1;%>
				 <c:forEach items="${hotBooks}" var="list">
				 	<li>
					<a href="#">
					<span style="color: red;displayeinline-block;width: 20px;height: 20px;float: left;"><%=i++ %></span>
					<span style="font-size: 8pt">${list.productName}</span>
					</a>
				    </li>
				 </c:forEach>		
			</ul>
		</div>
	</div>
</body>
</html>