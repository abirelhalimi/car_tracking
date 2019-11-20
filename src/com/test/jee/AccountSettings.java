package com.test.jee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/accountSettings")
public class AccountSettings extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AccountSettings() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null) {
	        //forward request to login.jsp
	        request.getRequestDispatcher("/login").forward(request, response);
	    } else {
	    	this.getServletContext().getRequestDispatcher("/WEB-INF/jsp_templates/account_settings.jsp").forward(request, response);
	    }
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
