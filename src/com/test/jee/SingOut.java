package com.test.jee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Admin;
import Models.User;

@WebServlet("/SingOut")
public class SingOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SingOut() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		        HttpSession session = request.getSession(false);
		        if(session != null) session.invalidate();
		        
		        response.sendRedirect(request.getContextPath() + "/home");		    
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user=(User) request.getSession().getAttribute("user");
		
		Admin.deleteAccount(user);
    	HttpSession session = request.getSession(false);
        if(session != null) session.invalidate();
        response.sendRedirect(request.getContextPath() + "/home");	
	}

}
