<%@page contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="<%=basePath %>css/login.css" rel="stylesheet" type="text/css" />
		<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
	</head>
	<body>


		<div class="login_top">
	<a href="#" target="_blank"><img class="logo"
			src="http://img35.ddimg.cn/upload_img/00405/luyi/logo-2.jpg" /> </a>
       </div>

		<div class="enter_part">

			<div class="introduce">
	<img src="${pageContext.request.contextPath}/images/d_introduce.gif" />
	<ul>
		<li>
			更多选择
		</li>
		<li class="bj_none">
			60万种图书音像，共计百万种商品。
		</li>
		<li>
			更低价格
		</li>
		<li class="bj_none">
			电视购物的3-5折，传统书店的5-7折，其他网站的7-9折。
		</li>
		<li>
			更方便、更安全
		</li>
		<li class="bj_none">
			全国超过300个城市送货上门、货到付款。零风险购物，便捷到家。
		</li>
	</ul>
</div>

			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red" id="divErrorMssage">
					
					</div>
					<div class="main">
						<h3>
							登录当当网
						</h3>

						<form method="post" action="${pageContext.request.contextPath}/user/login" id="ctl00">
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<input type="text" name="name" id="email" class="textbox" />
								</li>
								<li>
									<span class="blank">密码：</span>
									<input type="password" name="password" id="password" class="textbox" />
								</li>
								<li>
									<input type="button" id="btnSignCheck" class="button_enter"
										value="登 录" onclick="login()"/>


								</li>
							</ul>
							<input type="hidden" name="uri" value="${uri}" />
						</form>
					</div>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="${pageContext.request.contextPath}/user/registerForm">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>

	<div>
	<center>
		<hr style="height: 1px; width: 972px; color: #cfcfcf" />
		<div class="b_left"></div>
		<div class="publish_bottom_message2">
			<div class="copyright">
				Copyright (C) 当当网 2014-2015, 苏州科技学院达内暑期实训第九组
			</div>
			<div class="validate">
				<a
					href="#http://www.hd315.gov.cn/beian/view.asp?bianhao=010202001051000098"
					target="_blank"> <img
						src="${pageContext.request.contextPath}/images/validate.gif"
						border="0" /> </a>
				<p>
					<a href="" target="_blank">京ICP证041189号</a>
				</p>
			</div>
		</div>
	</center>
</div>

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
				if(data=="login_success"){
					window.location="${pageContext.request.contextPath}/user/main";
				}
				if(data=="login_failure"){
					alert("邮箱或密码不正确!");
				}
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

