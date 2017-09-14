
<html>
<%= new java.text.SimpleDateFormat("E,dd MM YYY").format(new java.util.Date())
%>
<body>
	<form method="post" action="Logchecking">
		<table>
			<tr>
				<td>User name</td>
				<td><input type="text" name="uname"></td>
			</tr>


			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>
				<td><input name="login"  type="submit" value="login"></td>
			</tr>
		</table>
	</form>
</body>
</html>
