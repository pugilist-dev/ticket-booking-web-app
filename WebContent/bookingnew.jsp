<%@ page import="com.atr.model.FlightModel,java.util.ArrayList" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script>
$(document).ready(function(){
	$(".cdob").datepicker({         //#date1 was here previously
		dateFormat:"dd-M-y"
		
	});
	$("#booking").validate({
		rules:{
			cname:{
				required:true,
				lettersonly:true //predefined method by developers for letter only			}
		},
			cdob:{
				required:true
		},
			cemail:{
				required:true,
				email:true
		},
			ctel:{
				required:true,
				digits:true,
				minlength:10,
				maxlength:10
		}
		},
		messages:{
			cname:{
				required:"Enter the Username",
				lettersonly:"Name field accepts only letters"
			},
			cdob:{
				required:"Enter the Date Of Birth"
			},
			cemail:{
				required:"Email ID cannot be Empty",
				email:"Invalid Email-ID"
				},
			ctel:{
				required:"Phone Number Cannot Be Empty",
				digits:"Enter 10 Number Digits Mobile Number",
				minlength:"Invalid Phone Number",
				maxlength:"Invalid Phone Number"
			},
			submitHandler:function(form){
				form.submit();
			},
				
			highlight:function(element){
				console.log(element);
				$(element).parent().addClass('error')
				$(element).before().css('background-color','#FF5733');
			},
			unhighlight:function(element){
				$(element).parent().removeClass('error')
				$(element).before().css('background-color','white');
			}
		}
	});
});
			
</script>
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
  background-image: url("https://wonderfulengineering.com/wp-content/uploads/2014/05/airplane-wallpaper-9.jpg");
  
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
  width: 100%;
  padding: 20px;
  text-align: center;
}
</style>

</head>
<body>
	<div class="bg-image">
		</div>
		<div class="bg-text">
		<div>
		<table>
			<tr>
				<th>Flight ID</th>
				<th>Airlines</th>
				<th>From</th>
				<th>To</th>
				<th>Departure Date</th>
				<th>Departure Time</th>
			</tr>
			<tr>
				<td>${bookingFlight.flightNo}</td>
				<td>${bookingFlight.airlineId}</td>
				<td>${bookingFlight.source}</td>
				<td>${bookingFlight.destination}</td>
				<td>${bookingFlight.departDate}</td>
				<td>${bookingFlight.departTime}</td>
			</tr>
			
			
		</table>
		</div><br><br>
		<form action="BookFlightServlet"id="booking" method="post">
		<div>	
		<table>
				<tr>
					<th>Name</th>
					<th>DOB</th>
					<th>Email</th>
					<th>Phone</th>
					<th> SSN Type</th>
					<th>SSN Number</th>
				</tr>
				<tr>
					<td><input type="text" name="cname" class="cname" ></td>
					<td><input type="text" name="cdob" class="cdob"></td>
					<td><input type="email" name="cemail" class="cemail"></td>
					<td><input type="tel" name="ctel" class="ctel"></td>
					<td><select name="ssntype" class="ssntype" required>
					<option value="">select</option>
					<option value="Unrestricted">Unrestricted</option>
					<option value="Restricted Card">Restricted Card</option>
					<option value="Non-Work Card">Non-Work Card</option>
					</select>
					</td>
					<td><input type="text" name="cssno" class="cssno" required></td>
				</tr>
		</table>
		</div>
	<button type="submit" class="button">Book</button><br><br>
	</form>
	</div>	
</body>
</html>