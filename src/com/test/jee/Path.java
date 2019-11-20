package com.test.jee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Location;


@WebServlet("/path")
public class Path extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public Path() {
        super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null) {
			
	        request.getRequestDispatcher("/login").forward(request, response);
	    }
		else {
			Long idPath=Long.parseLong(request.getParameter("idPath"));
			Models.Path path=new Models.Path(idPath);
			ArrayList<Location> locations=new ArrayList<Location>();
	    	locations=path.pathLocations();

			request.setAttribute("locations", locations);
			request.setAttribute("location", locations.get(0));
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp_templates/path.jsp").forward(request, response);
	    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
