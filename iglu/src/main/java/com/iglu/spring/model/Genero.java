package com.iglu.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the genero database table.
 * 
 */
@Entity
@NamedQuery(name="Genero.findAll", query="SELECT g FROM Genero g")
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GENERO_GENEROID_GENERATOR", sequenceName="GENERO_GENERO_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GENERO_GENEROID_GENERATOR")
	@Column(name="genero_id")
	private Long generoId;

	private String genero;

	//bi-directional many-to-one association to Pelicula
	@OneToMany(mappedBy="genero")
	private List<Pelicula> peliculas;

	public Genero() {
	}

	public Long getGeneroId() {
		return this.generoId;
	}

	public void setGeneroId(Long generoId) {
		this.generoId = generoId;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Pelicula> getPeliculas() {
		return this.peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public Pelicula addPelicula(Pelicula pelicula) {
		getPeliculas().add(pelicula);
		pelicula.setGenero(this);

		return pelicula;
	}

	public Pelicula removePelicula(Pelicula pelicula) {
		getPeliculas().remove(pelicula);
		pelicula.setGenero(null);

		return pelicula;
	}

}