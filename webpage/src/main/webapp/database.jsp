<%@ page import="java.sql.*"%>"
<%!
public Connection setConnection()
{
Connection connection = null;
try{
String connectionURL = "jdbc:mysql://localhost/carparking";
Class.forName("com.mysql.jdbc.Driver").newInstance();
connection = DriverManager.getConnection(connectionURL, "root","");
}catch(Exception e){
	System.out.println(e);
}
return connection;
}
%>
<%!
public int getRecordNumber(String Query){
	int result=0;
	Connection connection = null;
	PreparedStatement st = null;
	ResultSet rs= null;
	try {
		connection = setConnection();
		st = connection.prepareStatement(Query);
		rs = st.executeQuery();
		while(rs.next()){
			result++;
		}
		
	}catch(Exception ex){
		System.out.println(ex);
	}
	return result;
}
%>

