<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="elemento" tagdir="/WEB-INF/tags/elementos"%>

<t:genericPage titulo="Listado de avisos">

	<jsp:attribute name="cabecera">		
		<elemento:jumbo>
			<jsp:attribute name="textoPrincipal">
        		<spring:message code="listarAvisos.textoPrincipal" />
        	</jsp:attribute>
        	<jsp:attribute name="textoSecundario">
        		<spring:message code="listarAvisos.textoSecundario" />
        	</jsp:attribute>        	
        </elemento:jumbo>
    </jsp:attribute>

	<jsp:body>	
		<section class="container">
			<table class="table table-hover">
				<tr>
					<th>Título</th>
					<th>Contenido del aviso</th>
					<th>Tipo de aviso</th>
					<th>Etiqueta</th>
				</tr>
				<elemento:listarAvisos__listadoAvisos/>
			</table>
			<a href="<spring:url value="/" />" class="btn btn-default"> 
				<span class="glyphicon-hand-left glyphicon"></span> Volver	
			</a>
		</section>
		
	</jsp:body>


</t:genericPage>