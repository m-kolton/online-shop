<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="fonts" value="/resources/fonts" />




<!DOCTYPE html>
<html lang="pl-PL">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Sklep internetowy - ${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Simplex theme CSS -->
<link href="${css}/bootstrap-simplex-theme.css" rel="stylesheet">

<!-- DataTable Bootstrap -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- Fonts Awesome -->
<link href="${fonts}/css/font-awesome.min.css" rel="stylesheet">


</head>

<body>

	<div>
		<!-- Navigation -->

		<nav class="navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Sklep
						internetowy</a>
				</div>
			</div>

		</nav>

		<!-- Page Content -->

		<div>
			<div class="container">
				<%-- this will be displayed if the credentials are wrong --%>
				<c:if test="${not empty message}">
					<div class="row">

						<div class="col-md-6 offset-md-3">

							<div class="alert alert-danger">${message}</div>

						</div>
					</div>

				</c:if>
				<%-- this will be displayed only when user has logged out --%>
				<c:if test="${not empty logout}">
					<div class="row">

						<div class="col-md-6 offset-md-3">

							<div class="alert alert-success">${logout}</div>

						</div>
					</div>

				</c:if>


				<div class="row">

					<div class="col-md-6 offset-md-3">

						<div class="card">

							<div class="card-header">
								<h4>Login</h4>
							</div>

							<div class="card-body">
								<form action="${contextRoot}/login" method="POST" class="form-horizontal" id="loginForm">
									
									<div class="form-group">
										<label for="username" class="col-md-4 control-label">Email:</label>
										<div class="col-md-12">
											<input type="text" name="username" id="username" class="form-control" />
										</div>
									</div>
						
									<div class="form-group">
										<label for="password" class="col-md-4 control-label">Hasło:</label>
										<div class="col-md-12">
											<input type="password" name="password" id="password" class="form-control" />
										</div>
									</div>
							
									<div class="form-group">
										<div class="col-md-offset-4 col-md-8">
											<input type="submit" value="Login" class="btn btn-primary" />
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
										</div>
									</div>
								</form>
							</div>
							
							<div class="card-footer">
								<div class="text-right">
									Nowy? - <a href="${contextRoot}/register">Zarejestruj się!</a>
								</div>
							</div>
						</div>
					</div>
				</div>
					<div class="col-xs-12" style="height:50px;"></div>
			</div>
		</div>
	</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>

		<!-- jQuery validation -->
		<script src="${js}/jquery.validate.js"></script>

		<script src="${js}/bootstrap.bundle.min.js"></script>

		<!-- Small JavaScript -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
