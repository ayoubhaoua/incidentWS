package com.CasaSIG.demo.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Type {

	@Id
	private long id;
	private String type;
	@ManyToOne
	private Secteur secteur;
	
	public Type() {
		
	}

	
	public Type(long id, String type, Secteur secteur) {
		super();
		this.id = id;
		this.type = type;
		this.secteur = secteur;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}
	
	
}
