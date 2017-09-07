<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="logincheck">
		<table>

			<tr>
				<caption align="top">
					<h4>Refund your Extra Money</h4>
				</caption>
			</tr>

			<tr>
				<td>Ticket Number</td>
				<td><input type="text" name="Tnumber"></td>
			</tr>
			
			<tr>
				<td>Estimated Start Time</td>
				<td><input type="time" name="estime"> </td>
			</tr>
			
			<tr>
			<td> Estimated Finish Time</td>
			<td> <input type="time" name ="eftime"> </td>
			</tr>
			
			<tr>
			<td> Actual Finish Time</td>
			<td> <input type="time" name ="aftime"> </td>
			</tr>
			
			
			<tr>
			<td> Amount </td>
			<td> <input type="number" pattern="(\d{3})([\.])(\d{2})"> </td>
			</tr>
			
			<tr>
			<td> Exact Amount</td>
			<td> <input type="number" pattern="(\d{3})([\.])(\d{2})"> </td>
			</tr>
			
			<tr>
			<td> Refund Amount </td>
			<td> <input type="number" pattern="(\d{3})([\.])(\d{2})"> </td>
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