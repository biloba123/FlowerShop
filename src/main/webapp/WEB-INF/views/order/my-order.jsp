<%@page import="entity.Order"%>
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
		List<Order> orders = (List<Order>) session.getAttribute("orders");
	%>
	<div id="wrap">
		<%@ include file="../header.jsp"%>

		<div class="center_content">
			<div class="left_content">
				<div class="title">
					<span class="title_icon"><img
						src="<%=request.getContextPath()%>/img/bullet1.gif" alt=""
						title=""></span>My orders
				</div>

				<div class="feat_prod_box_details">

					<table class="cart_table">
						<tbody>
							<tr class="cart_title">
								<td>Code</td>
								<td>Total cost</td>
								<td>Create time</td>
								<td>State</td>
							</tr>
							<%
								for (Order o : orders) {
							%>
							<tr>
								<td><%=o.getId()%></td>
								<td><%=o.getTotal()%></td>
								<td><%=o.getCreateTime().substring(0,19) %></td>
								<%
									String s = "";
										switch (o.getState()) {
										case 0:
											s = "已付款/待发货";
											break;
										case 1:
											s = "已发货/待接收";
											break;
										case 2:
											s = "交易完成";
											break;
										default:
											s = "交易失败";
											break;
										}%>
										<td><a href="order-detail/<%=o.getId() %>" ><%=s %></a></td>
										<%
								%>
							</tr>
							<%
								}
							%>

						</tbody>
					</table>
				</div>

				<div class="clear"></div>
			</div>
			<%@ include file="../right-content.jsp"%>
		</div>

		<%@ include file="../footer.jsp"%>
	</div>

</body>
</html>