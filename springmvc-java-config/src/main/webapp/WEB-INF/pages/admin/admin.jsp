<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>

<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/starter-template.css"
	rel="stylesheet" />
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-2.1.4.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>


</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="${pageContext.request.contextPath}"><b>Udemy</b></a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a
							href="${pageContext.request.contextPath}">Home</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">

		<h1>Admin</h1>

	</div>
	<!-- /container -->

	<footer class="footer">
		<div class="container">
			<p class="text-muted">
				<b>my first page with spring mvc</b>
			</p>
			<a href="<%=request.getContextPath()%>?language=en">EN</a> <a
				href="<%=request.getContextPath()%>?language=de">DE</a>
			<spring:message code="language" />
			<font color="green"><b><spring:message code="welcome.text" /></b></font>
		</div>
	</footer>

</body>
</html>