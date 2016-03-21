import java.sql.*;
import java.io.*;
public class Demo
{
    public Statement stmt;
    public ResultSet res;
    public Connection con;
 public static void main(String rags[])throws SQLException,IOException
  {
      try {
          Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      }
      //DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
      DriverManager.setLoginTimeout(5);
        //Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");

      Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=shashank@96M");
	   Statement stmt3=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs3=stmt3.executeQuery("select * from sublocationstock where SLIID="+1);
         while(rs3.next())
          {
           System.out.println(rs3.getInt(1));
          }
   }
}