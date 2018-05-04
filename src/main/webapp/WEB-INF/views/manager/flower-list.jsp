<%@page import="entity.Flower"%>
<%@page import="entity.CartItem"%>
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
	<%
		List<Flower> flowers = (List<Flower>) session.getAttribute("m-flowers");
	%>
	<div id="wrap">
		<%@ include file="../manager-header.jsp"%>

		<div class="center_content">
			<div class="left_content">
				<div class="title">
					<span class="title_icon"><img
						src="<%=request.getContextPath()%>/img/bullet1.gif" alt=""
						title=""></span>Manage Flowers
				</div>
				<br>
				<a href="add-flower" class="checkout">add &gt;</a>

				<div class="feat_prod_box_details">

					<table class="cart_table">
						<tbody>
							<tr class="cart_title">
								<td>Item pic</td>
								<td>#</td>
								<td>Product name</td>
								<td>Unit price</td>
								<td>Intro</td>
							</tr>
							<%
								String intro;
								for (Flower f : flowers) {
							%>
							<tr>
								<td><a href="edit-flower/<%=f.getId() %>"><img width="60px"
										height="60px" src="<%=f.getImg()%>" alt="" title="" border="0"
										class="cart_thumb"></a></td>
								<td><%=f.getId()%></td>
								<td><%=f.getName()%></td>
								<td><%=f.getPrice()%></td>
								<%
									intro = f.getIntro();
								%>
								<td><%=intro.substring(0, Math.min(20, intro.length())) %></td>
							</tr>
							<%
								}
							%>

						</tbody>
					</table>
				</div>

				<div class="clear"></div>
			</div>
			<%@ include file="../manager-right-content.jsp"%>
		</div>

		<%@ include file="../footer.jsp"%>
	</div>

</body>
</html>