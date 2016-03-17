<%@ page language="java" import="javax.servlet.*,javax.servlet.http.*,java.sql.*,java.io.*,java.util.* " %>

<html>

<body bgcolor="cyan" >

<form   action=" "  name="form1" method="post" >
  <div align="center"><font color="blue" size="5">DMMS</font> 
<p align="center">
  <p align="center"><font color="blue" size="4">Call Loging Reports
<p>&nbsp;</p>
<% 
//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
// Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
 Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select *from problemdetail ");

 %>

<table border=1>
<tr><td><B>Customer Code</b></td>
<td><B>Machine Id</b></td>
 <td><B>Problem Cat</b></td>
 <td><B>Product</b></td>
<td><B></b>Problem Description</td>
<td><b> status</b></td>


</tr>

<%  

  while(rs.next())  

  {

	%>
	<tr><td><%=rs.getInt(6)%></td><td><%=rs.getInt(7)%></td><td><%=rs.getString(3)%></td><td><%=rs.getString(5)%></td><td><%=rs.getString(4)%></td><td><%=rs.getString(2)%></td></tr> 
<% 

   }


%>

</table>

</div>
</form>
</body>
</html>
