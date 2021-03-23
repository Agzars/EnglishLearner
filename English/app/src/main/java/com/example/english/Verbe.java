package com.example.english;

public class Verbe {
    String infintif;
    String preterit;
    String participe;
    String francais;

    public String getInfintif() {
        return infintif;
    }

    public void setInfintif(String infintif) {
        this.infintif = infintif;
    }

    public String getPreterit() {
        return preterit;
    }

    public void setPreterit(String preterit) {
        this.preterit = preterit;
    }

    public String getParticipe() {
        return participe;
    }

    public void setParticipe(String participe) {
        this.participe = participe;
    }

    public String getFrancais() {
        return francais;
    }

    public void setFrancais(String francais) {
        this.francais = francais;
    }

    public Verbe(String infintif, String preterit, String participe, String francais) {
        this.infintif = infintif;
        this.preterit = preterit;
        this.participe = participe;
        this.francais = francais;
    }
}
