package com.CasaSIG.demo.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Professionnel {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(unique=true, nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	
	@ManyToMany
	private List<Secteur> secteur;
	

	public Professionnel() {
	}

	
	

	public Professionnel(String username, String password, List<Secteur> secteur) {
		super();
		this.username = username;
		this.password = password;
		this.secteur = secteur;
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<Secteur> getSecteur() {
		return secteur;
	}


	public void setSecteur(List<Secteur> secteur) {
		this.secteur = secteur;
	}


	
	
}
