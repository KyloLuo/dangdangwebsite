<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户验证-当当网</title>
</head>
<body>
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
					<span class="write_in">输入您收到邮件中的验证码：</span> <input name="verifyCode"
						type="text" /> <input
						class="finsh" type="submit" value="完 成" id="Button1" /> <span
						id="errorMsg" class="no_right"></span>
				</div>
			</div>
		</div>
		</form>
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