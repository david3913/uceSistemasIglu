package com.iglu.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iglu.spring.model.Authority;
import com.iglu.spring.model.Cliente;
import com.iglu.spring.model.User;

@Repository
public class ClienteDAO {
	@Autowired
	private SessionFactory sessionFactory;

	
	public void insertCliente(Cliente cliente){
		
		getSessionFactory().getCurrentSession().save(cliente);
		
	
			}
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
