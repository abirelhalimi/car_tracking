package com.test.jee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Models.Car;
import Models.Location;

@WebServlet("/position")
public class Position extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Position() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getSession().getAttribute("user")==null) {
			
	        request.getRequestDispatcher("/login").forward(request, response);
	    }
		else {
			Long idCar=Long.parseLong(request.getParameter("idCar"));
			Car car=new Car(idCar);
			Location location=car.location();
	    	
			request.setAttribute("location", location);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp_templates/position.jsp").forward(request, response);
	    	}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
