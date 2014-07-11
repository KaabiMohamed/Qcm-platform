package com.qcm.platform.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.qcm.platform.entities.Candidat;
import com.qcm.platform.entities.Examen;
import com.qcm.platform.entities.Resultats;
import com.qcm.platform.repo.CandidatDao;
import com.qcm.platform.repo.ExamenDao;
import com.qcm.platform.repo.ResultatDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class UsersTest {

	@Autowired
	CandidatDao candidatDao;
	
	@Autowired
	ExamenDao examenDao;
	
	@Autowired
	ResultatDao resultatDao;

	@Test
	public void tester() {
		// Tester la recherche
		List<Candidat> userList = candidatDao.chercherTout();

		Candidat candidat = new Candidat();
		candidat.setIdentifiant("xxaxx@mail.com");
		candidat.setNomEtPrenom("JUnit");
		candidatDao.ajouterCandidat(candidat);
		// tester l'ajout
		Assert.assertEquals(userList.size() + 1, candidatDao.chercherTout()
				.size());

		Candidat searchCandidat = candidatDao
				.chercherCandidat("xxaxx@mail.com");
		Assert.assertEquals("JUnit", searchCandidat.getNomEtPrenom());

		// tester la modification
		candidat.setNomEtPrenom("NewName");
		candidatDao.modifierCandidat(candidat);
		searchCandidat = candidatDao.chercherCandidat("xxaxx@mail.com");
		Assert.assertEquals("NewName", searchCandidat.getNomEtPrenom());
		
		
		
		// ajouter examen 
		Examen exam = new Examen();
		exam.setTitre("new");
		 Examen ajout = examenDao.AjouterExamen(exam);
		 Resultats resultats = new Resultats();
		 resultats.setExamen(ajout);
		 resultats.setCandidat(searchCandidat);
		 resultats.setPourcentageReussite(22);
		 resultatDao.ajouterResultat(resultats);
		 
		 
		 List<Resultats> resultlist = resultatDao.findByCandidat(searchCandidat.getIdentifiant());
		 Assert.assertEquals(1, resultlist.size());
		

	}
}
