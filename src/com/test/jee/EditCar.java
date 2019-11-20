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

/**
 * Servlet implementation class EditCar
 */
@WebServlet("/editCar")
public class EditCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("user")==null) {
	        request.getRequestDispatcher("/login").forward(request, response);
	    } 
		else {
	    	Long idCar=Long.parseLong(request.getParameter("idCar"));
	    	
	    	Car car=Car.carById(idCar);
	    	
	    	request.setAttribute("car", car); 
	    	this.getServletContext().getRequestDispatcher("/WEB-INF/jsp_templates/editCar.jsp").forward(request, response);
	    }
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		ArrayList<Car> cars=new ArrayList<Car>();
		
		String model = request.getParameter("model");
		String matricule = request.getParameter("matricule");
		
		user.editCar(user.getId(), model, matricule);
		
		cars = user.userCars();
    	
    	request.setAttribute("cars", cars); 
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp_templates/car_settings.jsp").forward(request, response);
		
	}

}
