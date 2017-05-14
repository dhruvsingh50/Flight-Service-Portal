<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Pay" method="post">
Credit card number <input type="text" name="CreditCardNumber"><br>
VAlid from <input type="text" placeholder="MM/YYYY" name="ValidFrom"><br>
VAlid To <input type="text" placeholder="MM/YYYY" name="ValidTo"><br>
Total Amount<input type="text" value="<%=session.getAttribute("fare") %>" readonly="readonly"><br>
<input type="submit" value="PAY"> 

</form>
</body>
</html>