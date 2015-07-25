<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户验证-当当网</title>
</head>
<body>

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
</body>
</html>