package pt.ulusofona.lp2.deisiJungle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        manager.createInitialJungle(8, 10, array);
        manager.moveCurrentPlayer(2,false);
        manager.moveCurrentPlayer(4,false);
        manager.moveCurrentPlayer(5,false);
        boolean resultadoReal = manager.moveCurrentPlayer(5,false);
        boolean resultadoEsperado = true;


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
        manager.createInitialJungle(8, 6, array);

        manager.moveCurrentPlayer(2,false);
        manager.moveCurrentPlayer(4,false);
        manager.moveCurrentPlayer(5,false);
        manager.moveCurrentPlayer(2,false);

        String[] resultadoReal = manager.getCurrentPlayerInfo();

        String[] resultadoEsperado = { "2", "Leão", "L","4" };

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

        manager.moveCurrentPlayer(2,false);
        manager.moveCurrentPlayer(4,false);
        manager.moveCurrentPlayer(5,false);
        manager.moveCurrentPlayer(2,false);
        manager.moveCurrentPlayer(2,false);
        manager.moveCurrentPlayer(4,false);
        manager.moveCurrentPlayer(5,false);
        manager.moveCurrentPlayer(2,false);

        String[] resultadoReal = manager.getCurrentPlayerInfo();

        String[] resultadoEsperado = { "2", "Leão", "L","2" };

        assertEquals("testMoveCurrentPlayer", resultadoEsperado, resultadoReal);
    }
    @Test
    public void testMoveCurrentPlayer4(){
        GameManager manager = new GameManager();
        String[][] array = {
                { "11", "joao","E" },
                { "2", "Leão","L" },
                { "3", "Leão","L" },

        };
        manager.createInitialJungle(8, 5, array);

        manager.moveCurrentPlayer(2,false);
        manager.moveCurrentPlayer(4,false);
        manager.moveCurrentPlayer(5,false);
        manager.moveCurrentPlayer(2,false);
        manager.moveCurrentPlayer(2,false);
        manager.moveCurrentPlayer(4,false);
        manager.moveCurrentPlayer(5,false);
        manager.moveCurrentPlayer(2,false);

        boolean resultadoReal = manager.moveCurrentPlayer(2,false);

        boolean resultadoEsperado = false;

        assertEquals("testMoveCurrentPlayer", resultadoEsperado, resultadoReal);
    }
}
