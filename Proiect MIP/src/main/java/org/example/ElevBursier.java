package org.example;

public class ElevBursier extends Elev {
    private double medie;
    private double bursa;

    public ElevBursier(int id, String nume, String prenume, double medie, double bursa) {
        super(id, nume, prenume);
        this.medie = medie;
        this.bursa = bursa;
    }

    @Override
    public double getMedie() {
        return medie;
    }

    public double getBursa() {
        return bursa;
    }

    public void setBursa(double bursa) {
        this.bursa = bursa;
    }

    public void setMedie(double medie) {
        this.medie = medie;
    }
}