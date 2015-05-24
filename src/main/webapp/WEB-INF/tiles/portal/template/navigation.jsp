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
			
				<!-- #################### -->
				<!-- Anuncios -->
				<!-- #################### -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						<spring:message code="nav.bar.anuncios.title" /> 
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li>
							<a href="<spring:url value="/avisos"/>" role="button">
								<span class="glyphicon glyphicon-info-sign"></span> 
								<spring:message code="nav.bar.anuncios.show" />
							</a>
						</li>
						<li class="divider"></li>
						<li class="dropdown-header">
							<spring:message code="nav.bar.shortcuts" />
						</li>
						<li>
							<a href="<spring:url value="/avisos/nuevo"></spring:url>">
								<span class="glyphicon glyphicon-plus"></span> 
								<spring:message code="nav.bar.anuncios.create" />
							</a>
						</li>
					</ul>
				</li>
				
				<!-- #################### -->
				<!-- Reservas -->
				<!-- #################### -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						<spring:message code="nav.bar.reservas.title" />
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li class="dropdown-header"><spring:message code="nav.bar.reservas.title" /></li>
						<li>
							<a href="<spring:url value="/reservas/calendario"/>" role="button"> 
								<span class="glyphicon glyphicon-calendar"></span>
								<spring:message code="nav.bar.reservas.calendar" />
							</a>
						</li>
						<li>
							<a href="<spring:url value="/reservas"/>" role="button">
								<span class="glyphicon glyphicon-info-sign"></span> 
								<spring:message code="nav.bar.reservas.show" />
							</a>
						</li>
						<li>
							<a href="<spring:url value="/reservas/nuevo"/>" role="button"> <span class="glyphicon glyphicon-plus"></span>
								<spring:message code="nav.bar.reservas.create" />
							</a>
						</li>
						<li class="divider"></li>
						<li class="dropdown-header">
							<spring:message code="nav.bar.espacios.title" />
						</li>
						<li>
							<a href="<spring:url value="/espacios/"/>" role="button">
								<span class="glyphicon glyphicon-info-sign"></span> 
								<spring:message code="nav.bar.espacios.show" />
							</a>
						</li>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li>	
								<a href="<spring:url value="/espacios/nuevo"/>" role="button"> 
									<span class="glyphicon glyphicon-plus"></span>
									<spring:message code="nav.bar.espacios.create" />
								</a>
							</li>
						</sec:authorize>


					</ul></li>
				
				<!-- #################### -->
				<!-- Usuarios -->
				<!-- #################### -->
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						<spring:message code="nav.bar.users.title" />
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="<spring:url value="/users"/>" role="button">
									<span class="glyphicon glyphicon-info-sign"></span> 
									<spring:message code="nav.bar.users.show" />
							</a></li>


							<li><a href="${urlNuevoUsuario}" role="button"> <span
									class="glyphicon glyphicon-plus"></span> 
									<spring:message code="nav.bar.users.create" />
							</a></li>

						</ul></li>
				</sec:authorize>
				
				<!-- #################### -->
				<!-- URLs -->
				<!-- #################### -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						<spring:message code="nav.bar.urls.title" />
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li>
							<a href="<spring:url value="/urls/nueva"></spring:url>">
								<span class="glyphicon glyphicon-plus"></span> 
								<spring:message code="nav.bar.urls.create" />
							</a>
						</li>
					</ul>
				</li>
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						<spring:message code="nav.bar.tutorias.title" /> 
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li>
							<a href="<spring:url value="/tutorias"/>" role="button">
								<span class="glyphicon glyphicon-info-sign"></span> 
								<spring:message code="nav.bar.tutorias.show" />
							</a>
						</li>						
						<li>
							<a href="<spring:url value="/tutorias/nueva"></spring:url>">
								<span class="glyphicon glyphicon-plus"></span> 
								<spring:message code="nav.bar.tutorias.create" />
							</a>
						</li>
					</ul>
				</li>

			</ul>
				<ul class="nav nav-pills navbar-right">

				<sec:authorize access="hasRole('ROLE_USER')">
					<li>
					
						<a href="#" class="btn btn-info btn-lg" role="button" href="#">
						<span class="glyphicon glyphicon-user"></span>
							<sec:authentication property="principal.userGivenName" />
							<sec:authentication property="principal.userSurname" />
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