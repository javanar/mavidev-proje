<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${people}" var="person">
    	${person.firstName} ${person.lastName}
    	<br>
	</c:forEach>
	<br>
	Click <a href="index.jsp">here</a> to add another person...
</body>
</html>