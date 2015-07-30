package com.iglu.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iglu.spring.model.Authority;

@Repository
public class AuthorityDAO {
	@Autowired
	private SessionFactory sessionFactory;

	
	public void insertAuthority(Authority au){
		
		getSessionFactory().getCurrentSession().save(au);
			}
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
