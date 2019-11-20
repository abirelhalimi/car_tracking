package com.test.jee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Admin;
import Models.User;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Dashboard() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getSession().getAttribute("user")==null) {
	        request.getRequestDispatcher("/login").forward(request, response);
	    }
		else {
	    	this.getServletContext().getRequestDispatcher("/WEB-INF/jsp_templates/dashboard.jsp").forward(request, response);
	    }
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String passw = request.getParameter("passw");
		
		Admin admin=new Admin();
		
		User user=admin.correctLogin(email,passw);
		
		if( user!=null){
			if(user.getFname()==null) {
				request.setAttribute("error", "probleme de connexion au server!!"); 
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp_templates/login.jsp");
				dispatcher.forward( request, response);
			}
			else {
				HttpSession session=request.getSession();
				session.setAttribute("user", user);	
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp_templates/dashboard.jsp").forward(request, response);	
			}
		}
		else {
			request.setAttribute("error", "Invalid username or password"); 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp_templates/login.jsp");
			dispatcher.forward( request, response);
		}
	
	}
	


}