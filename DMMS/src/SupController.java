import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class SupController extends HttpServlet
{
  	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
  	{
   		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		//String id=req.getParameter("s1");
    		String name=req.getParameter("Name");
		System.out.println(name);
		int phone=Integer.parseInt(req.getParameter("Phone"));
                                System.out.println(phone);
		String email=req.getParameter("Email");
		System.out.println(email);
		String house=req.getParameter("House");
		System.out.println(house);
		String street=req.getParameter("Street");
		System.out.println(street);
		String city=req.getParameter("City");
		System.out.println(city);
		String country=req.getParameter("Country");
		try
		{
			
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    //    Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");

			//new oracle.jdbc.driver.OracleDriver();
			  //Connection con=DriverManager.getConnection("jdbc:oracle:thin:@active:1521:active","scott","tiger");
			//System.out.println("con");
			Statement stmt=con.createStatement();
			int SUPPLIERID=0;
			ResultSet rs=stmt.executeQuery("select max(SUPPLIERID) from supplier");
			System.out.println("rs");
			if(rs.next())
			{
				SUPPLIERID=rs.getInt(1);
				SUPPLIERID++;
				//out.println("<html><body><form action='./AddSupplier.html'><select name=s1><option name=op1>"+rs.getString(s1)+"</option></select>");
				//out.println("</form></body></html>");			
				System.out.println("id"+SUPPLIERID);
			}
			else
			{
				SUPPLIERID=1;
			}
			PreparedStatement pstmt=con.prepareStatement("insert into supplier values(?,?,?,?,?,?,?,?)");
			System.out.println("pstmt");
			pstmt.setInt(1,SUPPLIERID);
			pstmt.setString(2,name);
			pstmt.setInt(3,phone);
			pstmt.setString(4,email);
			pstmt.setString(5,house);
			pstmt.setString(6,street);
			pstmt.setString(7,city);
			pstmt.setString(8,country);
			int i=pstmt.executeUpdate();
			if(i==1)
			{
				out.println("Data Register"+SUPPLIERID);
				resp.setHeader("Refresh","2 URL=./choosesup.html");
				
				
								
				}
			else
			{
				out.println("Data not Register  ");
				resp.setHeader("Refresh","2 URL=./blank.html");
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
	