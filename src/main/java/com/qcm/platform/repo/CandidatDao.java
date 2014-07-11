package com.qcm.platform.repo;

import java.util.List;

import com.qcm.platform.entities.Candidat;




public interface CandidatDao {

	public String ajouterCandidat(Candidat candidat);
	public String supprimerCandidat(Candidat candidat);
	public String modifierCandidat(Candidat candidat);
	public Candidat chercherCandidat(String identifiant);
	public boolean candidatExist(String email);
	public List<Candidat> chercherTout();
}
