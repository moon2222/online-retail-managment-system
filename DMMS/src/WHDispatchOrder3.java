import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import javax.sql.*;
public class WHDispatchOrder3 extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
   {
     resp.setContentType("text/html");
     //String id1=req.getParameter("op1");
     int id=Integer.parseInt(req.getParameter("s1"));
     String WHSalesDate=req.getParameter("WAREHOUSESALESDATE");
     String ShipmentDes=req.getParameter("SHIPEMENTDES");
     int a=0,b=0,c=0,d=0,f=0,flag=0,found=0,xid=0,k=0,l=0,m=0;
	System.out.println("id"+id);
     PrintWriter out=resp.getWriter();
    try
     {
       // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       // Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
         Class.forName("com.mysql.jdbc.Driver");
         Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
        System.out.println("..............."+con);
	Statement stmt=con.createStatement();
        Statement stmt1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        Statement stmt2=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        System.out.println(WHSalesDate);
        System.out.println(ShipmentDes);
         int i=stmt.executeUpdate("Update warehousesalesorder SET WAREHOUSESALESDATE='"+WHSalesDate+"',SHIPMENTDES='"+ShipmentDes+"'WHERE SLPOID="+id);
        ResultSet rs1=stmt1.executeQuery("select * from warehousesalesorder where SLPOID="+id);
        
          rs1.beforeFirst();
         if(rs1.next())
          {
          a=rs1.getInt(4);
         b=rs1.getInt(5);
          }
        ResultSet rs2=stmt2.executeQuery("select * from slpayment where SLPOID="+id);
          rs2.next();
         System.out.println("no of rows in slpayment:"+rs2.getRow());
        rs2.beforeFirst();
         if(rs2.next())
          {
         c=rs2.getInt(2);
          }
                           
         
         PreparedStatement pstmt=con.prepareStatement("INSERT INTO sublocationstock VALUES(?,?,?)");                      
         pstmt.setInt(1,c);
         pstmt.setInt(2,a);
         pstmt.setInt(3,b);
         pstmt.executeUpdate();
         
                                    
         int j=stmt.executeUpdate("delete from slpayment WHERE SLPOID="+id);
        System.out.println("Deleted id has selected");
	if((i==1)&&(j==1))
	{
  		out.println("Dispatched successfully");
		resp.setHeader("Refresh","2;URL=./blank.html");
	
	}
	else
 	{
  		out.println("Dispatch failed");
		resp.setHeader("Refresh","2;URL=./choosesup.html");
	}
              
	out.close();
	stmt.close();
	con.close();
 	}catch(Exception e){e.printStackTrace();}
   }
}
