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
<section class="container">
	<table id="espacios" class="table table-hover">
		<thead>
			<tr>
				<th><spring:message code="crear.usuario.username"></spring:message></th>
				<th><spring:message code="crear.usuario.user.password"></spring:message></th>
				<th><spring:message code="crear.usuario.user.email"></spring:message></th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="item">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px" >
					<div class="caption">
						<tr>
							<td>${item.username}</td>
							<td>${item.password}</td>
							<td>${item.email}</td>
						</tr>
					</div>
				</div>
			</c:forEach>
		</tbody>
	</table>
</section>