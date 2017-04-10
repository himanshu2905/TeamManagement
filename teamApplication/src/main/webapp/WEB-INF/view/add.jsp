<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Add Team</title>
	</head> 
	<body>
		<h1>Add Team</h1>
		<form:form commandName="team" method="POST" action="${pageContext.request.contextPath}/team/create.html">
			<table>
				<tbody>
					<tr>
						<td>Name</td>
						<td><form:input path="name"/></td>
					</tr>
					<tr>
						<td>Rating</td>
						<td><form:input path="rating"/></td>
					</tr>			
				</tbody>
			</table>
			<input type="submit" value="Add"/>
		</form:form>
		<a href="${pageContext.request.contextPath}/">Go back to Home</a><br/>				
	</body>
</html>
