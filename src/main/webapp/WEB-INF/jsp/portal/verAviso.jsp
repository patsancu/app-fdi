<%--

    This file is part of Portal Web de la FDI.

    Portal Web de la FDI is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Portal Web de la FDI is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with Portal Web de la FDI.  If not, see <http://www.gnu.org/licenses/>.

--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<div class="jumbotron">
	<div class="container">
		<h1>"${a.titulo}"</h1>
	</div>
</div>
<section class="container col-md-offset-2 col-md-6 center">
	<div class="panel panel-info">
		<%-- <h3>${a.titulo}</h3> --%>
		<div class="panel-heading">
			<div class="panel-title">
				${a.titulo} <a class="pull-right"
					href="<spring:url value="/avisos/{id}"><spring:param name="id" value="${a.id}" /></spring:url>">
					<span hint="Editar aviso" class="glyphicon glyphicon-edit "></span>
				</a>

			</div>
		</div>
		<div class="panel-body clearfix" style="padding-top: 7.5px;">
			<p>${a.contenidoAviso}</p>
			<p>
				<strong> <spring:message code="ver.aviso.creado"/> </strong>
				${a.autor.userGivenName} ${a.autor.userSurname}</p>
			<p>
				<strong> <spring:message code="ver.aviso.etiqueta"/> </strong> 
				<span class=" label label-warning">${a.etiqueta}</span>
			</p>
			<p>
				<strong> <spring:message code="ver.aviso.tipo"/> </strong>
				${a.tipoAviso.description}
			</p>
			<p>
				<strong> <spring:message code="ver.aviso.fecha.creacion"/> </strong>
				<joda:format value="${a.fechaCreacion}" pattern="yyyy/MM/dd HH:mm" />
				
			</p>
			<p>
				<strong> <spring:message code="ver.aviso.fecha.publicacion.inicio"/></strong>
				<joda:format value="${a.comienzoPublicacion}" pattern="yyyy/MM/dd HH:mm" />
			</p>
			<p>
				<strong><spring:message code="ver.aviso.fecha.publicacion.hasta"/></strong>
				<joda:format value="${a.fechaCreacion}" pattern="yyyy/MM/dd HH:mm" />
			</p>
		</div>
	</div>
</section>