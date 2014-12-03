<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ attribute name="textoPrincipal" required="true"%>
<%@ attribute name="textoSecundario" required="true"%>

<div class="jumbotron">
	<div class="container">
		<img alt="Universidad Complutense de Madrid"
			src="https://www.ucm.es/data/cont/docs/340-2013-07-02-ucm.gif"
			width="100">

		<h1>${textoPrincipal}</h1>

		<p>${textoSecundario}</p>
		
	</div>
</div>