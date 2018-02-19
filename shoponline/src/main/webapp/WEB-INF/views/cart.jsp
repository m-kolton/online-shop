<%@ page pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">

	<c:if test="${not empty message}">
		<div class="alert alert-info">
			<h3 class="text-center">
				${message}
			</h3>
		</div>
	</c:if>

	<c:choose>
		<c:when test="${not empty cartLines}">
		
			<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Produkt</th>
							<th style="width:10%">Cena</th>
							<th style="width:8%">Ilość</th>
							<th style="width:22%" class="text-center">Kwota</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach items="${cartLines}" var="cartLine">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs">
										<img src="${images}/${cartLine.product.code}.jpg" alt="${cartLine.product.name}" class="cartImg img-responsive"/></div>
									<div class="col-sm-1"></div>
									<div class="col-sm-9">
										<h4 class="nomargin">${cartLine.product.name}
											<c:if test="${cartLine.available == false}">
												<strong class="unavailable">(Niedostępny!)</strong>
											</c:if>
										</h4>
										<p>Marka - ${cartLine.product.brand}</p>
										<p>Opis - ${cartLine.product.description}</p>
									</div>
								</div>
							</td>
							<td data-th="Price">${cartLine.buyingPrice} zł</td>
							<td data-th="Quantity">
								<input type="number" id="count_${cartLine.id}" min="1" max="3" class="form-control text-center" value="${cartLine.productCount}">
							</td>
							<td data-th="Subtotal" class="text-center">${cartLine.total} zł</td>
							<td class="actions" data-th="">
								<button type="button" name="refreshCart" value="${cartLine.id}" class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>
								<a href="${contextRoot}/cart/${cartLine.id}/delete" class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></a>								
							</td>
						</tr>
					
					</c:forEach>
					
						
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Razem: ${userModel.cart.grandTotal} zł</strong></td>
						</tr>
						<tr>
							<td><a href="${contextRoot}/show/all/products" class="btn btn-warning"><i class="fa fa-angle-left"></i> Kontunuuj zakupy</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Razem: ${userModel.cart.grandTotal} zł</strong></td>
							<td><a href="#" class="btn btn-success btn-block">Płatność <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
		</c:when>
		<c:otherwise>
			<div class="jumbotron">
				<div class="text-center">
					<h2>Twój koszyk jest pusty!</h2>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</div>