<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link href="<c:url value="/static/resources/css/bootstrap.min.css"/>"
		rel="stylesheet" type="text/css" />
	<link
		href="<c:url value="/static/resources/css/bootstrap-responsive.min.css"/>"
		rel="stylesheet" type="text/css" />

	<link href="<c:url value="/static/resources/css/font-awesome.css"/>"
		rel="stylesheet" />
	<link
		href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
		rel="stylesheet" />

	<link href="<c:url value="/static/resources/css/style.css"/>"
		rel="stylesheet" type="text/css" />
	<link href="<c:url value="/static/resources/css/pages/signin.css"/>"
		rel="stylesheet" type="text/css" />
	<link href="<c:url value="/static/resources/css/pages/dashboard.css"/>"
		rel="stylesheet" />
	<link href="<c:url value="/static/resources/js/guidely/guidely.css"/>"
		rel="stylesheet" />
</head>
<body>


<div class="container">
	
	<div class="row">
		
		<div class="span12">
			
			<div class="error-container">
				<h1>Error 403</h1>
				
				<h2>Access is denied.</h2>
				
				<div class="error-details">
					Sorry, You don't have the right to access this page! Why not try going back to the <a href="index">home page</a> or perhaps try following!
					
				</div> <!-- /error-details -->
				
				<div class="error-actions">
					<a href="${pageContext.request.contextPath}/" class="btn btn-large btn-primary">
						<i class="icon-chevron-left"></i>
						&nbsp;
						Back to Website						
					</a>
					
					
					
				</div> <!-- /error-actions -->
							
			</div> <!-- /error-container -->			
			
		</div> <!-- /span12 -->
		
	</div> <!-- /row -->
	
</div> <!-- /container -->
</body>
</html>