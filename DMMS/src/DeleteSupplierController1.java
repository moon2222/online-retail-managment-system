import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class DeleteSupplierController1 extends HttpServlet
{
  public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
   {
     resp.setContentType("text/html");
    String id1=req.getParameter("number");
     int id=Integer.parseInt(id1.trim());
     PrintWriter out=resp.getWriter();
Statement stmt;
    try
     {
      //new sun.jdbc.odbc.JdbcOdbcDriver();
         DriverManager.setLoginTimeout(5);
  //Connection con=DriverManager.getConnection("jdbc:odbc:whms","whms","whms");
         Class.forName("com.mysql.jdbc.Driver");
         Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
System.out.println("con");
 stmt=con.createStatement();
int i=stmt.executeUpdate("delete supplier where SUPPLIERID="+id+"");

if(i==1)
{
  out.println("deletion successfull");
}
else
 {
  out.println("deletion failed,no matching supplier found");
}
out.close();
stmt.close();
con.close();
 }catch(Exception e){}
}//method
}//class