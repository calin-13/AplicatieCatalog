package org.example;

public class ElevNeBursier extends Elev {
    private double medie;

    public ElevNeBursier(int id, String nume, String prenume, double medie) {
        super(id, nume, prenume);
        this.medie = medie;
    }

    @Override
    public double getMedie() {
        return medie;
    }

    public void setMedie(double medie) {
        this.medie = medie;
    }
}