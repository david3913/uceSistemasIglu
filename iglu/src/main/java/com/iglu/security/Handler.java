package com.iglu.security;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.iglu.managedController.InfoManagedBean;
import com.iglu.spring.model.Cuenta;
import com.iglu.spring.service.CuentaSuscripcionService;
import com.iglu.util.ApplicationContextProvider;



public class Handler extends SimpleUrlAuthenticationSuccessHandler {



	
	public Handler(String defaultUrl) {
		System.out.println("constructor");
		setDefaultTargetUrl(defaultUrl);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.web.authentication.AuthenticationSuccessHandler
	 * #onAuthenticationSuccess(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
//		System.out.println(authentication.getCredentials());
//		System.out.println(authentication.getDetails());
//		System.out.println(authentication.getName());
//		System.out.println(authentication.getPrincipal());
//		System.out.println(authentication.getDetails());
		////si cuenta inactiva... tonces activar free,,..

	
		CuentaSuscripcionService cuentaSuscripcionService = ApplicationContextProvider.getContext().getBean(CuentaSuscripcionService.class);
		Cuenta cuenta = cuentaSuscripcionService.estadoCuenta();
		
		
	
		if (cuenta.getEstado().equals("inactivo")) {
			cuentaSuscripcionService.suscripcionFree(cuenta);
		}
		
		cuentaSuscripcionService.suscripcionActiva();
		
		InfoManagedBean i= new InfoManagedBean();
		i.setUser("hola");
		
		
		
		
		if (Util.isAjaxRequest(request)) {
			System.out.println("si es peticin ajax");
			System.out.println(authentication.isAuthenticated());
			if (authentication.isAuthenticated()) {
				System.out.println("success IGLUXXXXXXXXXXXX");
				Util.sendJsonResponse(response, "login_status", "success");
			} else {
				System.out.println("invalid");
				Util.sendJsonResponse(response, "login_status", "invalid");
			}

		} else {
			System.out.println("else");
			super.onAuthenticationSuccess(request, response, authentication);			
		}

	}





	
}