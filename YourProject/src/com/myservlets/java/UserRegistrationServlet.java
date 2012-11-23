package com.myservlets.java;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.myclasses.java.InsertValues;
import com.myclasses.java.Users;

/**
 * Servlet implementation class UserRegistrationServlet
 */
@WebServlet("/UserRegistrationServletPath")
public class UserRegistrationServlet extends HttpServlet {
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
		int userId;
		String firstname;
		String lastname;
		String address;
		String city;
		String state;
		int pincode;
		int telephone;
		int mobile;
		String email;
		String password;
		
		// userId =Integer.parseInt(request.getParameter("userId"));
		// username
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		address = request.getParameter("address");
		city = request.getParameter("city");
		state = request.getParameter("state");
		pincode = Integer.parseInt(request.getParameter("pincode"));
		telephone = Integer.parseInt(request.getParameter("telephone"));
		mobile = Integer.parseInt(request.getParameter("mobile"));
		email = request.getParameter("email");
		password = request.getParameter("password");	
		
		Users record=new Users();
		
		record.setUsername(email);
		record.setFirstname(firstname);
		record.setLastname(lastname);
		record.setAddress(address);
		record.setCity(city);
		record.setState(state);
		record.setPincode(pincode);
		record.setTelephone(telephone);
		record.setMobile(mobile);
		record.setPassword(password);
		record.setEmail(email);
		
		SessionFactory sessionFactory=configureSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(record);
		session.getTransaction().commit();
		session.close(); 
		
		request.getSession().setAttribute("message", "Registration Successful!");
		response.sendRedirect("home.jsp");
		
	}

	private static SessionFactory configureSessionFactory(){
		SessionFactory sessionFactory;
		ServiceRegistry serviceRegistry;
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
}
