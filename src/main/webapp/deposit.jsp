<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: silver;">
<%@include file="navbar.jsp" %>
	<h1 style="background-color: gray; font-size: 30px">ENTER AMOUNT TO DEPOSIT</h1>
	<form action="deposit">
	Amount : <input type="number" name="amount">
	<input type="submit" value="deposit">
	</form>
</body>
</html>