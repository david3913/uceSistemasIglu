package com.iglu.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iglu.spring.model.Cliente;

@Repository
public class ClienteDAO {
	@Autowired
	private SessionFactory sessionFactory;

	
	public void insertCliente(Cliente cliente){
		
		getSessionFactory().getCurrentSession().save(cliente);
		
	
			}
	
public void deleteCliente(Long id){
		
	
		getSessionFactory().getCurrentSession().createQuery("delete from Cliente cascade where cliente_id=?").setParameter(0, id).executeUpdate();
		
			}
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
