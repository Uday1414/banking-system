<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%if(session.getAttribute("activeaccountHolder")!=null){ %>
	<%@include file="navbar.jsp" %>
	<h1 style="background-color: gray;">Password updated</h1>
	<a href="accountholderlogin.jsp" style="font-size: 20px ; background-color: gray;">Back to Account Holder Home Page</a>
	
	<%} else {
		response.sendRedirect("accountholderlogin.jsp");
	}	%>
</body>
</html>