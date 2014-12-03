<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="elemento" tagdir="/WEB-INF/tags/elementos"%>


<t:genericPage>
	<jsp:attribute name="titulo"> 
		<spring:message code="gestorAvisos.titulo" /> 
	</jsp:attribute>


	<jsp:attribute name="cabecera">
		<elemento:jumbo>
			<jsp:attribute name="textoPrincipal">
	        	<spring:message code="gestorAvisos.textoPrincipal" />
	        </jsp:attribute>
	        <jsp:attribute name="textoSecundario">
	        	<a
					href="<spring:url value="/avisos/gestor/crear"></spring:url>">
	        		<spring:message code="gestorAvisos.crearAviso" />
	        	</a>
	        </jsp:attribute>        	
        </elemento:jumbo>
    </jsp:attribute>


	<jsp:body> 
       <section class="container">
			<elemento:gestorAvisos__generarElementos />
		<!-- </div> -->
		</section>
    </jsp:body>


</t:genericPage>