package com.example.english;

import java.io.Serializable;

public class IrregularVerbQuestion implements Serializable {

    private Verbe verbe;
    private String preteritAnswer = "";
    private String infinitifAnswer = "";
    private String participeAnswer = "";
    private int score = 0;

    public IrregularVerbQuestion(Verbe v)
    {
        this.verbe = v;
    }

    public Verbe getVerbe() {
        return verbe;
    }

    public String getPreteritAnswer() {
        return preteritAnswer;
    }

    public void setPreteritAnswer(String preteritAnswer) {
        this.preteritAnswer = preteritAnswer;
    }

    public String getInfinitifAnswer() {
        return infinitifAnswer;
    }

    public void setInfinitifAnswer(String infinitifAnswer) {
        this.infinitifAnswer = infinitifAnswer;
    }

    public String getParticipeAnswer() {
        return participeAnswer;
    }

    public void setParticipeAnswer(String participeAnswer) {
        this.participeAnswer = participeAnswer;
    }

    public void correct()
    {
        if(preteritAnswer.equalsIgnoreCase(verbe.getPreterit()))
        {
            score++;
        }
        if(infinitifAnswer.equalsIgnoreCase(verbe.getInfintif()))
        {
            score++;
        }
        if(participeAnswer.equalsIgnoreCase(verbe.getParticipe()))
        {
            score++;
        }
    }

    public int getScore()
    {
        return this.score;
    }

}
