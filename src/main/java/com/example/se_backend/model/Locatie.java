package com.example.se_backend.model;

public class Locatie {
    private String taraOrigine;
    private String scop;
    private int perioada;
    private String climat;
    private String zona;
    private String nrPersoane;
    private String activitati;
    private int obiectiveTursitice;
    private String cazare;
    private int buget;
    private String numeDestinatie;

    public Locatie(String taraOrigine, String scop, int perioada, String climat, String zona, String nrPersoane, String activitati, int obiectiveTursitice, String cazare, int buget, String numeDestinatie) {
        this.taraOrigine = taraOrigine;
        this.scop = scop;
        this.perioada = perioada;
        this.climat = climat;
        this.zona = zona;
        this.nrPersoane = nrPersoane;
        this.activitati = activitati;
        this.obiectiveTursitice = obiectiveTursitice;
        this.cazare = cazare;
        this.buget = buget;
        this.numeDestinatie = numeDestinatie;
    }

    public String getTaraOrigine() {
        return taraOrigine;
    }

    public void setTaraOrigine(String taraOrigine) {
        this.taraOrigine = taraOrigine;
    }

    public String getScop() {
        return scop;
    }

    public void setScop(String scop) {
        this.scop = scop;
    }

    public int getPerioada() {
        return perioada;
    }

    public void setPerioada(int perioada) {
        this.perioada = perioada;
    }

    public String getClimat() {
        return climat;
    }

    public void setClimat(String climat) {
        this.climat = climat;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getNrPersoane() {
        return nrPersoane;
    }

    public void setNrPersoane(String nrPersoane) {
        this.nrPersoane = nrPersoane;
    }

    public String getActivitati() {
        return activitati;
    }

    public void setActivitati(String activitati) {
        this.activitati = activitati;
    }

    public int getObiectiveTursitice() {
        return obiectiveTursitice;
    }

    public void setObiectiveTursitice(int obiectiveTursitice) {
        this.obiectiveTursitice = obiectiveTursitice;
    }

    public String getCazare() {
        return cazare;
    }

    public void setCazare(String cazare) {
        this.cazare = cazare;
    }

    public int getBuget() {
        return buget;
    }

    public void setBuget(int buget) {
        this.buget = buget;
    }

    public String getNumeDestinatie() {
        return numeDestinatie;
    }

    public void setNumeDestinatie(String numeDestinatie) {
        this.numeDestinatie = numeDestinatie;
    }
}
