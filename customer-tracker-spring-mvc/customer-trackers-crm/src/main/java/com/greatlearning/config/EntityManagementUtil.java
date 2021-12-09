package com.greatlearning.config;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityManagementUtil {
	
	private Session session;

	@Autowired
	EntityManagementUtil(SessionFactory sessionFactory) {		
		try {
			this.session = sessionFactory.getCurrentSession();
		} catch (HibernateException ex) {
			this.session = sessionFactory.openSession();
		}
	}
	
	public Session getSession(){
		return this.session;
	}
	
}
