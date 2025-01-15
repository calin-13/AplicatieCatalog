package org.example;

public class Materie {
    private int id;
    private String nume;

    public Materie(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Materie{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                '}';
    }
}