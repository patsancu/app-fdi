<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Aplicación de noticias de la FdI-UCM</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<img alt="Universidad Complutense de Madrid"
					src="https://www.ucm.es/data/cont/docs/340-2013-07-02-ucm.gif"
					width="100">
				<h1>${greeting}</h1>

				<p>${tagline}</p>

			</div>
		</div>
		<ul>
			<li><a href="<spring:url value= "/avisos/gestor" />">Gestor de avisos</a></li>
			<li><a href="<spring:url value= "/avisos/ver" />">Visor de avisos</a></li>
			
		</ul>
	</section>
</body>
</html>