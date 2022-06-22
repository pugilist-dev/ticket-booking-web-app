<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
fieldset{

    display: block;
    margin-top:10px;
    margin-left: 2px;
    margin-right: 5px;
    padding-top: 0.35em;
    padding-bottom: 0.625em;
    padding-left: 40px;
    padding-right: 30px;
   border: 6px solid rgb(255,232,57);
   border-color:	#87CEEB;
   width: 400px;
   margin:auto
}
h2{
text-align:center;
}
body, html {
  height: 100%;
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}
* {
  box-sizing: border-box;
}

.bg-image {
  /* The image used */
  background-image: url("https://wonderfulengineering.com/wp-content/uploads/2014/05/airplane-wallpaper-33.jpg");
  
  /* Add the blur effect */
  filter: blur(8px);
  -webkit-filter: blur(8px);
  
  /* Full height */
  height: 100%; 
  
  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

/* Position text in the middle of the page/image */
.bg-text {
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0, 0.4); /* Black w/opacity/see-through */
  color: white;
  font-weight: bold;
  border: 3px solid #f1f1f1;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2;
  width: 80%;
  padding: 20px;
  text-align: center;
}
.button:hover {background-color: #400000;}

.button:active {
  background-color: #400000;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
.button {
  padding: 5px 10px;
  font-size: 15px;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color: #804000;
  border: none;
  border-radius: 20px;
  box-shadow: 0 9px #999;
}
</style>
<body>
<div class="bg-image"></div>

<div class="bg-text">
	<form action ="CancellationServlet" method="get">
	<h2 style="color:	#FF7F50;" >FLIGHT TICKET CANCELLATION</h2>
	<fieldset>
		ENTER YOUR BOOKING ID :<br><input type="text" name="bookingid"><br><br>
		<button type="submit" class="button">CANCEL TICKET</button>
		</fieldset>
	</form>
</div>
</body>
</html>