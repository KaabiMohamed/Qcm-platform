<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details examen</title>
</head>
<body>


	<div class="main">

		<div class="main-inner">

			<div class="container">

				<div class="row">

					<div class="span12">

						<div class="widget ">

							<div class="widget-header">
								<i class="icon-plus-sign"></i>
								<h3>Details d'examen</h3>
							</div>
							<!-- /widget-header -->

							<div class="widget-content">
								<div class="tabbable">

									<label title="Titre" class="news-item-title">Titre
										: ${selectedExam.titre}</label>
									<label title="Titre" class="news-item-title">Nombre de Questions
										: ${selectedExam.nombreQuestions}</label>
										
									<label title="Titre" class="news-item-title">Durée de l'exam
										: ${selectedExam.nombreMinutes} (minutes)</label>	
										
										<label title="Titre" class="news-item-title">Language
										: ${selectedExam.language}</label>
										
										<label title="Titre" class="news-item-title">Jours de validité
										: ${selectedExam.joursValidite}</label>
										
										<label title="Titre" class="news-item-title">Nombre d'invitations envoyées
										: ${selectedExam.lesCandidats.size()}</label>
									
									
								</div>

								<div class="form-actions">
								 <button type="button" class="btn btn-primary"
										onclick="window.location='${pageContext.request.contextPath}/backoffice/invite/${selectedExam.idExam}'">Envoyer des Invitations</button>
									<button type="button" class="btn btn-success"
										onclick="window.location='${pageContext.request.contextPath}/backoffice/modifierExam/${selectedExam.idExam}'">Modifier</button>
									<a href="#myModal" role="button" class="btn btn-danger" data-toggle="modal">Supprimer</a>
									<button type="button" class="btn"
										onclick="window.location='${pageContext.request.contextPath}/backoffice/exams'">Retour</button>
								
								
								
								
									<!-- Modal -->
									<div id="myModal" class="modal hide fade" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true"><i class="icon-remove" ></i></button>
											<h3 id="myModalLabel">On a besoin de votre confirmation</h3>
										</div>
										<div class="modal-body">
											<p>Voulez vous vraiment supprimer cet examen ?</p>
											<p>NB: tout les resultats de cet examens seront aussi supprimés</p>
										</div>
										<div class="modal-footer">
											<button class="btn" data-dismiss="modal" aria-hidden="true">Retour</button>
											<button onclick="window.location='${pageContext.request.contextPath}/backoffice/deleteExam/${selectedExam.idExam}'" class="btn btn-primary">Confirmer</button>
										</div>
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