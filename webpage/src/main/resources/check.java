

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class check
 */
public class check extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//doGet(request, response);
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		if(uname.equals("ravita") && password.equals("1234"))
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			response.sendRedirect("error.jsp");
		}
	

}
}