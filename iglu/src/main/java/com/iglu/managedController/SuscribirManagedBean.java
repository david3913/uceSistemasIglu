package com.iglu.managedController;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.iglu.security.SessionSpring;
import com.iglu.spring.model.Cliente;
import com.iglu.spring.service.SuscripcionService;
import com.iglu.util.MensajesPF;

//Bean facilita la captura y tranmisin de datos
@ManagedBean(name = "suscribirMB")
@ViewScoped
public class SuscribirManagedBean {

	// Inyeccion del servicio
	@ManagedProperty(value = "#{SuscripcionService}")
SuscripcionService suscripcionService;

	private int meses;
	private String username;
	private String numTarjeta;
	private final float precio=20;
	private float total;
	
	
	@PostConstruct
	public void init(){
		infoClienteTrajeta();
	}
	
	
	public void infoClienteTrajeta(){
		Cliente cliente = getSuscripcionService().infoCliente();
		username=cliente.getEmail();
		numTarjeta=cliente.getTarjetas().get(0).getNumero();
			
		
	}
	
	
	public void suscribir(){
		try{
			//System.out.println(SessionSpring.getUsername());
			getSuscripcionService().suscripcionPago(username,meses,total);
	MensajesPF.infoMsj("Suscripcion  Adicionada_ SIga disfrutando de nuestra aplicacion");
		}
		catch(Exception ex){
			MensajesPF.errorMsj("Error_No se ha podido completar la transaccion");
			ex.printStackTrace();
		}
		
		
		
		
	}


	public SuscripcionService getSuscripcionService() {
		return suscripcionService;
	}


	public void setSuscripcionService(SuscripcionService suscripcionService) {
		this.suscripcionService = suscripcionService;
	}


	public int getMeses() {
		return meses;
	}


	public void setMeses(int meses) {
		total= meses*precio;
		this.meses = meses;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getNumTarjeta() {
		return numTarjeta;
	}


	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}


	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}
	
	
	

	
	
}
