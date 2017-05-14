<%@page import="java.util.Iterator"%>
<%@page import="com.wipro.frs.bean.ScheduleBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
flight display
<table>

 <% List<ScheduleBean> slist= (List<ScheduleBean>)session.getAttribute("schedulelist");
 
Iterator it=slist.iterator();
while(it.hasNext()){
	ScheduleBean sb=(ScheduleBean)it.next();
	
	
	%>
	<tr>
			<td><%= sb.getScheduleID() %></td>
			<td><%= sb.getFlightID() %></td>
			<td><%= sb.getRouteID() %></td>
			<td><%= sb.getTravelDuration() %></td>
			<td><%= sb.getDepartureTime() %></td>
			<td>
			<form action="Book" method="post">
			<input type="hidden" name="scheduleID" value="<%= sb.getScheduleID() %>">
			<input type="hidden" name="routeID" value="<%= sb.getRouteID() %>">
			<input type="hidden" name="flightID" value="<%= sb.getFlightID() %>">
			<input type="submit" value="BOOK">
			</form>
			</td>
	</tr>
	
	<% 
	/* out.println(sb.getScheduleID());
	out.println(sb.getFlightID());
	out.println(sb.getRouteID());
	out.println(sb.getTravelDuratio());
	out.println(sb.getAvailableDays());
	out.println(sb.getDepartureTime());
 */}
 %>
		
</table>
	
</body>
</html>