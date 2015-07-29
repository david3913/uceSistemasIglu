package com.jemedics.spring.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jemedics.spring.model.Patient;

/**
 *
 * patient DAO
 *
 * @author jemedics
 * @since 07 Feb 2015
 * @version 1.0.0
 *
 */
@Repository
public class PatientDAO {
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Get Hibernate Session Factory
	 *
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Set Hibernate Session Factory
	 *
	 * @param sessionFactory
	 *            SessionFactory - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Add patient
	 *
	 * @param user
	 *            customer
	 */

	public void addPatient(Patient patient) {
		getSessionFactory().getCurrentSession().save(patient);
	}

	/**
	 * Delete customer
	 *
	 * @param customer
	 *            customer
	 */

	public void deletePatient(Patient patient) {
		getSessionFactory().getCurrentSession().delete(patient);
	}

	/**
	 * Update customer
	 *
	 * @param customer
	 *            customer
	 */

	public void updatePatient(Patient patient) {
		getSessionFactory().getCurrentSession().update(patient);
	}

	// lista de todos los pacientes... mapeada la entidad PATIENT
	@SuppressWarnings("unchecked")
	public List<Patient> getPatientsAll() {

		List<Patient> list = getSessionFactory().getCurrentSession()
				.createQuery("select distinct patient from Patient patient,Study where patient.pk=patient_fk").list();
		return list;
	}
 
	// select by like
	@SuppressWarnings("unchecked")
	public List<Patient> getPatientByLike(String patName, String patId,
			String accessionNo, String modsInStudy) {

		List<Patient> list = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"select distinct patient from Patient patient, Study where   upper(pat_name) like ? and upper(pat_id) like ? and upper(accession_no)  like ? and upper(mods_in_study) like ?  "
								+ "and patient.pk=patient_fk")
				.setParameter(0, "%" + patName + "%")
				.setParameter(1, "%" + patId + "%")
				.setParameter(2, "%" + accessionNo + "%")
				.setParameter(3, "%" + modsInStudy + "%").list();

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Patient> getPatientByNameIdDate(String patName, String patId,
			String accessionNo, String modsInStudy,
			Timestamp paramStudyDateFrom, Timestamp paramStudyDateTo) {

		Session session = getSessionFactory().getCurrentSession();
		session.enableFilter("filterBetweenPatientByStudyDate")
				.setParameter("paramStudyDateFrom", paramStudyDateFrom)
				.setParameter("paramStudyDateTo", paramStudyDateTo);

		List<Patient> list = session
				.createQuery(
						"select distinct patient from Patient patient,Study where"
								+ " study_datetime between ? and ? and  upper(pat_name) like ? and"
								+ " upper(pat_id) like ? and upper(accession_no)  like ? and"
								+ " upper(mods_in_study) like ? and patient.pk=patient_fk")
				.setParameter(0, paramStudyDateFrom)
				.setParameter(1, paramStudyDateTo)
				.setParameter(2, "%" + patName + "%")
				.setParameter(3, "%" + patId + "%")
				.setParameter(4, "%" + accessionNo + "%")
				.setParameter(5, "%" + modsInStudy + "%").list();

		return list;
	}

}

// String hql3
// ="from Patient where pat_name like upper(?0) and pat_id(?1)";
// Query query3 =
// getSessionFactory().getCurrentSession().createQuery(hql3);
// query3.setParameter(0, "%" + patName + "%");
// query3.setParameter(1, "%" + patId + "%");