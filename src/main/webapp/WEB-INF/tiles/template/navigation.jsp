<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="navbar navbar-fixed-top " style="z-index: 1000;"
	role="navigation">

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
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="navbarCollapse">
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
								Crear nuevo aviso</a></li>
					</ul></li>




			</ul>
		</div>
		<!--navbarCollapse -->
	</div>
	<!-- container -->
</div>

