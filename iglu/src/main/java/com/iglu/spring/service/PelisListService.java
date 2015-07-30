package com.iglu.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iglu.spring.dao.PelisListDAO;
import com.iglu.spring.model.Pelicula;
import com.iglu.util.config.ConfigApp;

///Logica del negocio

@Service("PelisListService")
@Transactional(readOnly = true)
public class PelisListService {
//@Autowired algun dao se inyecta
	
@Autowired
PelisListDAO pelisListDAO;
private List<String> peliculasList;

//recupera lista de de peliculas y las trasnforma a un string html5
public List<String> encontrarPeliculas(String titulo,String genero){
	peliculasList = new ArrayList<>();
	 List<Pelicula> peli=getPelisListDAO().selectPeliculasList(titulo, genero);
	
	 for (Pelicula p: peli) {
		 String img =p.getRuta()+"/"+p.getRuta()+"_1.jpg";
		 img=ConfigApp.getBaseServer()+img;
		//System.out.println(img);
		 String pelicula= "<div class='work'>" + "<div class='peli'>"
					+ "<a href='visor.xhtml?id="+p.getPeliculaId()+"'>"
					+ "<img src='"+img
					+ "' class='media' alt=''/>"
					+ "<div class='caption'>" + "<div class='work_title'>" + "<h1>"
					+  p.getAn()+  "</h1>" + "</div></div></a></div>"
					+ "<div class='tit'>"+p.getTitulo()
					
					+ "</div></div>";
		 peliculasList.add(pelicula);
	}
	
	 
	 
	 
	 
	 return peliculasList;
	
}

public PelisListDAO getPelisListDAO() {
	return pelisListDAO;
}

public void setPelisListDAO(PelisListDAO pelisListDAO) {
	this.pelisListDAO = pelisListDAO;
}
	
	
	
	
}
