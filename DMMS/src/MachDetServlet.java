import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class MachDetServlet extends HttpServlet
{
Connection con;
Statement stmt;
int i=0;
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
    Class.forName("com.mysql.jdbc.Driver");
    Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
//Class.forName("oracle.jdbc.driver.OracleDriver");
 //con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ind//ia","scott","tiger");
 stmt=con.createStatement();


int machslno=Integer.parseInt(request.getParameter("machslno"));
String machloc=request.getParameter("machloc");
int custcode=Integer.parseInt(request.getParameter("custcode"));
int refno=Integer.parseInt(request.getParameter("refno"));
String  instaldate=request.getParameter("instaldate");
String  status=request.getParameter("status");
String expdate=request.getParameter("expdate");
String modelid=request.getParameter("modelid");
String sitecond=request.getParameter("sitecond");
String countread=request.getParameter("countread");
String stab=request.getParameter("stab");
String amcv=request.getParameter("amcv");

   PreparedStatement ps=con.prepareStatement("insert into machinedetail values(?,?,?,?,?,?,?,?,?,?,?,?)");
System.out.println(ps);   
    ps.setInt(1,machslno);
    ps.setString(2,machloc);
    ps.setInt(3,custcode);
    ps.setInt(4,refno);
    ps.setString(5,instaldate);
    ps.setString(6,status);
    ps.setString(7,expdate);
    ps.setString(8,modelid);
    ps.setString(9,sitecond);
    ps.setString(10,countread);
    ps.setString(11,stab);
    ps.setString(12,amcv);

  i=ps.executeUpdate();
   if(i==1)
   {
   out.print("machinedetails are inserted ");	
    
   }
}
catch(Exception cnfe)
{
System.out.println(cnfe);
}

//response.sendRedirect("Succ_Off_Create.jsp");
}
}