import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ViewRetailer extends HttpServlet
{
       public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
         {
       try
	{
           res.setContentType("text/html");
	    PrintWriter out=res.getWriter();
	    //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     //Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
	     Statement st=con.createStatement();
	     ResultSet rs=st.executeQuery("select * from retailer");
	  out.println("<html><body bgcolor=lightyellow><table border=2>");
	out.println("<tr><th>RetNo</th><th>RetName</th><th>Hno</th><th>Street</th><th>city</th><th>State</th><th>Country</th><th>PhNo</th><th>E-mail</th></tr>");	     
	  
	while(rs.next())
	     {
                out.println("<tr><td>"+rs.getInt(1)+"</td>");
		out.println("<tr><td>"+rs.getInt(2)+"</td>");
		
                out.println("<td>"+rs.getString(4)+"</td>");
		out.println("<td>"+rs.getString(5)+"</td>");
		out.println("<td>"+rs.getString(6)+"</td>");
		out.println("<td>"+rs.getString(7)+"</td>");
		out.println("<td>"+rs.getString(8)+"</td>");
		out.println("<td>"+rs.getString(9)+"</td>");
		out.println("<td>"+rs.getString(10)+"</td>");
		out.println("<td>"+rs.getString(11)+"</td></tr>");
	}
             out.println("</table>");
	     out.println("<a href=blank.html>Home</a>"); 	
	out.println("</body></html>");
	}catch(Exception e){e.printStackTrace();}
     }
}
