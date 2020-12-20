<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
 .error{
 	color: red;
 }
</style>

<html>
<body>

	<form:form action="add" method="post" acceptCharset="UTF-8" commandName="form">
		<label for="firstName"> FirstName : 
			<form:input type="text" path="firstName" id="firstName"/>
		</label> 
		<form:errors path="firstName" cssClass="error"/>
		<br>
		<label for="lastName">  LastName :
			<form:input type="text" path="lastName" id="lastName"/>
		</label> 
		<form:errors path="lastName" cssClass="error"/>
		<br>
		<input type="submit">	
	</form:form>

	Click
	<a href="list">here</a> to list all people inserted before...

</body>
</html>
