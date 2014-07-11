package com.qcm.platform.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
public class Utilisateur implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Utilisateur() {
		
	}
	
	
	@Id
	private String identifiant;
	private String motDePasse;
	private String nomEtPrenom;
	private String telephone;
	private String adresse;
	private boolean active;

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getNomEtPrenom() {
		return nomEtPrenom;
	}
	public void setNomEtPrenom(String nomEtPrenom) {
		this.nomEtPrenom = nomEtPrenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result
				+ ((identifiant == null) ? 0 : identifiant.hashCode());
		result = prime * result
				+ ((motDePasse == null) ? 0 : motDePasse.hashCode());
		result = prime * result
				+ ((nomEtPrenom == null) ? 0 : nomEtPrenom.hashCode());
		result = prime * result
				+ ((telephone == null) ? 0 : telephone.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (active != other.active)
			return false;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (identifiant == null) {
			if (other.identifiant != null)
				return false;
		} else if (!identifiant.equals(other.identifiant))
			return false;
		if (motDePasse == null) {
			if (other.motDePasse != null)
				return false;
		} else if (!motDePasse.equals(other.motDePasse))
			return false;
		if (nomEtPrenom == null) {
			if (other.nomEtPrenom != null)
				return false;
		} else if (!nomEtPrenom.equals(other.nomEtPrenom))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Utilisateur [identifiant=" + identifiant + ", motDePasse="
				+ motDePasse + ", nomEtPrenom=" + nomEtPrenom + ", telephone="
				+ telephone + ", adresse=" + adresse + ", active=" + active
				+ "]";
	}
	public Utilisateur(String identifiant, String motDePasse, String nomEtPrenom,
			String telephone) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nomEtPrenom = nomEtPrenom;
		this.telephone = telephone;
	}
	
	
	
   
}
