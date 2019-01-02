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
			<c:forEach items="${allEmployees}" var="employee">
				<tr>
				<td>${employee.password}</td>
				<td>${employee.name}</td>
				<td>${employee.emailid}</td>
				<td>${employee.dob}</td>
				<td>${employee.gender}</td>
				</tr>
			</c:forEach>
</table>
</body>
</html>