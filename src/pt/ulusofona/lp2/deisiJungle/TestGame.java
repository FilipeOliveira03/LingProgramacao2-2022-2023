package pt.ulusofona.lp2.deisiJungle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestGame {

    @Test
    public void testCreateJungle(){
        GameManager manager = new GameManager();
        String[][] array = {
                { "11", "abc","E" },
                { "2", "Leão","L" },

        };

        boolean resultadoReal = manager.createInitialJungle(8, 6, array);
        boolean resultadoEsperado = true;

        assertEquals("testCreateJungle", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testCreateJungleIds(){
        GameManager manager = new GameManager();
        String[][] array = {
                { "1", "crp","Z" },
                { "2", "Leão","P" },
                { "3", "Leão","Z" },

        };

        boolean resultadoReal = manager.createInitialJungle(8, 6, array);
        boolean resultadoEsperado = false;

        assertEquals("testCreateJungleIDS", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testGetSquareInfo(){
        GameManager manager = new GameManager();
        String[][] array = {
                { "1", "crp","Z" },
                { "2", "Leão","P" },
                { "3", "Leã","P" },
                { "4", "Leã","P" },
        };

        manager.createInitialJungle(8, 6, array);

        Player a = manager.tabuleiro.get(1).get(1);

        manager.tabuleiro.get(1).remove(1);

        manager.tabuleiro.get(3).add(a);

        String resultadoReal = manager.getSquareInfo(1)[2];

        String resultadoEsperado = "1,3,4";

        assertEquals("testGetSquareInfo", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testgetPlayerInfo(){
        GameManager manager = new GameManager();
        String[][] array = {
                { "11", "joao","E" },
                { "2", "Leão","L" },
                { "3", "Leão","L" },
                { "23", "Leão","L" },

        };
        manager.createInitialJungle(8, 6, array);
        String[] resultadoReal = manager.getPlayerInfo(23);

        String[] resultadoEsperado = new String[]{"23", "Leão", "L", "6"};
        assertEquals("testgetPlayersInfo", resultadoEsperado, resultadoReal);

    }

    @Test
    public void testgetPlayersInfo(){
        GameManager manager = new GameManager();
        String[][] array = {
                { "1", "joao","E" },
                { "2", "Leão","L" },
                { "3", "Leão","L" },
                { "23", "Leão","L" },
        };

        manager.createInitialJungle(8, 6, array);
        ;

        String[][] resultadoReal = manager.getPlayersInfo();

        String[][] resultadoEsperado = {
                { "1", "joao","E" , "6"},
                { "2", "Leão","L" , "6"},
                { "3", "Leão","L" , "6"},
                { "23", "Leão","L", "6" },

        };

        assertEquals("testgetPlayersInfo2", resultadoEsperado, resultadoReal);
    }



    @Test
    public void testgetGameResults(){
        GameManager manager = new GameManager();
        String[][] array = {
                { "2", "a","E" },
                { "3", "c","E" },
                { "11", "b","E" },
                { "12", "d","E" },

        };
        manager.createInitialJungle(8, 8, array);


        boolean resultadoReal = manager.moveCurrentPlayer(10, true);;

        boolean resultadoEsperado = false;


        assertEquals("testMoveCurrentPlayer", resultadoEsperado, resultadoReal);
    }




}
