package com.jemedics.spring.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jemedics.spring.model.Study;

/**
 *
 * study DAO
 *
 * @author jemedics
 * @since 07 Feb 2015
 * @version 1.0.0
 *
 */
@Repository
public class StudyDAO {
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
	 * Add study
	 *
	 * @param user
	 *            customer
	 */

	public void addStudy(Study study) {
		getSessionFactory().getCurrentSession().save(study);
	}

	/**
	 * Delete customer
	 *
	 * @param customer
	 *            customer
	 */

	public void deleteStudy(Study study) {
		getSessionFactory().getCurrentSession().delete(study);
	}

	/**
	 * Update customer
	 *
	 * @param customer
	 *            customer
	 */

	public void updateStudy(Study study) {
		getSessionFactory().getCurrentSession().update(study);
	}

	// lista de todos los pacientes... mapeada la entidad PATIENT
	@SuppressWarnings("unchecked")
	public List<Study> getStudiesAll() {

		List<Study> list = getSessionFactory().getCurrentSession()
				.createQuery("from com.jemedics.spring.model.Study").list();
		return list;
	}

	// select by like
	@SuppressWarnings("unchecked")
	public List<Study> getStudyByLike(String patName, String patId,
			String accessionNo, String modsInStudy) {

		List<Study> list = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"select study from Study study, Patient patient where  upper(pat_name) like ? and upper(pat_id) like ? "
						+ "and upper(accession_no)  like ? and upper(mods_in_study) like ?  and patient.pk=patient_fk")
				.setParameter(0, "%" + patName + "%")
				.setParameter(1, "%" + patId + "%")
				.setParameter(2, "%" + accessionNo + "%")
				.setParameter(3, "%" + modsInStudy + "%").list();

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Study> getStudyByNameIdDate(String patName, String patId,
			String accessionNo, String modsInStudy,
			Timestamp studyDateFrom, Timestamp studyDateTo) {

	
		List<Study> list = getSessionFactory().getCurrentSession()
				.createQuery(
						"select study from Study study,Patient patient where"
								+ " study_datetime between ? and ? and  upper(pat_name) like ? and"
								+ " upper(pat_id) like ? and upper(accession_no)  like ? and"
								+ " upper(mods_in_study) like ?  and patient.pk=study.patient_fk")
				.setParameter(0, studyDateFrom)
				.setParameter(1, studyDateTo)
				.setParameter(2, "%" + patName + "%")
				.setParameter(3, "%" + patId + "%")
				.setParameter(4, "%" + accessionNo + "%")
				.setParameter(5, "%" + modsInStudy + "%").list();

		return list;
	}

}

// String hql3
// ="from Study where pat_name like upper(?0) and pat_id(?1)";
// Query query3 =
// getSessionFactory().getCurrentSession().createQuery(hql3);
// query3.setParameter(0, "%" + patName + "%");
// query3.setParameter(1, "%" + patId + "%");