<%@page import="entity.Flower"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
<title>flower shop</title>
</head>
<body>
	<div id="wrap">
		<%@ include file="../header.jsp"%>

		<div class="center_content">
			<div class="left_content">
				<div class="title">
					<span class="title_icon"><img
						src="<%=request.getContextPath()%>/img/bullet1.gif" alt=""
						title=""></span>Flowers
				</div>

				<div class="new_products">
				
				<%
				List<Flower> flowers=(List<Flower>)session.getAttribute("flowers");
				if(flowers!=null){
					for(Flower f: flowers){
						%>
						<div class="new_prod_box">
						<a href="details/<%=f.getId() %>"><%=f.getName() %></a>
						<div class="new_prod_bg">
							<a href="details/<%=f.getId() %>"><img src="<%=f.getImg() %>" alt=""
								title="" class="thumb" border="0" /></a>
						</div>
					</div>
						<% 
					}
				}
				%>
					
				</div>


				<div class="clear"></div>
			</div>
			<%@ include file="../right-content.jsp"%>
		</div>

		<%@ include file="../footer.jsp"%>
	</div>

</body>
</html>