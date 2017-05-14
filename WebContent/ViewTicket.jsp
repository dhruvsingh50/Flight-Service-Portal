<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>View Ticket</title>
	<link rel="shortcut icon" href="airline.png"/> 
	<style>
			body {  
			    background-image: url(viewticket.jpg); 
			    background-repeat: repeat; 
 			    background-attachment: ; 
 			    background-position: ; 

		} 
 			input:focus { 
 	   			background-color:#C0C0C0; 
 			} 
			table, th, td, td.select{ 
   				font-family: 'FontAwesome';   
    			
			} 
</style>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
		<link rel="stylesheet" href="demo.css">
		<link rel="stylesheet" href="sky-forms.css">
</head>
<body class="bg-cyan">

	<c:forEach items="${ticket}" var="list">

     

   

	<div class="body-viewticket"> 
		<form class="sky-form" > 
			<header>View Ticket</header> 
 			<fieldset>		
 				<section class="input"> 
 					<table style="width:100%">
 					  <tr>
 					  	<td width="50%">RESERVATION ID:</td> 
					  	<td><input type="text" name="Reservationid" id="Reservationid" value="${list['key'].reservationID}" readonly="readonly"></td>
				  </tr> 
 					  <tr> 
 					  	<td>SCHEDULE ID:</td>
					  	<td><input type="text" name="Scheduleid" id="Scheduleid" value="${list['key'].scheduleID}" readonly="readonly"></td>
 					  </tr> 
 					  <tr> 
 					  	<td>JOURNEY DATE:</td> 
					  	<td><input type="text" name="Journeydate" id="Journeydate" value="${list['key'].journeyDate}" readonly="readonly"></td>
					  </tr> 
 					  <tr> 
 					  	<td>BOOKING DATE:</td> 
					  	<td><input type="text" name="Bookingdate" id="Bookingdate" value="${list['key'].bookingDate}" readonly="readonly"></td>
 					  </tr> 
 					  <tr> 
 					  	<td>RESERVATION TYPE:</td> 
					  	<td><input type="text" name="Reservationtype" id="Reservationtype" value="${list['key'].reservationType}" readonly="readonly"></td>
 					  </tr> 
				  <tr> 
 					  	<td>NUMBER OF SEATS:</td>
					  	<td><input type="text" name="Noofseats" id="Noofseats" value="${list['key'].noOfSeats}" readonly="readonly"></td>
 					  </tr> 
 					  <tr> 
 					  	<td>TOTAL FARE:</td> 
					  	<td><input type="text" name="Totalfare" id="Totalfare" value="Rs.${list['key'].totalFare}" readonly="readonly"></td>
 					  </tr> 
 					</table> 
 				</section>			 
 			</fieldset> 
 		</form> 
 	</div> 
 	</c:forEach>
	<div class="body-viewpassenger"> 
 		<form class="sky-form" action="printticket" method="get"> 
			<fieldset>		 
				<section class="input">
					<table style="width:100%; text-align:center;" > 
					  <tr> 
					  	<td style="width:5%;">S.NO.</td>
					    <td style="width:45%;">NAME</td> 
				    <td style="width:20%;">GENDER</td>		
				    <td style="width:10%;">AGE</td> 
					    <td style="width:10%;">SEAT NO.</td> 
				  </tr> 
				   <%int i=1;%>
				  <c:forEach items="${ticket}" var="list">
					  <c:forEach items="${list.value}" var="listItem">
				  <tr> 
				 
				  	<td><%=i %></td> 
					    <td><input type="text" name="Name" id="Name" value="${listItem.name}" readonly="readonly"></td>
					    <td><input type="text" name="Gender" id="Gender" value="${listItem.gender}" readonly="readonly"></td>
					    <td><input type="text" name="Age" id="Age" value="${listItem.age}" readonly="readonly"></td>		 	    <td><input type="text" name="Seatno" id="Seatno" value="${listItem.seatNo}" readonly="readonly"></td>
				  </tr> 
				  <%i++; %>
				  	</c:forEach>
			</c:forEach>
					  
					  <tr>
					  <td></td>
					  <td></td>
					  <td></td>
					  <td></td>
					  <c:forEach items="${ticket}" var="list">
					  
					  <td><input type="hidden"  name="rid" value="${list['key'].reservationID}"></c:forEach>
					  <input type="submit" value="Print Ticket">
					  </td>
					  </tr>
					</table>
				</section>			
			</fieldset> 
	</form>
</div>
</body>
</html>