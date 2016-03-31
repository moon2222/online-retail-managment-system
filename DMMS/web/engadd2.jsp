<%@ page language="java" %>
<html>
<head>
<title>Untitled Document</title>

</head>

<body bgcolor="cyan" text="#000000">
<form action="./EngDetServlet" name="form16" method="post">
<div align="center">
  <p><font size="5"><i><font face="Verdana, Arial, Helvetica, sans-serif">Engineer 
    Details in Service</font></i></font></p>
  <p>&nbsp;</p><table border="0">
    <tr> 
      <td>Employee Id</td>
      <td> 
        <input type="text" name="empid">
      </td>
    </tr>
    <tr> 
      <td>Empoyee Name</td>
      <td> 
        <input type="text" name="empname">
      </td>
    </tr>
    <tr> 
      <td>Department ID</td>
      <td> 
        <input type="text" name="deptid">
      </td>
    </tr>
    <tr> 
      <td height="31">Job Category</td>
      <td height="31">
        <input type="text" name="jobcat">
      </td>
    </tr>
    <tr> 
      <td height="31">Action</td>
      <td height="31"> 
        <input type="text" name="action">
      </td>
    </tr>
  </table>
  <p>&nbsp;</p><table border="0">
    <tr>
      <td height="51"> 
        <input type="submit" name="Add" value="  Add  ">
      </td>
      <td height="51"> 
        <input type="reset" name="Clear" value="Clear">
      </td>
      <td height="51"> 
        </td>
    </tr>
  </table>
  <p>&nbsp;</p>
</div>
</form>
</body>
</html>
