package org.example;

public abstract class Elev {
    protected int id;
    protected String nume;
    protected String prenume;

    public Elev(int id, String nume, String prenume) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public abstract double getMedie();
}