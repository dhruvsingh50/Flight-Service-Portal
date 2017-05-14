<!DOCTYPE html>
<html>
<head>
	<title>Welcome Admin</title>
	<link rel="shortcut icon" href="airline.png" />
	<link rel="stylesheet" type="text/css" href="styles.css">
	<meta charset='utf-8'>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/styles.css">
	<link rel="stylesheet" href="tableshow.css">
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
		<a style="color:white;" href="adminhome.jsp">Home</a>
	</div>
	
	<div class="right" style="top:12%; left:91.5%; position:absolute;">
		<a style="color:white;" href="Logout">Logout</a>
	</div>

	<div class="left" style=" width:40%; top:25%; left:5%; position:absolute;"> 
		
			
			<div id='cssmenu'>
                <ul>
                    <li class="active"><a href='adminhome.jsp'><span>Home</span></a></li>
                    <li class=' has-sub'><a href='#'><span>Manage Flights</span></a>
    	                <ul>
    		                <li><a href='addFlight.jsp'><span>Add Flights</span></a></li>
    		                <li><a href='deleteFlight.jsp'><span>Delete Flights</span></a></li>
    		                <li><a href='viewallFlightt'><span>Modify Flights</span></a></li>
    		                <li class='last'><a href='viewallFlight'><span>Show Flights</span></a></li>
    		 	        </ul>
                    </li>
                    <li class='has-sub'><a href='#'><span>Manage Routes</span></a>
                        <ul>
    		                <li><a href='addRoute.jsp'><span>Add Routes</span></a></li>
    		                <li><a href='deleteRoute.jsp'><span>Delete Routes</span></a></li>
    		                <li><a href='ViewRoutee'><span>Modify Routes</span></a></li>
    		 	            <li class='last'><a href='ViewRoute'><span>Show Routes</span></a></li>
    	                </ul>
                    </li>
                    <li class='has-sub last'><a href='#'><span>Manage Schedules</span></a>
                        <ul>
                            <li><a href='AddSchedule'><span>Add Schedules</span></a></li>
                            <li><a href='deleteSchedule.jsp'><span>Delete Schedules</span></a></li>
                            <li><a href='viewallschedulese'><span>Modify Schedules</span></a></li>
                    		<li class='last'><a href='viewallschedules'><span>Show Schedules</span></a></li>
    		            </ul>
                    </li>
                </ul>
            </div>
        
	</div>
	<!-- <div class="tableshow" style=" width:40%; top:25%; right:5%; position:absolute; ">
		<table style="padding:10px;">
			<tr>
    			<th>Flight ID</th>
    			<th>Flight Name</th>
    			<th>Seating Capacity</th>
    			<th>Reservation Capacity</th>
  			</tr>
  			<tr>
  			<td></td>
  			<td></td><td></td><td></td></tr>
  		</table>
	</div> -->
	<div class="right" style=" color:white; width:50%;right:25%;top:91%; position:absolute;">
		<h4 style="text-align:center;">Copyright &#169 2013 Wipro Technologies. All Rights Reserved.</h4>
	</div>
</body>
</html>