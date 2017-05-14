<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="com.wipro.frs.bean.ReservationBean" %>
<!DOCTYPE html>
<html>
<head>
	<title>Passenger Details</title>
		<link rel="shortcut icon" href="airline.png"/>
		<style>
			body { 
			    background-image: url(passenger1.jpg);
			    background-repeat: repeat;
			    background-attachment: fixed;
			    background-position: center; 
			}
			input:focus {
	   			background-color:#C0C0C0;
			}
			table, th, td{
   				border: 1px solid silver;
    			border-collapse: collapse;
    			text-align: center;
    			font-family:  
    			
			}
		</style>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
		
		<link rel="stylesheet" href="demo.css">
		<link rel="stylesheet" href="sky-forms.css">
</head>
<body class="bg-cyan">
		<div class="body-frs">
		
			<form action="AddPassenger"  method="post" class="sky-form">
				<header>Passenger Details</header>
				
				<fieldset>	
				<%
ReservationBean rbean= (ReservationBean)session.getAttribute("reservation");
for(int i=1;i<=rbean.getNoOfSeats();i++){	

%>	
					<section class="input">
						<table style="width:100%">
						  <tr>
						  	<th style="width:5%;">SNo.</th>
						    <th style="width:55%;">Name</th>
						    <th style="width:20%;">Gender</th>		
						    <th style="width:20%;">Age</th>
						  </tr>
						  <tr>
						  	<td><%=i%></td>

						    <td><input type="text" name="name" id="Name" placeholder="Enter Passenger Name"></td>

						    <td><select style="width:100%;" name="gender<%=i%>">
								<option value="0" selected disabled>Gender</option>
								<option value="Male">Male</option>
								<option value="Female">Female</option>
			
							</select>
							</td>		
						    
						    <td><input type="text" name="age" id="Age" placeholder="Enter Age"></td>
						  </tr>
						</table>

					</section>			
					
					<%} %>
					
				</fieldset>

				<footer>
					<button type="submit" class="button">Make Payment</button>
				</footer>
			</form>
			
		</div>

</body>
</html>