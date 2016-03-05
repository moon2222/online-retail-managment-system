
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Log in Page</title>
</head>
<body>
<h1>Log in Page</h1>
<script type="text/javascript">
  function validateUsername(){
    var text = document.getElementById("username").value;
    if(text == ""){
      document.getElementById("errorusername").innerHTML = "Provide Username";
      document.getElementById("errorusername").style.color = "red";
    }
    else{
      document.getElementById("errorusername").innerHTML = "OK";
      document.getElementById("errorusername").style.color = "green";
    }
  }
  function validatePassword(){
    var text = document.getElementById("password").value;
    if(text == ""){
      document.getElementById("errorpassword").innerHTML = "Provide Password";
      document.getElementById("errorpassword").style.color = "red";
    }
    else{
      document.getElementById("errorpassword").innerHTML = "OK";
      document.getElementById("errorpassword").style.color = "green";
    }
  }
</script>

<form action ="valid_login" method ="POST">
  <table>
    <tr>
      <td>Username:</td>
      <td><input type="text" id="username" name ="username" onblur="validateUsername()"></td>
      <td><label id="errorusername"></label></td>
    </tr>

    <tr>
      <td>Password:</td>
      <td><input type="password" id="pass" name ="pass" onblur="validatePassword()"></td>
      <td><label id="errorpassword"></label></td>
    </tr>

    <tr>
      <td></td>
      <td><input type="submit" value="Login"></td>
      <td></td>
    </tr>

    <tr>
      <td colspan="2" align="center"><a href="New_register.jsp">REGISTER</a></td>
    </tr>
  </table>

</form>
</body>
</html>