import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

public class RetailerLogin extends HttpServlet
{
	  public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,java.io.IOException
	 {
	        int flag=0;
	        HttpSession session=req.getSession();
        
	       try
	         {
	   	resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
	   	String username=req.getParameter("username").trim();
        String password=req.getParameter("password").trim();
        
	   	if((username.equals(""))||(password.equals("")))
  		{
     			out.println("Login & pwd should not be null");
	     		resp.setHeader("Refresh","4;URL=./retailerlogin.html");
   		}//if
		else
    		{
     			//DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
				DriverManager.setLoginTimeout(5);
				//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     		//Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
				Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
		                 Statement stmt=con.createStatement();
		                 int retailerid=Integer.parseInt(req.getParameter("username").toString());
		                
   		                
ResultSet rs = stmt.executeQuery("select * from  retailer where  retailerid='"+retailerid+"' and password='"+password+"'");

			System.out.println(rs);
		                if(rs.next())
		                 {
		                      
		                       if(password.equals(rs.getString(2)))
			    {
				System.out.println("Retailer");
			                 session.setAttribute("username",username);
			                 session.setAttribute("pass",password);

		    		getServletContext().getRequestDispatcher("/mainpage13.html").forward(req,resp);
                                   			   //resp.sendRedirect("mainpage13.html");
			}//if

		               flag=1;
		              }//if

  	
	                     if(flag==0)
                  	     {   
 		     	out.println("Authentication failed!! due to invalid login or pwd");    
		   	resp.setHeader("Refresh","4;URL=./retailerlogin.html");
  	   	      }//if
                 }//else
	}//try
		catch(Exception e){e.printStackTrace();}
	}//service
}//class
