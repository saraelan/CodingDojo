<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new Team</title>
</head>
<body>
  <h1>Create a new team</h1>
  
  <form action="Team" method="post">
   <label>Team Name :</label>
    <input type="text" name="tname">
   <input type="submit" value="Create">
  </form>
</body>
</html>