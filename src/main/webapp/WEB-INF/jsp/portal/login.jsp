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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3"
	id="loginForm">
	<c:url value="/login" var="loginUrl" />

	<form:form action="${loginUrl}" method="POST" class="panel panel-default panel-set">

		<div class="panel-heading">
			<spring:message code="login.signin" />
		</div>
		
		<div class="panel-body">
			<!-- 				<fieldset> -->
			<label for="username" class="sr-only"> 
				<spring:message code="login.username" />
			</label> 
			<input type="text" id="username" name="username" value="${username}" class="form-control"
				placeholder="<spring:message code="login.username"/>" /> 
			<label for="password" class="sr-only">
				<spring:message code="login.password" /> 
			</label> 
			<input type="password" id="password" type="password" name="password" class="form-control"
				placeholder="<spring:message code="login.password"/>" />
				
			<input type="checkbox" name="_spring_security_remember_me" />
			<label >			 
				<spring:message code="login.remember.me" />
			</label>
				
			<c:set var="errorCredenciales" value="${param.auth}" />
			<c:set var="logoutHecho" value="${param.logout}" />
			
			<c:if test="${errorCredenciales != null || logoutHecho != null}">
			<hr />
				<div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> <span class="sr-only">Error:</span>
					
					<c:if test="${errorCredenciales != null}">
						<spring:message code="login.invalid" />
					</c:if>

					<c:if test="${logoutHecho != null}">
						<spring:message code="login.logout" />
					</c:if>
				</div>			
			</c:if>

			<div class="panel-footer">
				<button class="btn btn-lg btn-success btn-block" type="submit">
					<spring:message code="login.signin.button" />
				</button>
			</div>
		</div>
		<!-- panel-body -->


	</form:form>

</div>
