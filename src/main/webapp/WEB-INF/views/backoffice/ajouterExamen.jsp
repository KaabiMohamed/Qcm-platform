<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script language="JavaScript">
		$(document).ready(function() {
			
			
				 $('#zoneSub').hide();
				 
		});
		
                     
			
		function Validate() {
			//&& form.nombreQuestions.value == "" && form.nombreMinutes.value <1 && form.joursValidite.value <1

			if (form.titre.value == "" || parseInt(form.nombreQuestions.value) <1
					|| parseInt(form.nombreMinutes.value) <1
					|| parseInt(form.joursValidite.value)<1) {

				$('#zoneSub').show();
				document.getElementById('erreur').innerHTML = ('Veuillez Remplir correctement les details de l\'examen ');

				return false;

			}

			return true;
		}
	</script>
	<div class="main">

		<div class="main-inner">

			<div class="container">

				<div class="row">

					<div class="span12">

						<div class="widget ">

							<div class="widget-header">
								<i class="icon-plus-sign"></i>
								<h3>Nouveau QCM</h3>
							</div>

							<!-- /widget-header -->

							<div class="widget-content">
								<div class="tabbable">
									<div id="zoneSub" class="alert alert-block">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<div id="erreur"></div>
									</div>
									<form:form name="form" commandName="newQcm"
										onsubmit="return Validate();">

										<div class="tab-content">



											<div class="control-group">
												<label class="control-label" for="question">Titre</label>
												<form:input path="titre" id="titre" name="titre"
													placeholder="titre" class="span6" />
											</div>



											<div class="control-group">
												<label class="control-label" for="nombreQuestions">Nombre
													Questions</label>
												<form:input type="text" path="nombreQuestions"
													name="nombreQuestions" id="nombreQuestions" class="span4" />
													<c:if test="${errorMsj!=''}">
													<span class="label label-warning">${errorMsj}</span>
													</c:if>
											</div>

											<div class="control-group">
												<label class="control-label" for="nombreMinutes">Duree
													de l'examen</label>
												<form:input type="text" path="nombreMinutes"
													name="nombreMinutes" id="nombreMinutes" class="span4"
													placeholder="** (Minutes)" />
											</div>

											<div class="field">
												<label class="control-label" for="niveau">Language</label>
												<form:select path="language" class="span4" id="language">
													<c:forEach items="${select}" var="lang">
														<form:option value="${lang}" label="${lang}" />
													</c:forEach>


												</form:select>
											</div>

											<div class="control-group">
												<label class="control-label" for="nombreMinutes">Jours
													de Validité</label>
												<form:input type="text" path="joursValidite"
													name="joursValidite" id="joursValidite" class="span4"
													placeholder="** (Jours)" />
											</div>





											<div class="form-actions">
												<button type="submit" class="btn btn-primary">Enregistrer</button>
												<button type="button" class="btn"
													onclick="window.location='${pageContext.request.contextPath}/backoffice/exams'">Annuler</button>
											</div>

										</div>
									</form:form>

									<!-- /field -->
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