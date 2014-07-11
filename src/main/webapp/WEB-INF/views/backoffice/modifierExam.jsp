<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification examen</title>
</head>
<body>

	<div class="main">

		<div class="main-inner">

			<div class="container">

				<div class="row">

					<div class="span12">

						<div class="widget ">

							<div class="widget-header">
								<i class="icon-edit"></i>
								<h3>Modifier Examen</h3>
							</div>
							<!-- /widget-header -->

							<div class="widget-content">
								<div class="tabbable">

									<form:form commandName="editExam">
										
										<div class="tab-content">



											<div class="control-group">
												<label class="control-label" for="question">Titre</label>
												<form:input path="titre" id="titre" placeholder="titre"
													class="span6" />
											</div>



											<div class="control-group">
												<label class="control-label" for="nombreQuestions">Nombre
													Questions</label>
												<form:input type="text" path="nombreQuestions"
													id="nombreQuestions" class="span4" />
											</div>
											
											<div class="control-group">
												<label class="control-label" for="nombreMinutes">Duree de l'examen</label>
												<form:input type="text" path="nombreMinutes"
													id="nombreMinutes" class="span4" placeholder="** (Minutes)"/>
											</div>

											<div class="field">
												<label class="control-label" for="niveau">Language</label>
												<form:select path="language" 
													class="span4" id="language">
													<c:forEach items="${select}" var="lang">
													<form:option value="${lang}" label="${lang}" />
													</c:forEach>


												</form:select>
											</div>
											
											<div class="control-group">
												<label class="control-label" for="nombreMinutes">Jours de Validité</label>
												<form:input type="text" path="joursValidite"
													id="joursValidite" class="span4" placeholder="** (Jours)"/>
											</div>


											<div class="form-actions">
												<button type="submit" class="btn btn-primary"><i class="icon-save"> </i> Enregistrer</button>
												<button type="button" class="btn"
													onclick="window.location='${pageContext.request.contextPath}/backoffice/exams'">Retour</button>
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