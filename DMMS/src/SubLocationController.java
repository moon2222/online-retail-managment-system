import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class SubLocationController extends HttpServlet
{
  	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
  	{
   		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
    		String pass=req.getParameter("password");
		System.out.println(pass);
		String name=req.getParameter("Name");
		String house=req.getParameter("House");
		String street=req.getParameter("Street");
		String city=req.getParameter("City");
		int phone=Integer.parseInt(req.getParameter("Phone"));
                System.out.println(phone);
		String email=req.getParameter("Email");
		String state=req.getParameter("State");
		String country=req.getParameter("Country");
		String location=req.getParameter("Location");
		int maxretailers=Integer.parseInt(req.getParameter("MaxnoOfRetailers"));
		try
		{
			
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		     //   Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
			Statement stmt=con.createStatement();
			int SUBINCHARGEID=0;
			ResultSet rs=stmt.executeQuery("select max(SUBINCHARGEID) from sublocationincharge");
			if(rs.next())
			{
				SUBINCHARGEID=rs.getInt(1);
				SUBINCHARGEID++;
				System.out.println("id"+SUBINCHARGEID);
			}
			else
			{
				SUBINCHARGEID=1;
			}
			 PreparedStatement pstmt=con.prepareStatement("insert into sublocationincharge values(?,?,?,?,?,?,?,?,?,?,?,?)");
			System.out.println("pstmt");
			pstmt.setInt(1,SUBINCHARGEID);
			pstmt.setString(2,pass);
			pstmt.setString(3,name);
	System.out.println("insert name into table");
			pstmt.setString(4,house);
			pstmt.setString(5,street);
			pstmt.setString(6,city);
	System.out.println("insert city into table");			
			pstmt.setInt(7,phone);
			pstmt.setString(8,email);
			pstmt.setString(9,state);
			pstmt.setString(10,location);
			pstmt.setInt(11,maxretailers);
			pstmt.setString(12,country);
			int i=pstmt.executeUpdate();
			if(i==1)
			{
				out.println("Data Register");
				out.println("your id is "+SUBINCHARGEID);
				resp.setHeader("Refresh","2;URL=./choosesublocation.html");
								
				}
			else
			{
				out.println("Data not Register ");
				resp.setHeader("Refresh","2;URL=./choosesublocation.html");
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
	