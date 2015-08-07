package com.iglu.managedController;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.iglu.spring.model.Cliente;
import com.iglu.spring.model.Tarjeta;
import com.iglu.spring.service.RegistrarService;
import com.iglu.util.Email;
import com.iglu.util.MensajesPF;

//Bean facilita la captura y tranmisin de datos
@ManagedBean(name = "registrarMB")
@ViewScoped
public class RegistrarManagedBean {

	// Inyeccion del servicio
	@ManagedProperty(value = "#{RegistrarService}")
	RegistrarService registrarService;
	//

	// List<Genero> categoriaList ;

	private String ci;
	private String nombres;
	private String apellidos;
	private String email;
	private String direccion;
	private String telefonos;
	private String codPostal;
	private String tipTar;
	private String numero;
	private Date caducidad;
	// tipo de dato fecha de caducidad//

	private Cliente cliente;
	private Tarjeta tarjeta;

	public void registrar() {
		cliente = new Cliente();
		cliente.setCi(ci);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setTelefonos(telefonos);
		cliente.setDireccion(direccion);
		cliente.setPostal(codPostal);
		tarjeta = new Tarjeta();
		tarjeta.setNumero(numero);
		tarjeta.setTipo(tipTar);
		tarjeta.setCaducidad(caducidad);

		try {
			registrarService.registrar(cliente,tarjeta);
			MensajesPF.infoMsj("Registro exitoso_Favor revise su correo electrónico para la confirmacion");
		
		} catch (Exception ex) {
			MensajesPF.errorMsj("Error_Revise los datos, si el error persiste contactese a la empresa");
			System.out.println(ex);
		}

	}

	

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getTipTar() {
		return tipTar;
	}

	public void setTipTar(String tipTar) {
		this.tipTar = tipTar;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}



	public RegistrarService getRegistrarService() {
		return registrarService;
	}



	public void setRegistrarService(RegistrarService registrarService) {
		this.registrarService = registrarService;
	}

}
