package com.iglu.spring.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iglu.security.PassEncode;
import com.iglu.security.SessionSpring;
import com.iglu.spring.dao.CuentaDAO;
import com.iglu.spring.dao.SuscripcionDAO;
import com.iglu.spring.dao.UserDAO;
import com.iglu.spring.model.Cuenta;
import com.iglu.spring.model.Suscripcion;
import com.iglu.spring.model.User;

///Logica del negocio

@Service("CuentaService")

@Transactional(readOnly = true)
public class CuentaService {
	@Autowired
	SuscripcionDAO suscripcionDAO;

	@Autowired
	CuentaDAO cuentaDAO;

	@Autowired
	UserDAO userDAO;
	// recupera lista de de peliculas y las trasnforma a un string html5

	@Transactional(readOnly = false) /// configurar para q tb realice rollback
										/// con excepcino de email..
	public void suscripcionFree(Cuenta cuenta) {
		Suscripcion suscripcion = new Suscripcion();
		Calendar fecha = Calendar.getInstance();

		suscripcion.setInicio(fecha.getTime());
		fecha.add(Calendar.DAY_OF_YEAR, 30);
		suscripcion.setFin(fecha.getTime());
		suscripcion.setCliente(cuenta.getCliente());
		suscripcion.setTipo("prueba");

		cuenta.setEstado("activo");
		cuenta.setSuscripcion(suscripcion);

		cuentaDAO.updateCuenta(cuenta);
		suscripcionDAO.insertSuscripcion(suscripcion);

		// TransactionSynchronizationManager.registerSynchronization(new
		// TransactionSynchronizationAdapter() {
		//
		// public void afterCommit() throws RuntimeException {
		// // TODO Auto-generated method stub
		// /// lanzar excepcion de email
		// // try {
		// //
		// // } catch (MessagingException e) {
		// // // TODO Auto-generated catch block
		// // e.printStackTrace();
		// // throw new RuntimeException("Error al enviar email" +
		// // cliente.getEmail(), e.getCause());
		// // }
		//
		// }
		//
		// });

	}

	public boolean suscripcionActiva() {
		/// consultar el id de la suscripcino en la cuenta
		// ir a suscripcion y ver si no esta caducada
		Suscripcion suscripcion = getUserDAO().getUser(SessionSpring.getUsername()).getCliente().getCuenta()
				.getSuscripcion();
		if (suscripcion.getFin().before(Calendar.getInstance().getTime())) {
			//System.out.println("suscripcion caducada");
			return false;
		} else {
			return true;
		}

	}

	@Transactional(readOnly = false)
	public void modificarPass(String username, String pass) {
		User u = getUserDAO().getUser(username);
		PassEncode xx = new PassEncode();
		u.setPassword(xx.codificar(pass));
		getUserDAO().updateUser(u);

	}
	
	public Cuenta estadoCuenta() {
		
		return getUserDAO().getUser(SessionSpring.getUsername()).getCliente().getCuenta();

	}
	
	public Suscripcion infoSuscripcion(){
		return getUserDAO().getUser(SessionSpring.getUsername()).getCliente().getCuenta().getSuscripcion();
		
	}

	public SuscripcionDAO getSuscripcionDAO() {
		return suscripcionDAO;
	}

	public void setSuscripcionDAO(SuscripcionDAO suscripcionDAO) {
		this.suscripcionDAO = suscripcionDAO;
	}

	public CuentaDAO getCuentaDAO() {
		return cuentaDAO;
	}

	public void setCuentaDAO(CuentaDAO cuentaDAO) {
		this.cuentaDAO = cuentaDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		System.out.println("set dao User cuentassuscrip");
		this.userDAO = userDAO;
	}

}
