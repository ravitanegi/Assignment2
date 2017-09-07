package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class parkcheck
 */
public class parkcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public parkcheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String Platenumber= request.getParameter("pnumber");
			String Start= request.getParameter("time");
			String Finish= request.getParameter("fname");
			String sql="insert into parkinginfo(pnumber,time,fname) values(?,?)"
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn="DriverManager.getConnection("jdbc:mysql://localhost/carparking","root","");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,time);
			ps.setString(3,time);
			ps.executeUpdate();
			PrintWriter out = response.getWriter();
			out.println("You have successfully paid the parking fee");
			
				
		}
	}

}
