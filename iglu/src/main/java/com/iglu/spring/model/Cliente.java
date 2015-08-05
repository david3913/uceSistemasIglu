package com.iglu.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLIENTE_CLIENTEID_GENERATOR", sequenceName="CLIENTE_CLIENTE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLIENTE_CLIENTEID_GENERATOR")
	@Column(name="cliente_id")
	private Long clienteId;

	private String apellidos;

	private String ci;

	private String direccion;

	private String email;

	private String nombres;

	private String postal;

	private String telefonos;

	//bi-directional one-to-one association to Cuenta
	@OneToOne(mappedBy="cliente")
	private Cuenta cuenta;

	//bi-directional many-to-one association to Suscripcion
	@OneToMany(mappedBy="cliente")
	private List<Suscripcion> suscripcions;

	//bi-directional many-to-one association to Tarjeta
	@OneToMany(mappedBy="cliente")
	private List<Tarjeta> tarjetas;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="cliente")
	private List<User> users;

	public Cliente() {
	}

	public Long getClienteId() {
		return this.clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCi() {
		return this.ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPostal() {
		return this.postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public List<Suscripcion> getSuscripcions() {
		return this.suscripcions;
	}

	public void setSuscripcions(List<Suscripcion> suscripcions) {
		this.suscripcions = suscripcions;
	}

	public Suscripcion addSuscripcion(Suscripcion suscripcion) {
		getSuscripcions().add(suscripcion);
		suscripcion.setCliente(this);

		return suscripcion;
	}

	public Suscripcion removeSuscripcion(Suscripcion suscripcion) {
		getSuscripcions().remove(suscripcion);
		suscripcion.setCliente(null);

		return suscripcion;
	}

	public List<Tarjeta> getTarjetas() {
		return this.tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	public Tarjeta addTarjeta(Tarjeta tarjeta) {
		getTarjetas().add(tarjeta);
		tarjeta.setCliente(this);

		return tarjeta;
	}

	public Tarjeta removeTarjeta(Tarjeta tarjeta) {
		getTarjetas().remove(tarjeta);
		tarjeta.setCliente(null);

		return tarjeta;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setCliente(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setCliente(null);

		return user;
	}

}