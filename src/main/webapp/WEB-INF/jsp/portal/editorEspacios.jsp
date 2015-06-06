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

<title><c:out value="${modo}"></c:out> tutoría</title>
<section class="container center">
	<form:form modelAttribute="tutoria" class="form-horizontal"
		method="${method}">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />
		<fieldset>
			<legend>
				<c:out value="${modo}"></c:out>
				espacio
			</legend>


			<!-- Resumen -->
			<div id="nombre" class="form-group">
				<label class="control-label col-lg-2" for="resumenDudas">Resumen</label>
				<div class="col-lg-10">
					<form:input path="resumenDudas" type="text" class="form:input-large" />
				</div>
			</div>

			<!-- asignatura -->
			<div id="asignatura" class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="asignatura">Asignatura</label>
				<div class="col-lg-10">
					<form:input path="asignatura" type="text" class="form:input-large" />
				</div>
			</div>


			<!-- Botón crear aviso -->
			<div class="form-group add">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="<c:out value="${modo}"></c:out>	tutoria" />
				</div>
			</div>
		</fieldset>
	</form:form>
</section>
<script>
	tinymce.init({
		selector : '.notas'
	});
</script>

<style>
#tabbedContent {
	margin-top: 20px;
}
</style>