<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
#container{
border: 2px solid black;
background-color: blue;
width: 200px;
}
#icontainer{
margin: 5px 5px 5px 5px;
}
</style>
<body>
<div id="container">
<div id="icontainer">

<form action="Admin_Op" method="post">
<label>UserName:</label><br>
<input type="text" name="name"><br>

<label>Password</label><br>
<input type="password" name="password"><br>
<input type="submit" value="Login">
</form>
</div>
</div>
</body>
</html>