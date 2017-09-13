


<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<%
	Date today = new Date();
	SimpleDateFormat Date_format = new SimpleDateFormat("dd-MM-yyyy");
	String datetoday = Date_format.format(today);
%>
<body>
	<form method="post" action="Parkcheck">
		<table>

			<tr>
				<caption align="top">
					<h4>Welcome to Car Parking System</h4>
				</caption>
			</tr>
			<tr>
				<td>User Id</td>
				<td><input type="text" name="Uid" value="<%= request.getAttribute("userid")%>" readonly></td>
			</tr>

			<tr>
				<td>Ticket Number</td>
				<td><input type="text" name="Tnumber" value="<%= request.getAttribute("tnumber")%>" readonly></td>
			</tr>
			<tr>
				<td>Car Plate Number</td>
				<td><input type="text" name="pnumber" value="<%= request.getAttribute("pnumber")%>" readonly>
			</tr>
			<tr>
				<td>Date <%=datetoday%></td>

			</tr>
			<tr>
				<td>Start Time</td>
				<td><input type="time" name="time" value="<%= request.getAttribute("time")%>" readonly> </td>
			</tr>
			<tr>
			<td> Finish Time</td>
			<td> <input type="time" name ="ftime" value="<%= request.getAttribute("ftime")%>" readonly> </td>
			
			
			<tr>
			<td> Amount </td>
			<td> <input name ="amt"  type="number" pattern="(\d{3})([\.])(\d{2})" value="<%= request.getAttribute("amt")%>" readonly>  </td>
			</tr>
			<tr>
			<td>
				<a href = "Retrievedata?Tnumber=<%= request.getAttribute("tnumber")%>">Refund</a>
			</td>
			</tr>
		</table>




	</form>
</body>
</html>