<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>Reserve Ticket</title>
		<link rel="shortcut icon" href="airline.png"/>
		<style>
			body { 
			    background-image: url(reserveticket.jpg);
			    background-repeat: repeat;
			    background-attachment: fixed;
			    background-position: center; 
			}
			input:focus {
	   			background-color:#C0C0C0;
			}
		</style>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
		
		<link rel="stylesheet" href="demo.css">
		<link rel="stylesheet" href="sky-forms.css">
</head>
<body class="right" class="bg-cyan">
		<div class="body body-s">
		
			<form action="FindFlight"  method="post" class="sky-form">
				<header>Reserve Ticket</header>
				
				<fieldset>					
					<!-- <section class="input">
						<label class="input">
							<a>Source</a>
							<input type="text" name="source" placeholder="Enter Source">
						</label>
					</section> -->
					
					<section>
						<label class="select">
							<a>Source</a>
							<select name="source">
								<option value="0" selected disabled>Source &darr;</option>
								<c:forEach var="routebean" items="${route}">
									<option value="${routebean.source}">${routebean.source}</option>
								</c:forEach>
							</select>
						</label>
					</section>
					<section>
						<label class="select">
							<a>Destination</a>
							<select name="destination">
								<option value="0" selected disabled>Destination &darr;</option>
								<c:forEach var="routebean" items="${route}">
									<option value="${routebean.destination}">${routebean.destination}</option>
								</c:forEach>
							</select>
						</label>
					</section>
					
					<!-- <section class="input">
						<label class="input">
							<a>Destination</a>
							<input type="text" name="destination" placeholder="Enter Destination">
						</label>
					</section>
					 -->
					<section>
						<label class="input">
							<a>Journey Date</a>
							<input type="date" name="journeyDate">
						</label>
					</section>

					<section>
						<label class="select">
							<a>Select No. of Seats</a>
							<select name="noOfSeats">
								<option value="0" selected disabled>Maximum 5 &darr;</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</label>
					</section>
				
					<section >
						<label>
						<a>Reservation Type</a><br>
						<input type="radio" name="reservationType" value="Economy">Economy Class<br>
						<input type="radio" name="reservationType" value="Business">Business Class</label>
					</section>
				</fieldset>

				<footer>
					<button type="submit" class="button">Submit</button>
					<button type="reset" class="button" value="Reset">Reset</button>
				</footer>
			</form>
			
		</div>

</body>
</html>