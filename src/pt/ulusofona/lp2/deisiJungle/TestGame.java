package pt.ulusofona.lp2.deisiJungle;
import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.alimentos.*;
import pt.ulusofona.lp2.deisiJungle.especies.Tarzan;
import pt.ulusofona.lp2.deisiJungle.jogador.Player;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static pt.ulusofona.lp2.deisiJungle.InitializationErrorCode.*;
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
        MovementResult resultadoEsperado = new MovementResult(INVALID_MOVEMENT);

        assertEquals("testMoveCurrentPlayer2", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMoveCurrentPlayer3() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", "abc", "P"},
                {"22", "Leão", "T"},
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

        String[] arrayEnergia = {"2", "10"};

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

        String[] resultadoReal = manager.getCurrentPlayerEnergyInfo(-1);
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
        MovementResult resultadoReal = manager.moveCurrentPlayer(6, false);
        MovementResult resultadoEsperado = new MovementResult(NO_ENERGY);

        assertEquals("testPlayerStayWithFoodInPos", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMoveBehindStart() {
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
        MovementResult resultadoReal = manager.moveCurrentPlayer(41, true);
        MovementResult resultadoEsperado = new MovementResult(INVALID_MOVEMENT);

        assertEquals("testPlayerStayWithFoodInPos", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMovePlayersBeyondVelo() {
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


        MovementResult resultadoReal = manager.moveCurrentPlayer(7, false);
        MovementResult resultadoEsperado = new MovementResult(INVALID_MOVEMENT);

        assertEquals("testPlayerStayWithFoodInPos", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMovePlayersBeyondVeloNeg() {
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
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(5, false);

        MovementResult resultadoReal = manager.moveCurrentPlayer(-7, false);
        MovementResult resultadoEsperado = new MovementResult(INVALID_MOVEMENT);

        assertEquals("testPlayerStayWithFoodInPos", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testInitialJungleInvalidFoodPos() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", "abc", "P"},
                {"22", "cba", "E"},
        };

        String[][] arrayAlimentos = {
                {"e","1"},
                {"b","3"},
        };

        InitializationError resultadoReal = manager.createInitialJungle(40, arrayPlayers, arrayAlimentos);
        InitializationError resultadoEsperado = new InitializationError(INVALID_FOOD_POSITION);

        assertEquals("testInitialJungleInvalidFoodPos", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testInitialJungleNumbersInID() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11a", "1", "P"},
                {"22w", "cba11", "E"},
        };


        InitializationError resultadoReal = manager.createInitialJungle(40, arrayPlayers);
        InitializationError resultadoEsperado = new InitializationError(INVALID_ID_WITHOUT_NUMBERS);

        assertEquals("testInitialJungleNumbersInID", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testInitialJunglePlayerWithInvName() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", null, "P"},
                {"22", "cba11", "E"},
        };


        InitializationError resultadoReal = manager.createInitialJungle(40, arrayPlayers);
        InitializationError resultadoEsperado = new InitializationError(INVALID_PLAYER_NAME);

        assertEquals("testInitialJunglePlayerWithInvName", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testInitialJungleOnlyOneTarzan() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11","cobra", "Z"},
                {"22", "cba11", "Z"},
        };


        InitializationError resultadoReal = manager.createInitialJungle(40, arrayPlayers);
        InitializationError resultadoEsperado = new InitializationError(INVALID_JUST_ONE_TARZAN);

        assertEquals("testInitialJungleOnlyOneTarzan", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testInitialJungleNumPlayersInval() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11","cobra", "T"},
                {"222", "cba11", "Z"},
                {"223", "cba11", "E"},
                {"224", "cba11", "P"},
                {"225", "cba11", "T"},
        };


        InitializationError resultadoReal = manager.createInitialJungle(40, arrayPlayers);
        InitializationError resultadoEsperado = new InitializationError(INVALID_NUMBER_OF_PLAYERS);

        assertEquals("testInitialJungleNumPlayersInval", resultadoEsperado, resultadoReal);
    }


    @Test
    public void testInitialJungleVal() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11","cobra", "T"},
                {"222", "cba11", "Z"},
                {"223", "cba11", "E"},
                {"224", "cba11", "E"},
        };



        InitializationError resultadoReal = manager.createInitialJungle(40, arrayPlayers);
        InitializationError resultadoEsperado = null;

        assertEquals("testInitialJungleNumPlayersInval", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testPlayersIDs() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11","cobra", "L"},
                {"222", "cba311", "Z"},
                {"223", "cba411", "E"},
                {"224", "cba511", "P"},
        };

        String[][] arrayAlimentos = {
                {"e","6"},
                {"b","3"},
                {"a","4"},
                {"c","5"},
                {"m","7"},
        };

        manager.createInitialJungle(10, arrayPlayers, arrayAlimentos);
        manager.getPlayerIds(40);
        manager.getPlayerIds(1);
        manager.getSquareInfo(40);
        manager.getSquareInfo(10);
        manager.getSquareInfo(6);
        manager.getSquareInfo(3);
        manager.getSquareInfo(4);
        manager.getSquareInfo(5);
        manager.getSquareInfo(7);
        manager.getSquareInfo(1);
        manager.getPlayerInfo(11);
        manager.getPlayerInfo(0);
        manager.getCurrentPlayerInfo();

        MovementResult resultadoReal = manager.moveCurrentPlayer(2, false);
        MovementResult resultadoEsperado = new MovementResult(INVALID_MOVEMENT);

        assertEquals("testInitialJungleNumPlayersInval", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMoveCurrentPlayerError() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11","cobra", "T"},
                {"222", "cba11", "Z"},
                {"223", "cba11", "E"},
                {"224", "cba11", "E"},
        };
        manager.createInitialJungle(40, arrayPlayers);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(5, false);

        MovementResult resultadoReal = manager.moveCurrentPlayer(-5, false);
        MovementResult resultadoEsperado = new MovementResult(VALID_MOVEMENT);

        assertEquals("testInitialJungleVal", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMoveCurrentPlayerRest() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11","cobra", "E"},
                {"222", "cba11", "E"},
        };

        String[][] arrayAlimentos = {
                {"e","6"},
                {"b","3"},
                {"a","4"},
                {"c","5"},
                {"m","7"},
        };


        manager.createInitialJungle(40, arrayPlayers, arrayAlimentos);

        manager.moveCurrentPlayer(2, false);
        manager.moveCurrentPlayer(3, false);
        manager.moveCurrentPlayer(0, false);
        manager.moveCurrentPlayer(0, false);

        manager.moveCurrentPlayer(1, false);
        manager.moveCurrentPlayer(1, false);
        manager.moveCurrentPlayer(0, false);
        manager.moveCurrentPlayer(0, false);

        manager.moveCurrentPlayer(1, false);
        manager.moveCurrentPlayer(1, false);
        manager.moveCurrentPlayer(1, false);
        manager.moveCurrentPlayer(1, false);
        manager.moveCurrentPlayer(0, false);


        MovementResult resultadoReal = manager.moveCurrentPlayer(0, false);
        MovementResult resultadoEsperado = new MovementResult(CAUGHT_FOOD);

        assertEquals("testInitialJungleVal", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testTaborda() {
        GameManager manager = new GameManager();

        String resultadoReal = manager.whoIsTaborda();
        String resultadoEsperado = "professional wrestling";

        assertEquals("testInitialJungleVal", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMove() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11","cobra", "E"},
                {"222", "cba11", "E"},
        };

        String[][] arrayAlimentos = {
                {"e","6"},
                {"b","3"},
                {"a","4"},
                {"c","5"},
                {"m","7"},
        };


        manager.createInitialJungle(40, arrayPlayers, arrayAlimentos);

        manager.moveCurrentPlayer(0, false);

        MovementResult resultadoReal = manager.moveCurrentPlayer(39, true);
        MovementResult resultadoEsperado = new MovementResult(VALID_MOVEMENT);

        assertEquals("testInitialJungleVal", resultadoEsperado, resultadoReal);
    }

}
