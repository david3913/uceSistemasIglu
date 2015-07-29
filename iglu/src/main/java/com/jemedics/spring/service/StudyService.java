package com.jemedics.spring.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jemedics.spring.dao.StudyDAO;
import com.jemedics.spring.model.Study;

/**
 *
 * Study Service
 *
 * @author jemedics
 * @since 07 Feb 2015
 * @version 1.0.0
 * 
 *
 */

@Service("StudyService")
@Transactional(readOnly = true)
public class StudyService {

	// CustomerDAO is injected...
	@Autowired
	StudyDAO studyDAO;
	


	/**
	 * Add Customer
	 *
	 * @param customer
	 *            Customer
	 */

	@Transactional(readOnly = false)
	public void addStudy(Study study) {
		getStudyDAO().addStudy(study);

	}

	/**
	 * Delete Customer
	 *
	 * @param customer
	 *            Customer
	 */
	@Transactional(readOnly = false)
	public void deleteUser(Study study) {
		getStudyDAO().deleteStudy(study);
	}

	/**
	 * Update Customer
	 *
	 * @param customer
	 *            Customer
	 */
	@Transactional(readOnly = false)
	public void updateStudy(Study study) {
		getStudyDAO().updateStudy(study);
	}

	
	/**
	 * Get Customer
	 *
	 * @param id
	 *            int Customer Id
	 */

	public List<Study> getStudyByLike(String patName, String patId,
			String accessionNo, String modsInStudy) {
		return getStudyDAO().getStudyByLike(patName, patId, accessionNo,
				modsInStudy);
	}

	public List<Study> getStudyByNameIdDate(String patName, String patId,
			String accessionNo, String modsInStudy,
			Timestamp studyDateFrom, Timestamp studyDateTo) {
		return getStudyDAO().getStudyByNameIdDate(patName, patId, accessionNo, modsInStudy, studyDateFrom, studyDateTo);
	}

	/**
	 * Get Customer List
	 *
	 */

	public List<Study> getStudiesAll() {
		return getStudyDAO().getStudiesAll();
	}

	
	
	/**
	 * @return the studyDAO
	 */
	public StudyDAO getStudyDAO() {
		return studyDAO;
	}

	/**
	 * @param studyDAO the studyDAO to set
	 */
	public void setStudyDAO(StudyDAO studyDAO) {
		this.studyDAO = studyDAO;
	}

	
}