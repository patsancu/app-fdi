<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Avisos</title>

</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Avisos</h1>
				<h3><a href="<spring:url value="/avisos/gestor/crear"></spring:url>" >Crear nuevo aviso</a></h3>
			</div>
		</div>
	</section>

	<section class="container">
		<!-- <div class="row"> -->
		<c:forEach items="${avisos}" var="aviso">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<!-- <div class="row "> -->
				<%-- <img
							src="<c:url value="/resource/images/${aviso.avisoId}.png"></c:url>"
							alt="image" style="width: 100%" /> --%>
				<div class="caption panel panel-info">
					<div class="panel-heading">
						<div class="panel-title">
						<!-- Ver aviso -->
						<a href="<c:url value="/avisos/ver/individual?id=${aviso.postInternalId}"></c:url>">${aviso.titulo}</a>
						<!-- Editar aviso -->
						<a class="pull-right" href="<c:url value="/avisos/gestor/editar?id=${aviso.postInternalId}"></c:url>">
							<span hint="Editar aviso" class="glyphicon glyphicon-edit "></span>								
						</a>
						<!-- Eliminar aviso -->
						<a class="pull-right" href="<c:url value="/avisos/gestor/eliminar?id=${aviso.postInternalId}"></c:url>">
							<span class="glyphicon glyphicon-remove-sign"></span>
						</a>
						</div>
						
					</div>
					<h3></h3>
					<div class="panel-body">
						<p>${aviso.fechaPublicacion}</p>
						<p>${aviso.tipoAviso}</p>
					</div>
					<div class="panel-footer">
						<p>
							<span class="label label-warning">${aviso.etiqueta}</span>
						</p>
					</div>
				</div>
				<!-- </div> -->
			</div>
		</c:forEach>
		<!-- </div> -->
	</section>
</body>
</html>