package com.test.jee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Models.User;


@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Delete() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null) {
	        request.getRequestDispatcher("/login").forward(request, response);
	    } 
		else {
	    	User user=(User) request.getSession().getAttribute("user");
	    	Long idCar=Long.parseLong(request.getParameter("idCar"));
	    	user.deleteCar(idCar);
	    	
	    	this.getServletContext().getRequestDispatcher("/carSettings").forward(request, response);
	    }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
