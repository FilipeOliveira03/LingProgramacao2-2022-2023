package pt.ulusofona.lp2.deisiJungle;
import org.junit.Test;

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

        assertEquals("testCreateJungle", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMoveCurrentPlayer1() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", "abc", "E"},
                {"2", "Leão", "L"},
        };

        String[][] arrayFood = {
                {"e", "4"},
                {"e", "3"},
        };

        manager.createInitialJungle(10, arrayPlayers, arrayFood);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(6, false);
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

        assertEquals("testMoveCurrentPlayer1", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMoveCurrentPlayer3() {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", "abc", "E"},
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

        manager.createInitialJungle(10, arrayPlayers, arrayFood);
        MovementResult resultadoReal = manager.moveCurrentPlayer(6, false);
        MovementResult resultadoEsperado = new MovementResult(VALID_MOVEMENT);

        assertEquals("testMoveCurrentPlayer1", resultadoEsperado, resultadoReal);
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


        String[] resultadoReal = manager.getCurrentPlayerEnergyInfo(4);
        String[] resultadoEsperado = arrayEnergia;

        assertEquals("testMoveCurrentPlayer1", resultadoEsperado, resultadoReal);
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

        assertEquals("testMoveCurrentPlayer1", resultadoEsperado, resultadoReal);
    }

}
