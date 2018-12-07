package com.CasaSIG.demo.Models;

import java.io.Serializable;

public class IncidentSer implements Serializable{

	private static final long serialVersionUID = -1764970284520387975L;
	public String Secteur;
	private String type;
	private float longitude ;
	private float latitude ;
	private int ime;
	private String description;
	
	public IncidentSer() {
	}

	
}
