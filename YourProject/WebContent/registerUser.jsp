<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<form action="UserRegistrationServletPath" method="post">
		Firstname: <input type="text" name="firstname" /><br />
		Lastname: <input type="text" name="lastname" /><br />
		Address: <input type="text" name="address" /><br />
		City: <input type="text" name="city" /><br />
		State: <input type="text" name="state" /><br />
		Pincode: <input type="text" name="pincode" /><br />
		Telephone No: <input type="text" name="telephone" /><br />
		Mobile: <input type="text" name="mobile" /><br />
		Email Id: <input type="text" name="email" /><br />
		Password: <input type="text" name="password" /><br />
		Re-type Password: <input type="text" name="cpassword" /><br />
		<input type="submit"/>
		<input type="reset" />
	</form>
</body>
</html>