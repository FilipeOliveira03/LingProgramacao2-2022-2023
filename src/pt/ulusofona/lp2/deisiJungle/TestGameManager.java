package pt.ulusofona.lp2.deisiJungle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGameManager {
    @Test
    public void testMoveCurrentPlayer1(){
        GameManager manager = new GameManager();
        String[][] array = {
                { "11", "joao","E" },
                { "2", "Leão","L" },
                { "3", "Leão","L" },
                { "23", "Leão","L" },

        };
        manager.createInitialJungle(8, 3, array);

        String[] resultadoReal = manager.getCurrentPlayerInfo();

        String[] resultadoEsperado = { "2", "Leão", "L","3" };

        assertEquals("testMoveCurrentPlayer", resultadoEsperado, resultadoReal);
    }
    @Test
    public void testMoveCurrentPlayer2(){
        GameManager manager = new GameManager();
        String[][] array = {
                { "11", "joao","E" },
                { "2", "Leão","L" },
                { "3", "Leão","L" },
                { "23", "Leão","L" },

        };
        manager.createInitialJungle(8, 2, array);


        String[] resultadoReal = manager.getCurrentPlayerInfo();

        String[] resultadoEsperado = { "2", "Leão", "L","2" };

        assertEquals("testMoveCurrentPlayer", resultadoEsperado, resultadoReal);
    }
    @Test
    public void testMoveCurrentPlayer3(){
        GameManager manager = new GameManager();
        String[][] array = {
                { "11", "joao","E" },
                { "2", "Leão","L" },
                { "3", "Leão","L" },
                { "23", "Leão","L" },

        };
        manager.createInitialJungle(8, 6, array);


        String[] resultadoReal = manager.getCurrentPlayerInfo();

        String[] resultadoEsperado = { "2", "Leão", "L","6" };

        assertEquals("testMoveCurrentPlayer", resultadoEsperado, resultadoReal);
    }
    @Test
    public void testMoveCurrentPlayer4(){
        GameManager manager = new GameManager();
        String[][] array = {
                { "11", "joao","E" },
                { "2", "Leão","L" },
                { "3", "Leão","L" },
                { "23", "Leão","L" },

        };
        manager.createInitialJungle(8, 5, array);

        String[] resultadoReal = manager.getCurrentPlayerInfo();

        String[] resultadoEsperado = { "2", "Leão", "L","5" };

        assertEquals("testMoveCurrentPlayer", resultadoEsperado, resultadoReal);
    }
}
