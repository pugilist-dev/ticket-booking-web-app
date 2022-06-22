<%@page import="com.atr.model.FlightModel"%>
<%@page import="com.atr.model.CustomerModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>ResetUpdate Page</title>
<link type="text/css" href="forgot.css" rel="Stylesheet">
<link rel="stylesheet" type="text/css" href="jquery-ui.css">
<link rel="stylesheet" type="text/css" href="jquery-ui.theme.css"> 
<script type="text/javascript" src="jquery-1.11.1.js"></script>
<script type="text/javascript" src="jquery-ui.js"></script>
<script type="text/javascript" src="jquery.validate.js"></script>
<script type="text/javascript" src="additional-methods.js"></script>`
<script type="text/javascript">
 $(document).ready(function(){
	 $("#Validation").validate({
		rules:{
				password:{
					required:true,
					minlength:8,
					maxlength:12
				},
				cpassword:{
					required:true,
					minlength:8,
					maxlength:12,
					equalTo:"#password"
				}
				
		},
		messages:{
				
				password:{
					required:" password cant be empty",
					minlength:"minimum password length is 8 chars...",
					maxlength:"maximum password length is 12 chars..."
				},
				cpassword:{
					required:" Confirm password cant be empty",
					minlength:"minimum password length is 8 chars...",
					maxlength:"maximum password length is 12 chars...",
					equalTo:"password and confirm password should match"
				}
			},
			
	});
}); 
</script>
</head>
<body >

<div id="bg">
     
</div>
<body>
<form action="ForgotUpdateServlet" method="post">
    <%	HttpSession sessionForgot3 = request.getSession();
   		String email=(String)sessionForgot3.getAttribute("email");
   		if(email==null){
   		        HttpSession sessionHome = request.getSession();
   				CustomerModel cm=(CustomerModel)sessionHome.getAttribute("cm");
   				email=cm.getEmail();
   				out.println(email);
   		}
   	%>    
  <label for=""></label>
      <input type="text" name="password" id="password" placeholder="password" class="password">
  <label for=""></label>
      <input type="text" name="cpassword" id="cpassword" placeholder="Confirm-password" class="cpassword">
   <label for=""></label>
      <input type="hidden" name="email" id="" class="email" value=<%= email %>>
  																		
  <button type="submit">CHANGE</button>
  
   <label for=""></label>
   <a  href="signup.html">New Account</a>
  
</form>
</body>
</html>