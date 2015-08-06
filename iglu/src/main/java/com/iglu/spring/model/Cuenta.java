package com.iglu.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cuenta database table.
 * 
 */
@Entity
@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cuenta_id")
	private Long cuentaId;

	private String ci;

	@Temporal(TemporalType.DATE)
	private Date creacion;

	private String estado;

	//bi-directional one-to-one association to Cliente
	@OneToOne
	@JoinColumn(name="cuenta_id")
	private Cliente cliente;

	//bi-directional many-to-one association to Suscripcion
	@ManyToOne
	@JoinColumn(name="suscripcion_id")
	private Suscripcion suscripcion;

	public Cuenta() {
	}

	public Long getCuentaId() {
		return this.cuentaId;
	}

	public void setCuentaId(Long cuentaId) {
		this.cuentaId = cuentaId;
	}

	public String getCi() {
		return this.ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public Date getCreacion() {
		return this.creacion;
	}

	public void setCreacion(Date creacion) {
		this.creacion = creacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Suscripcion getSuscripcion() {
		return this.suscripcion;
	}

	public void setSuscripcion(Suscripcion suscripcion) {
		this.suscripcion = suscripcion;
	}

}