<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nouvelle question</title>
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
	      				<h3> Ajouter Question</h3>
	  				</div> <!-- /widget-header -->

		<div class="widget-content">
			<div class="tabbable">

				<form:form commandName="newQuestion"> <!-- onsubmit="return Validate();" -->
					<div class="tab-content">



						<div class="control-group">
							<label class="control-label" for="question">Question</label>
							<form:input path="question" id="question" placeholder="Question"
								class="span6" />
						</div>
						<div class="field">
							<label class="control-label" for="annexeQuestion">Ecrire Du code :</label>
							<form:textarea path="annexeQuestion" id="annexeQuestion"  class="span6" placeholder="Public void Function(){" />
						</div>
						<!-- /field -->


						<div class="control-group">
						<label class="control-label" for="rep1">Reponse 1</label>
							<input type="text"  name="rep1" class="span6" id="rep1">


							<div class="controls"> Correction : 
								<label class="radio inline"> <input type="radio"
									name="radiobtns1" value="Vrai"> Vrai
								</label> <label class="radio inline"> <input type="radio"
									name="radiobtns1" value="Faux"> Faux
								</label>
							</div>
						</div>

						<div class="control-group">
						<label class="control-label" for="rep2">Reponse 2</label>
							<input type="text" name="rep2" id="rep2" class="span6">


							<div class="controls"> Correction : 
								<label class="radio inline"> <input type="radio"
									name="radiobtns2" value="Vrai"> Vrai
								</label> <label class="radio inline"> <input type="radio"
									name="radiobtns2" value="Faux"> Faux
								</label>
							</div>
						</div>

						<div class="control-group">
						<label class="control-label" for="rep3">Reponse 3</label>
							<input type="text" id="rep3" name="rep3" class="span6">


							<div class="controls">
								<label class="radio inline"> <input type="radio"
									name="radiobtns3" value="Vrai"> Vrai
								</label> <label class="radio inline"> <input type="radio"
									name="radiobtns3"  value="Faux"> Faux
								</label>
							</div>
						</div>
						<div class="control-group">
						<label class="control-label" for="rep4">Reponse 4</label> <input type="text" id="rep4" name="rep4" class="span6">


												<div class="controls"> Correction : 
								<label class="radio inline"> <input type="radio"
									name="radiobtns4" value="Vrai"> Vrai
								</label> <label class="radio inline"> <input type="radio"
									name="radiobtns4" value="Faux"> Faux
								</label>
							</div>
						</div>

						<div class="field">
							<label class="control-label" for="lang">Language</label>
							<form:input path="language" id="lang"
								placeholder="language(java,Spring,Hybris...)" class="span6" />
						</div>
						<div class="field">
							<label class="control-label" for="niveau">Niveau</label>
							<form:select path="niveau" placeholder="Niveau" class="span6"
								id="niveau">
								
								<form:option value="1" label="Debutant" />
								<form:option value="2" label="Confirmé" />
								<form:option value="3" label="Expert" />
								
							</form:select>
						</div>


						<div class="form-actions">
							<button type="submit" class="btn btn-primary">Save</button>
							<button type="button" class="btn"
								onclick="window.location='${pageContext.request.contextPath}/backoffice/questions'">Cancel</button>
						</div>

					</div>
				</form:form>

				<!-- /field -->
			</div>


</div></div></div></div></div>
		</div>
	</div>
</body>
</html>