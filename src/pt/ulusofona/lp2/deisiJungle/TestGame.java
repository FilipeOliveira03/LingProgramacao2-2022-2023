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
        };

        manager.createInitialJungle(8, 6, array);
        String[] resultadoReal = manager.getSquareInfo(0);

        String[] resultadoEsperado = {"bird.png", "Vazio", "1,2"};

        assertEquals("testGetSquareInfo", resultadoEsperado, resultadoReal);
    }
    @Test
    public void TestGetPlayerIds(){
        String[][] array = {
                { "1", "crp","Z" },
                { "2", "Leão","P" },
        };
        GameManager manager = new GameManager();
        manager.createInitialJungle(8, 6, array);
        Player p1 = new Player();
        p1.id= 1;
        p1.posicaoAtual= 0;
        int [] a = new int[1];
        a[0]=p1.id;
        int [] resultadoReal = manager.getPlayerIds(0);


        System.out.println("epserado"+a[0]+"");
        System.out.println("real"+ Arrays.toString(resultadoReal) +"");



    }





}
