import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AddWareHouseStock1 extends HttpServlet
    {
   	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
 	{
	      
	      try
		{
		int i=0,j=0,flag=0;
                                 
		int itemno=Integer.parseInt(req.getParameter("s1").trim());
		int qty1=Integer.parseInt(req.getParameter("qty").trim());
		System.out.print("qty"+qty1);
	
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
	   // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
		
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     
		int k=st.executeUpdate("update warehousestock  set  qty=qty+"+qty1+"  where ITEMID="+itemno);  
		if(k==1)
		{	
			out.println("RecordUpdated");
			res.setHeader("Refresh","2;URL=./WareHouseStock.html");
		}
		else
		{
			PreparedStatement pstmt=con.prepareStatement("insert into warehousestock values(?,?)");
			pstmt.setInt(1,itemno);
		
			pstmt.setInt(2,qty1);
		             i=pstmt.executeUpdate();
			
			out.println("stock record inserted");
			res.setHeader("Refresh","2;URL=./blank.html");
			
			
		
		}
					
		}catch(Exception e){e.printStackTrace();}
	}
}
			