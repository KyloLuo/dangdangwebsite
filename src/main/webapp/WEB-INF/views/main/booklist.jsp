<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>物品展示</title>
<link href="<%=basePath%>css/layout.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath %>js/jquery-2.1.1.js" ></script>
</head>
<body>
	<div id="head_content">
			<c:import url="/category/headpage"></c:import>
	</div>
	<div class="breadcrumb">
		<a href="#">图书</a>
		<span>></span>
		<a href="#">小说</a>
	</div>
	<div id="main_content">
	 <div id="thirdmenu_content">
		<div id="thirdmenu_info">
			<div class="thirdmenu_title">
				小说
			</div>
		  <ul >
		  	<li>
		  		<a href="#">武侠小说(24)</a>
		  	</li>
		  	<li>
		  		<a href="#">言情小说(15)</a>
		  	</li>
		  	<li>
		  		<a href="#">都市小说(18)</a>
		  	</li>
		  	<li>
		  		<a href="#">官场小说(30)</a>
		  	</li>
		  	<li>
		  		<a href="#">影视小说(10)</a>
		  	</li>
		  	<li>
		  		<a href="#">外国小说(8)</a>
		  	</li>
		  </ul>
		</div>
	 </div>
	 
	 <div id="list_book_content">
	 	<div id="list_top">
	 		<span>
	 			排序:
	 		</span>
	 	 <div class="list_top_middle">
	 	 	<ul>
	 	 		<li>
	 	 			<a href="#" style="background-color:#fe7c2c ">
	 	 				默认排序
	 	 			</a>
	 	 		</li>
	 	 		<li>
	 	 			<a href="#" >
	 	 				销量   ↓
	 	 			</a>
	 	 		</li>
	 	 		<li>
	 	 			<a href="#" >
	 	 				价格   ↑
	 	 			</a>
	 	 		</li>
	 	 		<li>
	 	 			<a href="#" >
	 	 				出版时间   ↓
	 	 			</a>
	 	 		</li>
	 	 	</ul>
	 	 </div>
	 	 <div class="total_books">
	 	 	共计商品${books_pageInfo.totalCount}件
	 	 </div>
	 	</div>
	 	
	 	<!-- 以下开始具体书籍列表 -->
	 	<div id="con_shoplist">
	 		<ul>
	 			<c:forEach items="${books_pageInfo.books}" var="list">
	 		     <li>
	 				<span>
	 				<img alt="" src="<%=basePath %>images/${list.productPic}">
	 				</span>
	 				<p class="shoplist_bookname">${list.productName}</p>
	 				<p class="shoplist_score">评分:95</p>
	 				<div class="shoplist_author_place_time">
	 				<p class="author_place_time" style="width: 250px">作者:${list.author}</p>
	 				<p class="author_place_time">出版社:${list.publishing}</p>
	 				<p class="author_place_time">出版时间:<fmt:formatDate value="${list.publishTime}" pattern="yyyy-MM-dd "/></p>
	 				</div>
	 				<div class="easy_desc">
	 				 ${list.description}
	 				</div>
	 				<div class="price_buy">
	 					<p class="book_dangdang_price">￥${list.dangPrice} </p>
	 					<p class="book_market_price">￥${list.fixedPrice}</p>
	 					<p class="book_buy">
	 						<a href="${pageContext.request.contextPath}/user/loginForm">
	 						<img alt="" src="<%=basePath%>images/purchase_icon.png">
	 						</a>
	 					</p>
	 					<p class="book_cart">
	 						<a href="${pageContext.request.contextPath}/user/loginForm" >
	 						<img alt="" src="<%=basePath%>images/addtocart_icon.png">
	 						</a>
	 					</p>
	 				</div>
	 			</li>
	 			</c:forEach>
	 			
	 			
	 	</ul>
	 </div>	
	 	</div>
	 	<div id="page_div">
	 		<div class="pageinfo">
	 		<a  id="first" href="${pageContext.request.contextPath }/category/1/0/7">首页</a> 
            <a id="former" href="${pageContext.request.contextPath }/category/1/${books_pageInfo.currentPage-1}/7">上一页</a>
	 	    <a id="next" href="${pageContext.request.contextPath }/category/1/${books_pageInfo.currentPage+1}/7">下一页</a>
	 		<a id="last" href="${pageContext.request.contextPath }/category/1/${books_pageInfo.totalPages-1}/7">尾页</a>&nbsp;&nbsp;
	 		<span>共${books_pageInfo.totalCount}条</span>&nbsp;
	 	    <span>每页显示7条</span>&nbsp;
	 	    <div id="page" style="display: inline-block;">第${books_pageInfo.currentPage+1}页</div>
	 		</div>
	 	</div>
	 
	</div>
<script type="text/javascript">
	
var current = ${books_pageInfo.currentPage}
console.log(current);
if(current==0){
	$("#first").hide();
	$("#former").hide();
}
if(current==${books_pageInfo.totalPages-1}){
	console.log("lalal");
	$("#next").hide();
	$("#last").hide();
}


</script>
</body>
</html>