<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DOJO</title>
</head>
<body>
<a href="/">Back</a>
<h1>Create a New School</h1>
<form:form action="/dojos" method="post" modelAttribute="dojo">
    <p>
        <form:label path="name">Name of School</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>


</body>
</html>