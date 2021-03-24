package com.example.english;

import java.io.Serializable;

public class Verbe implements Serializable {
    String infinitif;
    String preterit;
    String participe;
    String francais;

    public String getInfintif() {
        return infinitif;
    }

    public void setInfintif(String infintif) {
        this.infinitif = infintif;
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

    public Verbe(String infinitif, String preterit, String participe, String francais) {
        this.infinitif = infinitif;
        this.preterit = preterit;
        this.participe = participe;
        this.francais = francais;
    }
}
