<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Liste des Animations</title>
</head>
<body style="color: green;">
	Liste des Animations
	<table border=1>
		
	<tr>
 		<td>nom   </td>
		<td>days   </td>
		<td>nombre place disponible  </td>
	</tr>
	<c:forEach items="${programs}" var="program">
	
	<tr>
		<td> <a href="http://localhost:8080/Brest_2016/connection.htm?id=<c:out value="${program.animation.name}" />"><c:out value="${program.animation.name}" /> </a></td>
		<td>  <c:out value="${program.day}"/>  </td>
		<td>  <c:out value="${program.getFreePlace()}"/>  </td>
		<td>  <button> reserver </button>   </td>
	</tr>
	</c:forEach>
	
	 </table>
</body>
</html>