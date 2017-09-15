package dbAccess;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
		int hours= Integer.parseInt(time.substring(0,2));
		int mins= Integer.parseInt(time.substring(3,5));
		int secs= Integer.parseInt(time.substring(6,8));
		int timeinsec = hours*3600 + mins*60 + secs;
		int h= Integer.parseInt(ftime.substring(0,2));
		int m= Integer.parseInt(ftime.substring(3,5));
		int s= Integer.parseInt(ftime.substring(6,8));
		int timein = h*3600 + m*60 + s;
		int duration = timein-timeinsec;
		Double amt = (duration/1800)*0.75;
		
		System.out.println(amt);
		try {
			
			connect = new DBconnection();
			String autonumber="";
			ArrayList<String> Parking= new ArrayList<String>();
			Parking = connect.readRow("Select id from carparking order by id desc limit 0,1 ");
			
			if(Parking.size()<=0) {
				autonumber = "";
			}else {
				autonumber = Parking.get(0);
			}
			
			if(autonumber.equals("")) {
				autonumber = "1";
			}
			else
			{
				autonumber= String.format("%d",Integer.parseInt(autonumber)+1);
			}
			
			connect.writeTodb(userid,autonumber,pnumber,time,ftime,amt);
			request.setAttribute("userid",userid);
			request.setAttribute("tnumber",autonumber);
			request.setAttribute("pnumber",pnumber);
			request.setAttribute("time", time);
			request.setAttribute("ftime", ftime);
			request.setAttribute("amt", amt);
	
			request.getRequestDispatcher("carparked.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
