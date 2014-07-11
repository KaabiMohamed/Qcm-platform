package com.qcm.platform.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qcm.platform.entities.Administrateur;
import com.qcm.platform.repo.AdminDao;



/**
 * Session Bean implementation class AdminDao
 */
@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

	@Autowired
   EntityManager entityManager;
    public AdminDaoImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String ajouterAdmin(Administrateur administrateur) {
		try {
			entityManager.persist(entityManager.merge(administrateur));
			return administrateur.getIdentifiant();
		} catch (Exception e) {
			return "";
		}
	}

	@Override
	public String supprimerAdmin(Administrateur administrateur) {
		try {
			entityManager.remove(administrateur);
			
			return administrateur.getIdentifiant();
		} catch (Exception e) {
			return "";
		}
	}

	@Override
	public String modifierAdmin(Administrateur administrateur) {
		try {
			entityManager.merge(administrateur);;
			return administrateur.getIdentifiant();
		} catch (Exception e) {
			return "";
		}
	}

	@Override
	public Administrateur chercherAdmin(String identifiant) {
		
		return entityManager.find(Administrateur.class, identifiant);
	}

	@Override
	public List<Administrateur> chercherTout() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select a from Administrateur a").getResultList();
	}

}
