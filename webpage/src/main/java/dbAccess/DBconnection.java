package dbAccess;
import java.sql.*;
import java.util.ArrayList;

public class DBconnection {
	private Connection myconn;
	
	 public DBconnection() throws ClassNotFoundException, SQLException{
		 String dbUrl= "jdbc:mysql://localhost:3306/carparking";
		 String user = "root";
		 String password = "";
		 Class.forName("com.mysql.jdbc.Driver");
		 myconn = DriverManager.getConnection(dbUrl,user,password);
		// System.out.println("Initializing the database..");
		 Statement myStmt = myconn.createStatement();	 
	 }
	 
	 public boolean searchUser(String username, String password)
	 {
		 PreparedStatement myStat = null;
		 ResultSet Rs = null;
		 try {
			 myStat = myconn.prepareStatement("select * from caruser where uname = ? and Password = ?");
			 myStat.setString(1, username);
			 myStat.setString(2, password);
			 Rs = myStat.executeQuery();
			 
			 if(Rs.next()){
				return true;
			 }
			 else
			 {
				 return false;
			 }
			 
		 }catch (SQLException e)
		 {
			 e.printStackTrace();
		 }
		return false; 
	 }
	 
	 public ArrayList readRow(String parkingnumber)
	 {
		 ArrayList<String> result = new ArrayList<String>();
		 PreparedStatement myStat = null;
		 ResultSet myRs= null;
		 try
		 {
			 myStat = myconn.prepareStatement(parkingnumber);
			 myRs= myStat.executeQuery();
			 while(myRs.next()) {
				 ResultSetMetaData myrsm = myRs.getMetaData();
				 for(int i=1; i<= myrsm.getColumnCount(); i++)
				 {
					 result.add(myRs.getString(i));
					 //System.out.println(myRs.getString(i));
                 }
			 }
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }
			 return result;
			 
		 }
		 
	 
	 public void writeTodb(String userid,String auto, String carno, String stime, String ftime, Double amt)
	 {
		 try {
			Statement sta = myconn.createStatement();
			sta.executeUpdate("INSERT INTO CARPARKING Values ('"+ auto +"','"+ userid +"','" + carno +"', NOW(), '" + stime +" ','"+ ftime +"'," +
			amt +")");
			//System.out.println("successfully registered");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	 }
	 
	 public void refundUpdateTodb(String auto, String ftime, Double amt)
	 {
		 try {
			Statement sta = myconn.createStatement();
			sta.executeUpdate("Update CARPARKING set ftime= '"+ftime+"', amount= '"+amt+"' where id ='"+auto+"'");
			//System.out.println("successfully updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	 }
	 
	public static void main(String[] args) {
		try {
		DBconnection obj = new DBconnection();
		System.out.println("Db object created");
		if(obj.searchUser("111", "12345"))
		{
			//System.out.println("User exist");
		}
		else
		{
			//System.out.println("The user is not in the database");
		}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		
			}

}
