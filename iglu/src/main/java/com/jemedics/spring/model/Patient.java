package com.jemedics.spring.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

/**
 * The persistent class for the patient database table.
 * 
 */
@Entity
@NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
@FilterDef(name = "filterBetweenPatientByStudyDate", parameters = {
		@ParamDef(name = "paramStudyDateFrom", type = "timestamp"),
		@ParamDef(name = "paramStudyDateTo", type = "timestamp")

})
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PATIENT_PK_GENERATOR", sequenceName = "PATIENT_PK_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATIENT_PK_GENERATOR")
	private Long pk;

	@Column(name = "created_time")
	private Timestamp createdTime;

	@Column(name = "pat_attrs")
	private byte[] patAttrs;

	@Column(name = "pat_birthdate")
	private String patBirthdate;

	@Column(name = "pat_custom1")
	private String patCustom1;

	@Column(name = "pat_custom2")
	private String patCustom2;

	@Column(name = "pat_custom3")
	private String patCustom3;

	@Column(name = "pat_fn_sx")
	private String patFnSx;

	@Column(name = "pat_gn_sx")
	private String patGnSx;

	@Column(name = "pat_i_name")
	private String patIName;

	@Column(name = "pat_id")
	private String patId;

	@Column(name = "pat_id_issuer")
	private String patIdIssuer;

	@Column(name = "pat_name")
	private String patName;

	@Column(name = "pat_p_name")
	private String patPName;

	@Column(name = "pat_sex")
	private String patSex;

	@Column(name = "updated_time")
	private Timestamp updatedTime;

	// bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name = "merge_fk")
	private Patient patient;

	// bi-directional many-to-one association to Patient
	@OneToMany(mappedBy = "patient")
	private List<Patient> patients;

	// bi-directional many-to-one association to Study
	@OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
	@Filter(name = "filterBetweenPatientByStudyDate", condition = "study_datetime between :paramStudyDateFrom and :paramStudyDateTo ")
	private List<Study> studies;

	public Patient() {
	}

	public Long getPk() {
		return this.pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public byte[] getPatAttrs() {
		return this.patAttrs;
	}

	public void setPatAttrs(byte[] patAttrs) {
		this.patAttrs = patAttrs;
	}

	public String getPatBirthdate() {
		return this.patBirthdate;
	}

	public void setPatBirthdate(String patBirthdate) {
		this.patBirthdate = patBirthdate;
	}

	public String getPatCustom1() {
		return this.patCustom1;
	}

	public void setPatCustom1(String patCustom1) {
		this.patCustom1 = patCustom1;
	}

	public String getPatCustom2() {
		return this.patCustom2;
	}

	public void setPatCustom2(String patCustom2) {
		this.patCustom2 = patCustom2;
	}

	public String getPatCustom3() {
		return this.patCustom3;
	}

	public void setPatCustom3(String patCustom3) {
		this.patCustom3 = patCustom3;
	}

	public String getPatFnSx() {
		return this.patFnSx;
	}

	public void setPatFnSx(String patFnSx) {
		this.patFnSx = patFnSx;
	}

	public String getPatGnSx() {
		return this.patGnSx;
	}

	public void setPatGnSx(String patGnSx) {
		this.patGnSx = patGnSx;
	}

	public String getPatIName() {
		return this.patIName;
	}

	public void setPatIName(String patIName) {
		this.patIName = patIName;
	}

	public String getPatId() {
		return this.patId;
	}

	public void setPatId(String patId) {
		this.patId = patId;
	}

	public String getPatIdIssuer() {
		return this.patIdIssuer;
	}

	public void setPatIdIssuer(String patIdIssuer) {
		this.patIdIssuer = patIdIssuer;
	}

	public String getPatName() {
		return this.patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getPatPName() {
		return this.patPName;
	}

	public void setPatPName(String patPName) {
		this.patPName = patPName;
	}

	public String getPatSex() {
		return this.patSex;
	}

	public void setPatSex(String patSex) {
		this.patSex = patSex;
	}

	public Timestamp getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Patient addPatient(Patient patient) {
		getPatients().add(patient);
		patient.setPatient(this);

		return patient;
	}

	public Patient removePatient(Patient patient) {
		getPatients().remove(patient);
		patient.setPatient(null);

		return patient;
	}

	public List<Study> getStudies() {
		return this.studies;
	}

	public void setStudies(List<Study> studies) {
		this.studies = studies;
	}

	public Study addStudy(Study study) {
		getStudies().add(study);
		study.setPatient(this);

		return study;
	}

	public Study removeStudy(Study study) {
		getStudies().remove(study);
		study.setPatient(null);

		return study;
	}

}