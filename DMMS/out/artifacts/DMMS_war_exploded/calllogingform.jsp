<%@ page  language="java" import="java.sql.*,javax.servlet.*,javax.servlet.http.*,java.io.*,java.util.*" %>

<html>
<head>
<title>Untitled Document</title>
<script language="javascript">
function check()
{
document.form17.action="./calllogingforms.jsp";
document.form17.submit();
}
</script>
</head>

<body bgcolor="#FFFFFF" text="#000000">
<form action="./CallLogServlet" name="form17" method="post">
<% //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 //Connection con=DriverManager.getConnection("jdbc:odbc:dmms","dmms","dmms");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dmms?user=root&password=shashank@96M");
 Statement stmt=con.createStatement();
 ResultSet rs=stmt.executeQuery("select custcode  from custdet2 ");
 %>

<div align="center">
  <p><font size="5">CALL LOGGING FORM</font></p>
  <p align="center"><font size="5"> <font size="4">Custormer  & Machine Details </font></font></p>
  <table width="75%" border="0">
    <tr>
      <td>Customer Code</td>
      <td>
        <select name="custcode" onBlur="check()">
       <% while(rs.next())
{
 %>
<option value=<%=rs.getInt(1)%>><%=rs.getInt(1)%></option>
<%
}
%>

        </select>
      </td>
      <td>Machine S.No.</td>
      <td>
        <input type="text" name="textfield7">
      </td>
    </tr>
    <tr>
      <td>Customer Name</td>
      <td>
        <input type="text" name="textfield">
      </td>
      <td>Machine Location</td>
      <td>
        <input type="text" name="textfield8">
      </td>
    </tr>
    <tr>
      <td>Address1</td>
      <td>
        <input type="text" name="textfield2">
      </td>
      <td>Expiry Date</td>
      <td>
        <input type="text" name="textfield9">
      </td>
    </tr>
    <tr>
      <td>Address2</td>
      <td>
        <input type="text" name="textfield3">
      </td>
      <td>Model ID</td>
      <td>
        <input type="text" name="textfield10">
      </td>
    </tr>
    <tr>
      <td>City</td>
      <td>
        <input type="text" name="textfield4">
      </td>
      <td>Counter Reading</td>
      <td>
        <input type="text" name="textfield11">
      </td>
    </tr>
    <tr>
      <td>Districit</td>
      <td>
        <input type="text" name="textfield5">
      </td>
      <td>AMCV</td>
      <td>
        <input type="text" name="textfield12">
      </td>
    </tr>
    <tr>
      <td>Phone</td>
      <td>
        <input type="text" name="textfield6">
      </td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
  <p align="center">Machine Problem Details</p>
  <table width="84%" border="1">
    <tr>
      <td width="31%">Problem ID</td>
      <td width="20%"> 
        <input type="text" name="textfield13">
      </td>
      <td width="24%">Status</td>
      <td width="25%"> 
        <input type="text" name="textfield17" value="">
      </td>
    </tr>
    <tr>
      <td width="31%" height="64">Problem Category</td>
      <td width="20%" height="64"> 
        <input type="text" name="textfield14">
      </td>
      <td width="24%" height="64">Problem Description</td>
      <td width="25%" height="64"> 
        <textarea name="textfield16"></textarea>
      </td>
    </tr>
    <tr>
      <td width="31%" height="17">Date</td>
      <td width="20%" height="17"> 
        <input type="text" name="textfield15">
      </td>
      <td width="24%" height="17">&nbsp;</td>
      <td width="25%" height="17">&nbsp;</td>
    </tr>
  </table>
  <p align="center">&nbsp;</p>
  <p> 
    <input type="submit" name="Submit" value="Submit">
    <input type="reset" name="reset" value="Reset">
  </p>
  <p>&nbsp;</p>
  <p align="center">&nbsp; </p>
  </div>
</form>
</body>
</html>
