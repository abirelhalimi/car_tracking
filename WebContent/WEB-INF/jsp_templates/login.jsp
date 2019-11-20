<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
<style>
.bggg{
	background-image: url('images/aa.jpg');
	
	}
</style>
 <link href="css/signin.css" rel="stylesheet">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 
</head>
<body class="bggg">

<div style="text-align:center;">
<a class="py-2 d-none d-md-inline-block" href="/test/home">
        <img src="https://users.cs.cf.ac.uk/KurtevaA/Final%20Year%20Project/FYP/home.png" width="32" height="32" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mx-auto"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line>
 </a>
 <h1 style="text-align:center; font-family:garamond; font-style: italic; comic-sans-ms; color: white; font-size:80px "> Welcome Back! </h1><br /><br />
 
 <form class="form-signin" action="/test/dashboard" method="post">
       
     
      <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
      
      
      <input type="password" name="passw" id="inputPassword" class="form-control" placeholder="Password" required>
      <%
		String login_msg=(String)request.getAttribute("error");  
		if(login_msg!=null)
		out.println("<font color=red size=4px>"+login_msg+"</font>");
	  %>
	  <br />
      <button class="btn btn-lg btn-block" type="submit">Sign in</button><br /><br />
 	
    </form>
	
    </div>
 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 
</body>
</html>