<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body>
<form action="register" method="post">
<pre>
<h2>User Registration</h2>

FIRST NAME : <input type="text" name="firstName"/>
LAST NAME : <input type="text" name="lastName"/>
EMAIL : <input type="text" name="email"/>
PASSWORD : <input type="text" name="password"/>
CONFIRM PASSWORD : <input type="text" name="confirmpassword"/>

 <input type="submit" value="register">
</form>
${mesg} 
</pre>
</body>
</html>
