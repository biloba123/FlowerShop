<%@page import="entity.User"%>
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

		$("#update-account").click(function() {
			var form = $("#form_update")
			if (form.is(":hidden")) {
				form.show("slow")
			} else {
				form.hide(1000)
			}
		});

	});

	function check() {
		var psd1 = document.getElementById("psd1");
		var psd2 = document.getElementById("psd2");
		if (psd1.value != psd2.value) {
			alert("密码不一致");
			return false;
		} else
			return true;
	}
</script>
</head>
<body>
	<div id="wrap">
		<%@ include file="../header.jsp"%>

		<div class="center_content">
			<div class="left_content">
				<div class="title">
					<span class="title_icon"><img
						src="<%=request.getContextPath()%>/img/bullet1.gif" alt=""
						title=""></span>My account
				</div>

				<div class="feat_prod_box_details">
					<p class="details">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit, sed do eiusmod tempor incididunt ut labore et
						dolore magna aliqua. Ut enim ad minim veniam, quis nostrud. Lorem
						ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
						minim veniam, quis nostrud.</p>

					<div class="contact_form">
						<div class="form_subtitle">account info</div>
						<%
							User u = (User) session.getAttribute("user");
						%>

						Hello, <strong><%=u.getUsername()%></strong>&nbsp;&nbsp; <a
							href="logout">logout</a><br> <br>
						<button id="update-account">update account</button>



						<form id="form_update" name="register" action="update-info"
							onsubmit="return check()" hidden="true">
							<div class="form_row">
								<label class="contact"><strong>Username:</strong></label> <input
									type="text" class="contact_input" name="username"
									value="<%=u.getUsername()%>" required>
							</div>
							<div class="form_row">
								<label class="contact"><strong>New Password:</strong></label> <input
									id="psd1" type="password" class="contact_input" name="password"
									required>
							</div>

							<div class="form_row">
								<label class="contact"><strong>Confirm
										Password:</strong></label> <input id="psd2" type="password"
									class="contact_input" required>
							</div>

							<div class="form_row">
								<input type="submit" class="register" value="update">
							</div>
						</form>
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