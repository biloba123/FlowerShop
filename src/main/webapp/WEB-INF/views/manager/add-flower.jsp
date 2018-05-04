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

<style type="text/css">
input, textarea {
	margin-top: 5px
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		
		$("#btn_delete").click(function() {
			if(confirm("确认删除？")){
				window.location.href="../delete-flower";
			}
		});

		$("#img_input").change(function() {
			var img = $(this).val();
			$("#img").attr("src", img);
		});

	});
</script>

</head>
<body>
	<%
		Flower f = (Flower) session.getAttribute("m-editFlower");
		boolean flag = f != null;
	%>
	<div id="wrap">
		<%@ include file="../manager-header.jsp"%>

		<div class="center_content">
			<div class="left_content">
				<div class="title">
					<span class="title_icon"><img
						src="<%=request.getContextPath()%>/img/bullet1.gif" alt=""
						title=""></span><%=flag ? "Edit Flower" : "Add Flower"%>
				</div>
				<div class="feat_prod_box_details">
					<div class="prod_det_box">
						<div class="box_top"></div>
						<img id="img" alt=""
							src="<%=flag ? f.getImg() : "/FlowerShop/img/thumb1.gif"%>"
							style="margin-bottom: 20px">
						<form action="<%=flag?"../update": "add" %>" method="post" style="margin-bottom: 5px">
							<strong>IMG: </strong> <select id="img_input" name="img">
								<option value="/FlowerShop/img/thumb1.gif" selected="selected">img_f1</option>
								<option value="/FlowerShop/img/thumb2.gif">img_f2</option>
								<option value="/FlowerShop/img/thumb3.gif">img_f3</option>
							</select> <br> <strong>NAME: </strong> <input type="text" name="name"
								value="<%=flag ? f.getName() : ""%>" required> <br>
							<strong>PRICE: </strong> <input type="text" name="price"
								value="<%=flag ? f.getPrice() : ""%>" required> <br>
							<strong>INTRO: </strong>
							<textarea rows="5" cols="25" name="intro""><%=flag ? f.getIntro() : ""%></textarea>
							<br> <input type="submit" value="<%=flag?"update": "add" %>">
						</form>
						<%
						if(flag){
							out.print("<button id=\"btn_delete\">delete</button>");
						}
						%>
						<div class="box_bottom"></div>
					</div>
				</div>

				<%-- <input id="flag_img" value="<%=flag ? f.getImg().charAt(21) : 0%>"
					style="visibility: hidden;"> --%>

				<div class="clear"></div>
			</div>
			<%@ include file="../manager-right-content.jsp"%>
		</div>

		<%@ include file="../footer.jsp"%>
	</div>
</body>
</html>