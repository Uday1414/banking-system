<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: silver;">
	<%@include file="navbar.jsp"%>
	<%
	if (session.getAttribute("activeadmin") != null) {
	%>
	<h1 style="background: gray;">WELCOME ADMIN</h1>
	<a href="accountrequests"
		style="font-size: 40px; background-color: white;">CREATE NEW
		ACCOUNT</a>
	<br>
	<br>
	<a href="changerequesttoadmin"
		style="font-size: 40px; background-color: white;">Request to
		change</a>
	<br>
	<br>
	<a href="viewalltransactions.jsp"
		style="font-size: 40px; background-color: white;">VIEW
		TRANSACTIONS</a>
	<%
	} else {
	response.sendRedirect("adminlogin.jsp");
	}
	%>
</body>
</html>