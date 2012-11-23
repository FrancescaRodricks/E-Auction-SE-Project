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

import com.myclasses.java.Products;



/**
 * Servlet implementation class ProductRegistrationServlet
 */
@WebServlet("/ProductRegistrationServletPath")
public class ProductRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		SessionFactory sessionFactory=configureSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();	
		
		int userId=(int) request.getSession().getAttribute("userId");
		String prodname = request.getParameter("prodname");
		String description = request.getParameter("description");
		String category = request.getParameter("category"); 
		int price = Integer.parseInt(request.getParameter("price"));
		String imagepath = request.getParameter("imagepath");
		
		
		Products pro = new Products();
		pro.setProdname(prodname);
		pro.setDescription(description);
		pro.setCategory(category);
		pro.setPrice(price);
		pro.setUserId(userId);
		pro.setImagepath("images\\"+imagepath);
		session.save(pro);
		response.sendRedirect("products.jsp");
		session.getTransaction().commit();
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
