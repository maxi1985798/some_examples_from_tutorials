<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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

		<h1>Java Spring MVC(JavaConfig)</h1>
		<p>The sample application provided by Spring MVC JavaConfig</p>
		<p>Welcome to Java Spring MVC with Java Configuration</p>

		<a href="${pageContext.request.contextPath}/displayUsers">Display
			users with embedded Database</a> <br /> <a
			href="${pageContext.request.contextPath}/displayUsersMySQL">Display
			users with MySQL Database</a> <br /> <a
			href="${pageContext.request.contextPath}/newblogpost.html">New
			Blog Post</a> <br /> <a
			href="${pageContext.request.contextPath}/blogposts">Blog Posts</a> <br />
		<a href="${pageContext.request.contextPath}/admin">Admin</a> <br /> <br />
		<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
			<!-- this content will be dispaly if user has 'ROLE_ADMIN' or 'ROLE_USER' -->
			<b>You are logged in as: </b>
			<security:authentication property="principal.username" />
          with the role of: <security:authentication
				property="principal.authorities" />
			<br />
			<a href="<c:url value="/logout" />">Logout</a>
		</security:authorize>

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