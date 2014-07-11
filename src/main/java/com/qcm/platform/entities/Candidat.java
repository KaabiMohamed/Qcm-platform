package com.qcm.platform.entities;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Candidat
 * 
 */
@Entity
public class Candidat extends Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;

	public Candidat() {
		super();
	}

}
