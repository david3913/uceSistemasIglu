package com.iglu.spring.service;

import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.iglu.security.PassEncode;
import com.iglu.simulations.Banco;
import com.iglu.spring.dao.AuthorityDAO;
import com.iglu.spring.dao.ClienteDAO;
import com.iglu.spring.dao.CuentaDAO;
import com.iglu.spring.dao.TarjetaDAO;
import com.iglu.spring.dao.UserDAO;
import com.iglu.spring.model.Authority;
import com.iglu.spring.model.Cliente;
import com.iglu.spring.model.Cuenta;
import com.iglu.spring.model.Tarjeta;
import com.iglu.spring.model.User;
import com.iglu.util.Email;
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
	
	@Autowired
	TarjetaDAO tarjetaDAO;
	
	@Autowired
	CuentaDAO cuentaDAO;

	// recupera lista de de peliculas y las trasnforma a un string html5

	@Transactional(readOnly = false) /// configurar para q tb realice rollback
										/// con excepcino de email..
	public void registrar(Cliente cliente, Tarjeta tarjeta) {
		Banco bank = new Banco();

		if (bank.simNumTrajeta()) {

			User u = new User();
			Authority au = new Authority();
			Cuenta cuenta= new Cuenta();
			PassEncode xx = new PassEncode();
			String yy = Password.genPass();
			// u.setPassword(xx.codificar(yy));
			
			u.setPassword(yy);
			System.out.println(yy + "\n" + u.getPassword());
			u.setUsername(cliente.getEmail());
			u.setEnabled(true);
			u.setCliente(cliente);

			
			au.setAuthority("cliente");
			au.setUser(u);
			
			tarjeta.setCliente(cliente);
			
			
			
			getClienteDAO().insertCliente(cliente);
			getUserDAO().insertUser(u);
			getAuthorityDAO().insertAuthority(au);
			getTarjetaDAO().insertUser(tarjeta);
			
			cuenta.setCuentaId(cliente.getClienteId());
			cuenta.setEstado("inactivo");
			cuenta.setCi(cliente.getCi());
			cuenta.setCreacion(new Date());
			getCuentaDAO().insertCuenta(cuenta);
			
			
			TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {

				public void afterCommit() throws RuntimeException {
					// TODO Auto-generated method stub
					/// lanzar excepcion de email
					try {
						Email email = new Email(cliente.getEmail(), "Registro exitoso",
								"Ahora puede acceder a nuestros servicios con la contraseña: " + yy);

						email.sendMail();
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuntimeException("Error al enviar email" + cliente.getEmail(), e.getCause());
					}

				}

			});

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
		System.out.println("set ucer dao cliente");
		this.userDAO = userDAO;
	}

	public AuthorityDAO getAuthorityDAO() {
		return authorityDAO;
	}

	public void setAuthorityDAO(AuthorityDAO authorityDAO) {
		this.authorityDAO = authorityDAO;
	}

	public TarjetaDAO getTarjetaDAO() {
		return tarjetaDAO;
	}

	public void setTarjetaDAO(TarjetaDAO tarjetaDAO) {
		this.tarjetaDAO = tarjetaDAO;
	}

	public CuentaDAO getCuentaDAO() {
		return cuentaDAO;
	}

	public void setCuentaDAO(CuentaDAO cuentaDAO) {
		this.cuentaDAO = cuentaDAO;
	}

}
