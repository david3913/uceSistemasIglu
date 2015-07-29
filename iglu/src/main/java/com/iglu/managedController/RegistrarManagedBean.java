package com.iglu.managedController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.iglu.spring.model.Cliente;
import com.iglu.spring.service.RegistrarService;

//Bean facilita la captura y tranmisin de datos
@ManagedBean(name="registrarMB")
@ViewScoped
public class RegistrarManagedBean {

	
	//Inyeccion del servicio
@ManagedProperty(value = "#{RegistrarService}")
RegistrarService registrarService;	
//	
 
//	List<Genero> categoriaList ;
	
	private String ci;
	private String nombres;
	private String apellidos;
	private String email;
	private String direccion;
	private String telefono;
	private String codPostal ;
	private String tipTar;
	private String num;
	private String caducidad;
	
	private Cliente cliente ;

	
	
	
	public void registrar(){
		cliente = new Cliente();
		cliente.setCi(ci);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		///telefonos
		///direccion
		cliente.setPostal(codPostal);
		
		
		
	
		registrarService.suscribir(cliente);
		
		
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getTipTar() {
		return tipTar;
	}

	public void setTipTar(String tipTar) {
		this.tipTar = tipTar;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}


	public RegistrarService getRegistrarService() {
		return registrarService;
	}


	public void setRegistrarService(RegistrarService registrarService) {
		this.registrarService = registrarService;
	}

	
	
	
	}
