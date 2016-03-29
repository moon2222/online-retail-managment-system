import java.io.*;
import java.sql.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class WareHouseSales extends HttpServlet
{
    public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
            int a=0,b=0,c=0,d=0,f=0,p=0,q=0;
      	try
		      {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body bgcolor=lightyellow><center><font color=red><b><u>WareHouse SalesOrder</b></u></font><br><br>");
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
System.out.println("con:"+con);
		Statement st=con.createStatement();
System.out.println("st:"+st);
	 	ResultSet rs=st.executeQuery("select * from warehousestock");
		Statement st1=con.createStatement();
		ResultSet rs1=st1.executeQuery("select * from slpurchaseorder");
	             Statement st2=con.createStatement();
		Statement st3=con.createStatement();
System.out.println("slpo");
		//rs1.beforeFirst();
		while(rs1.next())
		{
System.out.println("s");
		//rs.beforeFirst();
	             c=rs1.getInt(1);
		a=rs1.getInt(2);
             		b=rs1.getInt(3);
System.out.println("before inner while");
		while(rs.next())
		{
	     	d=rs.getInt(1);
                  	f=rs.getInt(2);
System.out.println("hai");
		if((a==d)&&(b<=f))
		{
System.out.println("hello");
			    f=f-b;
	       st2.executeUpdate("update warehousestock set QTY="+f+"WHERE  ITEMID="+d);                                       
                        PreparedStatement pstmt=con.prepareStatement("insert into warehousesalesorder values(?,?,?,?,?)");
System.out.println("before s");
                  	                 pstmt.setInt(1,c);
                          		pstmt.setString(2,"");
                          		pstmt.setString(3,"");
	                                    pstmt.setInt(4,a);
	                                    pstmt.setInt(5,b); 
                  	                 pstmt.executeUpdate();
                        st3.executeUpdate("delete from slpurchaseorder WHERE SUBPOID="+c);          
                        // rs=st.executeQuery("select * from warehousestock");
                }
                   
   System.out.println("p"+p);
	                p++;
 System.out.println(rs);
              }//in while
		rs.beforeFirst();
		q++;
		System.out.println("q"+q);
	}//out while	
                                out.println("<li><a href=./WHPendingOrder2>View Pending Orders</a></li><br>");
                                out.println("<li><a href=./WHDispatchOrder2>View Dispatched Orders</a></li><br>");
	              out.println("<li><a href=blank.html>Home</a></li>");  	
	              out.println("</form></center></body></html>");	
	            }catch(Exception e){e.printStackTrace();}
	}//service
}
