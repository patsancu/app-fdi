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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<title><c:out value="${modo}"></c:out> <spring:message code="crear.usuario.user"/> </title>
<section class="container center">
	<form:form modelAttribute="user" class="form-horizontal"
		method="${method}">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />
		<fieldset>
			<legend>
				<c:out value="${modo}"></c:out>
				<spring:message code="crear.usuario.user"/>
			</legend>

			<div class="alert alert-danger alert-dismissible" hidden="true" id="errores" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong><spring:message code="generico.atencion" /></strong>
				Las contraseñas no coinciden
			</div>

			<!-- Nombre de usuario -->
			<div id="username" class="form-group">
				<label class="control-label col-lg-2" for="username"><spring:message code="crear.usuario.username"/></label>
				<div class="col-lg-10">
					<form:input path="username" type="text" class="form:input-large" />
				</div>
			</div>

			<!-- Email -->
			<div id="email" class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="email"><spring:message code="crear.usuario.user.email"/></label>
				<div class="col-lg-10">
					<form:input path="email" type="text" class="form:input-large" />
				</div>
			</div>
			
			<!-- Nombre -->
			<div id="nombre" class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="nombre"><spring:message code="crear.usuario.user.name"/></label>
				<div class="col-lg-10">
					<form:input path="userGivenName" type="text" class="form:input-large" />
				</div>
			</div>
			
			<!-- Apellidos -->
			<div id="apellidos" class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="apellidos"><spring:message code="crear.usuario.user.surname"/></label>
				<div class="col-lg-10">
					<form:input path="userSurname" type="text" class="form:input-large" />
				</div>
			</div>

			<!-- Password -->
			<div id="password" class="form-group">
				<label class="control-label col-lg-2" for="password"><spring:message code="crear.usuario.user.password"/></label>
				<div class="col-lg-10">
					<form:input id="passwordInput" path="password" type="password" class="form:input-large" />
				</div>
			</div>
			
			<!-- Repite Password -->
			<div id="passwordRepeat" class="form-group">
				<label class="control-label col-lg-2" for="password"><spring:message code="crear.usuario.user.repeat.password"/></label>
				<div class="col-lg-10">
					<input id="passwordRepeatInput" type="password" class="form:input-large" />
				</div>
			</div>

			


			<!-- Botón crear usuario -->
			<div class="form-group add">
				<div class="col-lg-offset-2 col-lg-10">
					<input id="botonCrearUsuario" type="submit" id="btnAdd" class="btn btn-primary"
						value="<c:out value="${modo}"></c:out>	<spring:message code="crear.usuario.user"/>" />
				</div>
			</div>
		</fieldset>
	</form:form>
</section>

<script>
$('#botonCrearUsuario').click(  function(event) {	
	if ( $('#passwordInput').val() != $('#passwordRepeatInput').val() ){
		event.preventDefault();
		$('#errores').show();//attr('hidden', 'false');
	}
});
</script>