<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Password</title>


<script type="text/javascript">
	function validate() {
		var passwordPattern = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;

		

		var oldPassword = document.getElementById("oldPassword").value;
		if (oldPassword == "") {
			document.getElementById("spanOldPassword").innerHTML = "Old Password Cannot be empty";
			return false;
		}
		document.getElementById("spanOldPassword").innerHTML = "";

		

		var newPassword = document.getElementById("newPassword").value;
		if (oldPassword == newPassword) {
			document.getElementById("spanNewPassword").innerHTML = "Old and New Password cannot be same";
			return false;
		} else {
			if (newPassword.length > 5 && newPassword.length < 16) {
				if (newPassword.match(passwordPattern) == null) {
					document.getElementById("spanNewPassword").innerHTML = "Password Must Contain One UpperCase, One LowerCase and One Numeric";
					return false;
				}
			} else {
				document.getElementById("spanNewPassword").innerHTML = "Password length must be in between 6 & 15";
				return false;
			}
		}
		document.getElementById("spanNewPassword").innerHTML = "";

		

		var cPassword = document.getElementById("confirmPassword").value;
		if (!(cPassword == newPassword)) {
			document.getElementById("spanConfirmPassword").innerHTML = "Both Passwords must be same";
			return false;
		}
		document.getElementById("spanConfirmPassword").innerHTML = "";
		return true;
	}

</script>

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
		
			<form name="MyForm" onsubmit="return validate()"  method="GET" class="sky-form" action="changePassword">
				<header>GO Horizon Air Travels Ltd.<br>Reset Password</header>
				
				<fieldset>					
					<div class="row">
						
							<label class="input">
								<a>Enter Old Password</a>
								<input type="password" name="oldPassword"
								id="oldPassword" placeholder="Old Password">
								<span id="spanOldPassword"></span>
							</label>

						
					
					
							<label class="input">
								<a>Enter New Password</a>
								<input type="password" name="newPassword"
								id="newPassword" placeholder="New Password" />
								<span id="spanNewPassword"></span>
							</label>
						
					
					
						
							<label class="input">
								<a>Confirm New Password</a>
								<input type="password" name="password"
								id="confirmPassword" placeholder="Confirm Password" />
								<span id="spanConfirmPassword"></span>
							</label>
							
							
						
					
					</fieldset>
					
				<footer>
					
					<button type="submit" class="button">Reset Password</button>
					
				</footer>
			</form>
			
		</div>
	</body>
</html>