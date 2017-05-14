<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Flight</title>
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

<link rel="shortcut icon" href="airline.png"/>
    <style>
      body { 
          background-image: url(addflight.jpeg);
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
<body  class="leftshift" style="top:40%;" class="bg-cyan">

   <div div class="body body-s">


        <form action="addFlight" onsubmit="return validation()" method="post" class="sky-form">

        <header>GO Horizon Air Travels Ltd.<br>Add New Flight</header>




        <fieldset>          
          <div class="row">
            
              <label class="input">
                <a>Flight Name</a>
                <input type="text" name="flightName" id="flightName" placeholder="Enter Flight Name">
                <span id="spanFlightName"></span>
              </label>

            
          
          
              <label class="input">
                <a>Seating Capactiy</a>
                <input type="text" name="seatingCapacity"

                id="seatingCapacity" placeholder="seatingCapacity" />
                <span id="spanSeatingCapacity"></span>
              </label>
            
          
          
            
              <label class="input">
                <a>Reservation Capacity</a>
                <input type="text" name="reservationCapacity"

                id="reservationCapacity" placeholder="reservationCapacity" />
                <span id="spanReservationCapacity"></span>
              </label>
              
              <c:if test="${not empty message}">
              <label class="input">
                ${message}
              </label>
            </c:if>
          
          </fieldset>

         
         <footer>
          
          <button type="submit" class="button" >ADD THIS FLIGHT</button>
          
        </footer>
             
          </table>

        </form>

    
  </div>
</body>
</html>