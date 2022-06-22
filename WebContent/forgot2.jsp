<%@page import="com.atr.model.FlightModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Page</title>
<link type="text/css" href="forgot.css" rel="Stylesheet">
</head>
<body >

<div id="bg">
     
</div>
<body>
<form action="ForgotCheckServlet" method="post">
   <%	HttpSession sessionForgot2 = request.getSession();
   		String question=(String)sessionForgot2.getAttribute("question");
   		out.println(question);
   		String qnum=(String)sessionForgot2.getAttribute("qnum");
   		if(question==null)
   			question="";
   		String email=(String)sessionForgot2.getAttribute("email");
   	%>
  <label for="" style="c"></label>
      <!-- <input type="text" name="answer" id="" placeholder=${qnum}> -->
      <h3>${qnum}</h3>
      <input type="text" name="answer" id="">
       <input type="hidden" name="qnum" id="" value=${qnum}>
       <input type="hidden" name="email" id="" value=<%= email %>>
       <button type="submit">Continue</button>
  
   <label for=""></label>
   <a  href="signup.html">New Account</a>
  
   <%String msg="";
		if(request.getAttribute("errorMessage")!=null){ msg=(String)request.getAttribute("errorMessage");}
	%>
<h2 align="center"><%=msg %></h2>
  
</form>
</body>
</html>