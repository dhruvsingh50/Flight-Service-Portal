<%@page import="java.util.ArrayList"%>
<%@page import="com.wipro.frs.bean.FlightBean"%>
<%@page import="com.wipro.frs.bean.RouteBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>ADD SCHEDULE</title>
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
<% //ArrayList<RouteBean> r=( ArrayList<RouteBean>)session.getAttribute("rbean");
//ArrayList<FlightBean> f=(ArrayList<FlightBean>)session.getAttribute("fbean");
//System.out.println("from page");
//System.out.println(r.size());
//System.out.println(f.size());
%>
<body class="right" class="bg-cyan">
		<div class="body body-s">
		
			<form action="AddSchedule"  method="POST" class="sky-form">
				<header>ADD SCHEDULE</header>
				
				<fieldset>					
					<!-- <section class="input">
						<label class="input">
							<a>Source</a>
							<input type="text" name="source" placeholder="Enter Source">
						</label>
					</section> -->
					
					<section>
						<label class="select">
							<a>Flight Id</a>
							<select name="flightID">
								<option value="0" selected disabled>FlightId &darr;</option>
								
								<c:forEach var="fb" items="${sessionScope.fbean}">
								
									<option value="${fb.flightID}">${fb.flightID}</option>
								</c:forEach>
							</select>
						</label>
					</section>
					<section>
						<label class="select">
							<a>Route Id</a>
							<select name="routeID">
								<option value="0" selected disabled>Route &darr;</option>
								<c:forEach var="rb" items="${sessionScope.rbean}">
									<option value="${rb.routeID}">${rb.routeID}</option>
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
						<label class="select">
							<a>TRAVEL DURATION</a>
							<input type="text" name="travelDuration">
						</label>
					</section>
				
					<section>
						<label class="input">
							<a>AVAILABLE DAYS</a>
							<input type="text" name="availableDays">
						</label>
					</section>
					
					
					<section>
						<label class="input">
							<a>DEPARTURE TIME</a>
							<input type="text" name="departureTime">
						</label>
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