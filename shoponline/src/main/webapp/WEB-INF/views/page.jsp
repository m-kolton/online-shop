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
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->

		<div>

			<!-- Load "Strona główna" content -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load "Produkty" bookmark -->
			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>

			<!-- Load "Produkt" bookmark -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>

			<!-- Load "O nas" bookmark -->
			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load "Kontakt" bookmark -->
			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- Load "Zarządzaj" bookmark -->
			<c:if test="${userClickManageProducts == true }">
				<%@include file="manageProducts.jsp"%>
			</c:if>

			<!-- Footer -->
			<%@include file="./shared/footer.jsp"%>

			<!-- Bootstrap core JavaScript -->
			<script src="${js}/jquery.min.js"></script>
			
			<!-- jQuery validation -->
			<script src="${js}/jquery.validate.js"></script>
			
			<script src="${js}/bootstrap.bundle.min.js"></script>

			<!-- DataTable plugin -->
			<script src="${js}/jquery.dataTables.js"></script>

			<!-- DataTable Bootstrap script -->
			<script src="${js}/dataTables.bootstrap4.js"></script>

			<!-- Bootbox -->
			<script src="${js}/bootbox.min.js"></script>

			<!-- Small JavaScript -->
			<script src="${js}/myapp.js"></script>
		</div>
	</div>
</body>

</html>
