package com.test.jee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Admin;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Home() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp_templates/home.jsp").forward(request, response);
		

		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Admin admin=new Admin();
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String day = request.getParameter("day");
		String month=request.getParameter("month");
		String year=request.getParameter("year");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		
		int i=admin.createAccount(fname , lname, email, phone, day, month, year, pass1, pass2 ) ;

			
		if( i==0){
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp_templates/home.jsp").forward(request, response);
			}
		
		if(i==1) {
			request.setAttribute("error1", "Email ("+email+") already exist"); 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp_templates/signup.jsp");
			dispatcher.forward( request, response);
	    } 
		if(i==2)  {
			request.setAttribute("error2", "Your passwords don't match!!"); 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp_templates/signup.jsp");
			dispatcher.forward( request, response);
		}
	}

}
