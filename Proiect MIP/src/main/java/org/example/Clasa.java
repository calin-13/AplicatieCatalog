package org.example;

public class Clasa {
    private int id;
    private String nume;
    private List<Elev> elevi;

    public Clasa(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public List<Elev> getElevi() {
        return elevi;
    }

    public void setElevi(List<Elev> elevi) {
        this.elevi = elevi;
    }

    public int calculeazaTotalNote() {
        if (elevi == null || elevi.isEmpty()) {
            return 0;
        }
        return elevi.size(); // Assuming each elev has one note for simplicity
    }

    public double calculeazaMediaNote() {
        if (elevi == null || elevi.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (Elev elev : elevi) {
            total += elev.getMedie(); // Assuming `getMedie` exists in `Elev`
        }
        return total / elevi.size();
    }
}