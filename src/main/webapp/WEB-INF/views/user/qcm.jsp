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
	<script
		src="https://google-code-prettify.googlecode.com/svn/loader/run_prettify.js"></script>

			<form action="${pageContext.request.contextPath}/user/qcm/${numQuestion+1}" method="get">
	<div class="main">

		<div class="main-inner">

			<div class="container">

				<div class="row">

					<div class="span12">

						<div class="widget ">

							<div class="widget-header">
								<i class="icon-plus-sign"></i>
								<h3>Numero de la question ${numQuestion+1}/${numberOfQuestions}    ||  Temps restant: ${remainingTime } minutes</h3>
							</div>
							<!-- /widget-header -->

							<div class="widget-content">
								<div class="tabbable">
									<label title="Question" class="control-label">Question
										: ${question.question}</label>
									<!--  <img alt="annexeQuestion" src=<c:url value="/static/resources/question-img/QuestionId.PNG"/>>-->
<br>
									<c:if test="${not empty question.annexeQuestion}">
										<pre class=prettyprint>
										
												<xmp>${question.annexeQuestion}</xmp>
											
									</pre>
									</c:if>
<br>	<input type="hidden" name="currentQuestion" id="currentQuestion" value="${numQuestion}" />
									<c:forEach items="${question.reponses}" var="reponse" varStatus="index">
										<li><input type="checkbox" name="check${index.index}" id="check${index.index}"
											value="Vrai"> ${reponse.key}</li><br>
											<input type="hidden" name="key${index.index}" id="key${index.index}" value="${reponse.key}"/>
									</c:forEach>

								</div>

								<div class="form-actions">

<%-- 									<c:if test="${numQuestion!=0 }"> --%>
<!-- 										<a -->
<%-- 											href="${pageContext.request.contextPath}/user/qcm/${numQuestion-1}" --%>
<!-- 											role="button" class="btn"><i -->
<!-- 											class="icon-large icon-backward"></i> Precedent</a> -->
<%-- 									</c:if> --%>
									<c:if test="${numQuestion!=numberOfQuestions-1 }"><button type="submit" class="btn">Suivant <i
											class="icon-large icon-forward"></i></button>
<!-- 										<a -->
<%-- 											href="${pageContext.request.contextPath}/user/qcm/${numQuestion+1}" --%>
<!-- 											role="button" class="btn">Suivant <i -->
<!-- 											class="icon-large icon-forward"></i></a> -->
									</c:if>
									<c:if test="${numQuestion==numberOfQuestions-1 }">
										<a
											href="${pageContext.request.contextPath}/user/qcm/finalise"
											role="button" class="btn btn-success"><i
											class="icon-large icon-save"></i> Terminer</a>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	</form>
</body>
</html>