<%@page contentType="text/html;charset=utf-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="<%=basePath%>css/login.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>css/page_bottom.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="login_step">
			生成订单步骤: 1.确认订单 > 2.填写送货地址 >
			<span class="red_bold">3.订单成功</span>
		</div>


		<div class="login_success">
			<div class="login_bj">
				<div class="succ" style="height: 80px">
					<img src="<%=basePath%>images/success.png" />
				</div>
				<h5>
					订单已经生成
				</h5>
				

				<ul>
					<li class="nobj">
						您现在可以：<a href="${pageContext.request.contextPath}/user/main">继续浏览并选购商品</a>
					</li>
					
				</ul>
			</div>
		</div>

	</body>
</html>

