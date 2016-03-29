import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ViewWareHouseStock extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
	    try
	         {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body bgcolor=lightyellow><center><u><b>Stock Details</b></u>");
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
		Statement st=con.createStatement();
		out.println("<table border=1 bordercolor=red>");
		out.println("<tr><th>ITEMID</th><th>Quantity</th></tr>");
		ResultSet rs=st.executeQuery("select * from warehousestock");
		while(rs.next())
		{
		out.println("<tr><td>"+rs.getInt(1)+"</td>");
		out.println("<td>"+rs.getInt(2)+"</td></tr>");
		}
		out.println("</table>");
		out.println("<a href=./WareHouseStock.html>back</a>");
		out.println("</center></body></html>");
		}catch(Exception e){e.printStackTrace();}
	}
}