package com.qcm.platform.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Examen
 * 
 */
@Entity
public class ExamEnCours implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8385986658398678447L;

	public ExamEnCours() {

	}

	@Id
	@GeneratedValue
	private int id;
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<String, String> questionReponses = new HashMap<String, String>(); 
	@ManyToOne
	private Examen examen;
	@ManyToOne
	private Candidat candidat;
	private long startTime;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the questionReponses
	 */
	public Map<String, String> getQuestionReponses() {
		return questionReponses;
	}

	/**
	 * @param questionReponses
	 *            the questionReponses to set
	 */
	public void setQuestionReponses(Map<String, String> questionReponses) {
		this.questionReponses = questionReponses;
	}

	/**
	 * @return the examen
	 */
	public Examen getExamen() {
		return examen;
	}

	/**
	 * @param examen
	 *            the examen to set
	 */
	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	/**
	 * @return the candidat
	 */
	public Candidat getCandidat() {
		return candidat;
	}

	/**
	 * @param candidat
	 *            the candidat to set
	 */
	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
}
