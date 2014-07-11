<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Questions</title>
</head>
<body>
<script src="https://google-code-prettify.googlecode.com/svn/loader/run_prettify.js"></script>

	<div class="main">

		<div class="main-inner">

			<div class="container">

				<div class="row">

					<div class="span12">

						<div class="widget ">

							<div class="widget-header">
								<i class="icon-plus-sign"></i>
								<h3>Detail Question</h3>
							</div>
							<!-- /widget-header -->

							<div class="widget-content">
								<div class="tabbable">

									<label title="Question" class="control-label">Question
										: ${selectedQuestion.question}</label>
									<!--  <img alt="annexeQuestion" src=<c:url value="/static/resources/question-img/QuestionId.PNG"/>>-->
									
									<c:if test="${not empty selectedQuestion.annexeQuestion}">
										<pre class=prettyprint >
										<div align="left"><xmp>${selectedQuestion.annexeQuestion}</xmp></div>
									</pre>
									</c:if>
									<c:forEach items="${selectedQuestion.reponses}" var="reponse">
										<li><label class="control-label"> ${reponse.key}
												/ ${reponse.value}</label></li>
									</c:forEach>
									<label class="control-label">Language :
										${selectedQuestion.language}</label> <label class="control-label">Niveau
										: ${selectedQuestion.niveau}</label>
								</div>

								<div class="form-actions">
								 
									<button type="button" class="btn btn-success"
										onclick="window.location='${pageContext.request.contextPath}/backoffice/modifierQuestion/${selectedQuestion.idQuestion}'">Modifier</button>
									<a href="#myModal" role="button" class="btn btn-danger" data-toggle="modal">Supprimer</a>
									<button type="button" class="btn"
										onclick="window.location='${pageContext.request.contextPath}/backoffice/questions'">Retour</button>
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
											<p>Voulez vous vraiment supprimer cette question ?</p>
										</div>
										<div class="modal-footer">
											<button class="btn" data-dismiss="modal" aria-hidden="true">Retour</button>
											<button onclick="window.location='${pageContext.request.contextPath}/backoffice/deleteQuestion/${selectedQuestion.idQuestion}'" class="btn btn-primary">Confirmer</button>
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