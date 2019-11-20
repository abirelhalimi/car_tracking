package com.test.jee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Models.Car;
import Models.User;


@WebServlet("/carsPositions")
public class CarsPositions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CarsPositions() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("user")==null) {
	        request.getRequestDispatcher("/login").forward(request, response);
	    }
		else {
	    	User user=(User) request.getSession().getAttribute("user");
	    	ArrayList<Car> cars=new ArrayList<Car>();
	    	
	    	cars=user.userCars();
	    	
	    	request.setAttribute("cars", cars); 
	    	this.getServletContext().getRequestDispatcher("/WEB-INF/jsp_templates/cars_positions.jsp").forward(request, response);
	    }
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
