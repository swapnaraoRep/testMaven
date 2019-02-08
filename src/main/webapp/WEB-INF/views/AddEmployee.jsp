<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="/resources/style.css" var="mainCss" />
	<link href="${mainCss}" rel="stylesheet" />
</head>
<body>
<form:form action="checkEmployee" modelAttribute="employeeVO">
<div id="addEmployeeDiv">
<table align="center" >
<tr>
<td>Employee ID</td><td><form:input path="id" cssClass="focus1"/></td>
<td><form:errors path="id" cssClass="error"/></td></tr>
<tr>
<td>firstName</td><td><form:input path="firstName" cssClass="focus1"/></td>
<td><form:errors path="firstName" cssClass="error" /></td>
</tr>
<tr>
<td>LastName(*)</td><td><form:input path="lastName" cssClass="focus1"/></td>
<td><form:errors path="lastName" cssClass="error"/></td>
</tr>
<tr>
<td>Email(*)</td><td><form:input path="email" cssClass="focus1"/></td>
<td><form:errors path="email" cssClass="error"/></td>
</tr>

<tr>
<td><input type="submit"/></td>

</tr>

</table>

</div>	
	</form:form>
</body>
</html>