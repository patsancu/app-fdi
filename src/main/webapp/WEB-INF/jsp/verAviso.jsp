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
				<h1>Aviso</h1>
			</div>
		</div>
	</section>
	<section class="container col-md-offset-2 col-md-6 center">
		<div class="panel panel-info">
			<%-- <h3>${aviso.titulo}</h3> --%>
			<div class="panel-heading">

				<div class="panel-title">
					${aviso.titulo} 
					<a class="pull-right"
						href="<c:url value="/avisos/gestor/editar?id=${aviso.postInternalId}"></c:url>">
						<span hint="Editar aviso"
						class="glyphicon glyphicon-edit "></span>
					</a>

				</div>

			</div>
			<div class="panel-body clearfix" style="padding-top: 7.5px;">
				<p>${aviso.contenidoAviso}</p>
				<p>
					<strong>Etiqueta : </strong> <span class=" label label-warning">${aviso.etiqueta}</span>
				</p>
				<p>
					<strong>Tipo aviso</strong> : ${aviso.tipoAviso}
				</p>
			</div>

		</div>
		</div>
	</section>
</body>
</html>