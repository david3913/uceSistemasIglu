package com.iglu.util.config;

import java.io.Serializable;

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
		ConfigApp.baseServer = baseServer;
	}

}