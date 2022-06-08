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
	<form action="fundtransfer">
		BANK NAME <input type="text" name="bank"> <br> <br>
		ACC NUMBER <input type="text" name="accnumber"><br> <br>
		IFSC <input type="text" name="ifsc"><br> <br> AMOUNT
		<input type="number" name="amount"><br> <br> <input
			type="submit" value="transfer">
	</form>
</body>
</html>