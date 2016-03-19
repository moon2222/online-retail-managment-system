<%@ page  language="java" import="java.sql.*,javax.servlet.*,javax.servlet.http.*,java.io.*,java.util.*" %>

<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body bgcolor="#FFFFFF" text="#000000">
<form action="./CallLogServlet" name="form17" method="post">
<% //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 //Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
  Class.forName("com.mysql.jdbc.Driver");
  Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
Statement stmt=con.createStatement();
 ResultSet rs=stmt.executeQuery("select  *from custdetail ");
 %>

<div align="center">
  <p><font size="5">CALL LOGGING FORM</font></p>
  <h4>give proper Customer & machine details</h4>
  <p align="center"><font size="5"> <font size="4">Custormer  & Machine Details </font></font></p>
  <table width="75%" border="0">
    <tr>
      <td>Customer Code</td>
      <td>
         <input type="text" name="ccode" value="">
          </td>
                        
      <td>Machine S.No.</td>
       <td>
        <input type="text" name="msno">
       </td>
  
  
  
  
  <table width="84%" border="1">
    <tr>  <td align="center">Machine Problem Details</td>
    <tr>
      <td width="31%">Problem ID</td>
      <td width="20%"> 
        <input type="text" name="probid">
      </td>
      <td width="24%">Status</td>
      <td width="25%"> 
        <input type="text" name="status" value="">
      </td>
    </tr>
    <tr>
      <td width="31%" height="64">Problem Category</td>
      <td width="20%" height="64"> 
        <input type="text" name="probcat">
      </td>
      <td width="24%" height="64">Problem Description</td>
      <td width="25%" height="64"> 
        <textarea name="probdesc"></textarea>
      </td>
    </tr>
    <tr>
      <td width="31%" height="17">Product</td>
      <td width="20%" height="17"> 
        <input type="text" name="product">
      </td>
      <td width="24%" height="17">&nbsp;</td>
      <td width="25%" height="17">&nbsp;</td>
    </tr>
  </table>
  <p align="center">&nbsp;</p>
  <p> 
    <input type="submit" name="Submit" value="Submit">
   
  </p>
  <p>&nbsp;</p>
  <p align="center">&nbsp; </p>
  </div>
</form>
</body>
</html>
