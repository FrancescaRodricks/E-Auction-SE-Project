package com.myservlets.java;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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

import com.mybusiness.services.ProductService;
import com.myclasses.java.Auction;
import com.myclasses.java.Products;

/**
 * Servlet implementation class DisplayAuctionedProductsServlet
 */
@WebServlet("/DisplayAuctionedProductsServletPath")
public class DisplayAuctionedProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAuctionedProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// int userId;
		// userId = Integer.parseInt(request.getParameter("userId"));
		
		SessionFactory sessionFactory=configureSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
	
		ArrayList<Auction> auctionList = new ArrayList<Auction>();
		ProductService ps=new ProductService();
		auctionList=ps.getAllAuctions();
		
		request.setAttribute("auctionList", auctionList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("bid.jsp");
		dispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
}
