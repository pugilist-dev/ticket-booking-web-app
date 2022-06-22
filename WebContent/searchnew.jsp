<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Search</title>
<link rel="stylesheet" href="searchCSS.css">
<link rel="stylesheet" type="text/css" href="jquery-ui.css">
<link rel="stylesheet" type="text/css" href="jquery-ui.theme.css"> 
<script type="text/javascript" src="jquery-1.11.1.js"></script>
<script type="text/javascript" src="jquery-ui.js"></script>
<script type="text/javascript" src="jquery.validate.js"></script>
<script type="text/javascript" src="additional-methods.js"></script>
<style>
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
</style>
<script type="text/javascript">
$(document).ready(function(){
	$("#fdate").datepicker({   
		dateFormat:"dd-M-y"
		
	});
});
</script>
</head>
<body>
	<div class="bg-image">
	</div>

	<div class="bg-text">
  		<div class="header">
 			 <h1>Mphasis Travels</h1>
		</div>
		<div id="navbar">
 			 <a class="active" href="javascript:void(0)">Search Flights</a>
		</div>
			<h3 id=heading3>Enter your info to see the Flight Details:</h3>
  			<form action="SearchController" name="reg" method="get" id="register">
		<table>
			<tr>
				<th>From</th>
				<th>To</th>
				<th>Departure Date</th>
				<th>No of Seats</th>
			</tr>
			<tr>
				<td><select name="ffrom" id="ffrom" required>
						<option value="select">Select</option>
						<option value="1">(1)Pune Airport</option>
						<option value="2">(2)Bangalore Airport</option>
						<option value="3">(3)Aizawl Airport</option>
						<option value="4">(4)Akola Airport</option>
					</select>
				</td>
				<td><select name="fto" id="fto" required>
						<option value="select">Select</option>
						<option value="1">(1)Pune Airport</option>
						<option value="2">(2)Bangalore Airport</option>
						<option value="3">(3)Aizawl Airport</option>
						<option value="4">(4)Akola Airport</option>
					</select>
				</td>
				<td><input type="text" name="fdate" id="fdate" autocomplete="off" required></td>
				<td><input type="text" name="fseat" id="fseat" required min="1" max="1"></td>
			</tr>
	</table><br><br>
	<button type="submit" class="button">Search</button><br><br>
	</form>
	<a href="Profile.jsp"><button class="button">Edit Profile</button></a><br><br>
	<a href="FetchDetails.jsp"><button class="button">Cancel Booking</button></a><br><br>
</div>


</body>
</html>