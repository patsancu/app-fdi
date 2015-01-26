<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="incluir" tagdir="/WEB-INF/tags/portal/elementos/incluir"%>
<%@ taglib prefix="elemento" tagdir="/WEB-INF/tags/portal/elementos"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/anuncios"%>

<t:genericPage>

	<jsp:attribute name="titulo">		
		<spring:message code="principal.titulo" /> 
	</jsp:attribute>


	<jsp:attribute name="cabecera">		
		<elemento:jumbo>
        	<jsp:attribute name="textoSecundario">
        		<spring:message code="principal.subtexto" />
        	</jsp:attribute>
        	<jsp:attribute name="textoPrincipal">
        		<spring:message code="principal.saludoInicial" />
        	</jsp:attribute>
        </elemento:jumbo>
		
		
    </jsp:attribute>


	<jsp:body>
        <ul>
			<li class="list-group-item"><a
				href="<spring:url value= "/avisos/gestor" />">Gestor de avisos</a></li>
			<li class="list-group-item"><a
				href="<spring:url value= "/avisos/ver" />">Visor de avisos</a></li>
=======
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>AplicaciÃ³n de noticias de la FdI-UCM</title>
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
			
>>>>>>> new_branch_name
		</ul>
    </jsp:body>


</t:genericPage>
