import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class CustDetServlet extends HttpServlet
{
Connection con;
Statement stmt;
int i=0;

 /*public  void init(ServletConfig  config) throws ServletException
{
super.init(config);
}*/
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
{
response.setContentType("text/html");
PrintWriter out=response.getWriter();

  try
  {
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 //con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
      Class.forName("com.mysql.jdbc.Driver");
      Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
 System.out.println("driver");
 stmt=con.createStatement();


int custcode=Integer.parseInt(request.getParameter("custcode").trim());
String custname=request.getParameter("custname").trim();
String address1=request.getParameter("address1").trim();
String  address2=request.getParameter("address2").trim();
String  city=request.getParameter("city").trim();
String district=request.getParameter("district").trim();
int telno=Integer.parseInt(request.getParameter("telno").trim());

   PreparedStatement ps=con.prepareStatement("insert into custdetail values(?,?,?,?,?,?,?)");
System.out.println(ps);   
    ps.setInt(1,custcode);
    ps.setString(2,custname);
    ps.setString(3,address1);
    ps.setString(4,address2);
    ps.setString(5,city);
    ps.setString(6,district);
    ps.setInt(7,telno);

   i=ps.executeUpdate(); 
    if(i==1)
    {
    out.println("Data Registered");
     //response.setHeader("Refresh","2,URL=./blank.htm");
    }
}
catch(Exception e)
{
System.out.println(e);
}

//response.sendRedirect("Succ_Off_Create.jsp");
}
}