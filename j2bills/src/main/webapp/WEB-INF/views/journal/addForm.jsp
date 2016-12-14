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


	<!-- <c:out value="${language}"></c:out>  -->
	<h1><fmt:message key="journal.entry.addform.header" /></h1>
	
	<form:form method="POST" commandName="journal">
		
		
		
		WARTOSC <form:input path="value" type="number" step="0.01"/> <BR>
		OPIS <form:input path="description" /> <BR>
		
		Użytkownik<BR>
		<form:select path="person">
		<form:option value="0" label="Select" />
		<form:options items="${personList}" itemValue="id" itemLabel="firstName" />
		</form:select>

		<BR>
		Konto<BR>
		<form:select path="account">
		<form:option value="0" label="Select" />
		<form:options items="${accountList}" itemValue="id" itemLabel="accountName" />
		</form:select>		
		
		<BR>
		Waluta<BR>
		<form:select path="currency">
		<form:option value="0" label="Select" />
		<form:options items="${currencyList}" itemValue="id" itemLabel="iso4217" />
		</form:select>	

		
		<input type="submit" value="<fmt:message key="add" />" />
	</form:form>
	
	<BR> <a href="<c:url value="/" />"> | index | </a>

</body>
</html>