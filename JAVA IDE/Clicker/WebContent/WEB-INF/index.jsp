<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Button Clicker</title>
</head>
<body>
<h1> Button Clicker</h1>
<form action="/Clicker/Clickers">
        <button type="submit">Click Me!</button>
        <h1>You have clicked this button <%= (int) session.getAttribute("times") %> times!</h1>
    </form>
</body>
</html>