package com.iglu.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassEncode {

	
	public String codificar(String palabra){
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	return passwordEncoder.encode(palabra);
	
	}
}
