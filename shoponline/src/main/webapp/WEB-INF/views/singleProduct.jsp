<%@ page pageEncoding="UTF-8"%>
<div class="container">

	<!-- Breadcrumb -->
	<div class="row">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Strona
						główna</a></li>
				<li class="breadcrumb-item"><a
					href="${contextRoot}/show/all/products">Produkty</a></li>
				<li class="breadcrumb-item active">${product.name}</li>
			</ol>

		</div>


	</div>

	<div>
		<div class="row">
		
			<!-- Display product image -->
			<div class ="col-xs-12 col-sm-4">
				<div class="img-thumbnail">
					<img src="${images}/${product.code}.jpg/" class="img-fluid"> 
				</div>
			</div>
			
			<!-- Display product description -->
			<div class ="col-xs-12 col-sm-8">
				<h3>${product.name}</h3>
				<hr/>
				
				<p>${product.description}</p>
				<hr/>
				
				<h4>Cena: <strong>${product.unitPrice}</strong></h4>
				<hr/>
				
				
				<c:choose>
					<c:when test="${product.quantity < 1}">
						<h6>Ilość: <span style="color:red">Brak w magazynie!</span></h6>		
					</c:when>
					<c:otherwise>
						<h6>Ilość: ${product.quantity}</h6>
					</c:otherwise>
				</c:choose>
				
				<security:authorize access="hasAuthority('USER')">
				<c:choose>
					<c:when test="${product.quantity < 1}">
						<a href="javascript:void(0)" class="btn btn-success disabled" aria-disabled="true">Dodaj do koszyka <i class="fa fa-shopping-cart" aria-hidden="true"></i></a>		
					</c:when>
					<c:otherwise>
						<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">Dodaj do koszyka <i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
					</c:otherwise>
				</c:choose>
				</security:authorize>
				
				<security:authorize access="hasAuthority('ADMIN')">
					<a href="${contextRoot}/manage/${product.id}/product" class="btn btn-warning">Edytuj<i class="fa fa-pencil" aria-hidden="true"></i></a>
				</security:authorize>
				
				<a href="${contextRoot}/cart/show/products" class="btn btn-success">Powrót</a>
			
			</div>
			
		</div>
	</div>


</div>