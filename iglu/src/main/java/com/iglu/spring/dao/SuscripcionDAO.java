package com.iglu.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iglu.spring.model.Suscripcion;
import com.iglu.spring.model.User;

@Repository
public class SuscripcionDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void insertSuscripcion(Suscripcion suscripcion) {

		getSessionFactory().getCurrentSession().save(suscripcion);
	}

	public void updateUser(Suscripcion suscripcion) {
		getSessionFactory().getCurrentSession().update(suscripcion);
	}

	
//	public User get(String username) {
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
