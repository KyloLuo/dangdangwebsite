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
<script src="<%=basePath %>js/jquery-2.1.1.js" ></script>
<title>Insert title here</title>
</head>
<body>
	<div id="newbook_info">
		<div id="newbook_info_top">
			<ul>
			
			 <c:forEach items="${recentBooks}" var="list">					
					<li><a href="#">
						<img alt="" src="<%=basePath %>images/${list.productPic}">
					</a>
				      <span class="bookname"><a id="link${list.id}"  onclick="setLink(${list.id})" class="a_bookname" href="#">${list.productName}</a></span>
					<span class="author">${list.author}</span>
					<span class="price">￥${list.dangPrice}</span>
					</li>
					
					</c:forEach> 
			</ul>
		</div>
	</div>
<script type="text/javascript">

	function setLink(id){
		if(${currentUser.nickname}==null){
			$("#link"+id).attr("href","${pageContext.request.contextPath}/user/loginForm");
		}else{
			$("#link"+id).attr("href","${pageContext.request.contextPath}/book//bookcontent/"+id);
		}
	}
	
</script>
</body>
</html>