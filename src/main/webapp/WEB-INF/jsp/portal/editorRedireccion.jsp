<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />

<section class="container center">
	<form:form modelAttribute="redireccionUrl" class="form-horizontal"
		method="POST">
		<div id="id_urlOriginal" class="form-group">
			<label class="control-label col-lg-2" for="url"><spring:message
					code="redireccion.url"></spring:message></label>
			<div class="col-lg-10">
				<form:input path="url" type="text" id="urlOriginal"
					class="form:input-large" />
			</div>
		</div>

		<!-- Botón crear redirección -->
		<div class="form-group add">
			<div class="col-lg-offset-2 col-lg-10">
				<input type="submit" id="btnAdd" class="btn btn-primary"
					value='<spring:message code="redireccion.crear"></spring:message>' />
			</div>
		</div>
	</form:form>
</section>

<!-- Formulario para AJAX -->
<%-- <form:form id="newURLform" action="${urlEnvio}"> --%>
<!-- 	<div id="id_urlOriginal" class="form-group"> -->
<!-- 		<label class="control-label col-lg-2" for="urlOriginal">urlOriginal</label> -->
<!-- 		<div class="col-lg-10"> -->
<!-- 			<input type="text" id="urlOriginal" class="form:input-large" /> -->
<!-- 		</div> -->
<!-- 	</div> -->

<!-- 	<button id="botonCrearRedireccion" type="submit">Crear</button> -->
<%-- </form:form> --%>



<div id="campoSufijo"></div>



<script>
// AJAX
// $(document).ready(  
// 		function() {  
// 			$('#newURLform').submit(  function(event) {
// 				var producer = $('#producer').val();
//   				var model = $('#model').val();   
//   				var price = $('#price').val();   
//   				var json = { 
//   						"producer" : producer, 
//   						"model" : model, "price": price};  
//   				var url = $('#urlOriginal').val();  
//   				var caducidad = $('#fechaCaducidad').val();  
//   				var json = {  "url" : url, "caducidad" : caducidad  };  
//   				var cookie = $('input[name="_csrf"]').val();  
//   				console.log(cookie); console.log(json);  
//   				var token = $("meta[name='_csrf']").attr("content");  
//   				var header = $("meta[name='_csrf_header']").attr("content");  
//   				$.ajax({  
//   					url :$("#newURLform").attr("action"),  
//   					data : JSON.stringify(json),  
//   					type: "POST",  
//   					contentType: 'application/json; charset=utf-8',  					
// 					beforeSend : function(  xhr) { 
// 						xhr.setRequestHeader('X-CSRF-TOKEN', cookie);  
// 						console.log(header); console.log(token);  
// 						xhr.setRequestHeader(header, token);
// 						xhr.setRequestHeader(  "Accept",  "application/json"); 
// 						xhr.setRequestHeader(  "Content-Type",  "application/json");  },
//  					success : function(urlNueva) {  
//  						var respContent = ""; 
// 						respContent += "<span class='success'>Smartphone was created: [";  
// 						respContent += urlNueva.sufijo + " : ";   
// 						respContent += smartphone.model + " : ";   
// 						respContent += smartphone.price;  
// 						respContent += "]</span>";  
// 						$(  "#campoSufijo")  .html(  respContent);  }  
// 					}); 
// 					event.preventDefault();  });  });
</script>