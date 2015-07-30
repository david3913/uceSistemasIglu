package com.iglu.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iglu.spring.model.User;

@Repository
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void insertUser(User user) {

		getSessionFactory().getCurrentSession().save(user);
	}

	public void updateUser(User user) {
		getSessionFactory().getCurrentSession().update(user);
	}

	
	public User getUser(String username) {

		@SuppressWarnings("unchecked")
		User user = (User) getSessionFactory().getCurrentSession()
				.createQuery("from User where username = ?").setParameter(0, username).list().get(0);

		return user;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
