package com.qcm.platform.repo.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qcm.platform.entities.Administrateur;
import com.qcm.platform.entities.Candidat;
import com.qcm.platform.entities.Utilisateur;
import com.qcm.platform.repo.LoginDao;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {

	@Autowired
	EntityManager entityManager;

	public LoginDaoImpl() {
		
	}

	@Override
	public String getUserRole(String identifiant, String motDePasse) {
		Utilisateur user = null;
		try {
			user = (Utilisateur) entityManager.createQuery(
					"select a from Utilisateur a where a.identifiant='"
							+ identifiant + "' " + "and a.motDePasse='"
							+ motDePasse + "'").getSingleResult();
			if (user instanceof Candidat && user.isActive()) {
				return "candidat";
			} else if (user instanceof Administrateur && user.isActive()) {
				return "administrateur";
			} else {
				return "";
			}

		} catch (Exception e) {
			return "";
		}

	}

	@Override
	public String getRoleForIdentifiiant(String identifiant) {
		Utilisateur user = null;
		try {
			user = (Utilisateur) entityManager.createQuery(
					"select a from Utilisateur a where a.identifiant='"
							+ identifiant + "' ").getSingleResult();
			if (user instanceof Candidat ) {
				return "candidat";
			} else if (user instanceof Administrateur) {
				return "administrateur";
			} else {
				return "";
			}

		} catch (Exception e) {
			return "";
		}
	}
	
	

}
