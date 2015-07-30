package com.iglu.util.config;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "configApp", eager = true)
@ApplicationScoped
public class ConfigApp implements Serializable {

	private static final long serialVersionUID = 1L;
	private static String baseServer;

	public static String getBaseServer() {
		return baseServer;
	}

	public static void setBaseServer(String baseServer) {
						try {
					ConfigApp.baseServer="http://"+InetAddress.getLocalHost().getHostAddress()+baseServer;
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					ConfigApp.baseServer="http://localhost"+baseServer;
					e.printStackTrace();
				}
			
						
	
	}
	
	////correo de la empresa y su contraseña...

}