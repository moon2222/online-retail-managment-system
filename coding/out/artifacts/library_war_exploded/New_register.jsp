<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Registration Page</title>
</head>
<body>
<h1>Regisration Page</h1>
<form action ="valid_register" method ="POST">
  <table>
    <tr>
      <td> First Name*  </td>
      <td><input type="text" id="Fname" name ="Fname"></td>
    </tr>
    <tr>
      <td> Last Name*  </td>
      <td><input type="text" id="Lname" name ="Lname"></td>
    </tr>
    <tr>
      <td>Username*:</td>
      <td><input type="text" id="user_name" name ="user_name"></td>
    </tr>
    <tr>
      <td> Shop Name*  </td>
      <td><input type="text" id="shopName" name ="shopName"></td>
    </tr>
    <tr>
      <td> Address*  </td>
      <td><input type="text" id="address" name ="address"></td>
    </tr>
    <tr>
      <td> City*  </td>
      <td><input type="text" id="city" name ="city"></td>
    </tr>
    <tr>
      <td> State*  </td>
      <td><input type="text" id="State" name ="State"></td>
    </tr>
    <tr>
      <td> PINCODE*  </td>
      <td><input type="text" id="pincode" name ="pincode"></td>

    </tr>
    <tr>
      <td> Contact No*  </td>
      <td><input type="text" id="contact_no" name ="contact_no"></td>
    </tr>

    <tr>
      <td>Password*:</td>
      <td><input type="password" id="password" name ="password"></td>
    </tr>

    <tr>
      <td></td>
      <td><input type="submit" value="Register"></td>
      <td></td>
    </tr>
  </table>

</form>
</body>
</html>
