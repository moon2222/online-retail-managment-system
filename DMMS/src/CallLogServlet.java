import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class CallLogServlet extends HttpServlet
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
 stmt=con.createStatement();


int probid=Integer.parseInt(request.getParameter("probid"));
String status=request.getParameter("status");
String probcat=request.getParameter("probcat");
String  probdesc=request.getParameter("probdesc");
String  prod=request.getParameter("product");
int custcode=Integer.parseInt(request.getParameter("ccode"));
int machslno=Integer.parseInt(request.getParameter("msno"));


PreparedStatement ps=con.prepareStatement("insert into problemdetail values(?,?,?,?,?,?,?)");
System.out.println(ps);   
    ps.setInt(1,probid);
    ps.setString(2,status);
    ps.setString(3,probcat);
    ps.setString(4,probdesc);
    ps.setString(5,prod);
    ps.setInt(6,custcode);
    ps.setInt(7,machslno);

    i=ps.executeUpdate(); 
     if(i==1)
     {
    	  out.println("successfully inserted");
    	  response.setHeader("Refresh","2;URL=./service.jsp");
     }
}
catch(Exception cnfe)
{
System.out.println(cnfe);
}


}
}