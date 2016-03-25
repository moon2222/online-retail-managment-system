import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SubLocLogin extends HttpServlet
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
   	 int loginid=Integer.parseInt(username);
   	String password=req.getParameter("password").trim();
	System.out.println(username);
	System.out.println(password);
   	if((username.equals(""))||(password.equals("")))
  	{
     		out.println("Login & pwd should not be null");
     		resp.setHeader("Refresh","4;URL=./subloclogin.html");
   	}
	else
    	{
     		//DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
			DriverManager.setLoginTimeout(5);
     		//Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
                Statement stmt=con.createStatement();
         //int username1=Integer.parseInt(username); 
   		//ResultSet rs=stmt.executeQuery("select * from sublocationincharge where subinchargeid='"+username1+"'");
ResultSet rs = stmt.executeQuery("select * from sublocationincharge where subinchargeid='"+loginid+"' and password='"+password+"'");

   		
    		if(rs.next())
                 {
 if(password.equals(rs.getString(2)))
                  {
                    //(Object)username;

                 session.setAttribute("username",username);
                 session.setAttribute("pass",password);
    		getServletContext().getRequestDispatcher("/mainpage12.html").forward(req,resp);
    		   }
               flag=1;
              }//while

  	
                     if(flag==0)
                       {   
 		     	out.println("Authentication failed!! due to invalid login or pwd");    
		   	resp.setHeader("Refresh","4;URL=./subloclogin.html");
  	   	      }
                 }
	}catch(Exception e){e.printStackTrace();}
	}
}