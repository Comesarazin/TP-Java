package com.example.java;

public class Line extends HelloApplication {
    private String periode;
    private float total;
    private float logement;
    private float nouriture;
    private float sorties;
    private float voiture;
    private float voyage;
    private float impots;
    private float autres;

    // Constructeur par défaut
    public Line() {
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getLogement() {
        return logement;
    }

    public void setLogement(float logement) {
        this.logement = logement;
    }

    public float getNouriture() {
        return nouriture;
    }

    public void setNouriture(float nouriture) {
        this.nouriture = nouriture;
    }

    public float getSorties() {
        return sorties;
    }

    public void setSorties(float sorties) {
        this.sorties = sorties;
    }

    public float getVoiture() {
        return voiture;
    }

    public void setVoiture(float voiture) {
        this.voiture = voiture;
    }

    public float getVoyage() {
        return voyage;
    }

    public void setVoyage(float voyage) {
        this.voyage = voyage;
    }

    public float getImpots() {
        return impots;
    }

    public void setImpots(float impots) {
        this.impots = impots;
    }

    public float getAutres() {
        return autres;
    }

    public void setAutres(float autres) {
        this.autres = autres;
    }
}