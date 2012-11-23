package com.mybusiness.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.myclasses.java.Auction;
import com.myclasses.java.Bid;
import com.myclasses.java.Products;

public class ProductService {
	
	public ArrayList<Products> getAllProducts(){
		ArrayList<Products> productList=new ArrayList<Products>();
		
		SessionFactory sessionFactory=configureSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		String hql="FROM Products";
		Query query = session.createQuery(hql);
		List<Products> results = query.list();
	
		for (Products p : results) {
			productList.add(p);
		}
		return productList;
	}
	
	public ArrayList<Products> getProductsByUser(int userId){
		ArrayList<Products> productList=new ArrayList<Products>();
		
		SessionFactory sessionFactory=configureSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		String hql="FROM Products P WHERE P.userId="+ userId;
		Query query = session.createQuery(hql);
		List<Products> results = query.list();
		
		for (Products p : results) {
			productList.add(p);
		}
		return productList;
	}
	
	
	public ArrayList<Auction> getAllAuctions(){
		ArrayList<Auction> auctionList=new ArrayList<Auction>();
		
		SessionFactory sessionFactory=configureSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		String hql="FROM Auction";
		Query query = session.createQuery(hql);
		List<Auction> results = query.list();
	
		for (Auction p : results) {
			auctionList.add(p);
		}
		return auctionList;
	}

	
	
	

	public Products getProductDetails(int productId) {
		// TODO Auto-generated method stub
		Products product=new Products();
		SessionFactory sessionFactory=configureSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		String hql="FROM Products P WHERE P.productId="+ productId;
		Query query = session.createQuery(hql);
		List<Products> results = query.list();
		
		product=results.get(0);
		return product;
	}
	
	public ArrayList<Bid> getBidsByAuctionId(int auctionId) {
		ArrayList<Bid> bidList=new ArrayList<Bid>();
		
		SessionFactory sessionFactory=configureSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		String hql="FROM Bid B WHERE B.auctionId="+ auctionId;
		Query query = session.createQuery(hql);
		List<Bid> results = query.list();
		
		for (Bid b : results) {
			bidList.add(b);
		}
		return bidList;
	}
	
	/*
	public int getProductId(int auctionId){
		int pid;
		SessionFactory sessionFactory=configureSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		String hql="SELECT productId FROM Products P WHERE P.auctionId="+ auctionId;
		Query query = session.createQuery(hql);
		List<> result = query.list();

		
	return pid;	
	}
	*/
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
