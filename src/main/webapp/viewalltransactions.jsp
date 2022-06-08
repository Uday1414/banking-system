<%@page import="com.ty.banking_system.dto.FundTransfer"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.banking_system.service.FundTransferService"%>
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
	<h1 style="background-color: gray">ALL TRANSACTIONS</h1>
	<table border="3px" cellpadding=20px>
		<tr>
			<th>ID</th>
			<th>AccNumber</th>
			<th>Amount</th>
			<th>BankName</th>
			<th>ifscCode</th>
		</tr>
		<%
		FundTransferService fundTransferService = new FundTransferService();
		List<FundTransfer> fundTransfers = fundTransferService.getAllFundTransfers();
		for (FundTransfer fundTransfer : fundTransfers) {
		%>
		<tr>
			<td><%=fundTransfer.getId()%></td>
			<td><%=fundTransfer.getAccNumber()%></td>
			<td><%=fundTransfer.getAmount()%></td>
			<td><%=fundTransfer.getBankName()%></td>
			<td><%=fundTransfer.getIfscCode()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<br>
	<a href="adminhomepage.jsp">CLICK HERE</a>
</body>
</html>