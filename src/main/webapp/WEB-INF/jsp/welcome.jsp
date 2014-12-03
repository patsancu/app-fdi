<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="incluir" tagdir="/WEB-INF/tags/elementos/incluir"%>
<%@ taglib prefix="elemento" tagdir="/WEB-INF/tags/elementos"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>



<t:genericPage>

	<jsp:attribute name="titulo">		
		<spring:message code="principal.titulo" /> 
	</jsp:attribute>


	<jsp:attribute name="cabecera">		
		<elemento:jumbo>
        	<jsp:attribute name="textoSecundario">
        		<spring:message code="principal.subtexto" />
        	</jsp:attribute>
        	<jsp:attribute name="textoPrincipal">
        		<spring:message code="principal.saludoInicial" />
        	</jsp:attribute>
        </elemento:jumbo>
		
		
    </jsp:attribute>


	<jsp:body>
        <ul>
			<li class="list-group-item"><a
				href="<spring:url value= "/avisos/gestor" />">Gestor de avisos</a></li>
			<li class="list-group-item"><a
				href="<spring:url value= "/avisos/ver" />">Visor de avisos</a></li>
		</ul>
    </jsp:body>


</t:genericPage>