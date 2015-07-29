package com.jemedics.spring.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;




/**
 * The persistent class for the study database table.
 * 
 */
@Entity

@NamedQuery(name="Study.findAll", query="SELECT s FROM Study s")
public class Study implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STUDY_PK_GENERATOR", sequenceName="STUDY_PK_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STUDY_PK_GENERATOR")
	private Long pk;

	@Column(name="accession_no")
	private String accessionNo;

	@Column(name="accno_issuer_fk")
	private Long accnoIssuerFk;

	private Integer availability;

	@Column(name="checked_time")
	private Timestamp checkedTime;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="cuids_in_study")
	private String cuidsInStudy;

	@Column(name="ext_retr_aet")
	private String extRetrAet;

	@Column(name="fileset_id")
	private String filesetId;

	@Column(name="fileset_iuid")
	private String filesetIuid;

	@Column(name="mods_in_study")
	private String modsInStudy;

	@Column(name="num_instances")
	private Integer numInstances;

	@Column(name="num_series")
	private Integer numSeries;

	@Column(name="ref_phys_fn_sx")
	private String refPhysFnSx;

	@Column(name="ref_phys_gn_sx")
	private String refPhysGnSx;

	@Column(name="ref_phys_i_name")
	private String refPhysIName;

	@Column(name="ref_phys_p_name")
	private String refPhysPName;

	@Column(name="ref_physician")
	private String refPhysician;

	@Column(name="retrieve_aets")
	private String retrieveAets;

	@Column(name="study_attrs")
	private byte[] studyAttrs;

	@Column(name="study_custom1")
	private String studyCustom1;

	@Column(name="study_custom2")
	private String studyCustom2;

	@Column(name="study_custom3")
	private String studyCustom3;

	@Column(name="study_datetime")
	private Timestamp studyDatetime;

	@Column(name="study_desc")
	private String studyDesc;

	@Column(name="study_id")
	private String studyId;

	@Column(name="study_iuid")
	private String studyIuid;

	@Column(name="study_status")
	private Integer studyStatus;

	@Column(name="study_status_id")
	private String studyStatusId;

	@Column(name="updated_time")
	private Timestamp updatedTime;

	//bi-directional many-to-one association to Patient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="patient_fk")	
	private Patient patient;

	public Study() {
	}

	public Long getPk() {
		return this.pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getAccessionNo() {
		return this.accessionNo;
	}

	public void setAccessionNo(String accessionNo) {
		this.accessionNo = accessionNo;
	}

	public Long getAccnoIssuerFk() {
		return this.accnoIssuerFk;
	}

	public void setAccnoIssuerFk(Long accnoIssuerFk) {
		this.accnoIssuerFk = accnoIssuerFk;
	}

	public Integer getAvailability() {
		return this.availability;
	}

	public void setAvailability(Integer availability) {
		this.availability = availability;
	}

	public Timestamp getCheckedTime() {
		return this.checkedTime;
	}

	public void setCheckedTime(Timestamp checkedTime) {
		this.checkedTime = checkedTime;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public String getCuidsInStudy() {
		return this.cuidsInStudy;
	}

	public void setCuidsInStudy(String cuidsInStudy) {
		this.cuidsInStudy = cuidsInStudy;
	}

	public String getExtRetrAet() {
		return this.extRetrAet;
	}

	public void setExtRetrAet(String extRetrAet) {
		this.extRetrAet = extRetrAet;
	}

	public String getFilesetId() {
		return this.filesetId;
	}

	public void setFilesetId(String filesetId) {
		this.filesetId = filesetId;
	}

	public String getFilesetIuid() {
		return this.filesetIuid;
	}

	public void setFilesetIuid(String filesetIuid) {
		this.filesetIuid = filesetIuid;
	}

	public String getModsInStudy() {
		return this.modsInStudy;
	}

	public void setModsInStudy(String modsInStudy) {
		this.modsInStudy = modsInStudy;
	}

	public Integer getNumInstances() {
		return this.numInstances;
	}

	public void setNumInstances(Integer numInstances) {
		this.numInstances = numInstances;
	}

	public Integer getNumSeries() {
		return this.numSeries;
	}

	public void setNumSeries(Integer numSeries) {
		this.numSeries = numSeries;
	}

	public String getRefPhysFnSx() {
		return this.refPhysFnSx;
	}

	public void setRefPhysFnSx(String refPhysFnSx) {
		this.refPhysFnSx = refPhysFnSx;
	}

	public String getRefPhysGnSx() {
		return this.refPhysGnSx;
	}

	public void setRefPhysGnSx(String refPhysGnSx) {
		this.refPhysGnSx = refPhysGnSx;
	}

	public String getRefPhysIName() {
		return this.refPhysIName;
	}

	public void setRefPhysIName(String refPhysIName) {
		this.refPhysIName = refPhysIName;
	}

	public String getRefPhysPName() {
		return this.refPhysPName;
	}

	public void setRefPhysPName(String refPhysPName) {
		this.refPhysPName = refPhysPName;
	}

	public String getRefPhysician() {
		return this.refPhysician;
	}

	public void setRefPhysician(String refPhysician) {
		this.refPhysician = refPhysician;
	}

	public String getRetrieveAets() {
		return this.retrieveAets;
	}

	public void setRetrieveAets(String retrieveAets) {
		this.retrieveAets = retrieveAets;
	}

	public byte[] getStudyAttrs() {
		return this.studyAttrs;
	}

	public void setStudyAttrs(byte[] studyAttrs) {
		this.studyAttrs = studyAttrs;
	}

	public String getStudyCustom1() {
		return this.studyCustom1;
	}

	public void setStudyCustom1(String studyCustom1) {
		this.studyCustom1 = studyCustom1;
	}

	public String getStudyCustom2() {
		return this.studyCustom2;
	}

	public void setStudyCustom2(String studyCustom2) {
		this.studyCustom2 = studyCustom2;
	}

	public String getStudyCustom3() {
		return this.studyCustom3;
	}

	public void setStudyCustom3(String studyCustom3) {
		this.studyCustom3 = studyCustom3;
	}

	public Timestamp getStudyDatetime() {
		return this.studyDatetime;
	}

	public void setStudyDatetime(Timestamp studyDatetime) {
		this.studyDatetime = studyDatetime;
	}

	public String getStudyDesc() {
		return this.studyDesc;
	}

	public void setStudyDesc(String studyDesc) {
		this.studyDesc = studyDesc;
	}

	public String getStudyId() {
		return this.studyId;
	}

	public void setStudyId(String studyId) {
		this.studyId = studyId;
	}

	public String getStudyIuid() {
		return this.studyIuid;
	}

	public void setStudyIuid(String studyIuid) {
		this.studyIuid = studyIuid;
	}

	public Integer getStudyStatus() {
		return this.studyStatus;
	}

	public void setStudyStatus(Integer studyStatus) {
		this.studyStatus = studyStatus;
	}

	public String getStudyStatusId() {
		return this.studyStatusId;
	}

	public void setStudyStatusId(String studyStatusId) {
		this.studyStatusId = studyStatusId;
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

}