<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css"/>

<c:set var="contextRoot" value="${pageContex.Request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
   <link href="${css}/test.css" rel="stylesheet">
</head>
<body>
<header>
<h1>Employee List</h1>
</header>
<div align="center">
		
		<div>
		
		<table class="table">F
         <tr>
			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Action</th>
			</tr>
			<tr>
			<td>jitender</td>
			<td>jiteder@gmail.com</td>
			<td>delhi</td>
			<td>34534534</td>
			<td>delete</td>
			<tr/>
       </table>
</div>

</body>
</html>