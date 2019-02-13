<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
<style>
h3
{
color:blue;
}

h4
{
color:green;

}

div
{
margin:auto;
width:30%;
border :3px solid grey;
padding :10px;
}
</style>
</head>
<body>
<div classs="results">

<h1>Submitted Info</h1>

<h3>Name:</h3> <h4><c:out value="${name}"/></h4>

<h3>Dojo Location : </h3> <h4><c:out value="${location}"/></h4>

<h3>Favourite Language : </h3> <h4><c:out value="${language}"/></h4>

<h3>Comment : </h3> <h4><c:out value="${comment}"/></h4>


<a href="/"><button>Go Back</button></a>

</div>

</body>
</html>