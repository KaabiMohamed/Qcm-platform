package com.qcm.platform.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Examen
 * 
 */
@Entity
public class Examen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8385986658398678447L;

	public Examen() {

	}

	@Id
	@GeneratedValue
	private int idExam;
	private String Titre;
	private int nombreQuestions;
	private int nombreMinutes;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "EXAM_Candidat", joinColumns = @JoinColumn(name = "EXAM_ID"), inverseJoinColumns = @JoinColumn(name = "ID_Candidat"))
	private List<Candidat> lesCandidats;
	@ManyToOne
	private Administrateur createur;
	@Temporal(TemporalType.DATE)
	private Date dateExamen;
	private int joursValidite;
	private String language;
	private int niveau;
	private boolean valid;

	/**
	 * @return the nombreMinutes
	 */
	public int getNombreMinutes() {
		return nombreMinutes;
	}

	/**
	 * @param nombreMinutes
	 *            the nombreMinutes to set
	 */
	public void setNombreMinutes(int nombreMinutes) {
		this.nombreMinutes = nombreMinutes;
	}

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * @param valid
	 *            the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/**
	 * @return the idExam
	 */
	public int getIdExam() {
		return idExam;
	}

	/**
	 * @param idExam
	 *            the idExam to set
	 */
	public void setIdExam(int idExam) {
		this.idExam = idExam;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return Titre;
	}

	/**
	 * @param titre
	 *            the titre to set
	 */
	public void setTitre(String titre) {
		Titre = titre;
	}

	/**
	 * @return the lesCandidats
	 */
	public List<Candidat> getLesCandidats() {
		return lesCandidats;
	}

	/**
	 * @param lesCandidats
	 *            the lesCandidats to set
	 */
	public void setLesCandidats(List<Candidat> lesCandidats) {
		this.lesCandidats = lesCandidats;
	}

	/**
	 * @return the createur
	 */
	public Administrateur getCreateur() {
		return createur;
	}

	/**
	 * @param createur
	 *            the createur to set
	 */
	public void setCreateur(Administrateur createur) {
		this.createur = createur;
	}

	/**
	 * @return the dateExamen
	 */
	public Date getDateExamen() {
		return dateExamen;
	}

	/**
	 * @param dateExamen
	 *            the dateExamen to set
	 */
	public void setDateExamen(Date dateExamen) {
		this.dateExamen = dateExamen;
	}

	/**
	 * @return the joursValidite
	 */
	public int getJoursValidite() {
		return joursValidite;
	}

	/**
	 * @param joursValidite
	 *            the joursValidite to set
	 */
	public void setJoursValidite(int joursValidite) {
		this.joursValidite = joursValidite;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the niveau
	 */
	public int getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau
	 *            the niveau to set
	 */
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	/**
	 * @return the nombreQuestions
	 */
	public int getNombreQuestions() {
		return nombreQuestions;
	}

	/**
	 * @param nombreQuestions
	 *            the nombreQuestions to set
	 */
	public void setNombreQuestions(int nombreQuestions) {
		this.nombreQuestions = nombreQuestions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Titre == null) ? 0 : Titre.hashCode());
		result = prime * result
				+ ((createur == null) ? 0 : createur.hashCode());
		result = prime * result
				+ ((dateExamen == null) ? 0 : dateExamen.hashCode());
		result = prime * result + idExam;
		result = prime * result + joursValidite;
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result
				+ ((lesCandidats == null) ? 0 : lesCandidats.hashCode());
		result = prime * result + niveau;
		result = prime * result + nombreMinutes;
		result = prime * result + nombreQuestions;
		result = prime * result + (valid ? 1231 : 1237);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Examen other = (Examen) obj;
		if (Titre == null) {
			if (other.Titre != null)
				return false;
		} else if (!Titre.equals(other.Titre))
			return false;
		if (createur == null) {
			if (other.createur != null)
				return false;
		} else if (!createur.equals(other.createur))
			return false;
		if (dateExamen == null) {
			if (other.dateExamen != null)
				return false;
		} else if (!dateExamen.equals(other.dateExamen))
			return false;
		if (idExam != other.idExam)
			return false;
		if (joursValidite != other.joursValidite)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (lesCandidats == null) {
			if (other.lesCandidats != null)
				return false;
		} else if (!lesCandidats.equals(other.lesCandidats))
			return false;
		if (niveau != other.niveau)
			return false;
		if (nombreMinutes != other.nombreMinutes)
			return false;
		if (nombreQuestions != other.nombreQuestions)
			return false;
		if (valid != other.valid)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Examen [idExam=" + idExam + ", Titre=" + Titre
				+ ", nombreQuestions=" + nombreQuestions + ", nombreMinutes="
				+ nombreMinutes + ", lesCandidats=" + lesCandidats
				+ ", createur=" + createur + ", dateExamen=" + dateExamen
				+ ", joursValidite=" + joursValidite + ", language=" + language
				+ ", niveau=" + niveau + ", valid=" + valid + "]";
	}

}
