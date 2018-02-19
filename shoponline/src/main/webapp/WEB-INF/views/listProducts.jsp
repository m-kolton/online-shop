<%@ page pageEncoding="UTF-8"%>

<div class="container">
	<div class="row">
		<!-- Display sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- Display actual products -->
		<div class="col-md-9">

			<!-- Breadcrumb component -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">

						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Strona
									główna</a></li>
							<li class="breadcrumb-item active">Produkty</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">

						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Strona główna</a></li>
							<li class="breadcrumb-item">Kategoria</li>
							<li class="breadcrumb-item active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="container-fluid">
						<div class="table-responsive">
							<table id="productListTable" class="table table-striped table bordered">

								<thead>
									<tr>
										<th></th>
										<th>Nazwa</th>
										<th>Marka</th>
										<th>Cena</th>
										<th>Ilość</th>
										<th></th>
									</tr>
								</thead>
		
								<tfoot>
									<tr>
										<th></th>
										<th>Nazwa</th>
										<th>Marka</th>
										<th>Cena</th>
										<th>Ilość</th>
										<th></th>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<p></p>
			</div>
		</div>
	</div>
</div>


