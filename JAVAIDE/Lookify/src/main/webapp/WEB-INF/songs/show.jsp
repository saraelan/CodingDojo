<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<title>Show Songs</title>
</head>
<body>
<h1>Songs!!</h1>

	<h3><a href = "/dashboard">Dashboard</a></h3>
	<h2>
		<p>Name: <c:out value="${song.title}"/></p>
		<p>Artist: <c:out value="${song.artist}"/></p>
		<p>Rating: <c:out value="${song.rating}"/></p>
	</h2>
   	<a href="/songs/delete/${song.id}">Delete</a>
</body>
</html>