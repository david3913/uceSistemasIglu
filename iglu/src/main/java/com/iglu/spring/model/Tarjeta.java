package com.iglu.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tarjeta database table.
 * 
 */
@Entity
@NamedQuery(name="Tarjeta.findAll", query="SELECT t FROM Tarjeta t")
public class Tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TARJETA_TARJETAID_GENERATOR", sequenceName="TARJETA_TARJETA_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TARJETA_TARJETAID_GENERATOR")
	@Column(name="tarjeta_id")
	private Long tarjetaId;

	@Temporal(TemporalType.DATE)
	private Date caducidad;

	private String numero;

	private String seguridad;

	private String tipo;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	public Tarjeta() {
	}

	public Long getTarjetaId() {
		return this.tarjetaId;
	}

	public void setTarjetaId(Long tarjetaId) {
		this.tarjetaId = tarjetaId;
	}

	public Date getCaducidad() {
		return this.caducidad;
	}

	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSeguridad() {
		return this.seguridad;
	}

	public void setSeguridad(String seguridad) {
		this.seguridad = seguridad;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}