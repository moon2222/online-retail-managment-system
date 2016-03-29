import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;
public class WareHousePO extends HttpServlet
{
  	public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
  	{
		
   		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		System.out.println("hello");	
		out.println("<html><head><body bgcolor=lightyellow><center><b>WareHouse PurchaseOrder</b><br><br><table>");
		out.println("<form action=./WareHousePO1 method=post>");

		try
		{
			
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		     //           Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
			System.out.println("con");
			Statement stmt=con.createStatement();
			out.println("<tr><td>PurchaseOrderDate:</td><td><input type=text name=Wpdate></td></tr>");
			Statement stmt1=con.createStatement();
			ResultSet rs1=stmt1.executeQuery("select * from supplier");
			out.println("<tr><td>Supplier:</td><td><select name=s1>");
			while(rs1.next())
			{
				out.println("<option>"+rs1.getInt(1)+"</option>");
			}
			out.println("</select></td></tr>");
			System.out.println("rs1");
			 out.println("<tr><td>Cheque/DD:</td><td><input type=text name=Wcheque></td></tr>");
			Statement stmt2=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                       
			ResultSet rs2=stmt2.executeQuery("select * from ITEM");

			 rs2.beforeFirst();
                          out.println("<tr><td>ItemNo:</td><td><select name=s2>");
                                               
			   while(rs2.next())
			{
			out.println("<option>"+rs2.getInt(1)+"</option>");
                                        
                        }
                        out.println("</select></td></tr>");
                        rs2.beforeFirst();

                         out.println("<tr><td>ItemName:</td><td><select name=s3>");
                         
			   while(rs2.next())
			{
			out.println("<option>"+rs2.getInt(1)+"</option>");
                                        
                        out.println("<option>"+rs2.getString(2)+"</option>");
			}
                        out.println("</select></td></tr>");
			out.println("</select></td></tr>");
			System.out.println("rs2");
			out.println("<tr><td>Quantity:</td><td><input type=text name=Wqty></td></tr>");
			out.println("<tr><td align=middle><input type=submit name=sub value=AddPurchaOrder></td></tr>");
			out.println("</form></table></center></body></html>");
			}catch(Exception e){e.printStackTrace();}
	       }
}