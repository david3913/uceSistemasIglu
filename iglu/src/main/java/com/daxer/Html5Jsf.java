package com.daxer;

import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
	
@ManagedBean
@RequestScoped
public class Html5Jsf {

	private String html="";
	private int n=0;
	
	
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	
	public Html5Jsf(){
			System.out.println("CREACION");
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
	
	
	Thread thread = new Thread("New Thread") {
	      public void run(){
	    	  for (int i = 0; i < n; i++) {
	  			System.out.println(i);
	  			html=html+
	  					"<div class='work'>"
	  					+"<div class='peli'>"
	  					+ "<a href='index1.xhtml'>"
	  					+ "<img src='../img/work1.jpg' class='media' alt=''/>"+
	  			"<div class='caption'>"
	  			+ "<div class='work_title'>"
	  			+ "<h1>"
	  			+ "numero "+i
	  			+ "</h1>"
	  			+ "</div></div></a></div>"
	  			+ "<div class='tit'>"
	  			+"	Titulo de la pelicula<br /> genero"
	  		+"</div></div>";		
	  			
	  			
	  			
	  			html=html+
	  					"<div class='work'>"
	  					+"<div class='peli'>"
	  					+ "<a href='index1.xhtml'>"
	  					+ "<img src='../img/work2.jpg' class='media' alt=''/>"+
	  			"<div class='caption'>"
	  			+ "<div class='work_title'>"
	  			+ "<h1>"
	  			+ "numero "+i
	  			+ "</h1>"
	  			+ "</div></div></a></div>"
	  			+ "<div class='tit'>"
	  			+"	Titulo de la pelicula<br /> genero"
	  		+"</div></div>";
	  			
	  			
	  			html=html+
	  					"<div class='work'>"
	  					+"<div class='peli'>"
	  					+ "<a href='index1.xhtml'>"
	  					+ "<img src='../img/work3.jpg' class='media' alt=''/>"+
	  			"<div class='caption'>"
	  			+ "<div class='work_title'>"
	  			+ "<h1>"
	  			+ "numero "+i
	  			+ "</h1>"
	  			+ "</div></div></a></div>"
	  			+ "<div class='tit'>"
	  			+"	Titulo de la pelicula<br /> genero"
	  		+"</div></div>";
	  			
	  			html=html+
	  					"<div class='work'>"
	  					+"<div class='peli'>"
	  					+ "<a href='index1.xhtml'>"
	  					+ "<img src='../img/work4.jpg' class='media' alt=''/>"+
	  			"<div class='caption'>"
	  			+ "<div class='work_title'>"
	  			+ "<h1>"
	  			+ "numero "+i
	  			+ "</h1>"
	  			+ "</div></div></a></div>"
	  			+ "<div class='tit'>"
	  			+"	Titulo de la pelicula<br /> genero"
	  		+"</div></div>";
	  			
	  			html=html+
	  					"<div class='work'>"
	  					+"<div class='peli'>"
	  					+ "<a href='index1.xhtml'>"
	  					+ "<img src='../img/work5.jpg' class='media' alt=''/>"+
	  			"<div class='caption'>"
	  			+ "<div class='work_title'>"
	  			+ "<h1>"
	  			+ "numero "+i
	  			+ "</h1>"
	  			+ "</div></div></a></div>"
	  			+ "<div class='tit'>"
	  			+"	Titulo de la pelicula<br /> genero"
	  		+"</div></div>";
	  			
	  			html=html+
	  					"<div class='work'>"
	  					+"<div class='peli'>"
	  					+ "<a href='index1.xhtml'>"
	  					+ "<img src='../img/work6.jpg' class='media' alt=''/>"+
	  			"<div class='caption'>"
	  			+ "<div class='work_title'>"
	  			+ "<h1>"
	  			+ "numero "+i
	  			+ "</h1>"
	  			+ "</div></div></a></div>"
	  			+ "<div class='tit'>"
	  			+"	Titulo de la pelicula<br /> genero"
	  		+"</div></div>";}
	      }
	   };

	
///ejecutar en un hilo por separado
	public void save() {
		
			
			

			   thread.start();
		
			
		
		
		
		
		
//		RequestContext context = RequestContext.getCurrentInstance();
//		String data = "<div class='work'>			<a href='inner.html'><img src='img/work2.jpg' class='media' alt=''/><div class='caption'><div class='work_title'><h1>culpa qui officia deserunt mollit</h1></div></div></a></div>";
//		String david="david alexander";
//		context.addCallbackParam("user", david);
//		//<context.addCallbackParam("user1", "" + data);
//		// pojo as json

		// execute javascript oncomplete
		// context.execute("PrimeFaces.info('Hello from the Backing Bean');");

		// update panel
		// context.update("form:panel");

		// scroll to panel
		// context.scrollTo("form:panel");

		// add facesmessage
		// FacesContext.getCurrentInstance().addMessage(null, new
		// FacesMessage("Success", "Success"));
	}
	
	@PreDestroy
	public void fin(){
		///como la generacin del codigo esta en otro hilo entonces si se destruye la pagina detengo el hilo
		   thread.stop();
		  System.out.println("######################################");
		  System.out.println("######################################");
		  System.out.println("######################################");
		  System.out.println("DESCTRUCCION");
		
	}
	

}