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
				<p>Avisos disponibles</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${avisos}" var="aviso">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<%-- <img
							src="<c:url value="/resource/images/${aviso.avisoId}.png"></c:url>"
							alt="image" style="width: 100%" /> --%>
						<div class="caption">
							<h3>${aviso.titulo}</h3>
							<p>${aviso.fechaPublicacion}</p>
							<p>$${aviso.tipoAviso}</p>
							<%-- <p>Available ${aviso.unitsInStock} units in stock</p>
							<p>
								<a
									href=" <spring:url value=  "/avisos/aviso?id=${aviso.avisoId}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Details
								</a>
							</p> --%>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>