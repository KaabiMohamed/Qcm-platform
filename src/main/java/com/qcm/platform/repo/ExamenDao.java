package com.qcm.platform.repo;

import java.util.List;

import com.qcm.platform.entities.Examen;



public interface ExamenDao {

	public Examen AjouterExamen(Examen examen);
	public void ModifierExamen(Examen examen);
	public Examen RechercherExamen(int idExamen) ;
	public void supprimerExamen(Examen examen);
	public List<Examen> toutExamens();
	public List<Examen> getExamByUser(String identifiant);
	public List<Examen> getExamForCandidat(String idcandidat);
	
}
