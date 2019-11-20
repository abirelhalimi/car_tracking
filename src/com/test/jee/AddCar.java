package com.test.jee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Car;
import Models.User;

/**
 * Servlet implementation class AddCar
 */
@WebServlet("/addCar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null) {
	        //forward request to login.jsp
	        request.getRequestDispatcher("/login").forward(request, response);
	    } else {
	    	User user=(User) request.getSession().getAttribute("user");
	    	ArrayList<Car> cars=new ArrayList<Car>();
	    	
	    	cars=user.userCars();
	    	
	    	request.setAttribute("cars", cars); 
	    	this.getServletContext().getRequestDispatcher("/WEB-INF/jsp_templates/addcar.jsp").forward(request, response);
	    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		User user=(User) request.getSession().getAttribute("user");
		String model = request.getParameter("model");
		String matricule = request.getParameter("matricule");
		String graycard = request.getParameter("graycard");
		
		int i= user.addCar(model, graycard, matricule, user.getId());

    	
		if(i==1) {
			ArrayList<Car> cars=new ArrayList<Car>();
	    	
	    	cars=user.userCars();
	    	
	    	request.setAttribute("cars", cars); 
			request.setAttribute("error", "Gray card number  ("+graycard+") already exists"); 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp_templates/addcar.jsp");
			dispatcher.forward( request, response);
		}
		else {
			this.getServletContext().getRequestDispatcher("/carSettings").forward(request, response);
			
		}
		
		

	
	}

}
