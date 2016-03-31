<%@ page language="java" %>
<html>
<head>
<title>Untitled Document</title>

</head>

<body bgcolor="cyan" text="#000000">
<form action="./MachDetServlet" name="form14" method="post">
<div align="center"> 
  <p><font size="6">Machine Details</font></p>
  <p>&nbsp;</p>
  <table width="75%">
    <tr>
      <td>Machine S.No</td>
      <td>
        <input type="text" name="machslno">
      </td>
    </tr>
    <tr>
      <td>Machine Location</td>
      <td>
        <input type="text" name="machloc">
      </td>
    </tr>
    <tr>
      <td>Customer ID</td>
      <td>
        <input type="text" name="custcode">
      </td>
    </tr>
    <tr>
      <td>Refrence No</td>
      <td>
        <input type="text" name="refno">
      </td>
    </tr>
    <tr>
      <td>Installation Date</td>
      <td>
        <input type="text" name="instaldate">
      </td>
    </tr>
    <tr>
      <td>Status</td>
      <td>
        <input type="text" name="status">
      </td>
    </tr>
    <tr>
      <td>Expiry Date</td>
      <td>
        <input type="text" name="expdate">
      </td>
    </tr>
    <tr>
      <td>Model Id</td>
      <td>
        <input type="text" name="modelid">
      </td>
    </tr>
    <tr>
      <td>Site Condition </td>
      <td>
        <input type="text" name="sitecond">
      </td>
    </tr>
    <tr>
      <td>Counter Reading</td>
      <td>
        <input type="text" name="countread">
      </td>
    </tr>
    <tr>
      <td>Stabilizer</td>
      <td>
        <input type="text" name="stab">
      </td>
    </tr>
    <tr>
      <td>AMCV</td>
      <td>
        <input type="text" name="amcv">
      </td>
    </tr>
  </table>
  <p> 
    <input type="submit" name="Submit2" value="Submit">
     <input type="reset" name="Submit3" value="Reset">
  </p>
</div>
</form>
</body>
</html>
