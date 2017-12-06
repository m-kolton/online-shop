<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8"%>
<%@include file="../shared/flows-header.jsp"%>

<div class="container">

	<div class="row">
		<p></p>
	</div>

	<div class="col-md-8 offset-md-2">

		<div class="row">

			<div class="col-md-8 offset-md-2">

				<div class="card">

					<div class="card-header">
						<h4>Zarejestruj się - Dane</h4>
					</div>

					<div class="card-body">

						<sf:form method="POST" class="form-horizontal" id="registerForm"
							modelAttribute="user">


							<div class="form-group">
								<label class="control-label col-md-4">Imię</label>
								<div class="col-md-12">
									<sf:input type="text" path="firstName" class="form-control"
										placeholder="Imię" />

									<sf:errors path="firstName" cssClass="form-text" element="em" />

								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-md-4">Nazwisko</label>
								<div class="col-md-12">
									<sf:input type="text" path="lastName" class="form-control"
										placeholder="Nazwisko" />

									<sf:errors path="lastName" cssClass="form-text" element="em" />

								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Email</label>
								<div class="col-md-12">
									<sf:input type="text" path="email" class="form-control"
										placeholder="abc@zyx.com" />

									<sf:errors path="email" cssClass="form-text" element="em" />

								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Numer telefonu</label>
								<div class="col-md-12">
									<sf:input type="text" path="contactNumber" class="form-control"
										placeholder="XXXXXXXXXX" maxlength="10" />

									<sf:errors path="contactNumber" cssClass="form-text"
										element="em" />


								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Hasło</label>
								<div class="col-md-12">
									<sf:input type="password" path="password" class="form-control"
										placeholder="Hasło" />

									<sf:errors path="password" cssClass="form-text" element="em" />


								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Potwierdź hasło</label>
								<div class="col-md-12">
									<sf:input type="password" path="confirmPassword"
										class="form-control" placeholder="Podaj ponownie hasło" />

									<sf:errors path="confirmPassword" cssClass="form-text"
										element="em" />

								</div>
							</div>


							<!-- Radio button using bootstrap class of radio-inline -->
							<div class="form-group">
								<label class="control-label col-md-4">Wybierz role</label>
								<div class="col-md-12">
									<label class="radio-inline"> <sf:radiobutton
											path="role" value="USER" checked="checked" />
										Użytkownik&nbsp;
									</label> <label class="radio-inline"> <sf:radiobutton
											path="role" value="SUPPLIER" /> Sprzedawca
									</label>
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-4 offset-md-8">
									<button type="submit" class="btn btn-primary"
										name="_eventId_billing">

										Dalej - Płatność <i class="fa fa-chevron-right"
											aria-hidden="true"></i>

									</button>

								</div>
							</div>

						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>

<%@include file="../shared/flows-footer.jsp"%>