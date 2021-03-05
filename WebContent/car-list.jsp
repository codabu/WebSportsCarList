<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Club - Car List</title>
</head>
<body>

	<form method = "post" action = "navigationServlet">
	<c:forEach items="${requestScope.allOwners}" var="currentowner">
	<h3>${currentowner.name}</h3>
	<table>
	<tr>
	<th></th>
    <th>Make</th>
    <th>Model</th>
    <th>Year</th>
  	</tr>
  	<c:forEach items="${requestScope.allItems}" var="currentitem">
  		<c:if test = "${currentitem.ownerId == currentowner.ownerId}">
  			<tr>
  				<td><input type="radio" name="id" value="${currentitem.id}"></td>
  				<td>${currentitem.make}</td>
  				<td>${currentitem.model}</td>
  				<td>${currentitem.year}</td>
  			</tr>
  		</c:if>
  	</c:forEach>
	</table>
	</c:forEach>
	<input type = "submit" value = "delete" name="doThisToItem">
	<input type="submit" value = "add" name = "doThisToItem">
	</form>
	
</body>
</html>