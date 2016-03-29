import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewSubLocStock extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
	    try
	         {
               
  	//HttpSession session=req.getSession();
	//int subinchargeid= Integer.parseInt(session.getAttribute("username").toString()); 
	int qty=0,it=0,flag=0,rno=1;
          
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	out.println("<html><body bgcolor=lightyellow><center><u><b>Stock Details</b></u>");
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
	Statement st=con.createStatement();
	
	out.println("<table border=2 bordercolor=red>");
	out.println("<tr><th>ITEMID</th><th>Quantity</th></tr>");

	//-------------------------
	/*
	ResultSet rs=st.executeQuery("select * from sublocationstock");    //where SLIID="+subinchargeid
      // where SLIID="+subinchargeid

                 Statement stmt4=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                 ResultSet rs4=stmt4.executeQuery("select * from sublocationstock");                 // where ID="+subinchargeid
                 rs.beforeFirst();
                 rs3.absolute(rno);
                 while(rs.next())
                  {
                     rs.absolute(rno);
                     it=rs.getInt(1);
                    System.out.println(it);
                    qty=rs.getInt(2); 
                    System.out.println(qty);
                    while(rs3.next())
	                         {
                               if(it==rs3.getInt(1))
                          {
                              qty=qty+rs3.getInt(2);
                              System.out.println(qty);
                              while(rs4.next())
     	                   stmt1.executeUpdate("delete from sublocationstock");

                  	 PreparedStatement pstmt=con.prepareStatement("INSERT INTO sublocationstock VALUES(?,?)");                      
   		 pstmt.setInt(1,it);
		 pstmt.setInt(2,qty);
		 pstmt.executeUpdate();
	       }//if
                   }//while
                rno++;
                rs3.absolute(rno);
              }//while    
                        */ 
	 //-----------------------------------
                ResultSet rs=st.executeQuery("select * from slpurchaseorder" ); 
                while(rs.next())
                 {
		out.println("<tr><td>"+rs.getInt(2)+"</td>");
		out.println("<td>"+rs.getInt(3)+"</td></tr>");
	}//while
		out.println("</table>");
		//out.println("<a href=./blank.html>Home</a>");
		out.println("</center></body></html>");
             }//try
            catch(Exception e){e.printStackTrace();}
         }//service
}//main