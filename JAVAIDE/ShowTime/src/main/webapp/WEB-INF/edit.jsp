<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit a Show</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
<style>
div{
margin: auto;
    width: 50%;
    border: 3px solid green;
    padding: 10px;s

}
</style>
</head>
<body>
<div>
<h2><c:out value="${ show.showname}"></c:out></h2>
<br>
	<form:form method="POST" action="/shows/${show.id }/edit" modelAttribute="show">
                <label>Show Title :</label>
                <form:input path="showname"/>
                <form:errors path="showname"/><br>
				<br>
                <label>Network :</label>
                <form:input path="network"/>
                <form:errors path="network"/><br>
            
            <br>
            <input type="hidden" name="creator" value="${user.id}"/>
            <button type="submit">Update</button>
            
                
            
		</form:form>

<br>
<a href="/shows/${show.id}/delete">Delete</a> | <a href="/shows">Back</a>



</div>

</body>
</html>