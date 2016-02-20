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
	<ul>
	<c:forEach items="${programs}" var="program">
		<li>nom : <c:out value="${program.animation.name}" />; rype : <c:out value="${program.animation.type}"/>
	</c:forEach>
	</ul>
</body>
</html>