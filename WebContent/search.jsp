<%@ page import="com.atr.model.FlightModel" language="java" contentType="text/html; charset=ISO-8859-1"
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
<script type="text/javascript">
$(document).ready(function(){
	$("#fdate").datepicker({   
		dateFormat:"dd-M-y"
		
	});
}); 
</script>
</head>
<body>
	<div class="header">
 		 <h1>Mphasis Travels</h1>
	</div>

	<div id="navbar">
 		 <a class="active" href="javascript:void(0)">Search</a>
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
						<option value="">Select</option>
						<option value="1">(1)Pune Airport</option>
						<option value="2">(2)Bangalore Airport</option>
						<option value="3">(3)Aizawl Airport</option>
						<option value="4">(4)Akola Airport</option>
					</select>
				</td>
				<td><select name="fto" id="fto" required>
						<option value="">Select</option>
						<option value="1">(1)Pune Airport</option>
						<option value="2">(2)Bangalore Airport</option>
						<option value="3">(3)Aizawl Airport</option>
						<option value="4">(4)Akola Airport</option>
					</select>
				</td>
				<td><input type="text" name="fdate" id="fdate" autocomplete="off" required></td>
				<td><input type="number" name="fseat" id="fseat" required min="1" max="6"></td>
			</tr>
	</table><br><br>
	<button type="submit" class="button">Search</button><br><br>
	</form>
	<button class="button">Edit Profile</button><br><br>
	<button class="button">Cancel Booking</button><br><br>
</body>
</html>