package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ClassTest {

    @Test
    public void testAdaugaElev() {
        Clasa clasa = new Clasa(1, "Clasa 10A");
        List<Elev> elevi = new ArrayList<>();
        clasa.setElevi(elevi);

        Elev elev = new ElevNeBursier(1, "Ion", "Popescu", 8.5);
        clasa.getElevi().add(elev);

        Assertions.assertEquals(1, clasa.getElevi().size());
        Assertions.assertEquals("Ion", clasa.getElevi().get(0).getNume());
    }

    @Test
    public void testStatisticiClasa() {
        Clasa clasa = new Clasa(1, "Clasa 10A");
        List<Elev> elevi = new ArrayList<>();
        elevi.add(new ElevNeBursier(1, "Ion", "Popescu", 8.5));
        elevi.add(new ElevNeBursier(2, "Maria", "Ionescu", 9.0));
        clasa.setElevi(elevi);

        Assertions.assertEquals(2, clasa.calculeazaTotalNote());
        Assertions.assertEquals(8.75, clasa.calculeazaMediaNote(), 0.01);
    }
}