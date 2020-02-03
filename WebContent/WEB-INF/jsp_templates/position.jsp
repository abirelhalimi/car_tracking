
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Models.Location" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Location</title>
  <head>
    <style>
       /* Set the size of the div element that contains the map */
      #map {
        height: 520px;  /* The width is the width of the web page */
       }
    </style>
  
  <link href="css/product.css" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
  <body>
  <%Location location=(Location)request.getAttribute("location"); %>
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


    //............. beginning of maps code ...........


    <div id="map"></div>
    <script>
// Initialize and add the map
function initMap() {

  // ..... lat: for latitude p long: for longitude 
//..............................................

  var uluru = {lat:<%=location.getLatitude() %> , lng: <%=location.getLongitude() %>};
  // The map, centered at Uluru
  var map = new google.maps.Map(
      document.getElementById('map'), {zoom: 17, center: uluru});
  // The marker, positioned at Uluru
  var marker = new google.maps.Marker({position: uluru, map: map});
}
    </script>
    <!--Load the API from the specified URL
    * The async attribute allows the browser to render the page while the API loads
    * The key parameter will contain your own API key (which is not needed for this tutorial)
    * The callback parameter executes the initMap() function
    -->
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=ENTER_YOUR_KEY_HERE&callback=initMap">
    </script>

//............. end of maps code ...........


  </body>
</html>
