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




@WebServlet("/login")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogIn() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp_templates/login.jsp").forward(request, response);
		
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user=(User) request.getSession().getAttribute("user");
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String phone = request.getParameter("phone");
		String day = request.getParameter("day");
		String month=request.getParameter("month");
		String year=request.getParameter("year");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		
		if(!(pass1.equals(pass2)))  {
			request.setAttribute("error", "Your passwords don't match!!"); 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp_templates/account_settings.jsp");
			dispatcher.forward( request, response);
		}
		else {
			     
			Admin.editAccount(user.getId(),fname , lname, phone, day, month, year, pass1, pass2);
	    	HttpSession session = request.getSession(false);
	        if(session != null) session.invalidate();
	        response.sendRedirect(request.getContextPath() + "/home");	
		}
		
	}

}
