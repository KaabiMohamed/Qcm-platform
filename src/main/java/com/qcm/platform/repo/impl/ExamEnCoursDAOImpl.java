package com.qcm.platform.repo.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qcm.platform.entities.ExamEnCours;
import com.qcm.platform.repo.ExamEnCoursDao;

@Repository
@Transactional
public class ExamEnCoursDAOImpl implements ExamEnCoursDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public void ajouterExamEnCours(ExamEnCours examEnCours) {
		try {
			entityManager.persist(entityManager.merge(examEnCours));
		} catch (Exception e) {
		}
	}

	@Override
	public void modifierExamEnCours(ExamEnCours examEnCours) {
		try {
			entityManager.merge(examEnCours);
		} catch (Exception e) {
		}
	}

	@Override
	public void supprimerExamEnCours(ExamEnCours examEnCours) {
		try {
			entityManager.remove(examEnCours);
		} catch (Exception e) {
		}
	}

	@Override
	public ExamEnCours findExamEnCoursForQcmAndUser(String idQcm, String isUser) {
		return null;
	}

	@Override
	public ExamEnCours findExamEnCoursForId(int id) {
		
		ExamEnCours toReturn = entityManager.find(ExamEnCours.class, id);
		if (toReturn != null) {
			return entityManager.find(ExamEnCours.class, id);
		}
		return null;
	}
}
