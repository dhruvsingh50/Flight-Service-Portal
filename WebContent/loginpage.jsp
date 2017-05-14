<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Aboard</title>
	<link rel="shortcut icon" href="airline.png" />
	<style>
		body { 
		    background-image: url(background.jpg);
		    background-repeat: repeat;
		    background-attachment: fixed;
		    background-position: center; 
		}
		input:focus {
   			background-color:#C0C0C0;
		}
		h1{
    	font-family: "Comic Sans MS",bold, cursive, sans-serif;
    	text-decoration: underline;
		}
		h2{
			color: yellow;
		}
		div{
			color: silver;
		}
	</style>
</head>
<body>


<marquee behavior="slide" direction="right">
		<img src="logo-template.jpg" width="200" height="140"style="top:0%; left:17%;"/>
	</marquee>
	
	<div class="right" style="top:5%; left:31.5%; position:absolute;">
		<h1 style="color:silver;">GO Horizon Air Travels Ltd.</h1>
	</div>
	
	<div class="right" style="top:12%; left:70%; position:absolute;">
		<a style="color:grey;" href="http://www.wipro.com/about-wipro/">About Us</a>
	</div>
	
	<div class="right" style="top:12%; left:77%; position:absolute;">
		<a style="color:grey;" href="http://www.wipro.com/contact/">Contact Us</a>
	</div>

	<div class="left" style=" width:40%; top:25%; left:5%; position:absolute;">
		<h2 ALIGN = "center">GENERAL INFORMATION<hr></h2>
        <p style="text-align:justify;">
        Go HORIZON Air Travel ltd. is an Indian online travel company, founded by Abinash Sarangi in 2015. Headquartered in Hyderabad, India, the company provides online travel services like flight tickets, domestic and international holiday packages and reservations. In September and October 2015, Go HORIZON made strategic acquisitions in pursuit of growth through new channels and markets in Southeast India. Recently, we will be launching Travel Apps for mobile devices. The company has been consistently recognised as one of India's best travel portals. In addition to a full-service online portal, the company also operates through 59 retail stores across 37 cities in India along with international offices in New York City and Sydney.    
        </p>
	</div>
	
	<div class="right" style=" width:40%; top:25%; right:5%; position:absolute;">
		<h2 ALIGN = "center">LOGIN /<a style="color:yellow;"href="Register.jsp">REGISTER</a><hr></h2>
		<form action="Login" method="post">
	        <table align = "center" cellpadding="15">
	            <tr><td style="">
	        	USERID:</td><td>
	        	
	            <input type="text" name="Userid" placeholder="Userid" style="width:200px; height:20px;" required>
	            </td></tr>

	            <tr><td>
	        	PASSWORD:</td><td>
	            <input type="password" name="password" placeholder="password" style="width:200px; height:20px;" required>
	            </td></tr>

	            <tr><td><label><input id="rememberme" name="rememberme" value="remember" type="checkbox" /> &nbsp;Remember me</label></td><td>
	            	<input type="submit" value="Login">
	            	
	            </td></tr>  

	            <tr><td style="color:yellow;">Forgot Your Password?</td>
	            <td><a href='password.jsp' style="color:white;">Click To Reset Password</a></td></tr>

	            <tr><td></td><td >	
	            	<a title="find us on Facebook" href="https://www.facebook.com/WiproTechnologies/"><img src="facebook.png"width="80" height="30"></a>
	            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            	<a title="follow me on twitter" href="https://twitter.com/Wipro"><img src="twitter.png" width="79" height="29"></a>
	            </td></tr>       
	        </table> 
	        </form>   
    	
	</div>

	<div class="right" style=" color:black; width:50%;right:25%;top:91%; position:absolute;">
		<h4 style="text-align:center;">Copyright &#169 2013 Wipro Technologies. All Rights Reserved.</h4>
	</div>

</body>
</html>