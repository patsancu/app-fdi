<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>


<html>
<head>
<title>Login</title>
</head>
<body>
	<div class="container">
		<c:url value="/login" var="loginUrl" />
		<form:form  action="${loginUrl}" method="POST">
			<c:if test="${param.error != null}">
				<p><spring:message code="login.invalid" /></p>
			</c:if>
			<c:if test="${param.logout != null}">
				<p><spring:message code="login.logout" /></p>
			</c:if>
			<fieldset>
				<legend>Please Login</legend>
				
				<label for="username">Username</label> <input type="text"
					id="username" name="username" value="${username}" /> <label
					for="password">Password</label> <input type="password"
					id="password" type="password" name="password" />
				<div class="form-actions">
					<button type="submit" class="btn">Log in</button>
				</div>
			</fieldset>
		</form:form>

	</div>
</body>
</html>
