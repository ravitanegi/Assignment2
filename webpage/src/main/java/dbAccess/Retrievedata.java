package dbAccess;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Retrievedata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 DBconnection connect;
    public Retrievedata() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
			
			connect = new DBconnection();
			String c_id="";
			ArrayList<String> Retrieve= new ArrayList<String>();
			Retrieve = connect.readRow("Select caruser_id, plate_no, date, stime, ftime, amount"
					+ " from carparking where id='"+ request.getParameter("Tnumber") +"' order by id desc limit 0,1 ");
			
			c_id = Retrieve.get(0);
			String p_no = Retrieve.get(1);
			String Date = Retrieve.get(2);
			String Stime = Retrieve.get(3);
			String Ftime = Retrieve.get(4);
			String Amount = Retrieve.get(5);
			
			//System.out.println(c_id);
			
			request.setAttribute("Tnumber",request.getParameter("Tnumber"));
			request.setAttribute("estime",Stime);
			request.setAttribute("eftime",Ftime);
			request.setAttribute("Pamount",Amount);
			
			
		
	
			request.getRequestDispatcher("refund.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ActualTime = request.getParameter("aftime");
		String Stime = request.getParameter("estime");
		String Ftime = request.getParameter("eftime");
		String Tnumber = request.getParameter("Tnumber");
		String Amount = request.getParameter("Pamount");
		
		//System.out.println(Amount);
		
		int hours= Integer.parseInt(Stime.substring(0,2));
		int mins= Integer.parseInt(Stime.substring(3,5));
		int secs= Integer.parseInt(Stime.substring(6,8));
		int timeinsec = hours*3600 + mins*60 + secs;
		int h= Integer.parseInt(ActualTime.substring(0,2));
		int m= Integer.parseInt(ActualTime.substring(3,5));
		int s= Integer.parseInt(ActualTime.substring(6,8));
		int timein = h*3600 + m*60 + s;
		int duration = timein-timeinsec;
		Double amt = (duration/3600)*1.5;
		Double refund= Double.parseDouble(Amount)-amt;
		System.out.println(refund);
		request.setAttribute("Eamount", amt);
		request.setAttribute("Ramount", refund);
		request.setAttribute("Tnumber",Tnumber);
		request.setAttribute("estime",Stime);
		request.setAttribute("eftime",Ftime);
		request.setAttribute("aftime",ActualTime);
		request.setAttribute("Pamount",Amount);
		connect.refundUpdateTodb(Tnumber,ActualTime,amt);
		request.getRequestDispatcher("refund.jsp").forward(request, response);
		
		
	}
}
