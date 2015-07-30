package com.iglu.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iglu.spring.model.Pelicula;

@Repository
public class PelisListDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Pelicula> selectPeliculasList(String titulo, String genero){

//		List<Pelicula> list = getSessionFactory()
//				.getCurrentSession()
//				.createQuery(
//						"select p from Pelicula p where lower(titulo) like ? and genero_id="
//						+ "(select g from Genero g where lower(genero) like ?) ").
//				setParameter(0, "%" + titulo.toLowerCase() + "%")
//				.setParameter(1, "%" + genero.toLowerCase() + "%").list();
//

		List<Pelicula> list = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"select p from Pelicula p where lower(titulo) like ?").
				setParameter(0, "%" + titulo.toLowerCase() + "%").list();


		
		
		return list;
	}

	public Pelicula selectPeliculas(long id){



		@SuppressWarnings("unchecked")
		Pelicula peli = (Pelicula) getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"select p from Pelicula p where pelicula_id = ?").
				setParameter(0, id).list().get(0);


		
		
		return peli;
	}
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
