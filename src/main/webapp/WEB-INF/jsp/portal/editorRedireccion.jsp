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

<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />


<spring:url value='${urlEnvio}' var="urlEfectiva"/>
<spring:url value='${urlReenvios}' var="urlReenviosEfectiva"/>

<!-- Formulario para AJAX -->
<form:form id="newURLform" action="${urlEfectiva }" >

	<label class="control-label col-lg-2" for="urlOriginal">urlOriginal</label>
	<div class="col-lg-10">
		<input type="text" id="urlOriginal" class="form:input-large" />
	</div>
	<label class="control-label col-lg-2" for="urlOriginal">URL
		generada </label>
	<div class="col-lg-10">
		<label id="campoSufijo"></label>
	</div>

	<div class="form-group add">
		<div class="col-lg-offset-2 col-lg-10">
			<input type="submit" id="botonCrearRedireccion" class="btn btn-primary"
				value="Crear" />
		</div>
	</div>

</form:form>


<script>

$(document).ready(  
	function() {  
		$('#newURLform').submit(  function(event) {
			var urlRedireccion = $('#urlOriginal').val();  
			var object = {  "url" : urlRedireccion};  
			var jsonfile ={json:JSON.stringify(object)};
			var header = $("meta[name='_csrf_header']").attr("content"); 
			var token = $("meta[name='_csrf']").attr("content"); console.log("Token " + token); 
			//alert(JSON.stringify(object) );
			$.ajax({  					
				contentType: "application/json",
 					url: $("#newURLform").attr( "action"),
 					data: JSON.stringify(object),
 					method: "POST",
 					dataType: "json",
				beforeSend : function( xhr ) { 
					xhr.setRequestHeader('Content-Type', 'application/json');
					xhr.setRequestHeader(header, token);
				},
				mimeType: 'application/json',
			    success: function(data) {
			    	var urlRedireccion = "${urlReenviosEfectiva}" + '/' + data.sufijo;
			        $("#campoSufijo").html(
			        		"<a " + "href='" + urlRedireccion + "'>" +
			        		location.host + urlRedireccion + 
			        		" </a>"
			        );
			    },
			    error:function(data,status,er) {
			        alert("error: "+data+" status: "+status+" er:"+er);
			    }
			})
 				
			event.preventDefault();  
			});  
		});			
</script>