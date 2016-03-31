<%@ page language="java" import ="java.sql.*"%>
 <html>
 <head>
 <title>Untitled Document</title>
 </head>
 <body bgcolor="#CCCCCC" text="#000000">
 <%!Connection con;;%>
 <%!ResultSet rs;%>
 <%!Statement st;%>

 <%   
	   //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 	   //con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
     Class.forName("com.mysql.jdbc.Driver");
     Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
 	   st=con.createStatement();
 	   rs=st.executeQuery("select *from custdetail"); 	
 %>
 
<div align="center"> 
  <h2><font face="Arial, Helvetica, sans-serif" color="#993300">Customer  
    Details</font> </h2>
  
  
    <table width="101%" border="1" bordercolor="#9966FF">
      <tr> 
        <td width="9%" height="25"> <div align="center">CustomerCode</div></td>
        <td width="8%"><div align="center">Customer Name</div></td>
        <td width="11%"><div align="center">Address</div></td>
        <td width="10%"><div align="center">City</div></td>
        <td width="14%"><div align="center">Phone No </div></td>
        
      </tr>
      <% while(rs.next()){%>
      <tr> 
        <td height="24">&nbsp;<%=rs.getInt(1)%></td>
        <td>&nbsp;<%=rs.getInt(2)%></td>
        <td>&nbsp;<%=rs.getString(3)%></td>
        <td>&nbsp;<%=rs.getDouble(5)%></td>
        <td>&nbsp;<%=rs.getString(7)%></td>
        
      </tr>
      <%}%>
    </table>
    <p>&nbsp; </p>
  </form>
  <h2 align="left">&nbsp;</h2>
  
</div>
</body>
</html>

