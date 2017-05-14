<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("UserId")==null)
      response.sendRedirect("loginpage.jsp");

  %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="externals/bootstrap/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="externals/bootstrap/css/bootstrap-theme.min.css"/>
<link rel="stylesheet" type="text/css" href="externals/main.css"/>
<link rel="stylesheet" href="externals/styles.css" />
<script type="text/javascript"  src="externals/bootstrap/js/bootstrap.min.js" ></script>
<script type="text/javascript"  src="externals/bootstrap/js/jquery-2.1.4.min.js"></script>
<script src="externals/jquery-latest.min.js" type="text/javascript"></script>
<script src="externals/script.js"></script>
<script type="text/javascript">
  function validation() {

    var alpha = /^([a-zA-Z ])+$/;
    var numeric = /^[0-9\b]+$/;

    

    var FlightName = document.getElementById("flightName").value;

    if (FlightName.length != 0)
     {
      if (FlightName.match(alpha) == null) 
      {
        document.getElementById("spanFlightName").innerHTML = "Flight Name must be combination of Alphabets only";

        return false;
      } 
      else 
      {
        if ((FlightName.length < 2) || (FlightName.length >= 15)) 
        {
          document.getElementById("spanFlightName").innerHTML = "Flight Name must between 2 and  15";
          return false;
        }
      }
     } 

    else
     {
      document.getElementById("spanFlightName").innerHTML = "Flight Name cannot be empty";
      return false;
     }


    document.getElementById("spanFlightName").innerHTML = "";

    
    var Seating = document.getElementById("seatingCapacity").value;

    if (Seating.length != 0) 
    {

      if (Seating.match(numeric) == null) 
      {
        document.getElementById("spanSeatingCapacity").innerHTML = "Wrong Input. Seating Capacity must be Numeric only";
       
        return false;
     
      } 
      else
       {
        if ((Seating < 100) || (Seating >= 500)) 
        {
          document.getElementById("spanSeatingCapacity").innerHTML = "Wrong Input. Seating capacity must be between 100 to 500";
          return false;
        }
      }
    } 
    else
     {
      document.getElementById("spanSeatingCapacity").innerHTML = "There should bw a value for Seating capacity. It can not be empty.";
      return false;
     }

    document.getElementById("spanSeatingCapacity").innerHTML = "";

    
    var Reservation = document.getElementById("reservationCapacity").value;

    if (Reservation.length != 0) 
    {

      if (Reservation.match(numeric) == null) 
      {
        document.getElementById("spanReservationCapacity").innerHTML = "Wrong input. Reservation Capacity must be a numeric";
        
        return false;
      } 
      else {
        
            if (Reservation >= 70)
            {
             document.getElementById("spanReservationCapacity").innerHTML = "Reservation capacity must be less than 70";
            return false;
            }
           }
    } else 
    {
      document.getElementById("spanReservationCapacity").innerHTML = "Reservation Capacity cannot be empty";
      return false;
    }
    document.getElementById("spanReservationCapacity").innerHTML = "";
  }
</script>
<title>View Routes</title>
</head>

<body>
<div class="container " >
<div class="row ">
<div class="row header-row1 " >
<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2" ><img src="Images/logo.png" class="img-responsive img-rounded"  /></div>
<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 text-center" >
<h2 class="h2" style="color:#000; text-indent:hanging;text-shadow: 2px 2px 5px #000">Welcome to GO HORIZON Air Travel Pvt Ltd.</h2></div>
</div><!--first row--->

<div class="row header-row2" >



<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 text-center">
<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"><a style="line-height:20px; padding:5px; box-shadow:0px 3px 5px #093;" class="btn-success" href="adminhome.jsp">Home</a></div>
<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"><a style="line-height:20px; padding:5px; box-shadow:0px 3px 5px #F00;" class="btn-danger" href="Logout">Logout</a></div>


</div>
</div><!--secoend row--->
</div><!--header ends--->
</div><!--sub contaiener 1 ends--------->
<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9 sub-container-2" style="padding:30px;">

<div class="viewflightform">
<h2 class="h2" style="color:green;">${message}</h2>
<h2 class="h2" style="color:red;">${message2}</h2>

<h1 class="h1 btn-info" style="line-height:30px; padding:15px; box-shadow:0px 3px 10px #000;">List of available Routes</h1>
  
<table class="table table-bordered table-responsive text-center table-hover">
  <tr>
    <th style="background-color:white;"scope="col" >Route Id</th>
    <th style="background-color:white;" scope="col">Source</th>
    <th style="background-color:white;" scope="col">Destination</th>
    <th style="background-color:white;" scope="col">Distance</th>
    <th style="background-color:white;" scope="col">Fare</th><!-- 
   <th style="background-color:white;" scope="col">&nbsp;</th>
    <th style="background-color:white;" scope="col">&nbsp;</th> -->
  </tr>
  <c:forEach items="${al}" var="RouteBean">
  <tr>
    <td><label>${RouteBean.routeID}</label></td>
    <td><label>${RouteBean.source}</label></td>
    <td><label>${RouteBean.destination}</label></td>
    <td><label>${RouteBean.distance}</label></td>
   	<td><label>${RouteBean.fare}</label></td>
  	<td >
   <form action="modifyroute" method="post" >
    <input type="hidden" name="routeID" value="${RouteBean.routeID}" />
    <input class="btn btn-success"  type="submit" value="edit" name="edit" />  
    </form>
    </td>
  </tr>
   </c:forEach>
</table>
  </div>
</div><!--- sub container 2 ends---->
</div><!--- sub container ends---->
<div style="position: absolute;top:90%; left :30%;" class="panel-footer text-center">Copyright &copy; 2015 Wipro Technologies. All rights reserved</div>



</div><!--Container ends-->

</body>
</html>
