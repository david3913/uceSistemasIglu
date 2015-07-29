package com.iglu.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
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

	private String calle1;

	private String calle2;

	private String casa;

	private String celular;

	private String ci;

	private String ciudad;

	private String email;

	@Temporal(TemporalType.DATE)
	private Date nacimiento;

	private String nombres;

	private String postal;

	private String telefono;

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

	public String getCalle1() {
		return this.calle1;
	}

	public void setCalle1(String calle1) {
		this.calle1 = calle1;
	}

	public String getCalle2() {
		return this.calle2;
	}

	public void setCalle2(String calle2) {
		this.calle2 = calle2;
	}

	public String getCasa() {
		return this.casa;
	}

	public void setCasa(String casa) {
		this.casa = casa;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCi() {
		return this.ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNacimiento() {
		return this.nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
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

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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