<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<html>
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
<h2>Hello World!</h2>
<p>The time on the server is ${serverTime}.</p>
<div id="container">
<div id="icontainer">
<form action="user" method="post">
<label>UserName:</label><br>
<input type="text" name="name"><br>

<label>Password</label><br>
<input type="password" name="password"><br>

<label>FullName</label><br>
<input type="text" name = "fullName"><br>

<label>EmailId</label><br>
<input type="email" name="emailid"><br>

<label>DOB</label><br>
<input type="text" name="dob"><br>

<label>Gender</label><br>
<input type="text" name="gender"><br>

<label>Type</label><br>
<input type="text" name="type"><br>

<label>Security Question</label><br>
<input type="text" name="securityQuestion"><br>

<label>Security Answer</label><br>
<input type="text" name="securityAnswer"><br>
<input type="submit" value="Login">
</form>
</div>
</div>
</body>
</html>
