<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="datatables"
	uri="http://github.com/dandelion/datatables"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Questions</title>
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
								<i class="icon-list-alt"></i>
								<h3>Liste des questions</h3>
							</div>
							<!-- /widget-header -->

							<div class="control-group">

								<div class="controls">
									<a
										href="${pageContext.request.contextPath}/backoffice/ajouterQuestion"
										role="button" class="btn btn-primary"><i class="icon-plus"></i></a>
									<span class="label label-primary">Nouvelle question</span>


								</div>

							</div>


							<div class="widget widget-table action-table">


								<!-- /widget-header -->
								<div class="widget-content">
								<br>
								<datatables:table theme="bootstrap2"
											cssClass="table table-striped" id="questions" row="question"
											data="${listQuestion }">
											<datatables:column title="Question" property="question"></datatables:column>
											<datatables:column title="Language" property="language"></datatables:column>
											<datatables:column title="Niveau" property="niveau"></datatables:column>
											
											<datatables:column title="Details">
										
												<a
													href="${pageContext.request.contextPath}/backoffice/questionDetail/${question.idQuestion}"
													 class="btn btn-small btn-success"> <i
													class="btn-icon-only icon-zoom-in"></i></a>
											</datatables:column>
										</datatables:table>
								<br><br>
								
								
							

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