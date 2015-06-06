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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>

<c:set var="req" value="${pageContext.request}" />

<section class="container">
	<table id="espacios" class="table table-hover">
		<thead>
			<tr>
				<th><spring:message code="redireccion.listar.url.original"/></th>
				<th><spring:message code="redireccion.listar.url.acortada"/></th>
				<th><spring:message code="redireccion.listar.interna"/></th>
				<th><spring:message code="redireccion.listar.autor"/></th>
				<th><spring:message code="redireccion.listar.numero.visitas"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${urlsAcortadas}" var="item">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="caption">
						<tr>
							<c:set var="redireccionURL" value="${req.serverName}:${req.localPort}${req.contextPath}${urlReenviosEfectiva}/${item.sufijo}"> </c:set>
							
							<td>${item.urlOriginal}</td>							
							<td><a href="<c:out value="${redireccionURL}"></c:out>"><c:out value="${redireccionURL}"></c:out></a></td>													
							<td>${item.interna}</td>
							<td>${item.creador.username} </td>
							<td>${item.numeroVisitas}</td> 
						</tr>
					</div>
				</div>
			</c:forEach>
		</tbody>
	</table>
</section>


<script type="text/javascript">
	$(document).ready(function() { /* Se deshabilita el orden por estos campos */		
		$('#espacios').DataTable({
			//Cambio de texto de menus
			"language" : {
				"lengthMenu" : <spring:message code="listado.datatables.lengthmenu"></spring:message>,
				"zeroRecords" : <spring:message code="listado.datatables.zerorecords"></spring:message>,
				"info" : <spring:message code="listado.datatables.info"></spring:message>,
				"infoEmpty" : <spring:message code="listado.datatables.infoempty"></spring:message>,
				"infoFiltered" : <spring:message code="listado.datatables.infofiltered"></spring:message>,
				"search" : <spring:message code="listado.datatables.search"></spring:message>,
				"paginate" : { 
					"first" : <spring:message code="listado.datatables.first"></spring:message>,
					"last" : <spring:message code="listado.datatables.last"></spring:message>,
					"next" : <spring:message code="listado.datatables.next"></spring:message>,
					"previous" : <spring:message code="listado.datatables.previous"></spring:message>
				},
			}
		});
	});
</script>