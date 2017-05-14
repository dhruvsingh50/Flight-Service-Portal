<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.wipro.frs.bean.ReservationBean" %>
    <%@page import="com.wipro.frs.bean.ScheduleBean"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passenger details</title>
</head>
<body>
<form action="AddPassenger"  method="post">
<table>
<%
ReservationBean rbean= (ReservationBean)session.getAttribute("reservation");
for(int i=1;i<=rbean.getNoOfSeats();i++){	

%>
<tr>
	<td><input type="text" value="<%=i%>"></td>
	<td><input type="text" name="name"></td>
	<td><input type="radio" name="gender<%=i%>" value="Male">Male
	<input type="radio" name="gender<%=i%>" value="Female">Female</td>
	<td><input type="text" name="age"></td>
	
<tr>
<%} %>
<input type="submit" value="Proceed to payment">
</table>
</form>
</body>
</html>