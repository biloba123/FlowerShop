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
		List<CartItem> cItems = (List<CartItem>) session.getAttribute("orderItems");
		Order o = (Order) session.getAttribute("order");
	%>
	<div id="wrap">
		<%@ include file="../header.jsp"%>

		<div class="center_content">
			<div class="left_content">
				<div class="title">
					<span class="title_icon"><img
						src="<%=request.getContextPath()%>/img/bullet1.gif" alt=""
						title=""></span>Order detail
				</div>

				<div class="feat_prod_box_details">

					<strong>Order</strong>
					<table class="cart_table">
						<tbody>
							<tr class="cart_title">
								<td>Code</td>
								<td>Total cost</td>
								<td>Create time</td>
								<td>State</td>
							</tr>
							<tr>
								<td><%=o.getId()%></td>
								<td><%=o.getTotal()%></td>
								<td><%=o.getCreateTime().substring(0, 19)%></td>
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
									}
								%>
								<td><%=s%></td>
							</tr>

						</tbody>
					</table>
				</div>

				<div class="feat_prod_box_details">

					<strong>Products</strong>
					<table class="cart_table">
						<tbody>
							<tr class="cart_title">
								<td>Item pic</td>
								<td>Product name</td>
								<td>Unit price</td>
								<td>Qty</td>
								<td>Total</td>
							</tr>
							<%
								Flower f;
								float cost;
								for (CartItem cItem : cItems) {
									f = cItem.getFlower();
									cost = f.getPrice() * cItem.getCount();
							%>
							<tr>
								<td><img width="60px" height="60px" src="<%=f.getImg()%>"
									alt="" title="" border="0" class="cart_thumb"></td>
								<td><%=f.getName()%></td>
								<td><%=f.getPrice()%></td>
								<td><%=cItem.getCount()%></td>
								<td><%=cost%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
					<!-- <a href="create-order" class="checkout">buy now &gt;</a> -->
				</div>

				<div class="clear"></div>
			</div>
			<%@ include file="../right-content.jsp"%>
		</div>

		<%@ include file="../footer.jsp"%>
	</div>

</body>
</html>