package com.iglu.managedController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.iglu.security.SessionSpring;
import com.iglu.spring.service.ClienteService;
import com.iglu.util.MensajesPF;

//Bean facilita la captura y tranmisin de datos
@ManagedBean(name = "cuentaMB")
@ViewScoped
public class CuentaManagedBean {

	// Inyeccion del servicio
	@ManagedProperty(value = "#{ClienteService}")
	ClienteService clienteService;
	//

	private String pass1;
	private String pass2;
	
	
	public void modificarPass(){
		
		try{
	getClienteService().modificarPass(SessionSpring.getUsername(), pass1);
	MensajesPF.infoMsj("Cambio exitoso_Su contrase�a ha sido modificado");
		}
		catch(Exception ex){
			MensajesPF.errorMsj("Error_No se ha podido modificar su contrase�a");
			
		}
		
	}
	
	
	
	
	
	public void obtenerInfo(){}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
}
