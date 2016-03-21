import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CustDet2 extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
	    try
	         {
               
  	//HttpSession session=req.getSession();
	//int subinchargeid= Integer.parseInt(session.getAttribute("username").toString()); 
	int qty=0,it=0,flag=0,rno=1;
          
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	out.println("<html><body bgcolor=lightyellow><center><u><b>Customer Details</b></u>");
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
	Statement st=con.createStatement();
	
	out.println("<table border=2 bordercolor=red>");
	out.println("<tr><th>Customer Code </th><th>Name</th><th>Address</th><th>Phone</th></tr>");
    ResultSet rs=st.executeQuery("select * from custdetail" ); 
     while(rs.next())
       {
    	 out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(7)+"</td></tr>");
    	// out.println("<tr><td>"+rs.getString(2)+"</td>");
		//out.println("<tr><td>"+rs.getString(3)+"</td>");
	//	out.println("<td>"+rs.getInt(7)+"</td></tr>");
	}//while
		out.println("</table>");
		out.println("<a href=./blank.html>Home</a>");
		out.println("</center></body></html>");
             }//try
            catch(Exception e){e.printStackTrace();}
         }//service
}//main