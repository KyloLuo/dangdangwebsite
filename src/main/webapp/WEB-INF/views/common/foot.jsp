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
	<div id="foot_info">
		<div class="footer_pic_new">
			<div class="footer_pic_new_inner">
				<img alt="" src="<%=basePath %>images/foot_icon.png">
			</div>
			<div class="public_footer_new">
				<img alt="" src="<%=basePath %>images/foot_help.png">
			</div>
			<span>Copyright (C) 当当网 2014-2015, 苏州科技学院达内暑期实训第九组</span>
		</div>
	</div>
</body>
</html>