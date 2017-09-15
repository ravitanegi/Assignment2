<%
if(new java.text.SimpleDateFormat("E").format(new java.util.Date()).equals("Sun"))
	{
	out.println("Free and Unlimited Parking");
	}
	else if(new java.text.SimpleDateFormat("E").format(new java.util.Date()).equals("Sat"))
	{
	out.println("Free 2 hours Parking");
	}
else{
	if(Integer.parseInt(new java.text.SimpleDateFormat("H").format(new java.util.Date()))<9 &&
	Integer.parseInt(new java.text.SimpleDateFormat("H").format(new java.util.Date()))>17)
	{
		out.println("Free and Unlimited Parking");
	}
else{
%>


<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar" %>
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
<%
Calendar cal = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
String time= sdf.format(cal.getTime());
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
				<td><input type="text" name="Uid"></td>
			</tr>

			<tr>
				<td>Ticket Number</td>
				<td><input type="text" name="Tnumber"></td>
			</tr>
			<tr>
				<td>Car Plate Number</td>
				<td><input type="text" name="pnumber">
			</tr>
			<tr>
				<td>Date <%=datetoday%></td>

			</tr>
			<tr>
				<td>Start Time </td>
				<td> <input type="time" name ="time"  value="<%=time%>" readonly> </td>
			</tr>
			<tr>
			<td> Finish Time</td>
			<td> <input type="time" name ="ftime"> </td>
			
			
			<tr>
			<td> Amount </td>
			<td> <input name ="amt"  type="number" pattern="(\d{3})([\.])(\d{2})"> </td>
			</tr>
			<tr>
				<td><input name ="Pay" type="submit" value="Pay"> </td>
			</tr>
			
		</table>




	</form>
</body>
</html>
<% }}%>