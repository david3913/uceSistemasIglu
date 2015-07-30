package com.iglu.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iglu.security.PassEncode;
import com.iglu.simulations.Banco;
import com.iglu.spring.dao.AuthorityDAO;
import com.iglu.spring.dao.ClienteDAO;
import com.iglu.spring.dao.UserDAO;
import com.iglu.spring.model.Authority;
import com.iglu.spring.model.Cliente;
import com.iglu.spring.model.Tarjeta;
import com.iglu.spring.model.User;
import com.iglu.util.Password;

///Logica del negocio

@Service("ClienteService")
@Transactional(readOnly = true)
public class ClienteService {
	// @Autowired algun dao se inyecta

	@Autowired
	ClienteDAO clienteDAO;
	@Autowired
	UserDAO userDAO;

	@Autowired
	AuthorityDAO authorityDAO;

	// recupera lista de de peliculas y las trasnforma a un string html5

	@Transactional(readOnly = false)
	public String suscribir(Cliente cliente, Tarjeta tarjeta) {
		Banco bank = new Banco();

		if (bank.simNumTrajeta()) {

			User u = new User();
			PassEncode xx = new PassEncode();
			String yy = Password.genPass();
			//u.setPassword(xx.codificar(yy));
			u.setPassword(yy);
			System.out.println(yy + "\n" + u.getPassword());
			u.setUsername(cliente.getEmail());
			u.setEnabled(true);
			u.setCliente(cliente);

			Authority au = new Authority();
			au.setAuthority("cliente");
			au.setUser(u);
			getClienteDAO().insertCliente(cliente);

			getUserDAO().insertUser(u);
			getAuthorityDAO().insertAuthority(au);
			return yy;
		} else {
			return "";
		}
	}

	@Transactional(readOnly = false)
	public void modificarPass(String username, String pass) {
		User u = getUserDAO().getUser(username);
		PassEncode xx = new PassEncode();
		u.setPassword(xx.codificar(pass));
		getUserDAO().updateUser(u);

	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public AuthorityDAO getAuthorityDAO() {
		return authorityDAO;
	}

	public void setAuthorityDAO(AuthorityDAO authorityDAO) {
		this.authorityDAO = authorityDAO;
	}

}
