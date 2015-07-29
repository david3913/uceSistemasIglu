package com.jemedics.managedController;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.jemedics.spring.model.Study;
import com.jemedics.spring.service.StudyService;
import com.jemedics.util.configApp.ConfigApp1;

/**
 *
 * Study Managed Bean
 *
 *
 * @author dx
 * @since 12 Nov 2015
 * @version 1.0.0
 *
 */

@ManagedBean(name = "studyMB")
@ViewScoped
public class StudyManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// FacesContext context = FacesContext.getCurrentInstance();

	/*
	 * Inyeccion del servicio StudyService
	 */
	@ManagedProperty(value = "#{StudyService}")
	StudyService studyService;

	/* Constuctor */

	/*
	 * Listas
	 */
	List<Study> studyList;

	/*
	 * Objetos
	 */

	Study selectedStudy;
	/*
	 * Parametros
	 */
	private String patName;
	private String patId;
	private Timestamp studyFrom;
	private Timestamp studyTo;
	private String accessionNo;
	private String modsInStudy;
	private boolean showConfirm = false;

	@PostConstruct
	public void init() {

		studyList = new ArrayList<Study>();
		selectedStudy = new Study();
	}

	// reset
	public void reset() {
		this.patName = "";
		this.patId = "";
		this.studyFrom = null;
		this.studyTo = null;
		this.accessionNo = "";
		this.modsInStudy = "";
		this.studyList.clear();
		System.out.println(ConfigApp1.getBaseUrl1());
	}

	/* CONSULTAS A LA BASE DE DATOS */

	/*
	 * public void prueba() { System.out.println(patName); try {
	 * Thread.sleep(10000); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */

	// Escoje la forma de consulta
	public void decideSelect() {

		if (studyFrom != null && studyTo != null) {

			// select con intervalos de fechas y lo demas con likes
			System.out.println("con fecha");
			getStudyListByNameIdDate();

		} else if ((studyFrom == null || studyTo == null)
				&& (patName != "" || patId != "" || accessionNo != "" || modsInStudy != "")) {

			getStudyListByLike();

		} else {
			// setShowConfirm(true);
			// select de toda la tabla study con todos sus respectivos study
			// getStudysAll();
			System.out.println("************todo***********");
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('confirmPacsMain').show();");

		}
	}

	/**
	 * Consulta todos los registros study
	 * 
	 * */

	public void getStudiesAll() {
		System.out.println("getStudysAll");
		studyList.clear();
		studyList.addAll(getStudyService().getStudiesAll());
	}

	private void getStudyListByLike() {
		studyList.clear();
		studyList.addAll(getStudyService().getStudyByLike(patName, patId,
				accessionNo, modsInStudy));
	}

	private void getStudyListByNameIdDate() {
		studyList.clear();
		System.out.println(patName);
		System.out.println("manager " + studyFrom);
		studyList.addAll(getStudyService().getStudyByNameIdDate(patName, patId,
				accessionNo, modsInStudy, studyFrom, studyTo));
	}

	public void genUrl() {
		System.out.println("gen url");
		System.out.println(selectedStudy.getPk());

	}

	/*****
	 * GET AND SET****** /**
	 * 
	 * @return the studyService
	 */
	public StudyService getStudyService() {
		return studyService;
	}

	/**
	 * @param studyService
	 *            the studyService to set
	 */
	public void setStudyService(StudyService studyService) {
		this.studyService = studyService;
	}

	/**
	 * @return the studyList
	 */
	public List<Study> getStudyList() {
		return studyList;
	}

	/**
	 * @param studyList
	 *            the studyList to set
	 */
	public void setStudyList(List<Study> studyList) {
		this.studyList = studyList;
	}

	/**
	 * @return the patName
	 */
	public String getPatName() {
		return patName;
	}

	/**
	 * @param patName
	 *            the patName to set
	 */
	public void setPatName(String patName) {
		this.patName = patName;
	}

	/**
	 * @return the patId
	 */
	public String getPatId() {
		return patId;
	}

	/**
	 * @param patId
	 *            the patId to set
	 */
	public void setPatId(String patId) {
		this.patId = patId;
	}

	/**
	 * @return the selectedStudy
	 */
	public Study getSelectedStudy() {
		return selectedStudy;
	}

	/**
	 * @param selectedStudy
	 *            the selectedStudy to set
	 */
	public void setSelectedStudy(Study selectedStudy) {
		this.selectedStudy = selectedStudy;
	}

	/**
	 * @return the studyFrom
	 */
	public Timestamp getStudyFrom() {
		return studyFrom;
	}

	/**
	 * @param studyFrom
	 *            the studyFrom to set
	 */
	public void setStudyFrom(Timestamp studyFrom) {
		this.studyFrom = studyFrom;
	}

	/**
	 * @return the studyTo
	 */
	public Timestamp getStudyTo() {
		return studyTo;
	}

	/**
	 * @param studyTo
	 *            the studyTo to set
	 */
	public void setStudyTo(Timestamp studyTo) {
		this.studyTo = studyTo;
	}

	/**
	 * @return the accessionNo
	 */
	public String getAccessionNo() {
		return accessionNo;
	}

	/**
	 * @param accessionNo
	 *            the accessionNo to set
	 */
	public void setAccessionNo(String accessionNo) {
		this.accessionNo = accessionNo;
	}

	/**
	 * @return the modsInStudy
	 */
	public String getModsInStudy() {
		return modsInStudy;
	}

	/**
	 * @param modsInStudy
	 *            the modsInStudy to set
	 */
	public void setModsInStudy(String modsInStudy) {
		this.modsInStudy = modsInStudy;
	}

	/**
	 * @return the showConfirm
	 */
	public boolean isShowConfirm() {
		return showConfirm;
	}

	/**
	 * @param showConfirm
	 *            the showConfirm to set
	 */
	public void setShowConfirm(boolean showConfirm) {
		this.showConfirm = showConfirm;
	}

}