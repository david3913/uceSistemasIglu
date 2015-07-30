package com.iglu.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iglu.spring.dao.PelisListDAO;
import com.iglu.spring.model.Pelicula;

///Logica del negocio

@Service("VisorService")
@Transactional(readOnly = true)
public class VisorService {
	// @Autowired algun dao se inyecta

	@Autowired
	PelisListDAO pelisListDAO;

	// recupera lista de de peliculas y las trasnforma a un string html5
	
	
	public Pelicula peli(long id) {

		return pelisListDAO.selectPeliculas(id);
	}

}
