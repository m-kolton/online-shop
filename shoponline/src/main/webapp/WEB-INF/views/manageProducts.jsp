<%@ page pageEncoding="UTF-8"%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row">
		<p></p>
	</div>

	<div class="row">

		<div class="col-md-8 offset-md-2">
			<c:if test="${not empty message}">
				<div class="col-xs-12">
					<h6>
						<div class="alert alert-success alert-dissmissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							${message}
						</div>
					</h6>
				</div>
			</c:if>
		</div>

		<div class="col-md-8 offset-md-2">

			<div class="card">
				<div class="card-header">
					<h2>Zarządzaj produktami</h2>
				</div>

				<div class="card-body">


					<sf:form modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data"
						>
						
						<!-- Form-block for "name" -->
						<div class="form-group row">
							<label for="name" class="col-sm-2 col-form-label">Nazwa
								produktu:</label>
							<div class="col-sm-10">
								<sf:input type="text" class="form-control" path="name" id="name"
									aria-describedby="nameHelp" placeholder="Nazwa produktu"></sf:input>
								<sf:errors path="name" cssClass="form-text" element="em" style="color:red;"/>
							</div>
						</div>

						<!-- Form-block for "brand" -->
						<div class="form-group row">
							<label for="brand" class="col-sm-2 col-form-label">Marka:</label>
							<div class="col-sm-10">
								<sf:input type="text" class="form-control" path="brand"
									id="brand" placeholder="Marka"></sf:input>
								<sf:errors path="brand" cssClass="form-text" element="em" style="color:red;"/>
							</div>
						</div>

						<!-- Form-block for "description" -->
						<div class="form-group row">
							<label for="description" class="col-sm-2 col-form-label">Opis:</label>
							<div class="col-sm-10">
								<sf:textarea class="form-control" path="description"
									id="description" rows="4" placeholder="Opis"></sf:textarea>
								<sf:errors path="description" cssClass="form-text" element="em" style="color:red;"/>
							</div>
						</div>

						<!-- Form-block for "unitPrice" -->
						<div class="form-group row">
							<label for="unitPrice" class="col-sm-2 col-form-label">Cena:</label>
							<div class="col-sm-10">
								<sf:input type="number" class="form-control" path="unitPrice"
									id="unitPrice" placeholder="Cena w PLN"></sf:input>
								<sf:errors path="unitPrice" cssClass="form-text" element="em" style="color:red;"/>
							</div>
						</div>

						<!-- Form-block for "quantity" -->
						<div class="form-group row">
							<label for="quantity" class="col-sm-2 col-form-label">Ilość:</label>
							<div class="col-sm-10">
								<sf:input type="number" class="form-control" path="quantity"
									id="quantity" placeholder="Ilość"></sf:input>
							</div>
						</div>
						
						<!-- Form-block for image upload -->
						<div class="form-group row">
							<label for="file" class="col-sm-2 col-form-label">Wybierz zdjęcie:</label>
							<div class="col-sm-10">
								<sf:input type="file" class="form-control" path="file"
									id="file"></sf:input>
								<sf:errors path="file" cssClass="form-text" element="em" style="color:red;"/>	
							</div>
						</div>

						<!-- Form-block for "category" -->
						<div class="form-group row">
							<label for="categoryId" class="col-sm-2 col-form-label">Kategoria:
							</label>
							<div class="col-sm-10">
								<sf:select class="form-control" path="categoryId"
									id="categoryId" items="${categories}" itemLabel="name"
									itemValue="id">
								</sf:select>
								
								<c:if test="${product.id == 0}">
									<div class="text-right">
									<br/>
									<button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-xs">Dodaj kategorię</button>
									</div>
								</c:if>
							</div>
						</div>


						<div class="form-group">
							<button type="submit" class="btn btn-primary">Dodaj</button>

							<!-- Hideen fields -->
							<sf:hidden path="id" />
							<sf:hidden path="code" />
							<sf:hidden path="supplierId" />
							<sf:hidden path="active" />
							<sf:hidden path="purchases" />
							<sf:hidden path="views" />
							
						</div>

					</sf:form>

				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<h3>Dostępne produkty</h3>
			<hr/>
		</div>
		
		<div class="col-xs-12">
			<div class="container-fluid">
				<div class="table-responsive">
			
					<!-- Product table for Admin -->
					<table id="adminProductsTable" class="table table-stripped-bordered">
					
						<thead>
							<tr>
								<th>ID</th>
								<th>Zdjęcie</th>
								<th>Nazwa</th>
								<th>Marka</th>
								<th>Ilość</th>
								<th>Cena jednostkowa</th>
								<th>Aktywność</th>
								<th>Edycja</th>
							</tr>
						</thead>
						
						<tfoot>
							<tr>
								<th>ID</th>
								<th>Zdjęcie</th>
								<th>Nazwa</th>
								<th>Marka</th>
								<th>Ilość</th>
								<th>Cena jednostkowa</th>
								<th>Aktywność</th>
								<th>Edycja</th>
							</tr>
						</tfoot>
					
					</table>
					<div class="row">
						<p></p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<!-- Modal header -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
						<h4 class="modal-title">Dodaj nową kategorię</h4>
					</button>
				</div>
				<div class="modal-body">
					<!-- Category form -->
					<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category" method="POST" class="form-horizontal">
						<div class="form-group">
							<label for="category_name" class="control-label col-md-4">Nazwa kategorii</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="category_name" class="form-control"></sf:input>
							</div>
						</div>
						
						<div class="form-group">
							<label for="category_description" class="control-label col-md-4">Opis kategorii</label>
							<div class="col-md-8">
								<sf:textarea cols="" rows="5" path="description" id="category_description" class="form-control"></sf:textarea>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-8 offset-md-2">
								<input type="submit" value="Dodaj kategorię" class="btn btn-primary"></input>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>	
</div>