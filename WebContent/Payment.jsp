<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Payment</title>
		<link rel="shortcut icon" href="airline.png"/>
		<style>
			body { 
			    background-image: url(Hooded.jpg);
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
<body  class="right" class="bg-cyan">
		<div class="body body-s">
		
			<form action="Pay" method="post" class="sky-form">
				<header>Payment</header>
				
				<fieldset>					
					<section class="input">
						<label class="input">
							<a>Credit Card Number</a>
							<input type="text" name="CreditCardNumber" placeholder="XXXX XXXX XXXX XXXX">
						</label>
					</section>
					<section class="input">
						<label class="input">
							<a>Valid From</a>
							<input type="text" name="ValidFrom" placeholder="MM/YYYY">
						</label>
					</section>
					
					<section>
						<label class="input">
							<a>Valid To</a>
							<input type="text" name="ValidTo" placeholder="MM/YYYY">
						</label>
					</section>

					<section class="input">
						<label class="input">
							<a>Payable Amount</a>
							<input type="text" name="Amount" value="<%=session.getAttribute("fare") %>" readonly="readonly">
						</label>
					</section>
									
					<section>
						<label><input type="checkbox" name="checkbox">Save Card Details</label>
					</section>
				</fieldset>

				<footer>
					<button type="submit" class="button">Pay</button>
									</footer>
			</form>
			
		</div>

</body>
</html>