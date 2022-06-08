<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<%
	if (session.getAttribute("activeadmin") != null) {
	%>
	<h1 style="background: gray; font-size: 30px">No such request
		present</h1>
	<a href="adminhomepage.jsp"
		style="font-size: 40px; background-color: white;">Back to homepage</a>
	<%
	} else {
	response.sendRedirect("adminlogin.jsp");
	}
	%>

</body>
</html>