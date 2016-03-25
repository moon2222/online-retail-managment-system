import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Mechdet2 extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
	    try
	         {
               
  	
	
          
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	out.println("<html><body bgcolor=lightyellow><center><u><b>Customer Details</b></u>");
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
	Statement st=con.createStatement();
	
	out.println("<table border=2 bordercolor=red>");
	out.println("<tr><th>Mechine NO</th><th>Customer Code</th><th>Date</th><th>Status</th><th>AMCV</th></tr>");
    ResultSet rs=st.executeQuery("select * from machinedetail"); 
     while(rs.next())
       {
    	 out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(12)+"</td></tr>");
    	
	}//while
		out.println("</table>");
		out.println("<a href=./blank.html>Home</a>");
		out.println("</center></body></html>");
             }//try
            catch(Exception e){e.printStackTrace();}
         }//service
}//main