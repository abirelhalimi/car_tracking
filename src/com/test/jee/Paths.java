package com.test.jee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Car;
import Models.Path;

/**
 * Servlet implementation class Position
 */
@WebServlet("/paths")
public class Paths extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Paths() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null) {
	        //forward request to login.jsp
	        request.getRequestDispatcher("/login").forward(request, response);
	    } else {
	    	Long idCar=Long.parseLong(request.getParameter("idCar"));
	    	Car car=new Car(idCar);
	    	ArrayList<Path> paths=new ArrayList<Path>();
	    	
	    	paths=car.carPaths();
	    	request.setAttribute("paths", paths); 
	    	request.setAttribute("model", car.getModel());
	    	this.getServletContext().getRequestDispatcher("/WEB-INF/jsp_templates/paths.jsp").forward(request, response);
	  
	    }
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
