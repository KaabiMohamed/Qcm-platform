<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Envoi Email</title>
</head>
<body>
<div class="account-container register">
	
	<div class="content clearfix">
		
		<form id="form" action="${pageContext.request.contextPath}/backoffice/sendOne" method="post">
		
			<h1 id="btn-dropdowns" class="page-header">Envoyer Un E-mail</h1>		
			
			<div class="login-fields">
				
				
				
				<div class="field">
					<label for="email">Email:</label>
					<input type="text" id="identifiant" name="identifiant" value="${identifiant}" placeholder="E-Mail" class="login" />
				</div> <!-- /field -->
				
				<div class="field">
					<label for="sujet">Sujet:</label>	
					<input type="text" id="sujet" name="sujet" value="" placeholder="Sujet" class="login" />
				</div> <!-- /field -->
				
				
				<div class="field">
					<label for="email">Message:</label>
					<textarea rows="5" cols="40" id="message" name="message" placeholder="Type your Message"></textarea>
				</div> <!-- /field -->
				
				
				
			</div> <!-- /login-fields -->
			
			<div class="form-actions">
				<a href="${pageContext.request.contextPath}/backoffice/resultats/${idExam}" role="button" class="btn btn-danger"><i
					class="icon-chevron-left"></i> Retour</a> 
					
					<a href="#" role="button" onclick="document.getElementById('form').submit();"
					class="btn btn-primary"><i class="icon-envelope"></i> Envoyer</a>
					<input type="hidden" name="idExam" value="${idExam}">
					
			</div> <!-- .actions -->
			
		</form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->


</body>
</html>