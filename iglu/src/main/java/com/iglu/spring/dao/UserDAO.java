package com.iglu.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iglu.spring.model.Cliente;
import com.iglu.spring.model.User;

@Repository
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	
	public void insertUser(User user){
		
		getSessionFactory().getCurrentSession().save(user);
			}
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
