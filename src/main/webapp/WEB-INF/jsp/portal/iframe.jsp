<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

<title>Listar avisos</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Prueba con iframe</h1>
			</div>
		</div>
	</section>

	<section class="container">
		<%-- <iframe class="col-md-8" src="<c:url value="/avisos/ver/basico	"></c:url>"> --%>
		<iframe class="col-md-8" src="<c:url value="/avisos/ver/basico	"></c:url>">
		</iframe>
	</section>


</body>
</html>