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
					data-toggle="dropdown" role="button" aria-expanded="false">Avisos
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<spring:url value="/avisos/ver"/>" role="button">
								<span class="glyphicon glyphicon-info-sign"></span> Visor avisos
						</a></li>
						<li><a href="<spring:url value="/avisos/gestor"/>"> <span
								class="glyphicon glyphicon-user"></span> Gestor avisos
						</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Accesos directos</li>
						<li><a
							href="<spring:url value="/avisos/gestor/crear"></spring:url>">
								<span class="glyphicon glyphicon-plus"></span> Crear nuevo aviso
						</a></li>
					</ul></li>
				<li><a href="#">Sección1</a></li>
				<li><a href="#">Sección2</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Login</a></li>
				<li><a href="#">Registrarse</a></li>
				<li class="active"><a href="#">Logout <span class="sr-only">(current)</span></a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->




		<!-- Collect the nav links, forms, and other content for toggling -->
		<%-- <div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> Avisos <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<!-- <li> <a href="./about_me.html"> <span class="glyphicon glyphicon-user"></span>  Me</a> </li> -->
						<li><a href="<spring:url value="/avisos/gestor"/>"> <span
								class="glyphicon glyphicon-user"></span> Gestor avisos
						</a></li>
						<li><a href="<spring:url value="/avisos/ver"/>" role="button">
								<span class="glyphicon glyphicon-info-sign"></span> Visor avisos
						</a></li>
						<li><a
							href="<spring:url value="/avisos/gestor/crear"></spring:url>">
								<span class="glyphicon glyphicon-plus"></span> Crear nuevo aviso
						</a></li>
					</ul></li>




			</ul>
		</div> --%>
		<!--navbarCollapse -->
	</div>
	<!-- container -->
</div>

