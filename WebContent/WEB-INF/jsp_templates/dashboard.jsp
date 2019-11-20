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

    <title>Dashboard</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="css/product.css" rel="stylesheet">
    <style>
    .bgimg{
	background-image: url('images/bmw.jpg');
	
	-webkit-background-size: cover;
	color: #ffffff;
	}
    </style>
    <!-- URL IMAGE: https://www.bmw.com.au/content/dam/bmw/common/all-models/m-series/m3-sedan/2017/at-a-glance/BMW-m3-sedan-at-a-glance-driving-dynamics-desktop.jpg.asset.1487342976922.jpg-->

  </head>

  <body>
  	<% User user=(User)session.getAttribute("user");%>	

    <nav class="site-header sticky-top py-1">
      <div class="container d-flex flex-column flex-md-row justify-content-between">
        <a class="py-2 d-none d-md-inline-block" href="/test/dashboard">
        <img src="https://users.cs.cf.ac.uk/KurtevaA/Final%20Year%20Project/FYP/home.png" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mx-auto"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line>
          
       </a>
        <a class="py-2 d-none d-md-inline-block" href="/test/carSettings">Cars settings</a>
        <a class="py-2 d-none d-md-inline-block" href="/test/accountSettings">Account settings</a>
        <a class="py-2 d-none d-md-inline-block" href="/test/carsPositions">My Cars</a>
        <a class="py-2 d-none d-md-inline-block" href="/test/SingOut">Sign out</a>
      </div>
    </nav>

      <div class="bgimg">
     <br>
     
        <h1 style="text-shadow: 0 0 20px #000000; font-family:comic-sans-ms; color:#C5C4D1; font-size:400%; " >&nbsp;
        Hello<br>&nbsp; <%=(user.getFname()+" "+user.getLname())%> </h1>
        
      <br><br><br><br><br><br><br><br><br><br><br> <br> <br><br><br>
      </div>
      <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
        
        <p class="lead font-weight-normal">Global Positioning System tracking is a method of working out exactly where something is. A GPS tracking system is placed in a vehicle. It works by providing information on exact location. It can also track the movement of the vehicle by recording the position of vehicles as they make their journeys and sending the information to a centralized database or system via a modem within the GPS system unit on a regular basis.</p>
        
      </div>
     
      <br>
    
    <footer class="container py-5">
      <div class="row">
        <div class="col-12 col-md">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mb-2"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line></svg>
          <small class="d-block mb-3 text-muted " >Projet JEE <br>&copy;2018-2019</small>
        </div>
        
        <div class="col-6 col-md">
          <h5>Linked In</h5>
          <ul class="list-unstyled text-small">
            <li><a class="text-muted" href="https://www.linkedin.com/in/abdellah-naji-74a759160">Abdellah Naji</a></li>
            <li><a class="text-muted" href="https://www.linkedin.com/in/abir-el-halimi-6a404048/">Abir EL Halimi</a></li>
            <li><a class="text-muted" href="https://www.linkedin.com/in/yassine-hammouch-9b7b27157/">Yassine Hammouch</a></li>
            <li><a class="text-muted" href="https://www.linkedin.com/in/samia-nadi-130010131/">Samia Nadi</a></li>
          </ul>
        </div>
        <div class="col-6 col-md">
          <h5>Facebook</h5>
          <ul class="list-unstyled text-small">
            <li><a class="text-muted" href="https://web.facebook.com/profile.php?id=100009765859261">Abdellah Naji</a></li>
            <li><a class="text-muted" href="https://web.facebook.com/abir.elhalimi">Abir EL Halimi</a></li>
            <li><a class="text-muted" href="https://web.facebook.com/yh1337">Yassine Hammouch</a></li>
            <li><a class="text-muted" href="https://web.facebook.com/samia.nady.71">Samia Nadi</a></li>
          </ul>
        </div>
        
        <div class="col-6 col-md">
          <h5>Partners</h5>
          <ul class="list-unstyled text-small">
            <li><a class="text-muted" href="http://ensias.um5.ac.ma/">ENSIAS</a></li>
            <li><a class="text-muted" href="https://web.facebook.com/olympiades.ensias.33">Ensias Olympic Games</a></li>
            <li><a class="text-muted" href="https://www.google.com/maps">Google Maps</a></li>
            <li><a class="text-muted" href="https://www.pinterest.com/">Pinterest</a></li>
          </ul>
        </div>
        <div class="col-6 col-md">
          <h5>About</h5>
          <ul class="list-unstyled text-small">
            <li><a class="text-muted" href="">Team</a></li>
            <li><a class="text-muted" href="">Locations</a></li>
            <li><a class="text-muted" href="">Privacy</a></li>
            <li><a class="text-muted" href="">Terms</a></li>
          </ul>
        </div>
      </div>
    </footer>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
    
    <script>
      Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
      });
    </script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 
  </body>
</html>

