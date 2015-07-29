package com.iglu.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the actor database table.
 * 
 */
@Entity
@NamedQuery(name="Actor.findAll", query="SELECT a FROM Actor a")
public class Actor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACTOR_ACTORID_GENERATOR", sequenceName="ACTOR_ACTOR_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACTOR_ACTORID_GENERATOR")
	@Column(name="actor_id")
	private Long actorId;

	private String alias;

	private String apellidos;

	@Temporal(TemporalType.DATE)
	private Date nacimiento;

	private String nombre;

	//bi-directional many-to-many association to Pelicula
	@ManyToMany(mappedBy="actors")
	private List<Pelicula> peliculas;

	public Actor() {
	}

	public Long getActorId() {
		return this.actorId;
	}

	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getNacimiento() {
		return this.nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pelicula> getPeliculas() {
		return this.peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

}