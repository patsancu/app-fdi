<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<div class="jumbotron">
	<div class="container">
		<h1>"${aviso.titulo}"</h1>
	</div>
</div>
<section class="container col-md-offset-2 col-md-6 center">
	<div class="panel panel-info">
		<%-- <h3>${aviso.titulo}</h3> --%>
		<div class="panel-heading">
			<div class="panel-title">
				${aviso.titulo} <a class="pull-right"
					href="<spring:url value="/avisos/{id}"><spring:param name="id" value="${aviso.id}" /></spring:url>">
					<span hint="Editar aviso" class="glyphicon glyphicon-edit "></span>
				</a>

			</div>
		</div>
		<div class="panel-body clearfix" style="padding-top: 7.5px;">
			<p>${aviso.contenidoAviso}</p>
			<p><strong>Creado por: </strong>${aviso.autor}</p>
			<p>
				<strong>Etiqueta : </strong> <span class=" label label-warning">${aviso.etiqueta}</span>
			</p>
			<p>
				<strong>Tipo aviso</strong> : ${aviso.tipoAviso.description}
			</p>
			<p>
				<strong>Fecha creación:</strong>
				<joda:format value="${item.fechaCreacion}" pattern="yyyy/MM/dd HH:mm" />
			</p>
			<p>
				<strong>Comienzo Publicación (desde, inclusive):</strong>
				<joda:format value="${item.comienzoPublicacion}" pattern="yyyy/MM/dd HH:mm" />
			</p>
			<p>
				<strong>Fin Publicación (hasta, inclusive):</strong>
				<joda:format value="${item.fechaCreacion}" pattern="yyyy/MM/dd HH:mm" />
			</p>
		</div>
	</div>
</section>