package com.CasaSIG.demo.Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class Professionnel implements UserDetails{
	
	@Id
	@GeneratedValue
	private long id;
	@Column(unique=true, nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private  String role="USER";
	private  Boolean enabled=true;
	
	@ManyToMany
	private List<Secteur> secteur;
	

	public Professionnel() {
	}


	public Professionnel(long id, String username, String password, List<Secteur> secteur) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.secteur = secteur;
	}
	

	public Boolean getEnabled() {
		return enabled;
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


	@Override
	public ArrayList< GrantedAuthority> getAuthorities() {
		GrantedAuthority a = new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return "ROLE_USER";
			}
		};
		ArrayList<GrantedAuthority> b = new ArrayList<>();
		b.add(a);
		return b;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}


	
	
}
