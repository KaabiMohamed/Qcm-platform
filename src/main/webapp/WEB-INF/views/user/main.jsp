<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Examens</title>
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
								<h3>QCM à passer</h3>
							</div>
							<!-- /widget-header -->



							<div class="widget widget-table action-table">


								<!-- /widget-header -->
								<div class="widget-content">
									<table class="table table-striped table-bordered">
										<thead>
											<tr>
												<th class="td-actions">Titre d'examen</th>
												<th class="td-actions">Language</th>
												<th class="td-actions">Nombre Questions</th>
												<th class="td-actions">Passer Maintenant</th>
											</tr>
										</thead>
										<tbody>
											<c:if test="${exams.size() ==0}">
												<tr>
													<td>Vous n'avez encore reçu aucune invitation</td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
											</c:if>
											<c:forEach items="${exams}" var="exam">
												<tr>

													<td>${exam.titre}</td>
													<td>${exam.language}</td>
													<td>${exam.nombreQuestions}</td>

													<td class="td-actions"><a href="${pageContext.request.contextPath}/startQcm/${exam.idExam}"
														class="btn btn-small btn-primary"><i class="icon-time">Passer Maintenant</i></a></td>
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