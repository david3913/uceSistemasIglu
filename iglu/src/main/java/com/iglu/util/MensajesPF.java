package com.iglu.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensajesPF {
 public static void infoMsj(String mensaje) {
		 
		 String msj[] =mensaje.split("_");
		 
	        FacesContext context = FacesContext.getCurrentInstance();
	         
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,msj[0],msj[1] ) );
	   
	    }
 
 public static void errorMsj(String mensaje) {
	 
	 String msj[] =mensaje.split("_");
	 
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,msj[0],msj[1] ) );
   
    }

 
 
 
}
