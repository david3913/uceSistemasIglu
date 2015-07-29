package com.iglu.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import sun.security.util.ObjectIdentifier;

public class SessionSpring {

	private static String username;
	
	private static void obtieneUser(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 username = null;
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		}
		
		
	}

	public static String getUsername() {
		obtieneUser();
		return username;
	}


	
}
