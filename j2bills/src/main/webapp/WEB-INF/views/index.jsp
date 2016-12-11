<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>


<!-- jstl core -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- security -->
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!--  spring jsp forms tags -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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

	<c:out value="${language}"></c:out>
	<h1><fmt:message key="index.welcome" /></h1>
	<h2>Zalogowany <security:authentication property="principal.username" /></h2>
	
	<a href="<c:url value="login?logout" />">Logout</a><BR><BR>
	
	<fmt:message key="account" />: 
	<a href="<c:url value="account/addForm" />"> <fmt:message key="index.add" /> </a> |
	<a href="<c:url value="account/show" />"> <fmt:message key="index.show" /> </a> |
	<a href="<c:url value="account/select" />"> <fmt:message key="index.select" /> </a><BR>
	
	<fmt:message key="currency" />: 
	<a href="<c:url value="currency/addForm" />"> <fmt:message key="index.add" /> </a> |
	<a href="<c:url value="currency/show" />"> <fmt:message key="index.show" /> </a> |
	<a href="<c:url value="currency/select" />"> <fmt:message key="index.select" /> </a> | <BR>
	
	<fmt:message key="person" />: 
	<a href="<c:url value="person/addForm" />"> <fmt:message key="index.add" /> </a> |
	<a href="<c:url value="person/show" />"> <fmt:message key="index.show" /> </a> |
	<a href="<c:url value="person/select" />"> <fmt:message key="index.select" /> </a> | <BR>

	<fmt:message key="journal.entry" />: 
	<a href="<c:url value="journal/addFormExtended" />"> <fmt:message key="index.add" /> </a> |
	<a href="<c:url value="journal/show" />"> <fmt:message key="index.show" /> </a> |
	<a href="<c:url value="journal/select" />"> <fmt:message key="index.select" /> </a> | <BR>

</body>
</html>