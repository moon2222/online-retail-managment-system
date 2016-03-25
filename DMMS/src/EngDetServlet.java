import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class EngDetServlet extends HttpServlet
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
// Class.forName("oracle.jdbc.driver.OracleDriver");
 //con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ind//ia","scott","tiger");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
 stmt=con.createStatement();


 String empid=request.getParameter("empid");
 String empname=request.getParameter("empname");
 String deptid=request.getParameter("deptid");
 String  jobcat=request.getParameter("jobcat");
 String  action=request.getParameter("action");

 PreparedStatement ps=con.prepareStatement("insert into engdet2 values(?,?,?,?,?)");
 System.out.println(ps);   
    ps.setString(1,empid);
    ps.setString(2,empname);
    ps.setString(3,deptid);
    ps.setString(4,jobcat);
    ps.setString(5,action);
    
    ps.executeUpdate(); 
}
catch(Exception cnfe)
{
System.out.println(cnfe);
}

response.sendRedirect("Succ_Off_Create.jsp");
}
}