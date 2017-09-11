package dbAccess;


import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Logchecking extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DBconnection newConnection;
    public Logchecking() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		try
		{
			newConnection = new DBconnection();
			if(newConnection.searchUser(uname, password))
			{
				response.sendRedirect("index.jsp");
			}
			else
			{
				boolean result = newConnection.searchUser(uname, password);
					
					if(result == true)
					{
						response.sendRedirect("index.jsp");
					}
					else
					{
						response.sendRedirect("error.jsp");
					}
					
			}
		}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		
		}
			
	}
