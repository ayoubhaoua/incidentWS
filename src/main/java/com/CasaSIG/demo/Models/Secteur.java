package com.CasaSIG.demo.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Secteur {

	@Id
	private long id;
	private String secteur;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSecteur() {
		return secteur;
	}
	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}
	public Secteur() {
	}
	
}
