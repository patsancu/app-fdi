<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js">
	
</script>
<script src="/webstore/resource/js/controllers.js"></script>

</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Avisos</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
			</div>
			<div class="col-md-5">
				<h3>${aviso.titulo}</h3>
				<p>${aviso.contenidoAviso}</p>
				<p>
					<strong>Etiqueta : </strong><span class="label label-warning">${aviso.etiqueta}</span>
				</p>
				<p>
					<strong>Tipo aviso</strong> : ${aviso.tipoAviso}
				</p>
			</div>
		</div>
	</section>
</body>
</html>