<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <script src="validation.js"></script> 
<meta charset="ISO-8859-1">
<title>Sports Car Club - Home Page</title>
</head>
<body>

<form action="addItemServlet" method="post" onsubmit="return checkItemForm()">
Make: <input type ="text" name = "make" id="make">
Model: <input type = "text" name = "model" id="model">
Year: <input type = "text" name = "year" id="year">
Owner:
<select name = "ownerId" id = "ownerId">
<c:forEach items="${requestScope.allOwners}" var="currentOwner">
	<option value="${currentOwner.ownerId}">${currentOwner.name}</option>
</c:forEach>
</select>
<input type = "submit" value="Add Item">
</form><br />

<form action="addOwnerServlet" method="post" onsubmit="return checkOwnerForm()">
Name: <input type ="text" name = "name" id="name">
<input type = "submit" value="Add Owner">
</form><br />

<a href = "viewAllItemsServlet">View the complete list</a>
</body>
</html>