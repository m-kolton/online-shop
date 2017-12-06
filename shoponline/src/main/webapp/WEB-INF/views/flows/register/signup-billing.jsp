<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>

<div class="container">

	<div class="row">

		<div class="col-md-6 offset-md-3">

			<div class="card">

				<div class="card-header">
					<h4>Zarejestruj się - Adres</h4>
				</div>

				<div class="card-body">

					<sf:form method="POST" class="form-horizontal" id="billingForm"
						modelAttribute="billing">


						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineOne">Adres</label>
							<div class="col-md-12">
								<sf:input type="text" path="addressLineOne" class="form-control"
									placeholder="Podaj adres" />

								<sf:errors path="addressLineOne" cssClass="form-text"
									element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineTwo">Adres
								cd.</label>
							<div class="col-md-12">
								<sf:input type="text" path="addressLineTwo" class="form-control"
									placeholder="Podaj adres" />

								<sf:errors path="addressLineTwo" cssClass="form-text"
									element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="city">Miejscowość</label>
							<div class="col-md-12">
								<sf:input type="text" path="city" class="form-control"
									placeholder="Podaj miejscowość" />

								<sf:errors path="city" cssClass="form-text" element="em" />


							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="postalCode">Kod
								pocztowy</label>
							<div class="col-md-12">
								<sf:input type="text" path="postalCode" class="form-control"
									placeholder="XXXXXX" />

								<sf:errors path="postalCode" cssClass="form-text" element="em" />


							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="state">Województwo</label>
							<div class="col-md-12">
								<sf:input type="text" path="state" class="form-control"
									placeholder="Podaj nazwę województwa" />

								<sf:errors path="state" cssClass="form-text" element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="country">Kraj</label>
							<div class="col-md-12">
								<sf:input type="text" path="country" class="form-control"
									placeholder="Podaj miasto" />

								<sf:errors path="country" cssClass="form-text" element="em" />

							</div>
						</div>


						<div class="form-group">
							<div class="col-md-4 offset-md-4">
								<!-- submit button for moving to the personal -->
								<button type="submit" class="btn btn-primary"
									name="_eventId_personal">

									<i class="fa fa-chevron-left" aria-hidden="true"></i> Wróć

								</button>

								<!-- submit button for moving to the confirm -->
								<button type="submit" class="btn btn-primary"
									name="_eventId_confirm">

									Dalej <i class="fa fa-chevron-right" aria-hidden="true"></i>

								</button>

							</div>
						</div>


					</sf:form>
				</div>
			</div>
		</div>
	</div>

</div>





<%@include file="../shared/flows-footer.jsp"%>