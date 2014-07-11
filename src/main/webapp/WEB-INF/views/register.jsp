<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 

<head>

	<link href="<c:url value="/static/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/static/resources/css/bootstrap-responsive.min.css"/>" rel="stylesheet"
		type="text/css" />

	<link href="<c:url value="/static/resources/css/font-awesome.css"/>" rel="stylesheet" />
	<link
		href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
		rel="stylesheet" />

	<link href="<c:url value="/static/resources/css/style.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/static/resources/css/pages/signin.css"/>" rel="stylesheet" type="text/css" />

</head> 
<body> 


<div class="navbar navbar-fixed-top">
		
		<div class="navbar-inner">
			
			<div class="container">
				
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				
				<a class="brand" href="index">
					Plateforme de Test GFI 				
				</a>		
				
				<div class="nav-collapse">
					<ul class="nav pull-right">
						<li class="">						
							<a href="login" class="">
								Vous avez déja un compte? Connexion
							</a>
							
						</li>
						<li class="">						
							<a href="index" class="">
								<i class="icon-chevron-left"></i>
								Accueil
							</a>
							
						</li>
					</ul>
					
				</div><!--/.nav-collapse -->	
		
			</div> <!-- /container -->
			
		</div> <!-- /navbar-inner -->
		
	</div> <!-- /navbar -->

<div class="account-container register">
	
	<div class="content clearfix">
		
		<form:form commandName="newCandidat" >
		
			<h1>Inscription</h1>			
			
			<div class="login-fields">
				
				<p>Create your free account:</p>
				
				
				
				<div class="field">
					<label for="lastname">Nom et prenom:</label>	
					<td><form:input path="nomEtPrenom" placeholder="Nom & Prenom" class="login"/></td>
				</div> <!-- /field -->
				
				<div class="field">
					<label >Telephone :</label>	
					<td><form:input path="telephone" placeholder="Telephone" class="login"/></td>
				</div> <!-- /field -->
				
				<div class="field">
					<label for="firstname">E-mail:</label>
					<td><form:input path="identifiant" placeholder="E-mail" class="login"/></td>
				</div> <!-- /field -->
					
				<div class="field">
					<label for="password">Adresse:</label>
					<form:input path="adresse" id="adresse" name="adresse" value="" placeholder="adresse" class="login"/>
				</div> <!-- /field -->
				
				
			</div> <!-- /login-fields -->
			
			<div class="login-actions">
				
				<span class="login-checkbox">
					<input id="Field" name="Field" type="checkbox" class="field login-checkbox" value="First Choice" tabindex="4" />
					<label class="choice" for="Field">Agree with the Terms And Conditions.</label>
				</span>
									
				<button type="submit" class="button btn btn-primary btn-large">Register</button>
				
			</div> <!-- .actions -->
			
		</form:form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->


<!-- Text Under Box -->
<div class="login-extra">
	Vous avez déja un compte? <a href="login">Connexion</a>
</div> <!-- /login-extra -->


<script src="<c:url value="/static/js/jquery-1.7.2.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.js"/>"></script>

<script src="<c:url value="/static/js/signin.js"/>"></script>


</body>
</html>