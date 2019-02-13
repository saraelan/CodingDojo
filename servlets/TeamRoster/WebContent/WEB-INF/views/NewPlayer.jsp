<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a new Player</title>
</head>
<body>
  
       
  <h1>Add a player to team  ${name}</h1>
  
  <form action="teamInfo" method="post">
    <label>First Name:</label>
    <input type="text" name="fname"> 
    <label>Last Name :</label>
    <input type="text" name="lname">
    <label>Age :</label>
    <input type="number" name="age">
    <input type="hidden" name="id" value="${teamId}">
    <input type="submit" value="Submit"> 
  </form>

</body>
</html>