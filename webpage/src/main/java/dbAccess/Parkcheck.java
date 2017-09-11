package dbAccess;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Parkcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
     DBconnection connect;  
   
    public Parkcheck() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//doGet(request, response);
		Random dice = new Random();
		int number;
		for(int i=1;i<=5;i++)
		{
			number= dice.nextInt(5);
		}
	
		String userid = request.getParameter("Uid");
		String tnumber = request.getParameter("Tnumber");
		String pnumber = request.getParameter("pnumber");
		String time = request.getParameter("time");
		String ftime = request.getParameter("ftime");
		
		String amt = request.getParameter("amt");
		try {
			connect = new DBconnection();
			connect.writeTodb(userid,pnumber,time,ftime,amt);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");
	}

}
