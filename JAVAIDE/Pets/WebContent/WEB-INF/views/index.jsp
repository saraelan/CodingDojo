<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h1>Make a dog </h1>

<form action ="/Pets/Dogs" method ="get">
<p>Name: <input type="text" name="name"><br>
<p>Breed: <input type="text" name="breed"><br>
<p>Weight: <input type="text" name="weight"><br>
<p><button type="submit">Create</button></p><br>
</form>

<h1>Make a cat </h1>
<form action ="/Pets/Cats" method ="get">
<p>Name: <input type="text" name="name"><br>
<p>Breed: <input type="text" name="breed"><br>
<p>Weight: <input type="text" name="weight"><br>
<p><button type="submit">Create</button></p><br>
</form>


</body>
</html>