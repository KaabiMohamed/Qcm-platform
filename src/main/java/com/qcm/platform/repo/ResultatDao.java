package com.qcm.platform.repo;

import java.util.List;

import com.qcm.platform.entities.Examen;
import com.qcm.platform.entities.Resultats;

public interface ResultatDao {

	public String ajouterResultat(Resultats resultats);

	public String modifierResultat(Resultats resultats);

	public String supprimerResultat(Resultats resultats);

	public Resultats chercherResultat(int idResultat);

	public List<Resultats> findByCandidat(String idCandidat);
	
	boolean candidateHasPassedExam(String idCandidat,int idQcm); 

	public List<Resultats> findByExamen(int idExamen);
	
	public List<Resultats> findByAdministrateur(String idAdmin); 
	
	

}
