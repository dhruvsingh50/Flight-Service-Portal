<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="FindFlight" method="post">
source <input type="text" name="source"><br>
destination <input type="text" name="destination"><br>
journey date<input type="date" name="journeyDate"><br>
No. of seats <select name="noOfSeats">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select><br>
type<input type="radio" name="reservationType" value="economy">economy
	<input type="radio" name="reservationType" value="business">business
	<br>
	<input type="submit" value="findflight">
</form>
</body>
</html>