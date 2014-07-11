package com.qcm.platform.repo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qcm.platform.entities.Candidat;
import com.qcm.platform.entities.Examen;
import com.qcm.platform.entities.Resultats;
import com.qcm.platform.repo.CandidatDao;
import com.qcm.platform.repo.ExamenDao;
import com.qcm.platform.repo.ResultatDao;

/**
 * Session Bean implementation class ExamenDao
 */
@Repository
@Transactional
public class ExamenDaoImpl implements ExamenDao {

	@Autowired
	EntityManager entityManager;

	@Autowired
	ResultatDao resultat;
	@Autowired
	CandidatDao candidatDao;

	/**
	 * Default constructor.
	 */
	public ExamenDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Examen AjouterExamen(Examen examen) {
		entityManager.persist(examen);
		entityManager.merge(examen);
		return examen;
	}

	@Override
	public void ModifierExamen(Examen examen) {
		entityManager.merge(examen);

	}

	@Override
	public Examen RechercherExamen(int idExam) {

		return entityManager.find(Examen.class, idExam);
	}

	@Override
	public void supprimerExamen(Examen examen) {

		List<Resultats> res = resultat.findByExamen(examen.getIdExam());
		for (Resultats r : res) {
			entityManager.remove(r);

		}
		Examen deleteThis = entityManager.merge(examen);
		entityManager.remove(deleteThis);

	}

	@Override
	public List<Examen> toutExamens() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("Select a from Examen a")
				.getResultList();
	}

	@Override
	public List<Examen> getExamByUser(String identifiant) {

		return entityManager.createQuery(
				"Select a from Examen a where a.createur.identifiant='"
						+ identifiant + "' ORDER BY a.idExam Desc")
				.getResultList();
	}

	@Override
	public List<Examen> getExamForCandidat(String idcandidat) {
		Candidat candidat = candidatDao.chercherCandidat(idcandidat);
		System.out.println(candidat.toString());

		List<Examen> toReturn = new ArrayList<Examen>();
		if (candidat != null) {
			List<Examen> allExam = entityManager.createQuery(
					"Select a from Examen a").getResultList();
			for (Examen e : allExam) {

				if (e.getLesCandidats().contains(candidat)&& !resultat.candidateHasPassedExam(idcandidat, e.getIdExam())) {
					toReturn.add(e);
					System.out.println(e.toString());
				}

			}
		}

		return toReturn;
	}

}
