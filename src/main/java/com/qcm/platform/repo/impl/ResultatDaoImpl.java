package com.qcm.platform.repo.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qcm.platform.entities.Question;
import com.qcm.platform.entities.Resultats;
import com.qcm.platform.repo.ResultatDao;

@Repository
@Transactional
public class ResultatDaoImpl implements ResultatDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public String ajouterResultat(Resultats resultats) {
		
		Resultats res = entityManager.merge(resultats);
		res.setDate(new Date());
		entityManager.persist(res);
		return null;
	}

	@Override
	public String modifierResultat(Resultats resultats) {
		entityManager.merge(resultats);
		return null;
	}

	@Override
	public String supprimerResultat(Resultats resultats) {
		Resultats res = entityManager.merge(resultats);
		entityManager.remove(res);
		return null;
	}

	@Override
	public Resultats chercherResultat(int idResultat) {

		return entityManager.find(Resultats.class, idResultat);
	}

	@Override
	public List<Resultats> findByCandidat(String idCandidat) {
		TypedQuery<Resultats> query = this.entityManager.createQuery(
				"select a from Resultats a where a.candidat.identifiant='"
						+ idCandidat + "'", Resultats.class);

		return query.getResultList();
	}
	
	@Override
	public boolean candidateHasPassedExam(String idCandidat,int idQcm) {
		TypedQuery<Resultats> query = this.entityManager.createQuery(
				"select a from Resultats a where a.candidat.identifiant='"
						+ idCandidat + "' and a.examen.idExam='" + idQcm
						+ "'", Resultats.class);
		if(query.getResultList().size()==0){
			return false;
		}
		return true;
	}

	@Override
	public List<Resultats> findByExamen(int idExamen) {
		TypedQuery<Resultats> query = this.entityManager.createQuery(
				"select a from Resultats a where a.examen.idExam='" + idExamen
						+ "' order by a.pourcentageReussite DESC", Resultats.class);

		return query.getResultList();
	}

	@Override
	public List<Resultats> findByAdministrateur(String idAdmin) {
		TypedQuery<Resultats> query = this.entityManager.createQuery(
				"select a from Resultats a where a.examen.createur.identifiant='" + idAdmin
						+ "' group by a.examen ORDER BY a.examen.dateExamen", Resultats.class);

		return query.getResultList();
	}




}
