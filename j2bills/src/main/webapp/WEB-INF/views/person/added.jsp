<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>

<!-- jstl core -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--  spring jsp forms tags -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- i18l tags  -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />

<!-- set locale! -->
<fmt:setLocale value="${language}" />

<!-- properties file -->
<fmt:setBundle basename="text" />

<html lang="${language}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>j2bills</title>
</head>
<body>

	<h1>Added succesfully</h1>
	
	<fmt:message key="person.first.name" /> <c:out value="${person.firstName}"/> <BR>
	<fmt:message key="person.last.name" /> <c:out value="${person.lastName}"/> <BR>
	<fmt:message key="user" /> <c:out value="${person.users.username}"/> <BR>

	<BR> <a href="<c:url value="/" />"> | index | </a>

</body>
</html>