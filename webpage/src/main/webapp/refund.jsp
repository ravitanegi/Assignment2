<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="Retrievedata">
		<table>

			<tr>
				<caption align="top">
					<h4>Refund your Extra Money</h4>
				</caption>
			</tr>

			<tr>
				<td>Ticket Number</td>
				<td><input type="text" name="Tnumber" value="<%= request.getAttribute("Tnumber")%>"></td>
			</tr>
			
			<tr>
				<td>Estimated Start Time</td>
				<td><input type="time" name="estime" value="<%= request.getAttribute("estime")%>"> </td>
			</tr>
			
			<tr>
			<td> Estimated Finish Time</td>
			<td> <input type="time" name ="eftime" value="<%= request.getAttribute("eftime")%>"> </td>
			</tr>
			
			<tr>
			<td> Actual Finish Time</td>
			<td> <input type="time" name ="aftime" value="<%= request.getAttribute("aftime")%>"> </td>
			</tr>
			
			
			<tr>
			<td> Amount </td>
			<td> <input name="Pamount" type="number" value="<%= request.getAttribute("Pamount")%>"> </td>
			</tr>
			
			<tr>
			<td> Exact Amount</td>
			<td> <input name= "Eamount" type="number" pattern="(\d{3})([\.])(\d{2})"  value="<%= request.getAttribute("Eamount")%>"> </td>
			</tr>
			
			<tr>
			<td> Refund Amount </td>
			<td> <input name="Ramount" type="number" pattern="(\d{3})([\.])(\d{2})"  value="<%= request.getAttribute("Ramount")%>"> </td>
			</tr>
			
			<tr>
			<td>
				<input name ="Refund" type="submit" value="Refund">
			</td>
			</tr>
		</table>




	</form>
</body>
</html>