<%@page contentType="text/html;charset=utf-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="<%=basePath %>css/login.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath %>css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=basePath %>js/jquery-2.1.1.js"></script>
	</head>
	<body>
		<div class="login_step">
			生成订单骤:
			<span class="red_bold">1.确认订单</span> > 2.填写送货地址 > 3.订单成功
		</div>
		<div class="fill_message">

			<table class="tab_login">
				<tr>
					
					<td valign="top" class="w1" style="text-align: left">
						<b>商品名称</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品单价</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品数量</b>
					</td>
				</tr>

				<!-- 订单开始 -->
				<c:forEach items="${currentOrder.orderLines}" var="list">
					<tr>
						
						<td valign="top">
							${list.product.productName}
						</td>
						<td valign="top">
							${list.product.dangPrice}
						</td>
						<td valign="top">
							${list.productNum}
						</td>
					</tr>
				</c:forEach>
					
					
				<!-- 订单结束 -->
				<tr>
					<td valign="top" class="w1" style="text-align: left" colspan="5">
						总价<span class="totalprice"></span>
					</td>
				</tr>
			</table>
			<br />
			<br />
			<br />
			<div class="login_in">
				<a href="../cart/cart_list.jsp"><input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="取消" /></a>
			
				<a href="${pageContext.request.contextPath }/order/addressForm"><input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" /></a>
		
			</div>

		</div>
		<script type="text/javascript">
		window.onload = function(){
			$.ajax({
				type:'POST',
				url:'${pageContext.request.contextPath}/cart/cost',
				dataType: "json",
				success:function (data){
					console.log(data);
					$(".totalprice").html("￥"+data.toFixed(2));
				},
				error : function(status) {
				
					console.log(status);
				}
				
			});
		}
		</script>
		
	</body>
</html>

