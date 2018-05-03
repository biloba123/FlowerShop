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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<title>flower shop</title>

<script type="text/javascript">
	$(document).ready(function() {

		$("#count-input").blur(function() {
			var count=$(this).val();
			if (count < 1 || count > 99) {
                $("#tip").html("数量需在[1, 99]之间")
                $(this).focus();
            }
		});
		
		$("#update-btn").click(function() {
			window.location.href="../update-cart-item?count="+$("#count-input").val();
		});
		
		$("#delete-btn").click(function() {
			if(confirm("确认删除该商品？")){
				window.location.href="../delete-cart-item";;
			}
		});

	});
</script>

</head>
<body>
	<%
		CartItem cItem = (CartItem) session.getAttribute("editCartItem");
		Flower f = cItem.getFlower();
	%>
	<div id="wrap">
		<%@ include file="../header.jsp"%>

		<div class="center_content">
			<div class="left_content">
				<div class="title">
					<span class="title_icon"><img
						src="<%=request.getContextPath()%>/img/bullet1.gif" alt=""
						title=""></span>Edit product
				</div>
				<div class="feat_prod_box_details">
					<div class="prod_det_box">
						<div class="box_top"></div>
						<div class="box_center">
							<img alt="" src="<%=f.getImg()%>">
							<div class="price">
								<strong>NAME:</strong> <span class="red"><%=f.getName()%></span>
							</div>
							<div class="price">
								<strong>PRICE:</strong> <span class="red">￥<%=f.getPrice()%></span>
							</div>
							<div class="price">
								<strong>COUNT:</strong> <input id="count-input" type="text"
									value="<%=cItem.getCount()%>"><br> <span id="tip"
									style="color: red;"></span>
							</div>
							<div class="price">
								<button id="delete-btn">delete</button>
								<button id="update-btn">update</button>
							</div>
						</div>
						<div class="box_bottom"></div>
					</div>
				</div>

				<div class="clear"></div>
			</div>
			<%@ include file="../right-content.jsp"%>
		</div>

		<%@ include file="../footer.jsp"%>
	</div>
</body>
</html>