package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ElevTest {

    @Test
    public void testElevNeBursier() {
        ElevNeBursier elev = new ElevNeBursier(1, "Ion", "Popescu", 8.5);

        Assertions.assertEquals("Ion", elev.getNume());
        Assertions.assertEquals("Popescu", elev.getPrenume());
        Assertions.assertEquals(8.5, elev.getMedie());
    }

    @Test
    public void testElevBursier() {
        ElevBursier elev = new ElevBursier(2, "Maria", "Ionescu", 9.0, 300.0);

        Assertions.assertEquals("Maria", elev.getNume());
        Assertions.assertEquals(300.0, elev.getBursa());
        Assertions.assertEquals(9.0, elev.getMedie());
    }
}