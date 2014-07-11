<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="datatables"
	uri="http://github.com/dandelion/datatables"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des comptes</title>
<link
	href="<c:url value="/static/resources/css/bootstrap-combined.min.css"/>"
	rel="stylesheet" />
</head>
<body>
	<div class="main">

		<div class="main-inner">

			<div class="container">

				<div class="row">

					<div class="span12">

						<div class="widget ">

							<div class="widget-header">
								<i class="icon-user"></i>
								<h3>Gerer les comptes</h3>

							</div>
							<!-- /widget-header -->

							<br> <a href="${pageContext.request.contextPath}/backoffice/ajouterCompte" role="button" class="btn btn-primary"><i
								class="icon-plus"></i> </a><span class="label label-primary">Ajouter
								Compte</span>
						</div>
						<div class="widget-content">



							<div class="tabbable">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#candidat" data-toggle="tab">Candidats</a></li>
									<li><a href="#admin" data-toggle="tab">Administrateurs</a></li>

								</ul>

								<br>

								<div class="tab-content">
									<div class="tab-pane" id="admin">

										<datatables:table theme="bootstrap2"
											cssClass="table table-striped" id="myTableAdmin" row="admin"
											data="${listeAdmin }">
											<datatables:column title="E-mail" property="identifiant"></datatables:column>
											<datatables:column title="Nom/Prenom" property="nomEtPrenom"></datatables:column>
											<datatables:column title="Adresse" property="adresse"></datatables:column>
											<datatables:column title="Telephone" property="telephone"></datatables:column>
											<datatables:column title="active/inactive" property="active"></datatables:column>
											<datatables:column title="Active/Desactiver">
												<form id="form"
													action="${pageContext.request.contextPath}/backoffice/desactivate"
													method="post">
													<input type="hidden" id="identifiant" name="identifiant"
														value="${admin.identifiant}">
													<button type="submit" class="btn btn-small btn-danger">
														<i class=" icon-remove"></i>
													</button>

												</form>
											</datatables:column>
										</datatables:table>
									</div>

									<div class="tab-pane active" id="candidat">
										<datatables:table id="myTableCandidat" theme="bootstrap2"
											row="candidat" cssClass="table table-striped"
											data="${listeCandidat }">
											<datatables:column title="E-mail" property="identifiant"></datatables:column>
											<datatables:column title="Nom/Prenom" property="nomEtPrenom"></datatables:column>
											<datatables:column title="Adresse" property="adresse"></datatables:column>
											<datatables:column title="Telephone" property="telephone"></datatables:column>
											<datatables:column title="active/inactive" property="active"></datatables:column>
											<datatables:column title="Active/Desactiver">
												<form id="form"
													action="${pageContext.request.contextPath}/backoffice/desactivate"
													method="post">
													<input type="hidden" id="identifiant" name="identifiant"
														value="${candidat.identifiant}">
													<button id="sub" type="submit"
														class="btn btn-small btn-danger">
														<i class=" icon-remove"></i>
													</button>


												</form>
											</datatables:column>
										</datatables:table>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>