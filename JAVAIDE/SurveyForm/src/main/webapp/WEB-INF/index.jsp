<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Survey Dashboard</title>
 <style>
 
 div {
 margin:auto;
width:30%;
border :3px solid grey;
padding :10px;
 
 }
 
 </style>
 
 
</head>
<body>
<div class="form">
			<form method="POST" action="/reg">
				<h1>Dojo Survey</h1>
				<label>Your Name:<input type="text" name="name"></label>
				<br><br><br>
				<label>Dojo Location<select name="location">
					<option value="Seattle">Seattle</option>
					<option value="San Jose">San Jose</option>
					<option value="Chicago">chicago</option>
				</select></label>
					<br><br><br>
				<label>Favorite Language<select name="language">
					<option value="Python">Python</option>
					<option value="Java">Java</option>
					<option value="Mean">Mean</option>
				</select></label>
					<br><br><br>
				<label>Comment (optional)</label>
				<br><br>
				<textarea name="comment"></textarea>
				<br><br><br>
				<input class="button" type="submit" name="Enter">
			</form>
		</div>
    
 
</body>
</html>