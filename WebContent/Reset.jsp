<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="reset.css">
<script type="text/javascript" src="jquery-1.11.1.js"></script>
	<script type="text/javascript" src="jquery-ui.js"></script>
	<script type="text/javascript" src="jquery.validate.js"></script>
	<script type="text/javascript" src="additional-methods.js"></script>
<script src="resetvalidate.js"></script>
<title>Reset Password Page</title>
</head>
<body>
<form action="ResetServlet" method="post" id="reset">
<div id="content">
<h3>Re-set Password</h3>
<div class="container" id="c">
<label>Enter your current password:</label><br>
<input type="password" name="cpassword" id="cpassword"><br><br>
<label>Enter your new password</label><br>
<input type="password" name="npassword" id="npassword"><br><br>
<label>Confirm password</label><br>
<input type="password" name="conpassword" id="conpassword"><br><br>
<input type="submit" value="Reset" class="button" />
</div>
</div>
</form>
</body>
</html>