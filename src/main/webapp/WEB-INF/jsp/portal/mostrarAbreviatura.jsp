<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="${urlCorta}" var="urlAcortada" />

<div class="col-md-8 col-md-offset-4">

	<table class="table">
		<tr>
			<td><spring:message code="redireccion.mostrar.url.original" /></td>
			<td><b>${urlOriginal}</b></td>
		</tr>
		<tr>
			<td> <spring:message code="redireccion.mostrar.url.acortada" /> </td>
			<td><b><a href="${urlAcortada}">${urlAcortada}</a></b></td>
		</tr>
	</table>


</div>
