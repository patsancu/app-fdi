<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
					data-toggle="dropdown" role="button" aria-expanded="false">Espacios
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li class="dropdown-header">Espacios</li>
						<li><a href="<spring:url value="/espacios/"/>" role="button">
								<span class="glyphicon glyphicon-info-sign"></span> Visor
								espacios
						</a></li>
						<li><a href="<spring:url value="/espacios/nuevo"/>" role="button">
								<span class="glyphicon glyphicon-plus"></span> Crear
								espacio
						</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Reservas</li>
						<li><a href="<spring:url value="/reservas"/>" role="button">
								<span class="glyphicon glyphicon-info-sign"></span> Visor
								reservas
						<li><a href="<spring:url value="/reservas/nuevo"/>" role="button">
								<span class="glyphicon glyphicon-plus"></span> Crear reserva
						</a></li>
					</ul></li>
				<li><a href="#">Sección2</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><spring:message code="nav.signin" /></a></li>
				<li><a href="#"><spring:message code="nav.signup" /></a></li>
				<li class="active">
					<form action="<spring:url value="/logout" />" method="POST">
						<sec:csrfInput />
						<input type="submit" value="<spring:message code="nav.logout"/>" />
					</form> <span class="sr-only">(current)</span>
				</li>
			</ul>
		</div>
		<!--navbarCollapse -->
	</div>
	<!-- container -->
</div>