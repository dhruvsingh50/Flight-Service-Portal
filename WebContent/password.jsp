<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password Reset</title>
<link rel="shortcut icon" href="airline.png"/>
		<style>
			body { 
			    background-image: url(changepassword.jpg);
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
		
			<form name="MyForm" method="GET" class="sky-form" action="PasswordSuccess.jsp">
				<header>GO Horizon Air Travels Ltd.<br>Reset Password</header>
				
				<fieldset>					
					<div class="row">
						
							<label class="input">
								<a>Enter Your User ID</a>
								<input type="text" name="oldPassword"
								id="oldPassword" placeholder="User ID">
								<span id="spanOldPassword"></span>
							</label>

			</fieldset>
					
				<footer>
					
					<button type="submit" class="button">Reset Password</button>
					
				</footer>
			</form>
			
		</div>
	</body>
</html>