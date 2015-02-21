<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<section class="container">
    <c:out value="${logueado}"></c:out> 
	<table id="reservas" class="table table-hover">
		<thead>
			<tr>
				<th>Titular</th>
				<th>Desde</th>
				<th>Hasta</th>
				<th>Espacio</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${reservas}" var="item">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="caption">
						<tr>
							<td>${item.titular}</td>
							<td>${item.fechaInicio}</td>
							<td>${item.fechaFin}</td>
							<td>${item.espacio.nombre}</td>
						</tr>
					</div>
				</div>
			</c:forEach>
		</tbody>
	</table>
</section>