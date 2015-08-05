package com.iglu.spring.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the authorities database table.
 * 
 */
@Entity
@Table(name="authorities")
@NamedQuery(name="Authority.findAll", query="SELECT a FROM Authority a")
public class Authority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUTHORITIES_AUTHORITIESID_GENERATOR", sequenceName="AUTHORITIES_AUTHORITIES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTHORITIES_AUTHORITIESID_GENERATOR")
	@Column(name="authorities_id")
	private Long authoritiesId;

	private String authority;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="username")
	private User user;

	public Authority() {
	}

	public Long getAuthoritiesId() {
		return this.authoritiesId;
	}

	public void setAuthoritiesId(Long authoritiesId) {
		this.authoritiesId = authoritiesId;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}