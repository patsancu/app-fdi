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
<%-- 	<c:url value="/login" var="loginUrl" /> --%>
	<%-- <c:url value="/j_spring_security_check" var="loginUrl" /> --%>
	<spring:url value="/j_spring_security_check" var="loginUrl" />

	${loginUrl}
	<div class="container">
		<form:form  name="f" action="${loginUrl}" method="post">
			<fieldset>
				<legend>Please Login</legend>
				
				<label for="username">Username</label> <input type="text"
					id="username" name="j_username" value="${username}" /> <label
					for="password">Password</label> <input type="password"
					id="password" type="password" name="j_password" />
				<div class="form-actions">
					<button type="submit" class="btn">Log in</button>
				</div>
			</fieldset>
		</form:form>

	</div>
</body>
</html>
