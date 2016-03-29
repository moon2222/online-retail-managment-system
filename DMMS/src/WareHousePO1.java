import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class WareHousePO1 extends HttpServlet
{
  	public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
  	{
	try
	{
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	String podate=req.getParameter("Wpdate");
	int supid=Integer.parseInt(req.getParameter("s1"));
	String cheno=req.getParameter("Wcheque");
	int itemno=Integer.parseInt(req.getParameter("s2"));
	int qty=Integer.parseInt(req.getParameter("Wqty"));
		
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
	Statement stmt=con.createStatement();	
                int flag=0; 	
	int WPOID=0;
			
		
			ResultSet rs=stmt.executeQuery("select max(WPOID) from warehousepurchaseorder");
			if(rs.next())
			{
				
				WPOID=rs.getInt(1);
				WPOID++;
				
				System.out.println("id"+WPOID);
			}
			else
			{
				WPOID=1;
			}
			
	if((podate.equals(null))&&(cheno.equals(null))&&(qty==0))
	{
    	out.println("filds should not null");
    	resp.setHeader("Refresh","2;URL=./WareHousePO");
	}
	else	
	{    
	flag=1;	
	PreparedStatement pstmt=con.prepareStatement("insert into warehousepurchaseorder values(?,?,?)");
			System.out.println("pstmt");
			pstmt.setInt(1,WPOID);
			pstmt.setInt(2,itemno);
			pstmt.setInt(3,qty);
			pstmt.executeUpdate();
	PreparedStatement pstmt1=con.prepareStatement("insert into warehousepayment values(?,?,?,?)");
		System.out.println("pstmt1");
		pstmt1.setInt(1,WPOID);
		pstmt1.setString(2,podate);
		pstmt1.setInt(3,supid);
		pstmt1.setString(4,cheno);
		pstmt1.executeUpdate();
		             
		}
		if(flag==1)
		{
                                     out.println("Purchase order"+WPOID);
		     resp.setHeader("Refresh","2;URL=./blank.html");
		}
				
	}catch(Exception e){e.printStackTrace();}	
			               
		
         }
}	