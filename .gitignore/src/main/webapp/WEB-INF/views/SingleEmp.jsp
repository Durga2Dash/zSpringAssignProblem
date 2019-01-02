<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
			<th>Employee Id</th>
			<th>Name</th>
			<th>Email Id</th>
			<th>Date of Joining</th>
			<th>Role</th>
			
				<tr>
				<td>${allEmployees.password}</td>
				<td>${allEmployees.name}</td>
				<td>${allEmployees.emailid}</td>
				<td>${allEmployees.dob}</td>
				<td>${allEmployees.gender}</td>
				</tr>
</table>
</body>
</html>