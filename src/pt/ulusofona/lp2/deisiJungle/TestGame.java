package pt.ulusofona.lp2.deisiJungle;
import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.alimentos.*;
import pt.ulusofona.lp2.deisiJungle.especies.Tarzan;
import pt.ulusofona.lp2.deisiJungle.jogador.Player;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static pt.ulusofona.lp2.deisiJungle.InitializationErrorCode.INVALID_FOOD_POSITION_NOT_NUMBER;
import static pt.ulusofona.lp2.deisiJungle.MovementResultCode.*;

public class TestGame {

    @Test
    public void testCreateJungle1() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", "abc", "E"},
                {"2", "Leão", "L"},
        };

        String[][] arrayFood = {
                {"e", "h"},
                {"e", "3"},
        };

        InitializationError resultadoReal = manager.createInitialJungle(8, arrayPlayers, arrayFood);
        InitializationError resultadoEsperado = new InitializationError(INVALID_FOOD_POSITION_NOT_NUMBER);

        assertEquals("testCreateJungle1", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMoveCurrentPlayer1() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", "abc", "E"},
                {"22", "Leão", "L"},
        };

        String[][] arrayFood = {
                {"a", "4"},

                {"a", "2"},
                {"a", "5"},
                {"a", "6"},
                {"a", "7"},
                {"a", "8"},
                {"a", "9"},
        };

        manager.createInitialJungle(10, arrayPlayers, arrayFood);
        MovementResult resultadoReal = manager.moveCurrentPlayer(2, false);
        MovementResult resultadoEsperado = new MovementResult(VALID_MOVEMENT);

        assertEquals("testMoveCurrentPlayer1", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMoveCurrentPlayer2() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", "abc", "T"},
                {"2", "Leão", "P"},
        };

        manager.createInitialJungle(10, arrayPlayers);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);

        MovementResult resultadoReal = manager.moveCurrentPlayer(-2, false);
        MovementResult resultadoEsperado = new MovementResult(VALID_MOVEMENT);

        assertEquals("testMoveCurrentPlayer2", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMoveCurrentPlayer3() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", "abc", "P"},
                {"22", "Leão", "T"},
        };

        String[][] arrayFood = {
                {"a", "4"},
                {"a", "3"},
                {"a", "2"},
                {"a", "5"},
                {"a", "6"},
                {"a", "7"},
                {"a", "8"},
                {"a", "9"},
        };

        manager.createInitialJungle(40, arrayPlayers);
        manager.moveCurrentPlayer(10, true);
        manager.moveCurrentPlayer(10, true);
        MovementResult resultadoReal = manager.moveCurrentPlayer(0, true);
        MovementResult resultadoEsperado = new MovementResult(VALID_MOVEMENT);

        assertEquals("testMoveCurrentPlayer3", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMoveCurrentPlayer4() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", "abc", "P"},
                {"22", "Leão", "P"},
        };

        String[][] arrayFood = {
                {"a", "4"},
                {"a", "3"},
                {"a", "2"},
                {"a", "5"},
                {"a", "6"},
                {"a", "7"},
                {"a", "8"},
                {"a", "9"},
        };


        manager.createInitialJungle(10, arrayPlayers);

        MovementResult resultadoReal = manager.moveCurrentPlayer(6, false);
        MovementResult resultadoEsperado = new MovementResult(VALID_MOVEMENT);

        assertEquals("testMoveCurrentPlayer4", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testGetCurrentPlayerEnergyInfo1() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", "abc", "T"},
                {"22", "Leão", "L"},
        };

        String[] arrayEnergia = {"1", "5"};

        manager.createInitialJungle(10, arrayPlayers);
        manager.moveCurrentPlayer(1, false);
        manager.getCurrentPlayerEnergyInfo(1);
        String[] resultadoReal = manager.getCurrentPlayerEnergyInfo(1);
        String[] resultadoEsperado = arrayEnergia;

        assertEquals("testGetCurrentPlayerEnergyInfo1", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testGetCurrentPlayerEnergyInfo2() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", "abc", "T"},
                {"2", "Leão", "E"},
        };

        String[] arrayEnergia = {"4", "10"};

        manager.createInitialJungle(40, arrayPlayers);

        String[] resultadoReal = manager.getCurrentPlayerEnergyInfo(1);
        String[] resultadoEsperado = arrayEnergia;

        assertEquals("testGetCurrentPlayerEnergyInfo2", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testGetCurrentPlayerEnergyInfo3() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", "abc", "T"},
                {"22", "cba", "E"},
        };


        String[] arrayEnergiaT = {"1", "5"};
        String[] arrayEnergiaE = {"4", "10"};

        manager.createInitialJungle(40, arrayPlayers);
        manager.moveCurrentPlayer(2, false);
        manager.moveCurrentPlayer(2, false);
        manager.moveCurrentPlayer(2, false);


        String[] resultadoReal = manager.getCurrentPlayerEnergyInfo(1);
        String[] resultadoEsperado = arrayEnergiaE;

        assertEquals("testGetCurrentPlayerEnergyInfo3", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testWater() {

        Player jogador = new Player(213, "SAD", new Tarzan());
        jogador.getEspecie().mudaEnergiaAtual(78);

        Alimento agua = new Agua();
        agua.acontecimentoIngerir(jogador);
    }

    @Test
    public void testCugas() {

        Player jogador = new Player(213, "SAD", new Tarzan());
        jogador.getEspecie().mudaEnergiaAtual(78);

        Alimento cugas = new Cogumelo();
        cugas.acontecimentoIngerir(jogador);
    }

    @Test
    public void testCarne() {

        GameManager manager = new GameManager();

        String[][] arrayPlayers = {
                {"11", "abc", "T"},
                {"2", "Leão", "P"},
        };

        manager.createInitialJungle(30, arrayPlayers);
        manager.moveCurrentPlayer(1, false);
        manager.moveCurrentPlayer(-1, false);
        manager.moveCurrentPlayer(1, false);
        manager.moveCurrentPlayer(-1, false);
        manager.moveCurrentPlayer(1, false);
        manager.moveCurrentPlayer(-1, false);
        manager.moveCurrentPlayer(1, false);
        manager.moveCurrentPlayer(-1, false);
        manager.moveCurrentPlayer(1, false);
        manager.moveCurrentPlayer(-1, false);
        manager.moveCurrentPlayer(1, false);
        manager.moveCurrentPlayer(-1, false);

        Player jogador = new Player(213, "SAD", new Tarzan());
        jogador.getEspecie().mudaEnergiaAtual(78);

        Alimento carne = new Carne();
        carne.acontecimentoIngerir(jogador);
    }

    @Test
    public void testTooltipalimentosSquareinfo() {

        GameManager manager = new GameManager();

        String[][] arrayPlayers = {
                {"11", "abc", "T"},
                {"2", "Leão", "P"},
        };
         String[][] arrayalimentos = {
                {"b","2"},
                {"b","3"},
        };

        CachoBananas bananas= new CachoBananas();
        Player jogador = new Player(213, "SAD", new Tarzan());
        manager.createInitialJungle(40, arrayPlayers,arrayalimentos);
        bananas.acontecimentoIngerir(jogador);
        manager.moveCurrentPlayer(1,false);
        manager.getSquareInfo(2);



    }


    @Test
    public void testPlayerStayWithFoodInPos() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", "abc", "T"},
                {"22", "cba", "E"},
        };

        String[][] arrayAlimentos = {
                {"e","2"},
                {"b","3"},
        };

        manager.createInitialJungle(40, arrayPlayers, arrayAlimentos);
        manager.moveCurrentPlayer(2, false);
        manager.moveCurrentPlayer(2, false);
        MovementResult resultadoReal = manager.moveCurrentPlayer(0, false);
        MovementResult resultadoEsperado = new MovementResult(CAUGHT_FOOD);

        assertEquals("testPlayerStayWithFoodInPos", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMovePlayerNoEnergy() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", "abc", "P"},
                {"22", "cba", "E"},
        };

        String[][] arrayAlimentos = {
                {"e","2"},
                {"b","3"},
        };

        manager.createInitialJungle(40, arrayPlayers, arrayAlimentos);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);
        manager.moveCurrentPlayer(6, false);
        MovementResult resultadoReal = manager.moveCurrentPlayer(0, false);
    MovementResult resultadoEsperado = new MovementResult(NO_ENERGY);

        assertEquals("testPlayerStayWithFoodInPos", resultadoEsperado, resultadoReal);
    }
}
