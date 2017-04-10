<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome <security:authentication property="name"/></title>
	</head> 
	<body>
		<h1>Welcome <security:authentication property="name"/> !</h1>
		<c:url var="logout" value="/logout"/>
		${message}
		<h1>Home Page</h1> <a href="${logout}">Logout</a>
		<p>
			The context path is <c:out value="${pageContext.request.contextPath}"/><br/>
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<a href="${pageContext.request.contextPath}/team/add.html">Add New Team</a><br/>
			</security:authorize>
			<a href="${pageContext.request.contextPath}/team/list.html">Team List</a>
		</p>
		
	</body>
</html>
