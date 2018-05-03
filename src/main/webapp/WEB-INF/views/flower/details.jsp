<%@page import="entity.Flower"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
<script src="${pageContext.request.contextPath}/js/prototype.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/scriptaculous.js?load=effects"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/lightbox.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/java.js"></script>
<title>flower shop</title>
</head>
<body>
	<%
		Flower f = (Flower) session.getAttribute("detail-flower");
	%>
	<div id="wrap">
		<%@ include file="../header.jsp"%>

		<div class="center_content">
			<div class="left_content">
				<div class="title">
					<span class="title_icon"><img
						src="<%=request.getContextPath()%>/img/bullet1.gif" alt=""
						title=""></span>Details
				</div>

				<div class="feat_prod_box_details">

					<div class="prod_img">
						<a href="#"><img src="<%=f.getImg()%>" alt="" title=""
							border="0"></a> <br> <br> <a
							href="<%=request.getContextPath()%>/img/big_pic.jpg"
							rel="lightbox"><img
							src="<%=request.getContextPath()%>/img/zoom.gif" alt="" title=""
							border="0"></a>
					</div>

					<div class="prod_det_box">
						<div class="box_top"></div>
						<div class="box_center">
							<div class="prod_title">Details</div>
							<p class="details">
								<%=f.getIntro()%>
							</p>
							<div class="price">
								<strong>PRICE:</strong> <span class="red">￥<%=f.getPrice()%>
								</span>
							</div>
							<div class="price">
								<strong>COLORS:</strong> <span class="colors"><img
									src="<%=request.getContextPath()%>/img/color1.gif" alt=""
									title="" border="0"></span> <span class="colors"><img
									src="<%=request.getContextPath()%>/img/color2.gif" alt=""
									title="" border="0"></span> <span class="colors"><img
									src="<%=request.getContextPath()%>/img/color3.gif" alt=""
									title="" border="0"></span>
							</div>
							<a
								href="<%=request.getContextPath()%>/Order/add-to-card/<%=f.getId()%>"
								class="more"><img
								src="<%=request.getContextPath()%>/img/order_now.gif" alt=""
								title="" border="0"></a>
							<div class="clear"></div>
						</div>

						<div class="box_bottom"></div>
					</div>
					<div class="clear"></div>
				</div>

				<div id="demo" class="demolayout">

					<ul id="demo-nav" class="demolayout">
						<li><a class="active" href="#tab1">More details</a></li>
						<li><a class="" href="#tab2">Related Products</a></li>
					</ul>

					<div class="tabs-container">

						<div style="display: block;" class="tab" id="tab1">
							<p class="more_details">Lorem ipsum dolor sit amet,
								consectetur adipisicing elit, sed do eiusmod tempor incididunt
								ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
								nostrud exercitation.</p>
							<ul class="list">
								<li><a href="#">Lorem ipsum dolor sit amet, consectetur
										adipisicing elit</a></li>
								<li><a href="#">Lorem ipsum dolor sit amet, consectetur
										adipisicing elit</a></li>
								<li><a href="#">Lorem ipsum dolor sit amet, consectetur
										adipisicing elit</a></li>
								<li><a href="#">Lorem ipsum dolor sit amet, consectetur
										adipisicing elit</a></li>
							</ul>
							<p class="more_details">Lorem ipsum dolor sit amet,
								consectetur adipisicing elit, sed do eiusmod tempor incididunt
								ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
								nostrud exercitation.</p>
						</div>

						<div style="display: none;" class="tab" id="tab2">
							<div class="new_prod_box">
								<a href="#">product name</a>
								<div class="new_prod_bg">
									<a href="#"><img
										src="<%=request.getContextPath()%>/img/thumb1.gif" alt=""
										title="" class="thumb" border="0"></a>
								</div>
							</div>

							<div class="new_prod_box">
								<a href="#">product name</a>
								<div class="new_prod_bg">
									<a href="#"><img
										src="<%=request.getContextPath()%>/img/thumb2.gif" alt=""
										title="" class="thumb" border="0"></a>
								</div>
							</div>

							<div class="new_prod_box">
								<a href="#">product name</a>
								<div class="new_prod_bg">
									<a href="#"><img
										src="<%=request.getContextPath()%>/img/thumb3.gif" alt=""
										title="" class="thumb" border="0"></a>
								</div>
							</div>

							<div class="new_prod_box">
								<a href="#">product name</a>
								<div class="new_prod_bg">
									<a href="#"><img
										src="<%=request.getContextPath()%>/img/thumb1.gif" alt=""
										title="" class="thumb" border="0"></a>
								</div>
							</div>

							<div class="new_prod_box">
								<a href="#">product name</a>
								<div class="new_prod_bg">
									<a href="#"><img
										src="<%=request.getContextPath()%>/img/thumb2.gif" alt=""
										title="" class="thumb" border="0"></a>
								</div>
							</div>

							<div class="new_prod_box">
								<a href="#">product name</a>
								<div class="new_prod_bg">
									<a href="#"><img
										src="<%=request.getContextPath()%>/img/thumb3.gif" alt=""
										title="" class="thumb" border="0"></a>
								</div>
							</div>

							<div class="clear"></div>
						</div>

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