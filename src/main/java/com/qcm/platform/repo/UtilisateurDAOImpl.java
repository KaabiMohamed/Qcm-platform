package com.qcm.platform.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qcm.platform.entities.Utilisateur;

@Repository
@Transactional
public class UtilisateurDAOImpl implements UtilisateurDAO {

	@Autowired
	EntityManager entityManager;

	@Override
	public boolean ActiverOuDesactiverUser(String identifiant) {

		Utilisateur user = entityManager.find(Utilisateur.class, identifiant);

		if (user == null) {
			return false;
		}
		else if(user.isActive()){

		user.setActive(false);
		}else {
			user.setActive(true);
		}
		entityManager.merge(user);
		

		return true;

	}

}
