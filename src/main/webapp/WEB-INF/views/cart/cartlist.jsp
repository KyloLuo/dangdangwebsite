<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link href="<%=basePath %>css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>js/jquery-2.1.1.js"></script>
</head>
<body>
			<div id="ddnewhead_operate" style="height: 30px">
			<div id="ddnewhead_welcome">
				<div id="ddnewhead_welcome_inner">
				<span>${currentUser.nickname}<a href="./user/login_form.jsp" >【退出】</a></span>
				</div>
			</div>
			<div id="ddnewhead_rightinfo">
				<div id="ddnewhead_rightinfo_div">
					<span class="cart_icon">
						<img alt="" src="<%=basePath %>images/cart_icon.png">
					</span>
					<div class="shopping">
					 <a href="${pageContext.request.contextPath}/category/cart" style="color: red;">购物车</a>
					</div>
					 <a href="./cart/cart_list.jsp">我的当当</a>
				</div>
			</div>
		</div>
	
	<div id="logo_line_out" style="height: 80px;">
		<div id="logo_line">
			<div id="logo" style="width:18%;height: 110px;display: inline-block;">
				<img src="http://img35.ddimg.cn/upload_img/00405/luyi/logo-2.jpg">
			</div>
			<div class="cart_font">
			购物车
			</div>
		</div>
	</div>
	
	<div id="cart_list">
		<div class="cart_list_top">
			<div class="cart_list_bookinfo">商品信息</div>
			<div class="cart_list_bookother">单价(元)</div>
			<div class="cart_list_bookother">数量</div>
			<div class="cart_list_bookother">金额(元)</div>
			<div class="cart_list_bookother">操作</div>
		</div>
		<ul>
			<c:forEach items="${currentCart.items}" var="list">
			<li>
			<div  class="cart_list_bookcon" style="color: blue;">
				<div class="cart_list_bookcon_pic">
					<img alt="" src="<%=basePath %>images/${list.product.productPic}">
				</div>
				<div class="cart_list_bookcon_name">
				<span>${list.product.productName}</span>
				</div>
			</div>
			<div class="cart_list_bookother">
				<div class="cart_list_market">${list.product.fixedPrice}</div>
				<div class="cart_list_dangdang">
				<span class="dangdang_perprice">${list.product.dangPrice}</span>
				</div>
			</div>
			<div class="cart_list_bookother">
				<div class="item-amount">
					<a class="item-amount_cut" href="#" onclick="reduce(${list.product.id},${list.productNum},${list.product.dangPrice})">-</a>
					<input  id="num${list.product.id}" type="text" name ="number" class="item-amount_input" value=${list.productNum} onkeyup="this.value=this.value.replace(/\D/g,'')"
					onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<a class="item-amount_add" href="#" onclick="add(${list.product.id},${list.productNum},${list.product.dangPrice})">+</a>
				</div>
			</div>
			<div class="cart_list_bookother" >
				<span class="cart_list_bookprice" id="perTotal${list.product.id}"
				style="color: #f40;line-height: 100px;font-weight: 700;"> ${list.product.dangPrice} 
				</span>
			</div>
			<div class="cart_list_bookother" >
				<a class="cart_list_del" onclick="del(${list.product.id})" href="#">删除</a>
			</div>
			</li>
			
			</c:forEach>
		</ul>
	</div>
	
	<div class="cart_totalprice">
		<div class="cart_totalprice_right">
			<div class="cart_totalprice_right_top">
				<div class="cart_totalprice_font">应付总额</div>
				<div class="cart_totalprice_number">
					<span class="cartlist_totalprice" ></span>
				</div>
			</div>
			<div class="cart_totalprice_right_bottom">
				<a href="${pageContext.request.contextPath}/order/orderInfo">
					<img alt="" src="<%=basePath %>images/totalprice_icon.png">
				</a>
			</div>
		</div>
	</div>
	
<script type="text/javascript">
	var a = 1;
	
	window.onload = function(){
		$.ajax({
			type:'POST',
			url:'${pageContext.request.contextPath}/cart/cost',
			dataType: "json",
			success:function (data){
				console.log(data);
				$(".cartlist_totalprice").html("￥"+data.toFixed(2));
			},
			error : function(status) {
			
				console.log(status);
			}
			
		});
	}
	
	
	function add(id,num,price){
		console.log(num);
		var pertotal = 0;
		a++;
		pertotal = a*price;
		$("#num"+id).attr("value",a);
		$("#perTotal"+id).html(pertotal.toFixed(2));
		$.ajax({
			type:'POST',
			url:'${pageContext.request.contextPath}/cart/fixNum/'+id+'/'+a,
			success:function (data){
				$.ajax({
					type:'POST',
					url:'${pageContext.request.contextPath}/cart/cost',
					dataType: "json",
					success:function (data){
						$(".cartlist_totalprice").html("￥"+data.toFixed(2));
						console.log(data);
					},
					error : function(status) {
					
						console.log(status);
					}
					
				});
			},
			error : function(status) {
			
				console.log(status);
			}
			
		});
		

	}
	function reduce(id,num,price){
		var pertotal = 0;
		a = $("#num"+id).val();
		if(a>=2){
		a--;
		pertotal = a*price;
		$("#num"+id).attr("value",a);
		$("#perTotal"+id).html(pertotal.toFixed(2));
		$.ajax({
			type:'POST',
			url:'${pageContext.request.contextPath}/cart/fixNum/'+id+'/'+a,
			success:function (data){
				$.ajax({
					type:'POST',
					url:'${pageContext.request.contextPath}/cart/cost',
					dataType: "json",
					success:function (data){
						$(".cartlist_totalprice").html("￥"+data.toFixed(2));
						console.log(data);
					},
					error : function(status) {
					
						console.log(status);
					}
					
				});
			},
			error : function(status) {
			
				console.log(status);
			}
			
		});
		
		}
	}
	
	function del(id){
		$.ajax({
			type:'POST',
			url:'${pageContext.request.contextPath}/cart/deleteItem/'+id,
			success:function (data){
				$.ajax({
					type:'POST',
					url:'${pageContext.request.contextPath}/cart/cost',
					dataType: "json",
					success:function (data){
						$(".cartlist_totalprice").html("￥"+data.toFixed(2));
						console.log(data);
					},
					error : function(status) {
					
						console.log(status);
					}
					
				});
				window.location="${pageContext.request.contextPath}/cart/list";
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