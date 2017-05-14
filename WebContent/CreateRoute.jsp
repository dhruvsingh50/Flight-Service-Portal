<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type='text/javascript'>
	function validation() {

		var alpha = /^([a-zA-Z ])+$/;
		var nume = /^[0-9\b]+$/;
		var floatingPattern = /^[0-9.\b]+$/;
		

		var source = document.getElementById("source").value.toLowerCase();

		if (source.length != 0) 
		{
			if (source.match(alpha) == null) 
			{
				document.getElementById("spansourceName").innerHTML = "Source Name includes only Alphabets ";
				
				return false;
			} 
			else 
			{
				if ((source.length < 2) || (source.length >= 20)) 
				{
					document.getElementById("spansourceName").innerHTML = "Source name must in between 2 and  15 Character";
					return false;
				}
			}
		}

		else
		 {
			document.getElementById("spansourceName").innerHTML = "Source Name mustn0t be empty";
			return false;
		 }
		document.getElementById("spansourceName").innerHTML = "";

		var destination = document.getElementById("destination").value.toLowerCase();

		if (destination.length != 0) 
		{
			if (destination.match(alpha) == null) 
			{
				document.getElementById("spandestinationName").innerHTML = "Destination Name includes only Alphabets ";
				
				return false;

			} else 
			{
				if ((destination.length < 2) || (destination.length >= 20))
				{
					document.getElementById("spandestinationName").innerHTML = "Destination name must in between 2 and  15 Character";
					
					return false;
				}
			}
		} 
		else
		 {
			document.getElementById("spandestinationName").innerHTML = "Destination Name mustnot be empty";

			return false;
		}

		if (source == destination) 
		{
			document.getElementById("spandestinationName").innerHTML = "Source and Destination is same which is not possible";
			
			return false;
		}
		
		document.getElementById("spandestinationName").innerHTML = "";

		var distance = document.getElementById("distance").value;

		if (distance.length != 0)
		 {
			if (distance.match(nume) == null)
			{
				document.getElementById("spandistance").innerHTML = "Distance must be Numeric";
				
				return false;
			} 
			else 
			{
				if (distance >= 10000)
				{
					document.getElementById("spandistance").innerHTML = "Distance name must be less than 15000";
					return false;
				}
			}
		}

		else 
		{
			document.getElementById("spandistance").innerHTML = "Distance cannot be empty";
			
			return false;
		}
		
		document.getElementById("spandistance").innerHTML = "";

		var fare = document.getElementById("fare").value;

		if (fare.length != 0) 
		{
			if (fare.match(floatingPattern) == null) 
			{
				document.getElementById("spanfare").innerHTML = "Fare must be Numeric";
				
				return false;
			} 
			else 
			{
				if (fare >= 100000) 
				{
					document.getElementById("spanfare").innerHTML = "fare must be less than 100000";
					return false;
				}
			}
		} 
		else 
		{
			document.getElementById("spanfare").innerHTML = "Fare cannot be empty";

			return false;
		}
		document.getElementById("spanfare").innerHTML = "";
	}
</script>
</head>
<body>
	
			<div id="Center" style="margin-top:200px;">
				<form action="CreateRoute" onsubmit="return validation()">
					<table align="center">
						<tr>
							<td>Source</td>
							<td><input type="text" name="source" id="source"></td>
							<td><span id="spansourceName"></span></td>
						</tr>
						<tr>
							<td>Destination</td>
							<td><input type="text" name="destination" id="destination"></td>
							<td><span id="spandestinationName"></span></td>
						</tr>
						<tr>
							<td>Distance (in Miles) </td>
							<td><input type="text" name="distance" id="distance"></td>
							<td><span id="spandistance"></span></td>
						</tr>
						<tr>
							<td>Fare (in Rs.)</td>
							<td><input type="text" name="fare" id="fare"></td>
							<td><span id="spanfare"></span></td>
						</tr>
						<tr>
							<td style="text-align:center; padding-left:100px;" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;><input type="submit" name="action" value="ADD THIS ROUTE"></td>
							<td></td>
						</tr>
					</table>
				</form>
			</div>
		

</body>

</html>