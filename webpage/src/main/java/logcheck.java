

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logcheck
 */
public class logcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logcheck() {
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
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String login= request.getParameter("login");
		if(login!=null){
			boolean transaction = false;
			if(getRecordNumber("Select 1 from caruser where uname = '" + request.getParameter("uname") + "' And Password ='" + request.getParameter("password")+ "' ")==1){
				transaction = true;
			}
			if(transaction){
				response.sendRedirect("index.jsp");
			}
			else
			{ response.sendRedirect("error.jsp");
		}
	}

	}

}
