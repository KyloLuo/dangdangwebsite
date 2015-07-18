<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>当当用户登录</title>
<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
<script
	src="http://cdn.bootcss.com/jquery-json/2.5.1/jquery.json.min.js"></script>
</head>
<body>
	<!--<form action="${pageContext.request.contextPath}/user/login" method=post>  -->
	用户名：
	<input type="text" name="email" id="email" />
	<br /> 密码：
	<input type="password" name="password" id="password" />
	<button onclick="login()">确认</button>
	<!-- </form>-->
</body>

<script>
	function com(){
		var json= {
	 	"email":$("#email").val(),
     	"password":$("#password").val()
		};
		console.log(json);
		return json;
	}

	function login(){
		//var data={};
		//data.email="978364051@qq.com"
		//console.log(data.email);
		//data.password="dpc123"
		$.ajax({
			type:'POST',
			url:'${pageContext.request.contextPath}/user/login',
			data:com(),
			success:function (data){
				console.log(data);
			},
			error : function(status) {
				console.log(status);
			}
			
		});
	}
</script>
</html>