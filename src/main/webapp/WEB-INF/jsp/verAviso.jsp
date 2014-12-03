<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="incluir" tagdir="/WEB-INF/tags/elementos/incluir"%>
<%@ taglib prefix="elemento" tagdir="/WEB-INF/tags/elementos"%>


<t:genericPage titulo="Ver aviso '${aviso.titulo}'">


	<jsp:attribute name="cabecera">
		<elemento:jumbo >
			<jsp:attribute name="textoPrincipal">${aviso.titulo}</jsp:attribute>
			<jsp:attribute name="textoSecundario"></jsp:attribute>
		</elemento:jumbo>
	</jsp:attribute>
	
	
	
	<jsp:body>
		<section class="container col-md-offset-2 col-md-6 center">
			<div class="panel panel-info">
				
				<div class="panel-heading">
	
					<div class="panel-title">
						${aviso.titulo} <a class="pull-right"
								href="<c:url value="/avisos/gestor/editar?id=${aviso.postInternalId}"></c:url>">
							<span hint="Editar aviso" class="glyphicon glyphicon-edit "></span>
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
					<p>
						<strong>Fecha creación:</strong> ${fn:substring(aviso.fechaCreacion,0,19	)}
					</p>
					<p>
						<strong>Fecha publicación:</strong> ${fn:substring(aviso.fechaPublicacion,0,19	)}
					</p>
				</div>	
	
			</div>
			</section>
	</jsp:body>
</t:genericPage>

