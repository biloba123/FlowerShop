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
		<%@ include file="../manager-header.jsp"%>

		<div class="center_content">
			<div class="left_content">
				<div class="title">
					<span class="title_icon"><img src="<%=request.getContextPath()%>/img/bullet1.gif"
						alt="" title=""></span>Flower Shop Management Platform
				</div>

				<div class="feat_prod_box_details">

					<div class="contact_form">
						<div class="form_subtitle">login into manager's account</div>
						<form name="register" action="check" method="post">
							<div class="form_row">
								<label class="contact"><strong>Username:</strong></label> <input
									type="text" class="contact_input"  name="username" required>
							</div>
							<div class="form_row">
								<label class="contact"><strong>Password:</strong></label> <input
									type="password" class="contact_input" name="password" required>
							</div>
							<div class="form_row">
								<input type="submit" class="register" value="login">
							</div>
						</form>
						<%
							String errorMsg=(String)session.getAttribute("err");
							if(errorMsg!=null){
								out.print("<span style='color:red;'>"+errorMsg+"</span>");
								session.removeAttribute("err");
							}
						%>
					</div>
				</div>

				<div class="clear"></div>
			</div>
			<%@ include file="../manager-right-content.jsp"%>
		</div>

		<%@ include file="../footer.jsp"%>
	</div>

</body>
</html>