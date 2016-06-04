<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap.min.js"></script>


</head>
<body>
	<div id="slide">
		<div id="myCarousel" class="carousel slide">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators" style="bottom: 0px">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
			</ol>

			<!-- Carousel items -->
			<div class="carousel-inner">
				<div class="item active">
					<img alt=""
						src="http://img60.ddimg.cn/upload_img/00087/hw/750x315_hr_20150713.jpg">
				</div>
				<div class="item">
					<img alt=""
						src="http://img60.ddimg.cn/upload_img/00570/tongshu/750315mjts710.jpg">
				</div>
				<div class="item">
					<img alt=""
						src="http://img63.ddimg.cn/upload_img/00533/pxh/sy750315_pxh20150714.jpg">
				</div>
				<div class="item">
					<img alt=""
						src="http://img61.ddimg.cn/upload_img/00533/pxh/wy750315_gr_0619.jpg">
				</div>
				<div class="item">
					<img alt=""
						src="http://img62.ddimg.cn/upload_img/00570/tongshu/750315top0713.jpg">
                </div>
			</div>

			<!-- 轮播（Carousel）导航 -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev"
				style="font-size: 0px;">&lsaquo;</a> <a
				class="carousel-control right" href="#myCarousel" data-slide="next"
				style="font-size: 0px;">&rsaquo;</a>

		</div>

	</div>
	<script type="text/javascript">
		$("#myCarousel").carousel();
	</script>
</body>


</html>