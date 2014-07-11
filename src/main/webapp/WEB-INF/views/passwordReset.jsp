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
						<a href="register" class="">
							vous n'avez pas un compte?
						</a>
						
					</li>
					
					<li class="">						
						<a href="index" class="">
							<i class="icon-chevron-left"></i>
							Acceuil
						</a>
						
					</li>
				</ul>
				
			</div><!--/.nav-collapse -->	
	
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->



<div class="account-container">
	
	<div class="content clearfix">
		
		<form  action="${pageContext.request.contextPath}/reset" method="post">
		
			<h1>Vous avez oublié votre mot de passe? </h1>		
			
			<div class="login-fields">
				
				<p>Vous recevez un e-mail avec un nouveau mot de passe</p>
				
				<div class="field">
					<label for="username">Adresse électronique :</label>
					<input name="identifiant" placeholder="Adresse électronique" class="login username-field" />
				</div> <!-- /field -->
				
				</div>
			
			<div class="login-actions">
				
				
									
				<button type="submit" class="button btn btn-primary btn-large">Reset</button>
				
			</div> <!-- .actions -->
			
			
			
		</form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->





<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/bootstrap.js"></script>

<script src="js/signin.js"></script>

</body> 
</html>
