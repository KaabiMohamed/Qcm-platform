<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style media="screen" type="text/css">
#loading-indicator {
	position: absolute;
	left: 10px;
	top: 10px;
}
</style>

<title>Inviter</title>
</head>
<body>
	<script type="text/javascript">
	//Verifier l'email 
		function verifMail(champ) {
			var regex = /^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$/;
			if (champ.value == "") {
				surligne(champ, false);
				return true;
			} else {
				if (!regex.test(champ.value)) {
					alert("Cet E-mail n'est pas valide");
					surligne(champ, true);
					return false;
				} else {
					surligne(champ, false);
					return true;
				}
			}
		}

		//l'ajout des inputtext 
		$(document)
				.ready(
						function() {

							

							var MaxInputs = 1000; //maximum input boxes allowed
							var InputsWrapper = $("#InputsWrapper"); //Input boxes wrapper ID
							var AddButton = $("#AddMoreFileBox"); //Add button ID

							var x = InputsWrapper.length; //initlal text box count
							var FieldCount = 3; //to keep track of text box added

							$(AddButton)
									.click(
											function(e) //on add input button click
											{
												if (x <= MaxInputs) //max input box allowed
												{
													FieldCount++; //text box added increment
													//add input box
													$(InputsWrapper)
															.append(
																	'<div><input type="text" name="emails" id="field_'+ FieldCount +'" onblur="verifMail(this)" class="span4"/><a href="#" class="removeclass">&times;</a></div>');
													x++; //text box increment
												}
												return false;
											});

							$("body").on("click", ".removeclass", function(e) { //user click on remove text
								if (x > 1) {
									$(this).parent('div').remove(); //remove text box
									x--; //decrement textbox
								}
								return false;
							});

						});

		$(document).ajaxSend(function(event, request, settings) {
			$('#loading-indicator').show();
			$.isLoading({
				position : "overlay",
				text : "Loading"
			});
		});

		$(document).ajaxComplete(function(event, request, settings) {
			$('#loading-indicator').hide();
			$.isLoading("hide");
		});
	</script>


	<div class="main" align="center">
		<div id="loading-indicator" style="display: none">
			<img src="<c:url value="/static/resources/img/ajax-loader.gif"/>" />
			ENVOI EN COURS
		</div>
		<div class="main-inner">

			<div class="container">

				<div class="row">

					<div class="span12">

						<div class="widget ">

							<div class="widget-header">
								<i class="icon-plus-sign"></i>
								<h3>Envoyer Des invitations pour l'examen : ${exam.titre }</h3>
							</div>
							<!-- /widget-header -->

							<div class="widget-content">
								<div class="tabbable">

									<form id="form1" method="post" data-async
										data-target="event|close|#alert-settings"
										action="${pageContext.request.contextPath}/backoffice/sendInvites">

										<div id="InputsWrapper">

											<div>
												<input type="text" name="emails" onblur="verifMail(this)"
													placeholder="Enter an E-mail Adress" class="span4" /> <a
													href="#">&times;</a>
											</div>
											<div>
												<input type="text" name="emails" onblur="verifMail(this)"
													placeholder="Enter an E-mail Adress" class="span4" /> <a
													href="#">&times;</a>
											</div>
											<div>
												<input type="text" name="emails" onblur="verifMail(this)"
													placeholder="Enter an E-mail Adress" class="span4" /> <a
													href="#">&times;</a>
											</div>
											<div>
												<input type="text" name="emails" onblur="verifMail(this)"
													placeholder="Enter an E-mail Adress" class="span4" /> <a
													href="#">&times;</a>
											</div>
											<div>
												<input type="text" name="emails" onblur="verifMail(this)"
													placeholder="Enter an E-mail Adress" class="span4" /> <a
													href="#">&times;</a>
											</div>
											<div>
												<input type="text" name="emails" onblur="verifMail(this)"
													placeholder="Enter an E-mail Adress" class="span4" /> <a
													href="#">&times;</a>
											</div>

										</div>



										<div class="form-actions">
											<button id="AddMoreFileBox" class="btn btn-primary">
												<i class="icon-plus"></i> Ajouter d'autres E-mails
											</button>

											<button id="sendButton" type="submit" class="btn btn-success">Envoyer
												Les invitations</button>
											<button type="button" class="btn"
												onclick="window.location='${pageContext.request.contextPath}/backoffice/exams'">Suivant</button>
										</div>

									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//submit form
		jQuery(function($) {
			$(document)
					.on(
							'submit',
							'form[data-async]',
							function(event) {
								var $form = $(this);
								var $target = $($form.attr('data-target'));
								var submitButton = $(
										"input[type='submit'][clicked=true], button[type='submit'][clicked=true]",
										$form);

								var formData = $form.serializeArray();
								if (submitButton.size() === 1) {
									formData.push({
										name : $(submitButton[0]).attr("name"),
										value : "1"
									});
								} else if (submitButton.size() !== 0) {
									console
											.log("Multiple submit-buttons pressed. This should not happen!");
								}

								$.ajax({
									type : $form.attr('method'),
									url : $form.attr('action'),
									data : formData,

									success : function(data, status) {
										$target.html(data);
									}
								});

								event.preventDefault();
							});

			$(document)
					.on(
							"click",
							'input[type="submit"], button[type="submit"]',
							function() {
								$(
										'form[data-async] input[type=submit], form[data-async] button[type=submit]',
										$(this).parents("form")).removeAttr(
										"clicked");
								$(this).attr("clicked", "true");
							});
		});
	</script>

	<script src="http://code.jquery.com/jquery-latest.min.js"
		type="text/javascript"></script>
	<script src="<c:url value="/static/resources/js/jquery.isloading.js"/>"
		type="text/javascript"></script>

</body>
</html>