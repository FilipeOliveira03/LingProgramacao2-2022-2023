package pt.ulusofona.lp2.deisiJungle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGame {

    @Test
    public void testCreateJungle(){
        GameManager manager = new GameManager();
        String[][] array = {
                { "1", "Elefante","E" },
                { "2", "Leão","L" },
                { "3", "Tartaruga","P" },
                { "4", "Pássaro","T" }
        };

        boolean resultadoReal = manager.createInitialJungle(8, 6, array);
        boolean resultadoEsperado = true;

        assertEquals("testCreateJungle", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testCreateJungleIds(){
        GameManager manager = new GameManager();
        String[][] array = {
                { "-2", "crp","Z" },
                { "2", "Leão","P" },
                { "3", "Leão","Z" },

        };

        boolean resultadoReal = manager.createInitialJungle(8, 6, array);
        boolean resultadoEsperado = false;

        assertEquals("testCreateJungleIDS", resultadoEsperado, resultadoReal);
    }


}
