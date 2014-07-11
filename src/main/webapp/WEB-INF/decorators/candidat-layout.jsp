<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets">

<h:head>
	<link href="<c:url value="/static/resources/css/pages/plans.css"/>"
		rel="stylesheet" type="text/css" />
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

</h:head>
<body>

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">

				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">QCM Application </a>

				<div class="nav-collapse">
					<ul class="nav pull-right">

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="icon-user"></i> <%=session.getAttribute("email")%>
								<b class="caret"></b>
						</a>

							<ul class="dropdown-menu">
								<li onclick="window.location='${pageContext.request.contextPath}/user/profile'"><a href="#"> <i class="icon-cog"></i>Profil</a></li>
								<li
									onclick="window.location='${pageContext.request.contextPath}/disconnect'"><a
									href="#"> <i class="icon-power-off"></i> Deconnection
								</a></li>
							</ul></li>
						

					</ul>

					

				</div>
				<!--/.nav-collapse -->

			</div>
			<!-- /container -->

		</div>
		<!-- /navbar-inner -->

	</div>
	<!-- /navbar -->

	<div class="subnavbar">

		<div class="subnavbar-inner">

			<div class="container">

				<ul class="mainnav">

					<li><a href="${pageContext.request.contextPath}/user/">
							<i class="icon-home"></i> <span>Acceuil</span>
					</a></li>

					

					<li><a
						href="${pageContext.request.contextPath}/user/myResults">
							<i class="icon-bar-chart"></i> <span>Mes Resultats </span>
					</a></li>

				



				</ul>

			</div>
			<!-- /container -->

		</div>
		<!-- /subnavbar-inner -->

	</div>
	<!-- /subnavbar -->

	<script src="<c:url value="/static/resources/js/jquery-1.7.2.min.js"/>"></script>

	<script src="<c:url value="/static/resources/js/bootstrap.js"/>"></script>
	<script src="<c:url value="/static/resources/js/base.js"/>"></script>

	<script
		src="<c:url value="/static/resources/js/guidely/guidely.min.js"/>"></script>
	<script
		src="<c:url value="/static/resources/js/jquery.dataTables.min.js"/>"></script>






	<decorator:body />



</body>


</html>