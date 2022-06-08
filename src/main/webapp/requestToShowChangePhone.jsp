<%@page import="com.ty.banking_system.dto.RequestAdmin"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <%if(session.getAttribute("activeadmin")!=null){ %>
	<%@include file="navbar.jsp" %><br><br>
	<h1 style="background-color: gray">REQUEST LIST</h1>
	<table border="3px" cellpadding=20px>
		<tr>
			<th>Id</th>
			<th>Acc Holder Id</th>
			<th>New Number</th>
			<th>Change</th>
			<th>Trace Service Request</th>
			<th>Trace</th>
			<th>Cheque Book</th>
			<th>Request</th>
		</tr>
		<%
		ArrayList<RequestAdmin> admins=(ArrayList) request.getAttribute("changePhonelist");
		for(RequestAdmin e : admins){
		%>

		<tr>
			<td><%=e.getId()%></td>
			<td><%=e.getAccHolderid()%></td>
			<td><%=e.getPhone()%></td>
			<td><a href="noChanged?id=<%=e.getId()%>">Change</a></td>
			<td><%=e.getTrace() %></td>
			<td><a href="trace?id=<%=e.getId()%>">Trace</a></td>
			<td><%=e.getCheckBook()%></td>
			<td><a href="chequebook.jsp?id=<%=e.getAccHolderid()%>">Request</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<% } else{
		response.sendRedirect("adminlogin.jsp");
	} %>	

</body>
</html>