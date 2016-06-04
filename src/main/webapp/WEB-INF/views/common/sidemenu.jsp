<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当当图书</title>
<link href="<%=basePath %>css/layout.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>css/sidemenu/reset.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>css/sidemenu/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>css/sidemenu/default.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath %>js/sidemenu/modernizr.js" ></script>
</head>
<body>
	<div id="sidemenu_info">
		<div class="menu_head">图书分类</div>
		<div class="menu_content">
			<ul class="cd-dropdown-content" >
			
			
				<li class="has-children"  >
					<a  href="${pageContext.request.contextPath }/category/1/0/7" target="_blank" style="text-decoration: none;" >
						小说
					</a>
					<ul class="cd-secondary-dropdown" >
						
						<li class="has-children">
							<ul class="is-hidden">
								<li >
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">武侠</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">言情</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">科幻</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">都市</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">官场</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">影视小说</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">外国小说</a>
								</li>
								
								<li><img alt="" src="<%=basePath %>images/xiaoshuo.jpg"></li>
							</ul>
						</li>
					</ul>
				</li>
				
				
				
				<li class="has-children" >
					<a href="#" target="_blank" style="text-decoration: none;">
						成功励志
					</a>
					<ul class="cd-secondary-dropdown" style="top: 50px;">
						
						<li class="has-children">
							<ul class="is-hidden">
								<li >
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">人生哲学</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">心灵与修养</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">性格与习惯</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">智商与智谋</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">人在职场</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">口才/演讲/辩</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">名人励志</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">青少年励志</a>
								</li>
								
								<li><img alt="" src="<%=basePath %>images/successlizhi.jpg"></li>
							</ul>
						</li>
					</ul>
				</li>
				
				
				<li class="has-children" >
					<a href="#" target="_blank" style="text-decoration: none;">
						童书
					</a>
					<ul class="cd-secondary-dropdown" style="top: 100px;">
						
						<li class="has-children">
							<ul class="is-hidden">
								<li >
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">0-2岁</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">3-6岁</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">7-10岁</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">11-14岁</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">科普百科</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">少儿期刊</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">玩具书</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">动漫卡通</a>
								</li>
								
								<li><img alt="" src="<%=basePath %>images/childern.jpg"></li>
							</ul>
						</li>
					</ul>
				</li>
				
				
				<li class="has-children" >
					<a href="#" target="_blank" style="text-decoration: none;">
						历史
					</a>
					<ul class="cd-secondary-dropdown" style="top: 150px;height: 330px;" >
						
						<li class="has-children">
							<ul class="is-hidden">
								<li >
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">历史普及读物</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">中国史</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">世界史</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">史学理论</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">历史随笔</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">史料典籍</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">地方史志</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">口述史</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">逸闻野史</a>
								</li>
								
								<li><img alt="" src="<%=basePath %>images/history.jpg"></li>
							</ul>
						</li>
					</ul>
				</li>
				
				<li class="has-children" >
					<a href="#" target="_blank" style="text-decoration: none;">
						管理
					</a>
					<ul class="cd-secondary-dropdown" style="top: 200px;height: 280px;" >
						
						<li class="has-children">
							<ul class="is-hidden">
								<li >
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">一般管理学</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">会计</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">市场/营销</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">战略管理</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">投资理财</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">WTO</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">电子商务</a>
								</li>
								
								<li><img alt="" src="<%=basePath %>images/manage.jpg"></li>
							</ul>
						</li>
					</ul>
				</li>
				
						<li class="has-children" >
					<a href="#" target="_blank" style="text-decoration: none;">
						教辅
					</a>
					<ul class="cd-secondary-dropdown" style="top: 250px;height: 360px;" >
						
						<li class="has-children">
							<ul class="is-hidden">
								<li >
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">研究生/本科</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">高职高专教材</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">中职教材</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">成人教育教材</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">职业技术培训</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">工学类</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">文法类</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">医学类</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">理学类</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">经济管理类</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">农学</a>
								</li>
								
								<li><img alt="" src="<%=basePath %>images/education.jpg"></li>
							</ul>
						</li>
					</ul>
				</li>	
				
				
				<li class="has-children" >
					<a href="#" target="_blank" style="text-decoration: none;">
						青春文学
					</a>
					<ul class="cd-secondary-dropdown" style="top: 300px;height: 300px;" >
						
						<li class="has-children">
							<ul class="is-hidden">
								<li >
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">校园</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">爱情/情感</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">叛逆/成长</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">娱乐/偶像</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">爆笑/无厘头</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">港台青春文学</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">韩国青春文学</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">其他国外青春</a>
								</li>
								
							     <li><img alt="" src="<%=basePath %>images/young.jpg"></li>
							</ul>
						</li>
					</ul>
				</li>
				
				<li class="has-children" >
					<a href="#" target="_blank" style="text-decoration: none;">
						传记
					</a>
					<ul class="cd-secondary-dropdown" style="top: 350px;height: 400px;" >
						
						<li class="has-children">
							<ul class="is-hidden">
								<li >
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">财经人物</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">领袖首脑</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">军事人物</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">政治人物</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">历史人物</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">法律人物</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">女性人物</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">教育家</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">文学家</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">艺术家</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">娱乐明星</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">体育明星</a>
								</li>
								
							     <li><img alt="" src="<%=basePath %>images/record.jpg"></li>
							</ul>
						</li>
					</ul>
				</li>
				
				
				<li class="has-children" >
					<a href="#" target="_blank" style="text-decoration: none;">
						科技
					</a>
					<ul class="cd-secondary-dropdown" style="top: 400px;height: 300px;" >
						
						<li class="has-children">
							<ul class="is-hidden">
								<li >
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">科普读物</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">建筑</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">医学</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">计算机</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">农林</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">自然科学</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">工业</a>
								</li>
								
							     <li><img alt="" src="<%=basePath %>images/history.jpg"></li>
							</ul>
						</li>
					</ul>
				</li>
				
				
				<li class="has-children" >
					<a href="#" target="_blank" style="text-decoration: none;">
						工具书
					</a>
					<ul class="cd-secondary-dropdown" style="top: 450px;height: 200px;" >
						
						<li class="has-children">
							<ul class="is-hidden">
								<li >
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">汉语工具书</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">英语工具书</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">其他语种工具书</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">百科全书</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">牛津系列</a>
								</li>
								
								<li>
									<a href="http://e.dangdang.com/wxg/index.htm" target="_blank">名族工具书</a>
								</li>
								
							    
							</ul>
						</li>
					</ul>
				</li>
				
				
			</ul>
		</div>
	</div>
<script src="<%=basePath %>js/jquery-2.1.1.js" ></script>
<script src="<%=basePath %>js/sidemenu/main.js" ></script>

</body>
</html>