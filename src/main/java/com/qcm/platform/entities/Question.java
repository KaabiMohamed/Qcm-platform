package com.qcm.platform.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Question
 * 
 */
@Entity
public class Question implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6932151761740204249L;

	public Question() {

	}

	@Id
	@GeneratedValue
	private int idQuestion;
	private String question;
//	@Lob
//	@Basic(fetch=FetchType.LAZY) // this gets ignored anyway, but it is recommended for blobs
//	private  byte[] image;
	private String annexeQuestion;
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<String, String> reponses = new HashMap<String, String>();  // le premier String reponse 2 eme string Vrai/Faux
	private int niveau;
	
	private String language;


	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	
	public Question(int idQuestion, String question, String annexeQuestion,
			Map<String, String> reponses, int niveau, String language) {
		super();
		this.idQuestion = idQuestion;
		this.question = question;
		this.annexeQuestion = annexeQuestion;
		this.reponses = reponses;
		this.niveau = niveau;
		this.language = language;
	}

	/**
	 * @return the annexeQuestion
	 */
	public String getAnnexeQuestion() {
		return annexeQuestion;
	}

	/**
	 * @param annexeQuestion the annexeQuestion to set
	 */
	public void setAnnexeQuestion(String annexeQuestion) {
		this.annexeQuestion = annexeQuestion;
	}

	public Map<String, String> getReponses() {
		return reponses;
	}

	public void setReponses(Map<String, String> reponses) {
		this.reponses = reponses;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((annexeQuestion == null) ? 0 : annexeQuestion.hashCode());
		result = prime * result + idQuestion;
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result + niveau;
		result = prime * result
				+ ((question == null) ? 0 : question.hashCode());
		result = prime * result
				+ ((reponses == null) ? 0 : reponses.hashCode());
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
		Question other = (Question) obj;
		if (annexeQuestion == null) {
			if (other.annexeQuestion != null)
				return false;
		} else if (!annexeQuestion.equals(other.annexeQuestion))
			return false;
		if (idQuestion != other.idQuestion)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (niveau != other.niveau)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (reponses == null) {
			if (other.reponses != null)
				return false;
		} else if (!reponses.equals(other.reponses))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [idQuestion=" + idQuestion + ", question=" + question
				+ ", annexeQuestion=" + annexeQuestion + ", reponses="
				+ reponses + ", niveau=" + niveau + ", language=" + language
				+ "]";
	}


}
