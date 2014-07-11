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
								<h3>Liste de vos Examens</h3>
							</div>
							<!-- /widget-header -->



							<div class="widget widget-table action-table">


								<!-- /widget-header -->
								<div class="widget-content">
									<table class="table table-striped table-bordered">
										<thead>
											<tr>
												<th class="td-actions">Titre d'examen</th>
												<th class="td-actions">Nombre d'invit�s</th>


												<th class="td-actions">Voir Detail</th>
											</tr>
										</thead>
										<tbody>
											<c:if test="${resultats.size() ==0}">
												<tr>
													<td>Personne n'a encore pass� l'un de vos examens</td>
													<td></td>
													<td></td>
												</tr>
											</c:if>

											<c:forEach items="${resultats}" var="result">
												<tr>

													<td>${result.examen.titre}</td>
													<td>${result.examen.lesCandidats.size()}</td>

													<td class="td-actions"><a
														href="${pageContext.request.contextPath}/backoffice/resultats/${result.examen.idExam}"
														class="btn btn-small btn-primary"><i
															class="icon-search"></i></a></td>

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