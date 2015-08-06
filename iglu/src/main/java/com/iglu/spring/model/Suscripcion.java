package com.iglu.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the suscripcion database table.
 * 
 */
@Entity
@NamedQuery(name="Suscripcion.findAll", query="SELECT s FROM Suscripcion s")
public class Suscripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SUSCRIPCION_SUSCRIPCIONID_GENERATOR", sequenceName="SUSCRIPCION_SUSCRIPCION_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SUSCRIPCION_SUSCRIPCIONID_GENERATOR")
	@Column(name="suscripcion_id")
	private Long suscripcionId;

	@Temporal(TemporalType.DATE)
	private Date fin;

	@Temporal(TemporalType.DATE)
	private Date inicio;

	private String tipo;

	//bi-directional many-to-one association to Cuenta
	@OneToMany(mappedBy="suscripcion")
	private List<Cuenta> cuentas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	public Suscripcion() {
	}

	public Long getSuscripcionId() {
		return this.suscripcionId;
	}

	public void setSuscripcionId(Long suscripcionId) {
		this.suscripcionId = suscripcionId;
	}

	public Date getFin() {
		return this.fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cuenta addCuenta(Cuenta cuenta) {
		getCuentas().add(cuenta);
		cuenta.setSuscripcion(this);

		return cuenta;
	}

	public Cuenta removeCuenta(Cuenta cuenta) {
		getCuentas().remove(cuenta);
		cuenta.setSuscripcion(null);

		return cuenta;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}