package com.qcm.platform.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qcm.platform.entities.Candidat;
import com.qcm.platform.repo.CandidatDao;

@Repository
@Transactional
public class CandidatDaoImpl implements CandidatDao {

	@Autowired
	EntityManager entityManager;

	public CandidatDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ajouterCandidat(Candidat candidat) {
		try {
			candidat.setActive(true);
			entityManager.persist(entityManager.merge(candidat));
			return candidat.getIdentifiant();
		} catch (Exception e) {
			return "";
		}

	}

	@Override
	public String supprimerCandidat(Candidat candidat) {
		try {
		Candidat remove=	entityManager.merge(candidat);
			entityManager.remove(remove);
			return candidat.getIdentifiant();
		} catch (Exception e) {
			return "";
		}
	}

	@Override
	public String modifierCandidat(Candidat candidat) {
		try {
			entityManager.merge(candidat);
			return candidat.getIdentifiant();
		} catch (Exception e) {
			return "";
		}
	}

	@Override
	public Candidat chercherCandidat(String identifiant) {
try {
	Candidat found = entityManager.find(Candidat.class, identifiant);
	return found;
} catch (Exception e) {
	return null;
}
		

		
	}

	@Override
	public List<Candidat> chercherTout() {

		return entityManager.createQuery("select a from Candidat a ")
				.getResultList();
	}

	@Override
	public boolean candidatExist(String email) {
	List<Candidat> list =	entityManager.createQuery("select a from Candidat a where a.identifiant='"+email+"'").getResultList();

		if (list.size()>0)
			return true;
		else
			return false;
	}

}
