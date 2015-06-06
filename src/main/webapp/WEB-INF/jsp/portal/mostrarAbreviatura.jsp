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
