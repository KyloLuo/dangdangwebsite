<%@page contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="<%=basePath %>css/login.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath %>css/page_bottom.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath %>css/public_footer.css" rel="stylesheet" type="text/css" />
		<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
	</head>
	<body>
		<div class="login_top">
	  <a href="#" target="_blank"><img class="logo"
			src="http://img35.ddimg.cn/upload_img/00405/luyi/logo-2.jpg" /> </a>
       </div>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form:form  modelAttribute="userForm" method="post"
					 action="${pageContext.request.contextPath}/user/register" id="form">
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<form:input path="email" type="text" id="txtEmail" class="text_input" onblur="check()"/>
			
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，
								</p>
								<p>
									在下一步中您将用此邮箱接收验证邮件。
								</p>
									<span id="email.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<form:input path="nickname" type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="name.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<form:password path="password"  id="txtPassword"
								class="text_input" />
							<div class="text_left" id="passwordValidMsg" >
								<p>
									您的密码可以由大小写英文字母、
								</p>
								<p>
									数字组成，长度6－20位。
								</p>
								<span id="password.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="txtRepeatPass"
								class="text_input"/>
							<div class="text_left" id="repeatPassValidMsg">
							<span id="password1.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="${pageContext.request.contextPath}/code" />
							<input name="number" type="text" id="txtVerifyCode"
								class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									
									<span id="number.info" style="color:red"></span>
									<a href="#" onclick="changeImg()">看不清楚？换个图片</a>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form:form>
		</div>
		<div class="public_footer">
	 <div class="public_footer_bottom">
		<div class="public_footer_icp" style="line-height: 48px;">
			Copyright (C) 当当网 2004-2008, All Rights Reserved
			<a href="#" target="_blank"><img
					src="<%=basePath %>images/validate.gif" border="0" align="middle" /> </a>
			<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
		</div>
	 </div>
</div>

<script type="text/javascript">
		function changeImg() {
			var imgSrc = $("#imgVcode");
			var src = imgSrc.attr("src");
			imgSrc.attr("src", chgUrl(src));
		}
		//时间戳   
		//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳   
		function chgUrl(url) {
			var timestamp = (new Date()).valueOf();
			url = url.substring(0, 17);
			if ((url.indexOf("&") >= 0)) {
				url = url + "×tamp=" + timestamp;
			} else {
				url = url + "?timestamp=" + timestamp;
			}
			return url;
		}
	</script>
	<script>
		function com() {
			var json = {
				"email" : $("#txtEmail").val()
			};
			console.log(json);
			return json;
		}

		function check() {
			//var data={};
			//data.email="978364051@qq.com"
			//console.log(data.email);
			//data.password="dpc123"
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath}/user/check',
				data : com(),
				success : function(data) {
					console.log(data);
				},
				error : function(status) {
					console.log(status);
				}

			});
		}
	</script>


	<script>
		
	</script>

	</body>
</html>

