package com.iglu.managedController;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.iglu.security.SessionSpring;
import com.iglu.spring.model.Suscripcion;
import com.iglu.spring.service.CuentaService;
import com.iglu.util.MensajesPF;

//Bean facilita la captura y tranmisin de datos
@ManagedBean(name = "cuentaMB")
@ViewScoped
public class CuentaManagedBean {

	// Inyeccion del servicio
	@ManagedProperty(value = "#{CuentaService}")
	CuentaService cuentaService;
	//

	private String pass1;
	private String pass2;
	private Date ini;
	private Date fin;
	private String estado;
	private String tipo;
	
	@PostConstruct
	public void init(){
		infoSuscripcion();
	}
	
	
	public void infoSuscripcion(){
		Suscripcion suscripcion = getCuentaService().infoSuscripcion();
		
		ini=suscripcion.getInicio();
		fin=suscripcion.getFin();
		tipo=suscripcion.getTipo();
		if (suscripcion.getFin().before(Calendar.getInstance().getTime())) 
			estado="INACTIVA";
		else estado="ACTIVA";
			
		
	}
	public void modificarPass(){
		
		try{
			//System.out.println(SessionSpring.getUsername());
	getCuentaService().modificarPass(SessionSpring.getUsername(), pass1);
	MensajesPF.infoMsj("Cambio exitoso_Su contraseña ha sido modificado");
		}
		catch(Exception ex){
			MensajesPF.errorMsj("Error_No se ha podido modificar su contraseña");
			ex.printStackTrace();
		}
		
	}
	
	
	
	

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




	public CuentaService getCuentaService() {
		return cuentaService;
	}




	public void setCuentaService(CuentaService cuentaService) {
		this.cuentaService = cuentaService;
	}


	public Date getIni() {
		return ini;
	}


	public void setIni(Date ini) {
		this.ini = ini;
	}


	public Date getFin() {
		return fin;
	}


	public void setFin(Date fin) {
		this.fin = fin;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
}
