package com.myservlets.java;

import java.io.IOException;
import java.sql.Date;

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

import com.myclasses.java.Bid;

/**
 * Servlet implementation class PlaceNewBidServlet
 */
@WebServlet("/PlaceNewBidServletPath")
public class PlaceNewBidServlet extends HttpServlet {
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
		// int bidId;
		int price;
		int auctionId;
		int userId;
		userId = (int) request.getSession().getAttribute("userId");
		auctionId=Integer.parseInt(request.getParameter("aid"));
		price = Integer.parseInt(request.getParameter("price"));
		
		Bid newBid=new Bid();
		newBid.setPrice(price);
		newBid.setAuctionId(auctionId);
		newBid.setUserId(userId);
	
		SessionFactory sessionFactory=configureSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(newBid);
		session.getTransaction().commit();
		session.close(); 
		request.getSession().setAttribute("message", "Your bid has been placed.");
		response.sendRedirect("products.jsp");	
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
