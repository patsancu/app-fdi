<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<spring:url value="/users/nuevo" var="urlNuevoUsuario" />

<div class="navbar navbar-default navbar-fixed-top "
	style="z-index: 1000;" role="navigation">

	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="container">
	
		<div class="navbar-header">
			<button class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="glyphicon glyphicon-align-justify white"></span>
			</button>

			<a class="navbar-brand " href="<spring:url value="/"/>"> <img
				alt="Universidad Complutense de Madrid"
				src="<spring:url value="/static/img/logoUcm.gif" />" width="30">
			</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Anuncios
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<spring:url value="/avisos"/>" role="button">
								<span class="glyphicon glyphicon-info-sign"></span> Visor
								anuncios
						</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Accesos directos</li>
						<li><a href="<spring:url value="/avisos/nuevo"></spring:url>">
								<span class="glyphicon glyphicon-plus"></span> Crear nuevo
								anuncio
						</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Reservas
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li class="dropdown-header">Reservas</li>
						<li><a href="<spring:url value="/reservas/calendario"/>"
							role="button"> <span class="glyphicon glyphicon-calendar"></span>
								Calendario
						</a>
						<li><a href="<spring:url value="/reservas"/>" role="button">
								<span class="glyphicon glyphicon-info-sign"></span> Visor
						</a>
						<li><a href="<spring:url value="/reservas/nuevo"/>"
							role="button"> <span class="glyphicon glyphicon-plus"></span>
								Crear reserva
						</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Espacios</li>
						<li><a href="<spring:url value="/espacios/"/>" role="button">
								<span class="glyphicon glyphicon-info-sign"></span> Ver espacios
						</a></li>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li><a href="<spring:url value="/espacios/nuevo"/>"
								role="button"> <span class="glyphicon glyphicon-plus"></span>
									Crear espacio
							</a></li>
						</sec:authorize>


					</ul></li>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Usuarios
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="<spring:url value="/users"/>" role="button">
									<span class="glyphicon glyphicon-info-sign"></span> Ver
							</a></li>


							<li><a href="${urlNuevoUsuario}" role="button"> <span
									class="glyphicon glyphicon-plus"></span> Crear usuario
							</a></li>

						</ul></li>
				</sec:authorize>
				
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">URLs
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<spring:url value="/urls/nueva"></spring:url>">
								<span class="glyphicon glyphicon-plus"></span> Acortar URL
						</a></li>
					</ul></li>

			</ul>
<!-- 			<ul class="nav navbar-nav navbar-right"> -->
				<ul class="nav nav-pills navbar-right">

				<sec:authorize access="hasRole('ROLE_USER')">
					<li>
					
						<a href="#" class="btn btn-info btn-lg" role="button" href="#">
						<span class="glyphicon glyphicon-user"></span>
							<sec:authentication property="principal.username" />
						</a>
					</li>
				</sec:authorize>
				
				

				<li role="presentation"><a href="#"><spring:message code="nav.signin" /></a></li>
				<li role="presentation"><a href="#"><spring:message code="nav.signup" /></a></li>
				<sec:authorize access="hasRole('ROLE_USER')">
					<li >
						<a class="btn btn-danger" href="#"> 
							<span id="logoutClick" class="glyphicon glyphicon-log-out"></span>
						</a>
					</li>
				</sec:authorize>				
			</ul>
		</div>
		<!--navbarCollapse -->
	</div>
	<!-- container -->
</div>

<form id="logoutForm" action="<spring:url value="/logout" />" method="POST">
	<sec:csrfInput />	
</form>
<span class="sr-only">(current)</span>


<script>
	$(document).ready(function() {
		$("#logoutClick").click(function() {
			$("#logoutForm").submit();
		});
	});
</script>