package com.CasaSIG.demo.Models;


import javax.persistence.*;

@Entity
@Table(name="incident")
public class Incident {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "SERIAL")
    private Long id;
    private String IME;
    @ManyToOne
    private Type type;
    @ManyToOne
    private Secteur secteur;
    private float lat;
    private float lon;
    private String date;
    private String description;
    private String etat;
    private String motif;
    private String province;
    private String image;
    @ManyToOne
    private Professionnel pro;

    public Incident() {
    }

    




	public Incident(String iME, Type type, Secteur secteur, float lat, float lon, String date, String description,
			String etat, String motif, String province, String image, Professionnel pro) {
		super();
		IME = iME;
		this.type = type;
		this.secteur = secteur;
		this.lat = lat;
		this.lon = lon;
		this.date = date;
		this.description = description;
		this.etat = etat;
		this.motif = motif;
		this.province = province;
		this.image = image;
		this.pro = pro;
	}






	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIME() {
		return IME;
	}

	public void setIME(String iME) {
		IME = iME;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}






	public Professionnel getPro() {
		return pro;
	}






	public void setPro(Professionnel pro) {
		this.pro = pro;
	}


    
}