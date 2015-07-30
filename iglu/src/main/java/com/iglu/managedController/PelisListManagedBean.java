package com.iglu.managedController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.iglu.spring.model.Genero;
import com.iglu.spring.service.PelisListService;

//Bean facilita la captura y tranmisin de datos
@ManagedBean(name="pelisListMB")
@ViewScoped
public class PelisListManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	//Inyeccion del servicio
	@ManagedProperty(value = "#{PelisListService}")
	PelisListService pelisListService;	
	
	List<String> peliculasList;
	List<Genero> categoriaList ;
	
	

	private String genero;
	private String titulo;
	
	//no olvidar darle new a lisCustumer
	
	//metodo q llena el drop list de categoria
	
	//metodo que por defecto cargue todas las peliculas en orden de fecha de estreno
	
	/*metodo que realiza la consulta segun el genero y el titulo
	 * El genero deberea tener una accin por defecto que sea vacia --
	 * */
	public void encontrarPeliculas(){
		peliculasList = new ArrayList<>();
		peliculasList.addAll(getPelisListService().encontrarPeliculas(titulo, genero));

	}

	public PelisListService getPelisListService() {
		return pelisListService;
	}

	public void setPelisListService(PelisListService pelisListService) {
		this.pelisListService = pelisListService;
	}

	public List<String> getPeliculasList() {
		return peliculasList;
	}

	public void setPeliculasList(List<String> peliculasList) {
		this.peliculasList = peliculasList;
	}

	public List<Genero> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(List<Genero> categoriaList) {
		this.categoriaList = categoriaList;
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
	
	
}
