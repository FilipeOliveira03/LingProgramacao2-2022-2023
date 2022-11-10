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
                { "11", "Elefante","E" },
                { "2", "Leão","L" },
                { "334", "Tartaruga","P" },
                { "44", "Pássaro","T" }
        };

        boolean resultadoReal = manager.createInitialJungle(8, 6, array);
        System.out.println(manager.jogadores.get(0).id);
        System.out.println(manager.jogadores.get(1).id);
        System.out.println(manager.jogadores.get(2).id);
        System.out.println(manager.jogadores.get(3).id);
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
