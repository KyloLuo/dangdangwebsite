<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品购买</title>
<link href="<%=basePath %>css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>js/jquery-2.1.1.js"></script>
</head>
<body>
	<div id="ddnewhead_operate" style="height: 30px">
			<div id="ddnewhead_welcome">
				<div id="ddnewhead_welcome_inner">
				<span>${currentUser.nickname} <a href="${pageContext.request.contextPath}/user/loginForm" >【退出】</a></span>
				</div>
			</div>
			<div id="ddnewhead_rightinfo">
				<div id="ddnewhead_rightinfo_div">
					<span class="cart_icon">
						<img alt="" src="<%=basePath %>images/cart_icon.png">
					</span>
					<div class="shopping">
					 <a href="${pageContext.request.contextPath}/cart/list" style="color: red;">购物车</a>
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
			<li>
			<div class="cart_list_bookcon" style="color: blue;">
				<div class="cart_list_bookcon_pic">
					<img alt="" src="<%=basePath %>images/${book.productPic}">
				</div>
				<div class="cart_list_bookcon_name">
				<span>${book.productName}</span>
				</div>
			</div>
			<div class="cart_list_bookother">
				<div class="cart_list_market">${book.fixedPrice}</div>
				<div class="cart_list_dangdang">
				<span class="dangdang_perprice">${book.dangPrice}</span>
				</div>
			</div>
			<div class="cart_list_bookother">
				<div class="item-amount">
					<a class="item-amount_cut" href="#" onclick="reduce()">-</a>
					<input  type="text" name ="number" class="item-amount_input" value="1" onkeyup="this.value=this.value.replace(/\D/g,'')"
					onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<a class="item-amount_add" href="#" onclick="add()">+</a>
				</div>
			</div>
			<div class="cart_list_bookother" >
				<span class="cart_list_bookprice" 
				style="color: #f40;line-height: 100px;font-weight: 700;">${book.dangPrice}
				</span>
			</div>
			<div class="cart_list_bookother" >
				<a class="cart_list_del"  href="#">删除</a>
			</div>
			</li>
		</ul>
	</div>
	
	<div class="cart_totalprice">
		<div class="cart_totalprice_right">
			<div class="cart_totalprice_right_top">
				<div class="cart_totalprice_font">应付总额</div>
				<div class="cart_totalprice_number">
					<span class="cartlist_totalprice">￥${book.dangPrice}</span>
				</div>
			</div>
			<div class="cart_totalprice_right_bottom">
				<a href="${pageContext.request.contextPath}/order/orderInfo" onclick="getOrder()">
					<img alt="" src="<%=basePath %>images/totalprice_icon.png">
				</a>
			</div>
		</div>
	</div>
	

<script type="text/javascript">
	var a;
	var b;
	var c;
	function add(){
		a = $("input[name='number']").val();
		a++;
		 b = $(".dangdang_perprice").text();
		 c = (a*b).toFixed(2);
		$("input[name='number']").attr("value",a);
		$(".cart_list_bookprice").html(c);
		$(".cartlist_totalprice").html(c);
	}
	function reduce(){
		a = $("input[name='number']").val();
		if(a>=2){
		a--;
		 b = $(".dangdang_perprice").text();
		 c = (a*b).toFixed(2);
		$("input[name='number']").attr("value",a);
		$(".cart_list_bookprice").html(c);
		$(".cartlist_totalprice").html(c);
		}
	}
	
	function getOrder(){
		$.ajax({
			type : 'GET',
			url : '${pageContext.request.contextPath}/category/orderInfo',
			data : com(),
			success : function(data) {
				console.log(data);
			},
			error : function(status) {
				console.log(status);
			}

		});
	}
	function com(){
		var json = {
				"name" : $(".cart_list_bookinfo").text(),
				"number":$("input[name='number']").val()
			};
			console.log(json);
			return json;
	}
	
</script>	
</body>
</html>