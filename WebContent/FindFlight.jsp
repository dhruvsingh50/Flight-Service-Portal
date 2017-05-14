<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Iterator"%>
<%@page import="com.wipro.frs.bean.ScheduleBean"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<title>Schedule Details</title>
		<link rel="shortcut icon" href="airline.png"/>
		<style>
			body { 
			    background-image: url(Scheduledetails.jpg);
			    background-repeat: repeat;
			    background-attachment: fixed;
			    background-position: center; 
			}
			input:focus {
	   			background-color:#C0C0C0;
			}
			table, th, td, td.select{
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
		<div class="body-schedule">
		
		
		
		
			<div class="sky-form">
				<header>Schedule Details</header>
				
				<fieldset>	
				<% List<ScheduleBean> slist= (List<ScheduleBean>)session.getAttribute("schedulelist");
 
Iterator it=slist.iterator();
while(it.hasNext()){
	ScheduleBean sb=(ScheduleBean)it.next();
	
	
	%>	
					<section class="input">
						<table style="width:100%">
						  <tr>
						  	<th style="width:15%;">Scheduleid</th>
						    <th style="width:10%;">Flightid</th>
						    <th style="width:10%;">Routeid</th>		
						    <th style="width:30%;">TravelDuration</th>
						    <th style="width:30%;">DepartureTime</th>
						    <th style="width:5%;">Book Now</th>
						  </tr>
						  <tr>
						  	<td><input type="text" name="Scheduleid" id="Scheduleid" placeholder="Schedule ID" value="<%= sb.getScheduleID() %>" readonly="readonly"></td>

						  	<td><input type="text" name="Flightid" id="Flightid" placeholder="Flight ID" value="<%= sb.getFlightID() %>" readonly="readonly"></td>

						  	<td><input type="text" name="Routeid" id="Routeid" placeholder="Route ID" value="<%= sb.getRouteID() %>" readonly="readonly"></td>

						  	<td><input type="text" name="TravelDuration" id="TravelDuration" placeholder="Travel Duration" value="<%= sb.getTravelDuration() %>" readonly="readonly"></td>

						  	<td><input type="text" name="DepartureTime" id="DepartureTime" placeholder="Departure Time" value="<%= sb.getTravelDuration() %>" readonly="readonly"></td>

						  	<td>
						  	<form action="Book" method="post">
					<input type="hidden" name="scheduleID" value="<%= sb.getScheduleID() %>">
					<input type="hidden" name="routeID" value="<%= sb.getRouteID() %>">
							<input type="hidden" name="flightID" value="<%= sb.getFlightID() %>">
						  	
						  	<button class="body-book" type="submit">BOOK</button>
						  	</form>
						  	</td>
						  	
						</table>

					</section>			
					<% 
					}
 %>
				</fieldset>

			</div>
			
		</div>

</body>
</html>