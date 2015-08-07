package com.iglu.security;

import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.iglu.spring.service.CuentaService;

@ManagedBean
@RequestScoped
public class SessionSpring {
	
	
	private static String username;
	private static String authority;
	private static boolean sus;
	   static Collection<? extends GrantedAuthority>   authorities;
	
	 
	

	public static void obtieneUser(){
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		 username = null;
//		if (principal instanceof UserDetails) {
//		   username = ((UserDetails)principal).getUsername();
//		  authorities = ((UserDetails)principal).getAuthorities();
//		   GrantedAuthority a=  authorities.iterator().next();
//		   authority=a.getAuthority();
//		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    username = auth.getName(); 
	    authorities = auth.getAuthorities();
	   GrantedAuthority a=  authorities.iterator().next();
		   authority=a.getAuthority();
		 
		
	}
	

	public static String getUsername() {
		//obtieneUser();
			return username;
	}

	public static String getAuthority() {
		//obtieneUser();
		return authority;
	}

	

	public static void setUsername(String username) {
		SessionSpring.username = username;
	}

	public static void setAuthority(String authority) {
		SessionSpring.authority = authority;
	}
	

	

	
}
