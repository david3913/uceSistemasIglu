package com.iglu.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iglu.spring.model.Tarjeta;

@Repository
public class TarjetaDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void insertUser(Tarjeta tarjeta) {

		getSessionFactory().getCurrentSession().save(tarjeta);
	}

	public void updateUser(Tarjeta tarjeta) {
		getSessionFactory().getCurrentSession().update(tarjeta);
	}

	
//	public User getUser(String username) {
//
//		@SuppressWarnings("unchecked")
//		User user = (User) getSessionFactory().getCurrentSession()
//				.createQuery("from User where username = ?").setParameter(0, username).list().get(0);
//
//		return user;
//	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
