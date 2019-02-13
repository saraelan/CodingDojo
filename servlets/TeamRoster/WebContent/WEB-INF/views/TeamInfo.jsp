<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="com.codingdojo.model.Player"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Team Info</title>
</head>
<body>
  <h1>${tname}</h1>
  <h1><a href="Players">New ${tname}</a></h1>
  <h1><a href="Home">Home Page</a></h1>
  <table>
    <thead>
    <tr>
     <td>First Name</td>
     <td>Last Name</td>
     <td>Age</td>
     <td>Actions</td>
    </tr>
    </thead>
    
    <tbody>
     <c:forEach var="player" items="${teamplayers}" varStatus="loop">
     <tr>
     <td><c:out value="${player.getFirstName() }"/></td>
     <td><c:out value="${player.getLastName() }"/></td>
     <td><c:out value="${player.getAge() }"/></td>
     </tr>
     </c:forEach>
    </tbody>
  </table>
      
</body>
</html>