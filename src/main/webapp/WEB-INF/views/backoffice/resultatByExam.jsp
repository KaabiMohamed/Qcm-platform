<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultats</title>
</head>
<body>
	<div class="main">

		<div class="main-inner">

			<div class="container">

				<div class="row">

					<div class="span12">

						<div class="widget ">

							<div class="widget-header">
								<i class="icon-list-alt"></i>
								<h3>${titre}</h3>
							</div>
							<!-- /widget-header -->



							<div class="widget widget-table action-table">


								<!-- /widget-header -->
								<div class="widget-content">
									<table class="table table-striped table-bordered">
										<thead>
											<tr>
												<th class="td-actions"><i class="icon-user"></i> Utilisateur</th>
												<th class="td-actions">Pourcentage</th>


												<th class="td-actions">Action </th>
											</tr>
										</thead>
										<tbody>
										<c:if test="${lesResultats.size() ==0}"><tr><td>Personne n'a encore passé le QCM </td><td></td><td></td></tr></c:if>
											<c:forEach items="${lesResultats}" var="result">
												<tr>

													<td>${result.candidat.identifiant}</td>
													<td>${result.pourcentageReussite} %</td>
														
													<td class="td-actions">
													<form action="${pageContext.request.contextPath}/backoffice/user" method="post">
												<input type="hidden" name="identifiant" id="identifiant" value="${result.candidat.identifiant}">
												<input type="hidden" name="idExam" id="idExam" value="${idExam}">
												<button type="submit" class="btn btn-primary">Voir Profil</button>
															</form>
															</td>
												
												</tr>
											</c:forEach>

										</tbody>



									</table>

								</div>
								<!-- /widget-content -->
							</div>
							<!-- /widget -->

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>