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
			
			<!-- Profesor -->
			<div id="destinatario_id" class="form-group">
				<label class="control-label col-lg-2" for="id_espacio">Profesor</label>
				<div class="col-lg-10">
					<form:select path="destinatario_id">
						<c:forEach items="${users}" var="item">
							<form:option value="${item.id}" label="${item.username}"></form:option>
						</c:forEach>
					</form:select>
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
