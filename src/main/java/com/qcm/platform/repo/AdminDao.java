package com.qcm.platform.repo;

import java.util.List;

import com.qcm.platform.entities.Administrateur;

public interface AdminDao {

	public String ajouterAdmin(Administrateur administrateur);

	public String supprimerAdmin(Administrateur administrateur);

	public String modifierAdmin(Administrateur administrateur);

	public Administrateur chercherAdmin(String identifiant);

	public List<Administrateur> chercherTout();

}
