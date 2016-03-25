import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class RetailerPO1 extends HttpServlet
{
  	public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
  	{
	try
	{
         int sliid=0;
          HttpSession session=req.getSession();
          int retailerid= Integer.parseInt(session.getAttribute("username").toString());
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	String podate=req.getParameter("Retailerdate");
        System.out.println(podate);
	String cheno=req.getParameter("Retailercheque");
        System.out.println(cheno);
	int itemno=Integer.parseInt(req.getParameter("s2"));
	int qty=Integer.parseInt(req.getParameter("Retailerqty"));
		
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
	Statement stmt=con.createStatement();	
        Statement stmt1=con.createStatement();
        ResultSet rs1=stmt1.executeQuery("Select * from retailer where retailerid="+retailerid);
        if(rs1.next())
         // sliid=rs1.getInt(1);
          f=0; 	
	int RPOID=0;
			
		
			ResultSet rs=stmt.executeQuery("select max(RPOID) from retailerpayment");
			if(rs.next())
			{
				
				RPOID=rs.getInt(1);
				RPOID++;
				
				
			}
			else
			{
				RPOID=1;
			}
			
	if((podate.equals(null))&&(cheno.equals(null))&&(qty==0))
	{
    	out.println("filds should not null");
    	resp.setHeader("Refresh","2;URL=./RetailerPO");
	}
	else	
	{    
	f=1;	
	PreparedStatement pstmt=con.prepareStatement("insert into retailerpurchaseorder values(?,?,?,?)");
			System.out.println("pstmt");
               			pstmt.setInt(1,retailerid);
			pstmt.setInt(2,RPOID);
			System.out.println("id");
			pstmt.setInt(3,itemno);
			System.out.println("no");
			pstmt.setInt(4,qty);
			System.out.println("qty");
			pstmt.executeUpdate();
	PreparedStatement pstmt1=con.prepareStatement("insert into retailerpayment values(?,?,?,?)");
		System.out.println("pstmt1");
		pstmt1.setInt(1,RPOID);
		System.out.println("id1");
                pstmt1.setInt(2,retailerid);
		pstmt1.setString(3,podate);
		System.out.println("date");
		
		pstmt1.setString(4,cheno);
		System.out.println("cno");
		pstmt1.executeUpdate();
		             
		}
		if(f==1)
		{
                                     out.println("Purchase order"+RPOID);
		     resp.setHeader("Refresh","2;URL=./blank.html");
		}
				
	}catch(Exception e){e.printStackTrace();}	
			               
		
         }
int f;
}	
