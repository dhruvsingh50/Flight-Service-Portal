<!DOCTYPE html>
<html>
<head>
	<title>Welcome Customer</title>
	<link rel="shortcut icon" href="airline.png" />
	<link rel="stylesheet" type="text/css" href="styles.css">
	<meta charset='utf-8'>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/styles.css">
	<script src="css/jquery-latest.min.js" type="text/javascript"></script>
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

<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("UserId")==null)
      response.sendRedirect("loginpage.jsp");

  %>
<body>
	<div class="left" style="top:2%; left:15%; position:absolute;">
		<img src="logo-template.jpg" width="200" height="140"/>
	</div>
	
	<div class="right" style="top:5%; left:31.5%; position:absolute;">
		<h1 style="color:silver;">GO Horizon Air Travels Ltd.</h1>
	</div>
	
	<div class="right" style="top:12%; left:85%; position:absolute;">
		<a style="color:white;" href="loginpage.html">Home</a>
	</div>
	
	<div class="right" style="top:12%; left:91.5%; position:absolute;">
		<a style="color:white;" href="Logout">Logout</a>
	</div>

	<div class="left" style=" width:40%; top:25%; left:5%; position:absolute;"> 
		
			
			<div id='cssmenu'>
                <ul>
                    <li class="active"><a href='customerhome.jsp'><span>Home</span></a></li>
                    <li class=' has-sub'><a href='Res'><span>Reserve Tickets</span></a></li>
                    <li class='has-sub'><a href='CancelTicket.jsp'><span>Cancel Tickets</span></a></li>
                     <li class='has-sub'><a href='TicketView.jsp'><span>View Tickets</span></a></li>
                    <li class='has-sub last'><a href='#'><span>Print Tickets</span></a></li>
                </ul>
            </div>
        
	</div>
	
	<div class="right" style=" color:white; width:50%;right:25%;top:91%; position:absolute;">
		<h4 style="text-align:center;">Copyright &#169 2013 Wipro Technologies. All Rights Reserved.</h4>
	</div>
</body>
</html>