<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification question</title>
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
								<h3>Modifier Question</h3>
							</div>
							<!-- /widget-header -->

							<div class="widget-content">
								<div class="tabbable">

									<form:form commandName="editQuestion">
										<!-- onsubmit="return Validate();" -->
										<div class="tab-content">



											<div class="control-group">
												<label class="control-label" for="question">Question</label>
												<form:input path="question" id="question"
													placeholder="Question" class="span6" />
											</div>
											<div class="field">
												<label class="control-label" for=annexeQuestion>Ecrire
													Du code :</label>
												<form:textarea path="annexeQuestion" id="annexeQuestion"
													class="span6" />
											</div>
											<!-- /field -->

											<%
												int i = 1;
											%>
											<c:forEach items="#{editQuestion.reponses}" var="qest">
												<div class="control-group">
													<label class="control-label" for="rep1">Reponse 1</label> <input
														type="text" name="rep<%=i%>" class="span6"
														value="${qest.key}">

													<div class="controls">
														<input type="text" name="inp" class="span2 disabled"
															value="${qest.value}" disabled> <label
															class="radio inline"> <input type="radio"
															name="radiobtns<%=i%>" value="Vrai"> Vrai
														</label> <label class="radio inline"> <input type="radio"
															name="radiobtns<%=i%>" value="Faux"> Faux
														</label>
													</div>

												</div>
												<%
													i = i + 1;
												%>
											</c:forEach>


											<div class="field">
												<label class="control-label" for="lang">Language</label>
												<form:input path="language" id="lang"
													placeholder="language(java,Spring,Hybris...)" class="span6" />
											</div>
											<div class="field">
												<label class="control-label" for="niveau">Niveau</label>
												<form:select path="niveau" placeholder="Niveau"
													class="span6" id="niveau">
													<form:option value="1" label="Debutant" />
													<form:option value="2" label="Confirmé" />
													<form:option value="3" label="Expert" />
												</form:select>
											</div>


											<div class="form-actions">
												<button type="submit" class="btn btn-primary">
													<i class="icon-save"> </i> Enregistrer
												</button>
												<button type="button" class="btn"
													onclick="window.location='${pageContext.request.contextPath}/backoffice/questions'">Retour</button>
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