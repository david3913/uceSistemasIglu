package com.iglu.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pelicula database table.
 * 
 */
@Entity
@NamedQuery(name="Pelicula.findAll", query="SELECT p FROM Pelicula p")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PELICULA_PELICULAID_GENERATOR", sequenceName="PELICULA_PELICULA_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PELICULA_PELICULAID_GENERATOR")
	@Column(name="pelicula_id")
	private Long peliculaId;

	private String an;

	private String ruta;

	private String sinopsis;

	private String titulo;

	private Long visto;

	//bi-directional many-to-many association to Actor
	@ManyToMany
	@JoinTable(
		name="pelicula_actor"
		, joinColumns={
			@JoinColumn(name="pelicula_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="actor_id")
			}
		)
	private List<Actor> actors;

	//bi-directional many-to-one association to Genero
	@ManyToOne
	@JoinColumn(name="genero_id")
	private Genero genero;

	public Pelicula() {
	}

	public Long getPeliculaId() {
		return this.peliculaId;
	}

	public void setPeliculaId(Long peliculaId) {
		this.peliculaId = peliculaId;
	}

	public String getAn() {
		return this.an;
	}

	public void setAn(String an) {
		this.an = an;
	}

	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getSinopsis() {
		return this.sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getVisto() {
		return this.visto;
	}

	public void setVisto(Long visto) {
		this.visto = visto;
	}

	public List<Actor> getActors() {
		return this.actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}