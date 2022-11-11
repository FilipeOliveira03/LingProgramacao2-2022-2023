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
                { "11", null,"E" },
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

        Player a = manager.tabuleiro.get(0).get(1);

        manager.tabuleiro.get(0).remove(1);

        manager.tabuleiro.get(3).add(a);

        String resultadoReal = manager.getSquareInfo(0)[2];

        String resultadoEsperado = "";

        assertEquals("testGetSquareInfo", resultadoEsperado, resultadoReal);
    }
    @Test
    public void TestGetPlayerIds(){
        String[][] array = {
                { "1", "crp","Z" },
                { "2", "Leão","P" },
                { "3", "Leão","P" },

        };

        GameManager manager = new GameManager();
        manager.createInitialJungle(8, 6, array);

        int [] resultadoReal = manager.getPlayerIds(0);
        System.out.println(resultadoReal[0]);
        System.out.println(resultadoReal[1]);
        System.out.println(resultadoReal[2]);

        int [] resultadoEsperado = new int[]{1,2,3,4};

        assertEquals("TestGetPlayerIds", resultadoEsperado, resultadoReal);

    }





}
