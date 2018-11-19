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
    private String type;
    private String secteur;
    private float lat;
    private float lon;
    private String date;
    private String description;
    private String etat;
    private String motif;
    @Column(columnDefinition = "geometry")
    private String geometry;

    public Incident() {
    }

    public Incident(String IME, String type, String secteur, float lat, float lon, String date, String description, String etat, String motif, String geometry) {
        this.IME = IME;
        this.type = type;
        this.secteur = secteur;
        this.lat = lat;
        this.lon = lon;
        this.date = date;
        this.description = description;
        this.etat = etat;
        this.motif = motif;
        this.geometry = geometry;
    }

    public Long getId() {
        return id;
    }

    public String getIME() {
        return IME;
    }

    public String getType() {
        return type;
    }

    public String getSecteur() {
        return secteur;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getEtat() {
        return etat;
    }

    public String getMotif() {
        return motif;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setIME(String IME) {
        this.IME = IME;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }
}