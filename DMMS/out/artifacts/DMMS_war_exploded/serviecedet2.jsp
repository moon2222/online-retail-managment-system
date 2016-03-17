<%@ page language="java" %>
<html>
<head>
<title>Untitled Document</title>
</head>

<body bgcolor="cyan" text="#000000">
<form action="./ServieceServlet" name="form18" method="post">
<div align="center">
  <p><font size="5"><i><font face="Verdana, Arial, Helvetica, sans-serif">Serviece 
    Details </font></i></font></p>
  <p>&nbsp;</p>
  <table width="100%" border="0">
    <tr> 
      <td width="23%">Cust ID</td>
      <td width="37%"> 
        <input type="text" name="custid">
      </td></tr>
      <tr><td width="19%">Machine ID</td>
      <td width="21%"> 
        <input type="text" name="machid">
      </td>
    </tr>
    <tr> 
      <td width="23%">Engineer ID</td>
      <td width="37%"> 
        <input type="text" name="engid">
      </td></tr><tr>
      <td width="19%">Date</td>
      <td width="21%"> 
        <input type="text" name="date">
      </td>
    </tr>
    <tr> 
      <td width="23%">Status</td>
      <td width="37%"> 
        <input type="text" name="status">
      </td>
       </tr>
  <p>&nbsp;</p><table border="0">
    <tr>
      <td height="51"> 
        <input type="submit" name="Add" value="  Add  ">
      </td>
      <td height="51"> 
        <input type="reset" name="Clear" value="Reset">
      </td>
      
    </tr>
  </table>
  <p>&nbsp;</p>
</table>
</div>
</form><

</body>
</html>
