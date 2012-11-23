package com.mybusiness.services;




import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.myclasses.java.Users;

public class LoginService {

	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		if(username!=null && username.trim()!=null && password!=null && password.trim()!="" ){
			SessionFactory sessionFactory=configureSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			String hql="SELECT U.username, U.password FROM Users U where U.username='"+username+"'"+" and U.password='"+password+"'";
			Query query = session.createQuery(hql);
			List<Users> results = query.list();
			if(results.size()==1){
				// session.getTransaction().commit();
				// session.close();
				return true;
			}
		}
		return false;
	}

	public Users getUserDetails(String username) {
		// TODO Auto-generated method stub
		Users user=new Users();
		SessionFactory sessionFactory=configureSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		// user=(Users) session.get(Users.class, username);
		String hql="FROM Users U WHERE U.username='"+ username +"' ";
		Query query = session.createQuery(hql);
		List<Users> results = query.list();
		user=results.get(0);
		return user;
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
