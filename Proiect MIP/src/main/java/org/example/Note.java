package org.example;

public class Note {
    private int id;
    private int idElev;
    private int idMaterie;
    private double nota;

    public Note(int id, int idElev, int idMaterie, double nota) {
        this.id = id;
        this.idElev = idElev;
        this.idMaterie = idMaterie;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public int getIdElev() {
        return idElev;
    }

    public int getIdMaterie() {
        return idMaterie;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}