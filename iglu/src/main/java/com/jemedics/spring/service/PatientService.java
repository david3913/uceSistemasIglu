package com.jemedics.spring.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jemedics.spring.dao.PatientDAO;
import com.jemedics.spring.dao.StudyDAO;
import com.jemedics.spring.model.Patient;

/**
 *
 * Patient Service
 *
 * @author jemedics
 * @since 07 Feb 2015
 * @version 1.0.0
 *
 *
 */

@Service("PatientService")
@Transactional(readOnly = true)
public class PatientService {

	// CustomerDAO is injected...
	@Autowired
	PatientDAO patientDAO;

	



	/**
	 * Add Customer
	 *
	 * @param customer
	 *            Customer
	 */

	@Transactional(readOnly = false)
	public void addPatient(Patient patient) {
		getPatientDAO().addPatient(patient);

	}

	/**
	 * Delete Customer
	 *
	 * @param customer
	 *            Customer
	 */
	@Transactional(readOnly = false)
	public void deleteUser(Patient patient) {
		getPatientDAO().deletePatient(patient);
	}

	/**
	 * Update Customer
	 *
	 * @param customer
	 *            Customer
	 */
	@Transactional(readOnly = false)
	public void updatePatient(Patient patient) {
		getPatientDAO().updatePatient(patient);
	}

	
	/**
	 * Get Customer
	 *
	 * @param id
	 *            int Customer Id
	 */

	public List<Patient> getPatientByLike(String patName, String patId,
			String accessionNo, String modsInStudy) {
		return getPatientDAO().getPatientByLike(patName, patId, accessionNo,
				modsInStudy);
	}

	public List<Patient> getPatientByNameIdDate(String patName, String patId,
			String accessionNo, String modsInStudy,
			Timestamp paramStudyDateFrom, Timestamp paramStudyDateTo) {
		System.out.println("service");
		return getPatientDAO().getPatientByNameIdDate(patName, patId, accessionNo, modsInStudy, paramStudyDateFrom, paramStudyDateTo);
	}

	/**
	 * Get Customer List
	 *
	 */

	public List<Patient> getPatientsAll() {
		return getPatientDAO().getPatientsAll();
	}

	
	
	/**
	 * Get Patient DAO
	 *
	 * @return patientDAO - Patient DAO
	 */
	public PatientDAO getPatientDAO() {
		return patientDAO;
	}

	/**
	 * Set Patient DAO
	 *
	 * @param patientDAO
	 *            - PatientDAO
	 */
	public void setPatientDAO(PatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}
}