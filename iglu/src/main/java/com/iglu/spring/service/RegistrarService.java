package com.iglu.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iglu.spring.dao.AuthorityDAO;
import com.iglu.spring.dao.ClienteDAO;
import com.iglu.spring.dao.UserDAO;
import com.iglu.spring.model.Authority;
import com.iglu.spring.model.Cliente;
import com.iglu.spring.model.User;

///Logica del negocio

@Service("RegistrarService")
@Transactional(readOnly = true)
public class RegistrarService {
	// @Autowired algun dao se inyecta

	@Autowired
	ClienteDAO clienteDAO;
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	AuthorityDAO authorityDAO;


	// recupera lista de de peliculas y las trasnforma a un string html5
	
	@Transactional(readOnly = false)
	public void suscribir(Cliente cliente) {

		
		clienteDAO.insertCliente(cliente);
		System.out.println("cliente id"+cliente.getClienteId());		
		
		User u = new User();
		u.setPassword("123");
		u.setUsername(cliente.getEmail());
		u.setEnabled(true);
		u.setCliente(cliente);
		
		userDAO.insertUser(u);
				
		

		Authority au = new Authority();
		au.setAuthority("cliente");
		au.setUser(u);
		authorityDAO.insertAuthority(au);
		
	

	}

}
