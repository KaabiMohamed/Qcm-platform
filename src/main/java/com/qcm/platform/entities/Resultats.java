package com.qcm.platform.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Resultats
 * 
 */
@Entity
public class Resultats implements Serializable {

	private static final long serialVersionUID = 1L;

	public Resultats() {
		super();
	}

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Candidat candidat;
	@ManyToOne(cascade=CascadeType.ALL)
	private Examen examen;
	private double pourcentageReussite;
	@Temporal(TemporalType.DATE)
	private Date date;

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

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
	 * @return the pourcentageReussite
	 */
	public double getPourcentageReussite() {
		return pourcentageReussite;
	}

	/**
	 * @param pourcentageReussite
	 *            the pourcentageReussite to set
	 */
	public void setPourcentageReussite(double pourcentageReussite) {
		this.pourcentageReussite = pourcentageReussite;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((candidat == null) ? 0 : candidat.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((examen == null) ? 0 : examen.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(pourcentageReussite);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Resultats other = (Resultats) obj;
		if (candidat == null) {
			if (other.candidat != null)
				return false;
		} else if (!candidat.equals(other.candidat))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (examen == null) {
			if (other.examen != null)
				return false;
		} else if (!examen.equals(other.examen))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(pourcentageReussite) != Double
				.doubleToLongBits(other.pourcentageReussite))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Resultats [id=" + id + ", candidat=" + candidat + ", examen="
				+ examen + ", pourcentageReussite=" + pourcentageReussite
				+ ", date=" + date + "]";
	}

}
