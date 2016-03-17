<%@ page language="java" import="javax.servlet.*,javax.servlet.http.*,java.sql.*,java.io.*,java.util.* " %>

<html>

<body bgcolor="cyan" >

<form   action=" "  name="form1" method="post" >
  <div align="center"><font color="blue" size="5">WHMS</font> 
<p align="center">
  <p align="center"><font color="blue" size="4">Serviece Reports
<p>&nbsp;</p>
<% 

//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 //Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
 Class.forName("com.mysql.jdbc.Driver");
			  Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
 Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from servdet2 ");

 %>

<table border=1>
<tr><td><B>custcode</b></td>
<td><B>machid</b></td>
<td><B>Engid</b></td>
<td><b> ServDate</b></td>
<td><b> Status</b></td>

</tr>

<%  

  while(rs.next())  

  {

	%>
	<tr><td><%=rs.getInt(1)%></td><td><%=rs.getInt(2)%></td><td><%=rs.getString(3)%></td><td><%=rs.getString(4)%></td><td><%=rs.getString(5)%></td></tr> 
<% 

   }


%>

</table>

</div>
</form>
</body>
</html>
