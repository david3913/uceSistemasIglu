package com.iglu.spring.service;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iglu.security.SessionSpring;
import com.iglu.spring.dao.CuentaDAO;
import com.iglu.spring.dao.SuscripcionDAO;
import com.iglu.spring.dao.UserDAO;
import com.iglu.spring.model.Cuenta;
import com.iglu.spring.model.Suscripcion;

///Logica del negocio

@Service("SessionService")

@Transactional(readOnly = true)
public class SessionService {
	
	public void ingo(){
		FacesContext ctx = FacesContext.getCurrentInstance();
	    ExternalContext extCtx = ctx.getExternalContext();
	Map<String, Object> sessionMap = extCtx.getSessionMap();
	Iterator it = sessionMap.keySet().iterator();
	while(it.hasNext()){
	  Object a= it.next();
	  System.out.println("Clave: " + a + " -> Valor: " + sessionMap.get(a));
	}
	}
	

}
