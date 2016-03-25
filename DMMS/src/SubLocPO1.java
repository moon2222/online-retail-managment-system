import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class SubLocPO1 extends HttpServlet
{
  	public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
  	{
	try
	{
          
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	String podate=req.getParameter("SubLocdate");
	String cheno=req.getParameter("SubLoccheque");
	int itemno=Integer.parseInt(req.getParameter("s2"));
	int qty=Integer.parseInt(req.getParameter("SubLocqty"));
		
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
	Statement stmt=con.createStatement();	
                int flag=0; 	
	int SUBPOID=0;
			
		
			ResultSet rs=stmt.executeQuery("select max(SUBPOID) from slpayment");
			if(rs.next())
			{
				
				SUBPOID=rs.getInt(1);
				SUBPOID++;
				
				
			}
			else
			{
				SUBPOID=1;
			}
			
	if((podate.equals(null))&&(cheno.equals(null))&&(qty==0))
	{
    	out.println("filds should not null");
    	resp.setHeader("Refresh","2;URL=./SubLocPO");
	}
	else	
	{    
	flag=1;	
	PreparedStatement pstmt=con.prepareStatement("insert into slpurchaseorder values(?,?,?)");
			System.out.println("pstmt");
			pstmt.setInt(1,SUBPOID);
			System.out.println("id");
			pstmt.setInt(2,itemno);
			System.out.println("no");
			pstmt.setInt(3,qty);
			System.out.println("qty");
			pstmt.executeUpdate();
	PreparedStatement pstmt1=con.prepareStatement("insert into slpayment values(?,?,?)");
		System.out.println("pstmt1");
		pstmt1.setInt(1,SUBPOID);
		System.out.println("id1");
             
		pstmt1.setString(2,podate);
		System.out.println("date"+podate);
		pstmt1.setString(3,cheno);
		System.out.println("cno");
		pstmt1.executeUpdate();
		             
		}
		if(flag==1)
		{
                                     out.println("<h3>Purchase order</h3>"+SUBPOID);
		     resp.setHeader("Refresh","2;URL=./blank.html");
		}
				
	}catch(Exception e){e.printStackTrace();}	
			               
		
         }
}	