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
		List<CartItem> cItems = (List<CartItem>) session.getAttribute("cartItems");
		float total = 0;
	%>
	<div id="wrap">
		<%@ include file="../header.jsp"%>

		<div class="center_content">
			<div class="left_content">
				<div class="title">
					<span class="title_icon"><img
						src="<%=request.getContextPath()%>/img/bullet1.gif" alt=""
						title=""></span>My cart
				</div>

				<div class="feat_prod_box_details">

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
								<td><a href="edit-cart-item/<%=cItem.getId() %>"><img width="60px" height="60px"
										src="<%=f.getImg()%>" alt="" title="" border="0"
										class="cart_thumb"></a></td>
								<td><%=f.getName()%></td>
								<td><%=f.getPrice()%></td>
								<td><%=cItem.getCount()%></td>
								<td><%=cost%></td>
							</tr>
							<%
								total += cost;
								}
							%>

							<tr>
								<td colspan="4" class="cart_total"><span class="red">TOTAL:</span></td>
								<td>￥<%=total%></td>
							</tr>

						</tbody>
					</table>
					<a href="#" class="checkout">checkout &gt;</a>
				</div>

				<div class="clear"></div>
			</div>
			<%@ include file="../right-content.jsp"%>
		</div>

		<%@ include file="../footer.jsp"%>
	</div>

</body>
</html>