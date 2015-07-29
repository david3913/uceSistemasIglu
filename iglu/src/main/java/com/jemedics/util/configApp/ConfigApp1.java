package com.jemedics.util.configApp;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * ConfigApp Application Bean
 *
 *
 * @author dx
 * @since 12 Nov 2015
 * @version 1.0.0
 *
 */

@ManagedBean(name = "configApp1", eager = true)
@ApplicationScoped
public class ConfigApp1 implements Serializable {

	private static final long serialVersionUID = 1L;
	private static String baseUrl1;
	private String baseUrl2 = "url 2";


		// try {
		// prop.load(new FileInputStream(pathProperties));
		// } catch (Exception ex) {
		// ex.printStackTrace();
		// }
	
	/**
	 * @return the baseUrl1
	 */
	public static String getBaseUrl1() {
		return baseUrl1;
	}

	/**
	 * @param baseUrl1
	 *            the baseUrl1 to set
	 */
	public static void setBaseUrl1(String baseUrl1) {
		ConfigApp1.baseUrl1 = baseUrl1;
	}

	/**
	 * @return the baseUrl2
	 */
	public String getBaseUrl2() {
		return baseUrl2;
	}

	/**
	 * @param baseUrl2
	 *            the baseUrl2 to set
	 */
	public void setBaseUrl2(String baseUrl2) {
		this.baseUrl2 = baseUrl2;
	}

}