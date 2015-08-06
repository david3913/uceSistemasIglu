package com.iglu.managedController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ComponentSystemEvent;

import com.iglu.spring.model.Pelicula;
import com.iglu.spring.service.VisorService;
import com.iglu.util.config.ConfigApp;

//Bean facilita la captura y tranmisin de datos
@ManagedBean(name = "visorMB")
@ViewScoped
public class VisorManagedBean {

	// Inyeccion del servicio
	@ManagedProperty(value = "#{VisorService}")
	VisorService visorService;
	Pelicula pelicula;
	//

	// List<Genero> categoriaList ;

	private String genero;
	private String titulo;
	private String sinopsis;
	private String rutaPeli;
	private String rutaImg;
	private String foto;
	private long id;

	public void preLoad(ComponentSystemEvent event) {
		// consultar en la base la url de la peli para rerpoducir..
		pelicula=visorService.peli(id);
		 rutaPeli =ConfigApp.getBaseServer()+pelicula.getRuta()+"/"+pelicula.getRuta()+".mp4";
		 rutaImg=ConfigApp.getBaseServer()+pelicula.getRuta()+"/"+pelicula.getRuta()+"_2.jpg";
		
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public VisorService getVisorService() {
		return visorService;
	}

	public void setVisorService(VisorService visorService) {
		this.visorService = visorService;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRutaPeli() {
		return rutaPeli;
	}

	public void setRutaPeli(String rutaPeli) {
		this.rutaPeli = rutaPeli;
	}

	public String getRutaImg() {
		return rutaImg;
	}

	public void setRutaImg(String rutaImg) {
		this.rutaImg = rutaImg;
	}

	// no olvidar darle new a lisCustumer

	// metodo q llena el drop list de categoria

	// metodo que por defecto cargue todas las peliculas en orden de fecha de
	// estreno

}
