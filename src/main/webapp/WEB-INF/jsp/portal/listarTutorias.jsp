<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<section class="container">
	<c:choose>
		<c:when test="${fn:length(tutorias) eq 0}">
			<div class="alert alert-danger alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>				
				<strong><spring:message code="generico.atencion" /></strong>
				<spring:message code="tutoria.listar.vacio" />
			</div>
		</c:when>
		<c:otherwise>
			<table id="tutorias" class="table table-hover">
				<thead>
					<tr>
						<th><spring:message code="tutoria.listar.emisor" /></th>
						<th><spring:message code="tutoria.listar.destinatario" /></th>
						<th><spring:message code="tutoria.listar.asignatura" /></th>
						<th><spring:message code="tutoria.listar.resumen" /></th>
						<th><spring:message code="tutoria.listar.confirmada" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tutorias}" var="item">
						<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
							<div class="caption">
								<tr>
									<td>${item.emisor.username}</td>
									<td>${item.destinatario.username}</td>
									<td>${item.asignatura}</td>
									<td>${item.resumenDudas}</td>
									<td>${item.confirmada}</td>
								</tr>
							</div>
						</div>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</section>