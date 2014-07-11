<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Détail candidat</title>
</head>
<body>
	<div class="account-container register">

		<div class="content clearfix">



			<h1 id="btn-dropdowns" class="page-header">Détails du candidat</h1>

			<br> <br>

			<div class="tabbable">
				<label><strong class="text-danger">Email :</strong> ${candidat.identifiant}</label> 
				<label><strong class="text-danger">Nom et prénom:</strong> ${candidat.nomEtPrenom}</label> 
				<label><strong class="text-danger">Téléphone :</strong>${candidat.telephone}</label>
				<label><strong class="text-danger">Adresse :</strong>${candidat.adresse}</label>
			</div>


			<br> <br>

			<div class="form-actions"><form id="form" action="${pageContext.request.contextPath}/backoffice/sendMail" method="post">
				<a href="${pageContext.request.contextPath}/backoffice/resultats/${idExam}" role="button" class="btn btn-danger"><i
					class="icon-chevron-left"></i> Retour</a> 
					
					<a href="#" role="button" onclick="document.getElementById('form').submit();"
					class="btn btn-primary"><i class="icon-envelope"></i> Contacter</a>
					<input type="hidden" name="identifiant" id="identifiant" value="${candidat.identifiant}">
					<input type="hidden" name="idExam" id="idExam" value="${idExam}">
					</form>
			</div>
			<!-- .actions -->




			<!-- /content -->

		</div>
		<!-- /account-container -->
	</div>

</body>
</html>