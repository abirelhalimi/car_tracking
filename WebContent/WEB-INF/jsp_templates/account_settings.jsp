<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="Models.User" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Account Settings</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >

    <!-- Custom styles for this template -->
    <link href="css/product.css" rel="stylesheet">
    <style>
    .bgimage {
		background-image: url('images/pic1.jpg');
		-webkit-background-size: cover;
		background-position: center center;
	}
	
    </style>
  </head>

  <body class="bgimage">
  	<% User user=(User)session.getAttribute("user");%>	

    <nav class="site-header sticky-top py-1">
      <div class="container d-flex flex-column flex-md-row justify-content-between">
        <a class="py-2" href="/test/dashboard">
          <img src="https://users.cs.cf.ac.uk/KurtevaA/Final%20Year%20Project/FYP/home.png" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mx-auto"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line>
         </a>
        <a class="py-2 d-none d-md-inline-block" href="/test/carSettings">Cars settings</a>
        <a class="py-2 d-none d-md-inline-block" href="/test/accountSettings">Account settings</a>
        <a class="py-2 d-none d-md-inline-block" href="/test/carsPositions">My Cars</a>
        <a class="py-2 d-none d-md-inline-block" href="/test/SingOut">Sign out</a>
      </div>
    </nav>
    
   
	
	 <div class="container">
	 <div class="py-5 text-center">
	  <form action="/test/SingOut" method="post">
		<button class="btn btn-primary btn-lg btn-block" onclick="return confirm('All your cars and their positions will be deleted...\nContinue?!! ');" type="submit">Delete your account</button>
	</form>
	<br>
        <h2 style="color: black;" >Edit your Account</h2>
        </div>
<form class="needs-validation"  action="/test/login" method="post">
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName" style="color: black;">First name</label>
                <input type="text" class="form-control" name="fname" id="firstName" placeholder="" value=<%=user.getFname() %> required>
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="lastName" style="color: black;">Last name</label>
                <input type="text" class="form-control" name="lname" id="lastName" placeholder="" value=<%=user.getLname() %> required>
                <div class="invalid-feedback">
                  Valid last name is required.
                </div>
              </div>
            </div>
            
            
           

            <div class="mb-3">
              <label for="address" style="color:black;">Phone number</label>
              <input type="text" class="form-control" name="phone" id="phone" value=<%=user.getPhone() %> required>
              <div class="invalid-feedback">
                Please enter your phone number.
              </div>
            </div>
 			<label for="bdate" style="color: black;">Birth Date</label>
            <div class="row">
            	<div class="col-md-4 mb-3">
	                <select class="custom-select d-block w-100"  name="day" id="day" required>
	       
	                  <option value="01">01</option>
	                  <option value="02">02</option>
	                  <option value="03">03</option>
	                  <option value="04">04</option>
	                  <option value="05">05</option>
	                  <option value="06">06</option>
	                  <option value="07">07</option>
	                  <option value="08">08</option>
	                  <option value="09">09</option>
	                  <%for(int i=10;i<32;i++){ %>
	                	  <option value="<%=i%>"><%=i%></option>
	                 <%  }%>
	                </select>
	                <div class="invalid-feedback">
	                  Please select a valid day.
                </div>
              </div>
              <div class="col-md-4 mb-3">
	                <select class="custom-select d-block w-100"  name="month" id="month" required>
	          		
	                  <option value="01">01</option>
	                  <option value="02">02</option>
	                  <option value="03">03</option>
	                  <option value="04">04</option>
	                  <option value="05">05</option>
	                  <option value="06">06</option>
	                  <option value="07">07</option>
	                  <option value="08">08</option>
	                  <option value="09">09</option>
	                  <option value="10">10</option>
	                  <option value="11">11</option>
	                  <option value="12">12</option>
	                </select>
	                <div class="invalid-feedback">
	                  Please select a valid month.
                </div>
              </div>
              
              <div class="col-md-4 mb-3">
                <input type="number" class="form-control" name="year" id="yyyy" value="2000"  min="1900" max="2018" required>
                <div class="invalid-feedback">
                  Please provide a valid year.
                </div>
              </div>
            </div>
            
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="password" style="color: black;">New password</label>
                <input type="password" class="form-control" name="pass1" id="pass" placeholder="" value="" required>
                <div class="invalid-feedback">
                  Password is required.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="password2" style="color: black;">Confirm Password</label>
                <input type="password" class="form-control" name="pass2" id="pass2" placeholder="" value="" required>
                <div class="invalid-feedback">
                  Password is required.
                </div>
              </div>
            </div>
             <%
				String passs=(String)request.getAttribute("error");  
				if(passs!=null)
				out.println("<font color=red size=4px>"+passs+"</font>");
	 		%>
            
            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Update Account</button>
            <hr class="mb-4">
          </form>
      </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    
    <script>
      Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
      });
    </script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 
  </body>
</html>

