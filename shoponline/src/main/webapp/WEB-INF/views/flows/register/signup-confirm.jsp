<%@ page pageEncoding="UTF-8"%>
<%@include file="../shared/flows-header.jsp" %>
			<div class="container">
				<div class="row">
					<!-- Personal details column -->
					<div class="col-sm-6">
						<p></p>
						<div class="card">
							<div class="card-header">
								<h4>Dane osobowe</h4>
							</div>
							
							<div class="card-body">
							<!-- Code to display personal details -->
								<div class="text-center">
									<h4>${registerModel.user.firstName} ${registerModel.user.lastName}</h4>
									<h5>Email: ${registerModel.user.email}</h5>
									<h5>Numer telefonu: ${registerModel.user.contactNumber}</h5>
									<h5>Rola: ${registerModel.user.role}</h5>
								</div>
							</div>
							
							<div class="card-footer">
							<!-- Anchor to move to edit personal details -->
								<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edytuj</a>
							</div>
						</div>
					</div>
					
					<!-- Address details column -->
					<div class="col-sm-6">
						<p></p>
						<div class="card">
							<div class="card-header">
								<h4>Adres</h4>
							</div>
							
							<div class="card-body">
							<!-- Code to display address details -->
							<div class="text-center">
									<h4>${registerModel.billing.addressLineOne}</h4>
									<h4>${registerModel.billing.addressLineTwo}</h4>
									<h4>${registerModel.billing.city} - ${registerModel.billing.postalCode}</h4>
									<h4>${registerModel.billing.state}</h4>
									<h4>${registerModel.billing.country}</h4>
								</div>
							</div>
							
							<div class="card-footer">
							<!-- Anchor to move to edit address details -->
								<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edytuj</a>
							</div>
						</div>
					</div>				
				</div>
				
				<div class="row">
					<div class="cos-sm-8 offset-sm-4" class="text-center">
						<!-- Anchor to move to success page -->
							<p></p>
							<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary">Potwierdź</a>
							<p></p>
					</div>
				</div>
			</div>
		</div>
<%@include file="../shared/flows-footer.jsp" %>