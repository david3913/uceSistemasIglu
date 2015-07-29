package com.daxer;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class a1 implements Serializable {
	


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2008838929834442505L;
	/**
	 * 
	 */

	private String nombre;
	
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void btn(){
	System.out.println("btn");
	}
	@PostConstruct
	public void a(){
		System.out.println("inicio");
	}
	@PreDestroy
	public void b(){
		System.out.println("fin");
		
	}
	

}
