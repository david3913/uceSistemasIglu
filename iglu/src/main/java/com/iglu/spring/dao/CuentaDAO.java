package com.iglu.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iglu.spring.model.Cuenta;
import com.iglu.spring.model.User;

@Repository
public class CuentaDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void insertCuenta(Cuenta cuenta) {

		getSessionFactory().getCurrentSession().save(cuenta);
	}

	public void updateCuenta(Cuenta cuenta) {
		getSessionFactory().getCurrentSession().update(cuenta);
	}

	
	public Cuenta getCuenta(String username) {

		@SuppressWarnings("unchecked")
		Cuenta cuenta = (Cuenta) getSessionFactory().getCurrentSession()
				.createQuery("from Cuenta where username = ?").setParameter(0, username).list().get(0);

		return cuenta;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
