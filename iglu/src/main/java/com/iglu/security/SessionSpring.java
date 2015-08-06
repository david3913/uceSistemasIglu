package com.iglu.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SessionSpring {

	private static String username;
	private static String authority;
	   static Collection<? extends GrantedAuthority>   authorities;
	
	  
	

	private static void obtieneUser(){
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
		obtieneUser();
			return username;
	}

	public static String getAuthority() {
		obtieneUser();
		return authority;
	}

	

	
}
