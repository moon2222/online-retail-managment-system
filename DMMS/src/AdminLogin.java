import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AdminLogin extends HttpServlet
{
   public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
      HttpSession session = req.getSession();
      RequestDispatcher disp = getServletContext().getRequestDispatcher("/mainpage11.html");
      try
      {
        resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
        String username=req.getParameter("username");
System.out.println("username is"+username);
        String pass=req.getParameter("password");
System.out.println("password is "+pass);

          int flag=0;
         //Boolean flag=new Boolean(true);
        if((username.equals(""))||(pass.equals("")))
  	{
     		out.println("Login & pwd should not be null");
     		resp.setHeader("Refresh","4 URL=./adminlogin.html");
          flag=1;
   	}
         if(flag==0)
         {
       // DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
      // DriverManager.setLoginTimeout(5);
        //Connection con = DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
             Class.forName("com.mysql.jdbc.Driver");
             Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from adminlogin where username='"+username+"' and password='"+pass+"'");

        if(rs.next())

        {
            session.setAttribute("username",username);
            session.setAttribute("password",pass); 
           // session.setAttribute("flag",flag);
             disp.forward(req,resp);
        }//if
        else
  	   	{
		     	out.println("Authentication failed!! due to invalid login or pwd");    
		   	resp.setHeader("Refresh","4 URL=./adminlogin.html");
  	   	}
       
      }//try
     }//if 
      catch(Exception e)
      {
            e.printStackTrace();
      }//catch
   }//service
}
