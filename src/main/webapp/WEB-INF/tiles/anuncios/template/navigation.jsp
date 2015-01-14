<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


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
				src="https://www.ucm.es/data/cont/docs/340-2013-07-02-ucm.gif"
				width="30">
			</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Anuncios
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<spring:url value="/ver"/>" role="button">
								<span class="glyphicon glyphicon-info-sign"></span> Visor anuncios
						</a></li>
						<li><a href="<spring:url value="/gestor"/>"> <span
								class="glyphicon glyphicon-user"></span> Gestor anuncios
						</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Accesos directos</li>
						<li><a
							href="<spring:url value="/gestor/crear"></spring:url>">
								<span class="glyphicon glyphicon-plus"></span> Crear nuevo anuncio
						</a></li>
					</ul></li>
				<li><a href="#">SecciÃ³n1</a></li>
				<li><a href="#">SecciÃ³n2</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Login</a></li>
				<li><a href="#">Registrarse</a></li>
				<li class="active"><a href="#">Logout <span class="sr-only">(current)</span></a></li>
			</ul>
		</div>
		<!--navbarCollapse -->
	</div>
	<!-- container -->
</div>

