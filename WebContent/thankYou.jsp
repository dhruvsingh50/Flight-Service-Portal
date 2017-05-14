<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thank You For Registering</title>
<link rel="shortcut icon" href="airline.png"/>
    <style>
      body { 
          background-image: url(welcome2.jpg);
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
<body class="right" >
  <div class="body body-s">
    <form action="addFlight" onsubmit="return validation()" method="post" class="sky-form">
      <header><br>Thank You For Registering<br>____________________________</header>
      <fieldset>          
        <div class="row">
          <label class="input">
            <a>This is your User ID:</a>
              <br><br><p>${str}</p>
          </label>
        </div>
    </fieldset>
    <footer>
      <a class="right" href="loginpage.jsp">Proceed To Login</a>
        </footer>
      </form>
    </div>
  </body>
</html>