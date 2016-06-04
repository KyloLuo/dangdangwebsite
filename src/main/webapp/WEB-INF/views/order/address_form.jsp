<%@page contentType="text/html;charset=utf-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="<%=basePath%>css/login.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=basePath %>js/jquery-2.1.1.js"></script>
	</head>
	<body>
		
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：
				<select id="address" onchange="ChangeStore()">
					<option value="填写新地址" >
						填写新地址
					</option>
					
					<option value="罗亮">
						罗亮
					</option>
					
				</select>
			</p>
			<form name="ctl00" method="post" action="${pageContext.request.contextPath}/order/success" id="f">
				<input type="hidden" name="id" id="addressId" />

				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" class="text_input" name="receiveName"
								id="receiveName" />
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" name="fullAddress" class="text_input"
								id="fullAddress" />
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<input type="text" class="text_input" name="postalCode"
								id="postalCode" />
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" class="text_input" name="phone"
								id="mobile" />
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							手机
						</td>
						<td>
							<input type="text" class="text_input" name="mobile"
								id="phone" />
							<div class="text_left" id="mobileValidMsg">
								<p>
									请填写有效的收件人的手机
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<a href="../cart/cart_list.jsp"><input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="取消" /></a>
			
				<a href="#" "><input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" /></a>
				</div>
			</form>
		</div>
<script type="text/javascript">

	function com(){
		var json= {
			 	"receiveName":$("#receiveName").val(),
		     	"fullAddress":$("#fullAddress").val(),
		     	"postalCode":$("#postalCode").val(),
		     	"mobile":$("#mobile").val(),
		     	"phone":$("#phone").val()
		     	
				};
				console.log(json);
				return json;
	}

	function add(){
		$.ajax({
			type:'GET',
			url:'${pageContext.request.contextPath}/order/create',
			contentType : 'application/json',
			dataType : 'json',
			data:com(),
			success:function (data){
				console.log("kajsfasjflasfj");
				if(data=="success"){
					window.location="${pageContext.request.contextPath}/order/success";
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

	function ChangeStore(){
		var options=$("#address option:selected");
		var text = options.val();
		console.log(text);
		if(text=="罗亮"){
			$("#receiveName").attr("value","罗亮");
			$("#fullAddress").attr("value","江苏省扬州市江都区");
	     	$("#postalCode").attr("value","225235");
	     	$("#mobile").attr("value","051486389988");
	     	$("#phone").attr("value","15850160932");
		}
		if(text=="填写新地址"){
			$("#receiveName").attr("value","");
			$("#fullAddress").attr("value","");
	     	$("#postalCode").attr("value","");
	     	$("#mobile").attr("value","");
	     	$("#phone").attr("value","");
		}
	}
	
	
	
</script>
	</body>
</html>

