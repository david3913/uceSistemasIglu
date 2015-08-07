package com.iglu.managedController;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import com.iglu.security.SessionSpring;
import com.iglu.spring.model.Cuenta;
import com.iglu.spring.service.CuentaService;

//Bean facilita la captura y tranmisin de datos
@ManagedBean(name = "initMB")
@RequestScoped
public class InitManagedBean {

	// Inyeccion del servicio
	@ManagedProperty(value = "#{CuentaSuscripcionService}")
	CuentaService cuentaSuscripcionService;

	public void info(){
		
		 FacesContext ctx = FacesContext.getCurrentInstance();
		    ExternalContext extCtx = ctx.getExternalContext();
		Map<String, Object> sessionMap = extCtx.getSessionMap();
		sessionMap.put("a", 1);		
		ctx = FacesContext.getCurrentInstance();
	   extCtx = ctx.getExternalContext();
sessionMap = extCtx.getSessionMap();
		
		Iterator it = sessionMap.keySet().iterator();
		while(it.hasNext()){
		  Object a= it.next();
		  System.out.println("Clave: " + a + " -> Valor: " + sessionMap.get(a));
		}
			
	}

	public void preLoad(ComponentSystemEvent event) {
		// FacesContext.getCurrentInstance().getExternalContext().getSessionMap().
		 
		try {
			if (SessionSpring.getAuthority().equals("admin"))
				FacesContext.getCurrentInstance().getExternalContext().redirect("../admin/home.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public CuentaService getCuentaSuscripcionService() {
		return cuentaSuscripcionService;
	}

	public void setCuentaSuscripcionService(CuentaService cuentaSuscripcionService) {
		this.cuentaSuscripcionService = cuentaSuscripcionService;
	}

}
