package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class StatisticiTest {

    @Test
    public void testCalculeazaTotalNote() {
        Clasa clasa = new Clasa(1, "Clasa 10A");
        List<Elev> elevi = new ArrayList<>();
        elevi.add(new ElevNeBursier(1, "Ion", "Popescu", 8.5));
        elevi.add(new ElevNeBursier(2, "Maria", "Ionescu", 9.0));
        clasa.setElevi(elevi);

        int totalNote = clasa.calculeazaTotalNote();
        Assertions.assertEquals(2, totalNote);
    }

    @Test
    public void testCalculeazaMediaNote() {
        Clasa clasa = new Clasa(1, "Clasa 10A");
        List<Elev> elevi = new ArrayList<>();
        elevi.add(new ElevNeBursier(1, "Ion", "Popescu", 8.5));
        elevi.add(new ElevNeBursier(2, "Maria", "Ionescu", 9.0));
        clasa.setElevi(elevi);

        double mediaNote = clasa.calculeazaMediaNote();
        Assertions.assertEquals(8.75, mediaNote, 0.01);
    }
}