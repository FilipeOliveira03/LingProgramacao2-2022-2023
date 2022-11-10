package pt.ulusofona.lp2.deisiJungle;
import org.junit.Test;

import java.util.ArrayList;

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
        String[] info = manager.getSquareInfo(0);

        String resultadoReal = info[1];
        String resultadoEsperado = "Vazio";

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
        p1.posicaoAtual= 1;
        int [] a = new int[1];
        a[0]=p1.id;
        int [] resultadoReal = manager.getPlayerIds(90);


        System.out.println("epserado"+a[0]+"");
        System.out.println("real"+resultadoReal[0]+"");



    }





}
