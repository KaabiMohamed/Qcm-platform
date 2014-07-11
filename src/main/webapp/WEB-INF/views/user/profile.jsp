<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="account-container register">
	
	<div class="content clearfix">
		
		<form:form commandName="profil" id="form" >
		
			<h1 id="btn-dropdowns" class="page-header">Mon Profil</h1>		
			
			<div class="login-fields">
				
				
				
				
				
				<div class="field">
					<label for="lastname">Nom et prenom:</label>	
					<td><form:input path="nomEtPrenom" placeholder="Nom & Prenom" class="login"/></td>
				</div> <!-- /field -->
				<div class="field">
					<label for="lastname">Adresse:</label>	
					<td><form:input path="adresse" placeholder="adresse" class="login"/></td>
				</div> <!-- /field -->
				
				<div class="field">
					<label >Telephone :</label>	
					<td><form:input path="telephone" placeholder="Telephone" class="login"/></td>
				</div> <!-- /field -->
				
					<form:hidden path="identifiant"/>
				<div class="field">
					<label for="password">Password:</label>
					<form:input path="motDePasse" id="password" name="password" value="" placeholder="Password" class="login"/>
				</div> <!-- /field -->
				
			</div> <!-- /login-fields -->
			
			<div class="form-actions">
				
				
			<a href="${pageContext.request.contextPath}/user" role="button" class="btn btn-danger"><i
					class="icon-chevron-left"></i> Retour</a> 					
				<a href="#" role="button" onclick="document.getElementById('form').submit();"
					class="btn btn-primary"><i class="icon-ok"></i> Enregistrer </a>
				
			</div> <!-- .actions -->
			
		</form:form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->

<br><br><br>
</body>
</html>