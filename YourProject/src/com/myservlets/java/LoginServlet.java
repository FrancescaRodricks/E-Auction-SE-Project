package com.myservlets.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.mybusiness.services.LoginService;
import com.myclasses.java.Users;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServletPath")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username, password;
		username=request.getParameter("username");
		password=request.getParameter("password");
		
		LoginService loginService=new LoginService();
		boolean result=loginService.authenticate(username, password);
		
		if(result){
			Users user=loginService.getUserDetails(username);
			// request.setAttribute("user", user);
			// RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
			// dispatcher.forward(request, response);
			
		
			request.getSession().setAttribute("userId", user.getUserId());
			request.getSession().setAttribute("username", user.getUsername());
			request.getSession().setAttribute("message", "Welcome, "+user.getFirstname());
			response.sendRedirect("home.jsp");
			return;
		} else {
			String message="Username or Password do not match!";
			request.getSession().setAttribute("error_message", message);
			response.sendRedirect("login.jsp");
			return;
		}
	}
	


}
