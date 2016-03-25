import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class ServieceServlet extends HttpServlet
{
Connection con;
Statement stmt;

public  void init(ServletConfig  config) throws ServletException
{
super.init(config);
}
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
{
doPost(request,response);
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
{
response.setContentType("text/html");
PrintWriter out=response.getWriter();

try
{
//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
//Class.forName("oracle.jdbc.driver.OracleDriver");
 //con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ind//ia","scott","tiger");
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=shashank@96M");
 stmt=con.createStatement();


int custid=Integer.parseInt(request.getParameter("custid"));
int machid=Integer.parseInt(request.getParameter("machid"));
String engid=request.getParameter("engid");
String date=request.getParameter("date");
String  status=request.getParameter("status");

 PreparedStatement ps=con.prepareStatement("insert into servdet2 values(?,?,?,?,?)");
 System.out.println(ps);   
    ps.setInt(1,custid);
    ps.setInt(2,machid);
    ps.setString(3,engid);
    ps.setString(4,date);
    ps.setString(5,status);
    
    ps.executeUpdate(); 
}
catch(Exception cnfe)
{
System.out.println(cnfe);
}

response.sendRedirect("Succ_Off_Create.jsp");
}
}