<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="Models.User" %>
 <%@ page import="Models.Car" %>
  <%@ page import="java.util.ArrayList" %>
 
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>My Cars</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    
    <link href="css/product.css" rel="stylesheet">
    <style>
    .bgimg{
	background-image: url('images/bmw.jpg');
	text-align: center;
	-webkit-background-size: cover;
	color: #ffffff;
	}
	
	.butn{
	height: 20px;
	width: 100px;
	box-shadow: 2px 2px 7px 1px #1C6EA4;
	}
	.bgimage {
		background-image: url('images/pic1.jpg');
		-webkit-background-size: cover;
		background-position: center center;
	}
	
	.bg-trans {
		background-color: rgba(234,223,239,0.7);
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

    <div role="main" class="container">
      
	<% ArrayList<Car> cars=(ArrayList<Car>)request.getAttribute("cars");%>
      <div class="my-3 p-3 bg-trans rounded box-shadow">
        <h6 class=" border-gray pb-2 mb-0">My Cars</h6>
        </div>
        <% for(Car car:cars){%>
        <div class="media bg-trans text-muted pt-3  rounded p-3 ">
          <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded" src="images/im.svg">
           <p class="media-body pb-3 mb-0 small lh-125  border-gray">
           <font color="black">
            <strong class="d-block "><%=car.getModel() %></strong>
           <strong>Car Id : </strong> <%=car.getId() %><br>
           <strong> Car number : </strong><%=car.getMatricule() %><br>
            <strong> Id Gray Card : </strong><%=car.getGrayCard() %>
            </font>
          </p>
        <a class="btn btn-outline-secondary" href="/test/paths?idCar=<%=car.getId()%>">Paths</a>&nbsp;
        <a class="btn btn-outline-secondary" href="/test/position?idCar=<%=car.getId()%>">Current position</a>&nbsp;
        
        </div>
        <br>
        <% }%>
        
        
      </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    
    <script>
      Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
      });
    </script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <script src="js/offcanvas.js"></script>
  </body>
</html>

