<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SignUp</title>

    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="css/form-validation.css" rel="stylesheet">
    <style>
    .bggg{
	background-image: url('images/aa.jpg');
	}
    </style>
  </head>

  <body class="bggg">
  <div style="text-align:center;">
  <br>
<a class="py-2 d-none d-md-inline-block" href="/test/home">
        <img src="https://users.cs.cf.ac.uk/KurtevaA/Final%20Year%20Project/FYP/home.png" width="32" height="32" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mx-auto"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line>
 </a></div>
    <div class="container">
      

      
       
        <div class="py-5 text-center">
        <h2 style="color: rgb(211,211,211);" >Sign Up</h2>
        </div>
        <div class="alert alert-warning">
  <strong>
  <%
				String email=(String)request.getAttribute("error1");  
				if(email!=null)
				out.println("<font color=red size=4px>"+email+"</font>");
				
				String passs=(String)request.getAttribute("error2");  
				if(passs!=null)
				out.println("<font color=red size=4px>"+passs+"</font>");
	 		
	 		%></strong> 
</div>
          <form class="needs-validation"  action="/test/home" method="post">
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName" style="color: rgb(211,211,211);">First name</label>
                <input type="text" class="form-control" name="fname" id="firstName" placeholder="" value="" required>
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="lastName" style="color: rgb(211,211,211);">Last name</label>
                <input type="text" class="form-control" name="lname" id="lastName" placeholder="" value="" required>
                <div class="invalid-feedback">
                  Valid last name is required.
                </div>
              </div>
            </div>

            <div class="mb-3">
              <label for="email" style="color: rgb(211,211,211);">Email</label>
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text">@</span>
                </div>
                <input type="email" class="form-control" name="email" id="email" placeholder="you@example.com" required>
                <div class="invalid-feedback" style="width: 100%;">
                  Valid email address is required.
                </div>
              </div>
            </div>
            
            
           

            <div class="mb-3">
              <label for="address" style="color: rgb(211,211,211);">Phone number</label>
              <input type="text" class="form-control" name="phone" id="phone" placeholder="0666666666" required>
              <div class="invalid-feedback">
                Please enter your phone number.
              </div>
            </div>
 			<label for="bdate" style="color: rgb(211,211,211);">Birth Date</label>
            <div class="row">
            	<div class="col-md-4 mb-3">
	                <select class="custom-select d-block w-100"  name="day" id="day" required>
	          		  <option value="">choose a day</option>
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
	          		  <option value="">choose a month</option>
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
                <input type="number" class="form-control" name="year" id="yyyy" placeholder="Choose a year"  min="1900" max="2018" required>
                <div class="invalid-feedback">
                  Please provide a valid year.
                </div>
              </div>
            </div>
            
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="password" style="color: rgb(211,211,211);">Password</label>
                <input type="password" class="form-control" name="pass1" id="pass" placeholder="" value="" required>
                <div class="invalid-feedback">
                  Password is required.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="password2" style="color: rgb(211,211,211);">Confirm Password</label>
                <input type="password" class="form-control" name="pass2" id="pass2" placeholder="" value="" required>
                <div class="invalid-feedback">
                  Password is required.
                </div>
              </div>
            </div>
            
            
            <hr class="mb-4">
            <button class="btn  btn-lg btn-block" type="submit">Create account</button>
            <hr class="mb-4">
          </form>
      </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../../../assets/js/vendor/popper.min.js"></script>
    <script src="../../../../dist/js/bootstrap.min.js"></script>
    <script src="../../../../assets/js/vendor/holder.min.js"></script>
    <script>
      // Example starter JavaScript for disabling form submissions if there are invalid fields
      (function() {
        'use strict';

        window.addEventListener('load', function() {
          // Fetch all the forms we want to apply custom Bootstrap validation styles to
          var forms = document.getElementsByClassName('needs-validation');

          // Loop over them and prevent submission
          var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
              if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
              }
              form.classList.add('was-validated');
            }, false);
          });
        }, false);
      })();
    </script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
  </body>
</html>
