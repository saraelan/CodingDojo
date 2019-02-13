<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Dashboard</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
<style>
div{
margin: auto;
    width: 50%;
    border: 3px solid green;
    padding: 10px;

}
</style>
</head>

<body>
<div class="box">
	<h1>Login</h1>
    <p class="red">
        <p><c:out value="${error}" /></p>
    <form method="POST" action="/login">
        <p>
            <label for="email">Email</label>
            <input type="text" id="email" name="email"/>
             <form:errors path="email" class="red"/>
            
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <input type="submit" value="Login!"/>
    </form>   
</div><br><br>
<div class="box">
    <h1>Register!</h1>  
    
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
            <form:label path="email">Email:</form:label>
            <form:input type="email" path="email"/>
            <form:errors path="email" class="red"/>
        </p>
        <p>
            <form:label path="firstName">First Name:</form:label>
            <form:input path="firstName"/>
            <form:errors path="firstName" class="red"/>
        </p>
        <p>
            <form:label path="lastName">Last Name:</form:label>
            <form:input path="lastName"/>
            <form:errors path="lastName" class="red"/>
        </p>
        <p>
            <form:label path="city">Location:</form:label>
            <form:input path="city"/>
            <form:errors path="city" class="red"/>
        </p>
        <p>
            <form:label path="state">State:</form:label>
            <form:select path="state">
                <form:option value="${user.state}" />
            
                <c:forEach items="${states}" var="state">
                    <form:option value="${state}">${state}</form:option>
                </c:forEach>
            </form:select>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
            <form:errors path="password" class="red"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
			<form:errors path="passwordConfirmation" class="red"/>
        </p>
        <input type="submit" value="Register!"/>
    </form:form>
</div>
</body>
</html>