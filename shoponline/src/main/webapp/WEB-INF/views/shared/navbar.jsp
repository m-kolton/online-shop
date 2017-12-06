<%@ page pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${contextRoot}/home">Sklep
			internetowy</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="nav navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="${contextRoot}/home">Strona główna <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item" id="listProducts"><a class="nav-link"
					href="${contextRoot}/show/all/products">Produkty</a></li>
				<li class="nav-item" id="about"><a class="nav-link"
					href="${contextRoot}/about">O nas</a></li>
				<li class="nav-item" id="contact"><a class="nav-link"
					href="${contextRoot}/contact">Kontakt</a></li>
				<li class="nav-item" id="manageProducts"><a class="nav-link"
					href="${contextRoot}/manage/products">Zarządzaj</a></li>
			</ul>

			<ul class="nav navbar-nav ml-auto">
				<li class="nav-item" id="register"><a class="nav-link"
					href="${contextRoot}/register"><i class="fa fa-user"
						aria-hidden="true"></i> Zarejestruj się</a></li>
				<li class="nav-item" id="login"><a class="nav-link"
					href="${contextRoot}/login"><i class="fa fa-sign-in"
						aria-hidden="true"></i> Zaloguj się</a></li>

				<li class="dropdown">
				
					<a href="javascript:void(0)"
						class="btn btn-default dropdown-toggle" 
						id="dropdownMenu1"
						data-toggle="dropdown"
						aria-haspopup="true"
						aria-expanded="false"> ${userModel.fullName} 
					</a>
					
					<span class="caret"></span>
				

					<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
						<a class="dropdown-item" href="${contextRoot}/cart"> 
							<i class="fa fa-shopping-cart" aria-hidden="true"></i> 
						<span class="badge badge-pill badge-default">${userModel.cart.cartLines}</span> ${userModel.cart.grandTotal}
						</a>

						<div class="dropdown-divider"></div>

						<a class="dropdown-item" href="${contextRoot}/logout">Wyloguj się</a>
					</div>
				</li>
			</ul>
		</div>
	</div>
</nav>