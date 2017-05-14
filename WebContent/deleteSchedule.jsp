<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DELETE SCHEDULE</title>
<link rel="shortcut icon" href="airline.png"/>
    <style>
      body { 
          background-image: url(deleteFlight.jpg);
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
    
    <link rel="stylesheet" href="register/demo.css">
    <link rel="stylesheet" href="register/sky-forms.css">
</head>
<body class="leftshift" style="top:40%;" class="bg-cyan">
  <div class="body body-s">
    <form action="DeleteSchedule" method="post" class="sky-form">
      <header><br>Delete Schedule<br></header>
      <fieldset>          
        <div class="row">
          <label class="input">
            <h3 style="blue;">Enter Schedule ID:</h3>
            <input type="text" name="scheduleID"><br>
          </label>
        </div>
        
        
        
         <c:if test="${not empty message}">
              <label class="input">
                ${message}
              </label>
            </c:if>
    	</fieldset>
    	<footer>
        	<button type="submit" class="button" >DELETE THIS Schedule</button>
    	</footer>
    </form>
    </div>
  </body>
</html>