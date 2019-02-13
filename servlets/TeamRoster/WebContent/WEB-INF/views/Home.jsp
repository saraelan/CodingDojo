<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="com.codingdojo.model.team"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

<h1>Prototype Roster</h1>  <h1><a href="Team">New Team</a></h1>
  
  <table>
    <thead>
       <tr>
        <td>Team</td>
        <td>Players</td>
        <td>Actions</td>
       </tr>    
    </thead>
    
    <tbody>
     <c:forEach var="team" items="${allTeams}" varStatus="loop">
     <tr>
      <td><c:out value="${team.getTeamName()}"/></td>
       <td><c:out value="${team.getPlayers().size()}"/></td>
       <td><a href="teamInfo?id=${loop.index}">Details</a> | <a href="#">Delete</a></td>
     </tr>
     </c:forEach>
    </tbody>
  </table>


</body>
</html>