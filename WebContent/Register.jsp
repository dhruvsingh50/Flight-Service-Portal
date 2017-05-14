<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Register New User</title>
		<link rel="shortcut icon" href="airline.png"/>
		<style>
			body { 
			    background-image: url(backgroundreg.jpg);
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
		
			<form action="Register" class="sky-form">
				<header>GO Horizon Air Travels Ltd.<br>Register Now</header>
				
				<fieldset>					
					<div class="row">
						<section class="col col-6">
							<label class="input">
								<a>First Name</a>
								<input type="text" name="firstName" placeholder="First name">
							</label>
						</section>
						<section class="col col-6">
							<label class="input">
								<a>Last Name</a>
								<input type="text" name="lastName" placeholder="Last name">
							</label>
						</section>
					</div>

					<section>
						<label class="input">
							<a>Date Of Birth</a>
							<input type="date" name="dateOfBirth" placeholder="Date of birth">
						</label>
					</section>

					<section>
						<label class="select">
							<select name="gender">
								<option value="0" selected disabled>Gender</option>
								<option value="1">Male</option>
								<option value="2">Female</option>
								<option value="3">Other</option>
							</select>
							<i></i>
						</label>
					</section>

					<section>
						<label class="input">
							<a>Address Line 1</a>
							<input type="text" name="street" placeholder="Street Address">
						</label>
					</section>
					
					<section class="input">
							<label class="input">
								<a>Address Line 2</a>
								<input type="text" name="location" placeholder="Locality">
							</label>
					</section>

					<section class="input">
							<label class="input">
								<a>City</a>
								<input type="text" name="city" placeholder="City">
						</label>
					</section>

					<section class="input">
						<label class="input">
							<a>State</a>
							<input type="text" name="state" placeholder="State">
						</label>
					</section>

					<section class="input">
						<label class="input">
							<a>Pin Code</a>
							<input type="text" name="pincode" placeholder="Pin Code">
						</label>
					</section>

					<section>
						<label class="input">
							<a>Mobile Number</a>
							<input type="text" name="mobileNo" placeholder="Mobile Number">
						</label>
					</section>

					<section>
						<label class="input">
							<a>Email Id</a>
							<input type="text" name="emailID" placeholder="Email Id">
						</label>
					</section>
					<section class="input">
							<label class="input">
								<a>Password</a>
								<input type="password" name="password" placeholder="Password">
							</label>
					</section>

				</fieldset>
					
				<fieldset>
					<section>
						<label><input type="checkbox" name="checkbox"><i></i>I agree to the Terms of Service</label>
						<br>
						<label><input type="checkbox" name="checkbox"><i></i>I want to receive news and  special offers</label>
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