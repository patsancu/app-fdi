<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="incluir" tagdir="/WEB-INF/tags/elementos/incluir"%>
<%@ taglib prefix="elemento" tagdir="/WEB-INF/tags/elementos"%>

<t:genericPage>
	<jsp:attribute name="titulo">
		<spring:message code="principal.titulo" />
	</jsp:attribute>
	<jsp:attribute name="cabecera">
      
    </jsp:attribute>
	<jsp:attribute name="pie">
      <p id="copyright">Copyright PatSanCu</p>
    </jsp:attribute>
	<jsp:body>
        
    </jsp:body>
</t:genericPage>