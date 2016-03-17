import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddSubLocRetailer extends HttpServlet
{
  	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
  	{
   		resp.setContentType("text/html");
	                 PrintWriter out=resp.getWriter();
                                	String cpass=req.getParameter("Cpassword");
    		String name=req.getParameter("Name");
		String house=req.getParameter("House");
		String street=req.getParameter("Street");
		String city=req.getParameter("City");
		String state=req.getParameter("State");
		String country=req.getParameter("Country");
		String phone=req.getParameter("Phone");
		String email=req.getParameter("Email");
		
		try
		{
						//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		       // Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");

			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        //Connection //con=DriverManager.getConnection("jdbc:odbc:sai","scott","tiger");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
			
			Statement stmt=con.createStatement();
			int RETAILERID=0;
			ResultSet rs=stmt.executeQuery("select max(RETAILERID) from retailer");
			System.out.println("rs");
			if(rs.next())
			{
				RETAILERID=rs.getInt(1);
				RETAILERID++;
				
				System.out.println("id"+RETAILERID);
			}
			else
			{
				RETAILERID=1;
			}
			
			 PreparedStatement pstmt=con.prepareStatement("insert into retailer values(?,?,?,?,?,?,?,?,?,?)");
			System.out.println("pstmt");
            			//pstmt.setInt(1,subinchargeid);                       

			pstmt.setInt(1,RETAILERID);
			
			pstmt.setString(2,cpass);
			
			pstmt.setString(3,name);

			pstmt.setString(4,house);
			
			pstmt.setString(5,street);
			
			pstmt.setString(6,city);
			
			pstmt.setString(7,state);
			
			pstmt.setString(8,country);
			
			pstmt.setString(9,phone);
			
			pstmt.setString(10,email);
			
			int i=pstmt.executeUpdate();
			System.out.println("record inserted");
			if(i==1)
			{
				out.println("Data Register");
				out.println("your id is "+RETAILERID);
				resp.setHeader("Refresh","2;URL=./blank.html");
								
				}
			else
			{
				out.println("Data not Register ");

				resp.setHeader("Refresh","2;URL=./AddSubLocRetailer");
			}
			
			rs.close();
			pstmt.close();
			stmt.close();
			con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
	