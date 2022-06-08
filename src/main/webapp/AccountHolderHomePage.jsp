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
    <%@include file="navbar.jsp" %><br><br>
	<h1 style="background: gray; font-size: 40px">WELCOME AccountHolder</h1>
	<a href="deposit.jsp" style="font-size: 30px ; background-color: white;">DEPOSIT</a> <br> <br>
	<a href="viewmini.jsp" style="font-size: 30px ; background-color: white;">VIEW MINI STATEMENT</a> <br> <br>
	<a href="reqChangePhone.jsp" style="font-size: 30px ; background-color: white;">Request To change Mobile Number</a> <br> <br>
	<a href="reuqestChequeBook" style="font-size: 30px ; background-color: white;">Request For ChequeBook</a> <br> <br>
	<a href="fundtransfer.jsp" style="font-size: 30px ; background-color: white;">Fund Transfer</a> <br> <br>
	<a href="reqchangepassword.jsp" style="font-size: 30px ; background-color: white;">change password</a> <br> <br>
	<%}else{
		response.sendRedirect("accountholderlogin.jsp");
	} %>
</body>
</html>