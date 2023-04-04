package com.example.se_backend.model;

public class Locatie {
    private String scop;
    private long perioada;
    private String climat;
    private String zona;
    private String nrPersoane;
    private String activitati;
    private long obiectiveTuristice;
    private String cazare;
    private long buget;
    private String numeDestinatie;

    public Locatie(String scop, long perioada, String climat, String zona, String nrPersoane, String activitati, long obiectiveTuristice, String cazare, long buget, String numeDestinatie) {
        this.scop = scop;
        this.perioada = perioada;
        this.climat = climat;
        this.zona = zona;
        this.nrPersoane = nrPersoane;
        this.activitati = activitati;
        this.obiectiveTuristice = obiectiveTuristice;
        this.cazare = cazare;
        this.buget = buget;
        this.numeDestinatie = numeDestinatie;
    }

    public String getScop() {
        return scop;
    }

    public void setScop(String scop) {
        this.scop = scop;
    }

    public long getPerioada() {
        return perioada;
    }

    public void setPerioada(long perioada) {
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

    public long getobiectiveTuristice() {
        return obiectiveTuristice;
    }

    public void setobiectiveTuristice(long obiectiveTuristice) {
        this.obiectiveTuristice = obiectiveTuristice;
    }

    public String getCazare() {
        return cazare;
    }

    public void setCazare(String cazare) {
        this.cazare = cazare;
    }

    public long getBuget() {
        return buget;
    }

    public void setBuget(long buget) {
        this.buget = buget;
    }

    public String getNumeDestinatie() {
        return numeDestinatie;
    }

    public void setNumeDestinatie(String numeDestinatie) {
        this.numeDestinatie = numeDestinatie;
    }
}
