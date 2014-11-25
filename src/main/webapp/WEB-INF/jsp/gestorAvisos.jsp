<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Gestión de avisos</title>

</head>


<div class="container">
	<div class="row">
		<div class="col-md-12">
			<ul class="list-group">
				<li class="list-group-item"><a
					href="<spring:url value="/avisos/gestor/crear"/>"
					class="btn btn-default"> <span
						class="glyphicon-hand-right glyphicon"></span> Crear aviso
				</a></li>
				<li class="list-group-item">
					<a href="<spring:url value= '/avisos/ver' />"> Listar avisos </a>
				</li>
				<li class="list-group-item">
					<a href="<spring:url value= "/avisos/gestor/editar" />">Editor de avisos</a>
				</li>
			</ul>
		</div>
	</div>
</div>
</html>