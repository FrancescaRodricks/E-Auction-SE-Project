package com.myservlets.java;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

import com.myclasses.java.Auction;
import com.myclasses.java.InsertValues;
import com.myclasses.java.Products;
import com.myclasses.java.Users;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
 

/**
 * Servlet implementation class CreateAuctionServlet
 */
@WebServlet("/CreateAuctionServletPath")
public class CreateAuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				

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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// int auctionId;
		
		int productId;
		productId=Integer.parseInt(request.getParameter("pid"));
		// System.out.println("product id "+ productId);
		SessionFactory sessionFactory=configureSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Auction newAuction = new Auction();
		String startdate;
		String enddate;
		
		startdate = request.getParameter("startdate");
		enddate = request.getParameter("enddate");
		Calendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR);
	
		int startTime = hour;
		int endTime = hour;
		
		newAuction.setStartDate(startdate);
		newAuction.setEndDate(enddate);
		newAuction.setStartTime(startTime);
		newAuction.setEndTime(endTime);
		newAuction.setProductId(productId);
		
		session.save(newAuction);
		session.getTransaction().commit();
		request.getSession().setAttribute("message", "Your auction has been created.");
		response.sendRedirect("products.jsp");

		
	}

	
}
