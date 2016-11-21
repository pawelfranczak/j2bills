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


	<h1>Konta</h1>

	<table width="100%" border="1">
		<tr>
			<th><fmt:message key="field.id" /></th>
			<th><fmt:message key="person" /></th>
			<th><fmt:message key="field.name" /></th>
			<th><fmt:message key="field.description" /></th>
			<th><fmt:message key="account.field.balance" /></th>
		</tr>
		<c:forEach items="${accountList}" var="account">
			<tr>
				<td><c:out value="${account.id}"/></td>
				<td><c:out value="${account.person}"/></td>
				<td><c:out value="${account.name}"/></td>
				<td><c:out value="${account.description}"/></td>
				<td><c:out value="${account.balance}"/></td>
			</tr>

		</c:forEach>
	</table>
	
	
	<BR> <a href="<c:url value="/" />"> | index | </a>

</body>
</html>