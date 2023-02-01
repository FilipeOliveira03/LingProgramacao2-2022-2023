package pt.ulusofona.lp2.deisiJungle;
import org.junit.Test;
import pt.ulusofona.lp2.deisiJungle.alimentos.*;
import pt.ulusofona.lp2.deisiJungle.especies.Tarzan;
import pt.ulusofona.lp2.deisiJungle.jogador.Player;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static pt.ulusofona.lp2.deisiJungle.InitializationErrorCode.*;
import static pt.ulusofona.lp2.deisiJungle.MovementResultCode.*;

public class TestGame {

    @Test
    public void testCreateJungle1() throws InvalidInitialJungleException {
        try {
            GameManager manager = new GameManager();
            String[][] arrayPlayers = {
                    {"11", "abc", "E"},
                    {"2", "Leão", "L"},
            };

            String[][] arrayFood = {
                    {"e", "h"},
                    {"e", "3"},
            };
            manager.createInitialJungle(8, arrayPlayers, arrayFood);
            fail("Deveria ter lançado uma exception");
        } catch (Exception ex) {
            assertEquals("A posição da comida não é um número", ex.getMessage());
        }
    }


    @Test
    public void testMoveCurrentPlayer1() throws InvalidInitialJungleException {
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
    public void testMoveCurrentPlayer2() throws InvalidInitialJungleException {
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
    public void testMoveCurrentPlayer3() throws InvalidInitialJungleException {
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
    public void testMoveCurrentPlayer4() throws InvalidInitialJungleException {
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
    public void testGetCurrentPlayerEnergyInfo1() throws InvalidInitialJungleException {
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
    public void testGetCurrentPlayerEnergyInfo2() throws InvalidInitialJungleException {
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
    public void testGetCurrentPlayerEnergyInfo3() throws InvalidInitialJungleException {
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
    public void testCarne() throws InvalidInitialJungleException {

        GameManager manager = new GameManager();

        String[][] arrayPlayers = {
                {"11", "abc", "T"},
                {"2", "Leão", "P"},
        };

        String[][] arrayalimentos = {
                {"c","2"},
        };

        manager.createInitialJungle(30, arrayPlayers, arrayalimentos);
        manager.moveCurrentPlayer(1, false);
        MovementResult resultadoReal = manager.moveCurrentPlayer(1, false);
        MovementResult resultadoEsperado = new MovementResult(CAUGHT_FOOD);

        assertEquals("testPlayerStayWithFoodInPos", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testTooltipalimentosSquareinfo() throws InvalidInitialJungleException {

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
    public void testPlayerStayWithFoodInPos() throws InvalidInitialJungleException {
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
    public void testMovePlayerNoEnergy() throws InvalidInitialJungleException {
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
    public void testMoveBehindStart() throws InvalidInitialJungleException {
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
        manager.moveCurrentPlayer(0, true);
        manager.moveCurrentPlayer(0, true);
        manager.moveCurrentPlayer(20, true);
        manager.moveCurrentPlayer(20, true);
        manager.moveCurrentPlayer(0, true);
        manager.moveCurrentPlayer(0, true);
        manager.moveCurrentPlayer(0, true);
        manager.moveCurrentPlayer(0, true);
        manager.moveCurrentPlayer(23, true);
        MovementResult resultadoReal = manager.moveCurrentPlayer(23, true);
        MovementResult resultadoEsperado = new MovementResult(VALID_MOVEMENT);

        assertEquals("testPlayerStayWithFoodInPos", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMovePlayersBeyondVelo() throws InvalidInitialJungleException {
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
    public void testMovePlayersBeyondVeloNeg() throws InvalidInitialJungleException {
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
        try{
            GameManager manager = new GameManager();
            String[][] arrayPlayers = {
                    {"11", "abc", "P"},
                    {"22", "cba", "E"},
            };

            String[][] arrayAlimentos = {
                    {"e","1"},
                    {"b","3"},
            };

            manager.createInitialJungle(40, arrayPlayers, arrayAlimentos);
           fail("Deveria ter lançado uma exception");
        } catch (Exception ex) {
            assertEquals("A posição da comida é inválida", ex.getMessage());
        }

    }

    @Test
    public void testInitialJungleNumbersInID() {
        try{
            GameManager manager = new GameManager();
            String[][] arrayPlayers = {
                    {"11a", "1", "P"},
                    {"22w", "cba11", "E"},
            };

            manager.createInitialJungle(40, arrayPlayers);
            fail("Deveria ter lançado uma exception");
        } catch (Exception ex) {
            assertEquals("O id de um dos utilizadores não têm números", ex.getMessage());
        }
    }

    @Test
    public void testInitialJunglePlayerWithInvName() {
        try{
            GameManager manager = new GameManager();
            String[][] arrayPlayers = {
                    {"11", null, "P"},
                    {"22", "cba11", "E"},
            };

            manager.createInitialJungle(40, arrayPlayers);
            fail("Deveria ter lançado uma exception");
        } catch (Exception ex) {
            assertEquals("Um dos utilizadores têm um nome inválido", ex.getMessage());
        }
    }

    @Test
    public void testInitialJungleOnlyOneTarzan() {
        try{
            GameManager manager = new GameManager();
            String[][] arrayPlayers = {
                    {"11","cobra", "Z"},
                    {"22", "cba11", "Z"},
            };

            manager.createInitialJungle(40, arrayPlayers);
            fail("Deveria ter lançado uma exception");
        } catch (Exception ex) {
            assertEquals("Existe mais do que um tarzan", ex.getMessage());
        }
    }

    @Test
    public void testInitialJungleNumPlayersInval() {
        try{
            GameManager manager = new GameManager();
            String[][] arrayPlayers = {
                    {"11","cobra", "T"},
                    {"222", "cba11", "Z"},
                    {"223", "cba11", "E"},
                    {"224", "cba11", "P"},
                    {"225", "cba11", "T"},
            };

            manager.createInitialJungle(40, arrayPlayers);
            fail("Deveria ter lançado uma exception");
        } catch (Exception ex) {
            assertEquals("O número de jogadores em jogo é inválido", ex.getMessage());
        }
    }


    @Test
    public void testInitialJungleVal() throws InvalidInitialJungleException {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11","cobra", "T"},
                {"222", "cba11", "Z"},
                {"223", "cba11", "E"},
                {"224", "cba11", "E"},
        };



        manager.createInitialJungle(40, arrayPlayers);
    }

    @Test
    public void testPlayersIDs() throws InvalidInitialJungleException {
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
        manager.getCurrentPlayerEnergyInfo(4);
        manager.getCurrentPlayerEnergyInfo(-4);
        manager.getPlayersInfo();
        manager.getWinnerInfo();
        manager.getGameResults();

        MovementResult resultadoReal = manager.moveCurrentPlayer(2, false);
        MovementResult resultadoEsperado = new MovementResult(INVALID_MOVEMENT);

        assertEquals("testPlayersIDs", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMoveCurrentPlayerError() throws InvalidInitialJungleException {
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

        assertEquals("testMoveCurrentPlayerError", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMoveCurrentPlayerRest() throws InvalidInitialJungleException {
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

        assertEquals("testMoveCurrentPlayerRest", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testTaborda() {
        GameManager manager = new GameManager();

        String resultadoReal = manager.whoIsTaborda();
        String resultadoEsperado = "professional wrestling";

        assertEquals("testTaborda", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMove() throws InvalidInitialJungleException {
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

        manager.moveCurrentPlayer(3, false);
        manager.moveCurrentPlayer(0, false);

        MovementResult resultadoReal = manager.moveCurrentPlayer(-4, false);
        MovementResult resultadoEsperado = new MovementResult(VALID_MOVEMENT);

        assertEquals("testMove", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testBananas() throws InvalidInitialJungleException {

        GameManager manager = new GameManager();

        String[][] arrayPlayers = {
                {"11", "abc", "T"},
                {"2", "Leão", "T"},
        };

        String[][] arrayalimentos = {
                {"b","2"},
        };

        manager.createInitialJungle(30, arrayPlayers, arrayalimentos);
        manager.moveCurrentPlayer(1, false);
        manager.moveCurrentPlayer(1, false);
        manager.moveCurrentPlayer(-1, false);
        manager.moveCurrentPlayer(-1, false);
        MovementResult resultadoReal = manager.moveCurrentPlayer(1, false);
        MovementResult resultadoEsperado = new MovementResult(CAUGHT_FOOD);

        assertEquals("testPlayerStayWithFoodInPos", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testCugas() throws InvalidInitialJungleException {

        GameManager manager = new GameManager();

        String[][] arrayPlayers = {
                {"11", "abc", "T"},
                {"22", "Leão", "Z"},
        };

        String[][] arrayalimentos = {
                {"m","2"},
        };

        manager.createInitialJungle(10, arrayPlayers, arrayalimentos);
        manager.moveCurrentPlayer(1, false);
        MovementResult resultadoReal = manager.moveCurrentPlayer(1, false);
        MovementResult resultadoEsperado = new MovementResult(CAUGHT_FOOD);

        assertEquals("testPlayerStayWithFoodInPos", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testWinner() throws InvalidInitialJungleException {

        GameManager manager = new GameManager();

        String[][] arrayPlayers = {
                {"11", "abc", "T"},
                {"22", "Leão", "Z"},
        };



        manager.createInitialJungle(10, arrayPlayers);
        manager.moveCurrentPlayer(7, true);
        manager.getWinnerInfo();

    }

    @Test
    public void testSave() throws InvalidInitialJungleException {

        GameManager manager = new GameManager();

        String[][] arrayPlayers = {
                {"11", "abc", "T"},
                {"22", "Leão", "Z"},
        };

        String[][] arrayalimentos = {
                {"m","2"},
                {"m","7"},
                {"a","3"},
                {"b","5"},
                {"b","6"},
        };

        manager.createInitialJungle(40, arrayPlayers, arrayalimentos);
        manager.moveCurrentPlayer(1, true);
        manager.moveCurrentPlayer(1, true);
        manager.moveCurrentPlayer(1, true);
        manager.moveCurrentPlayer(1, true);
        manager.moveCurrentPlayer(2, true);
        manager.moveCurrentPlayer(2, true);
        manager.moveCurrentPlayer(6, true);
        manager.moveCurrentPlayer(7, true);
        manager.saveGame(new File("C:/Users/filip/IdeaProjects/ProjetoLP2/write.txt"));
        manager.loadGame(new File("C:/Users/filip/IdeaProjects/ProjetoLP2/write.txt"));
    }

    @Test
    public void testMovePlayer() throws InvalidInitialJungleException {
        GameManager manager = new GameManager();
        String[][] arrayPlayers = {
                {"11", "abc", "P"},
                {"22", "cba", "E"},
        };

        String[][] arrayAlimentos = {
                {"b","2"},

        };

        manager.createInitialJungle(40, arrayPlayers);
        MovementResult resultadoReal = manager.moveCurrentPlayer(-7, false);
        MovementResult resultadoEsperado = new MovementResult(INVALID_MOVEMENT);

        assertEquals("testPlayerStayWithFoodInPos", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testSaveAndMove() throws InvalidInitialJungleException {

        GameManager manager = new GameManager();

        String[][] arrayPlayers = {
                {"11", "abc", "T"},
                {"22", "Leão", "Z"},
        };

        String[][] arrayalimentos = {
                {"m","2"},
                {"m","7"},
                {"a","3"},
                {"b","5"},
                {"b","6"},
        };

        manager.createInitialJungle(40, arrayPlayers, arrayalimentos);
        manager.getSquareInfo(2);

    }

    @Test
    public void testMoveCurrentPlayerErva() throws InvalidInitialJungleException {

        GameManager manager = new GameManager();

        String[][] arrayPlayers = {
                {"11", "abc", "L"},
                {"22", "Leão", "L"},
        };

        String[][] arrayalimentos = {
                {"e","6"},
        };

        manager.createInitialJungle(10, arrayPlayers, arrayalimentos);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(-5, false);
        manager.moveCurrentPlayer(-5, false);
        manager.moveCurrentPlayer(0, false);
        manager.moveCurrentPlayer(0, false);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(-5, false);
        manager.moveCurrentPlayer(-5, false);
        MovementResult resultadoReal = manager.moveCurrentPlayer(5, false);
        MovementResult resultadoEsperado = new MovementResult(CAUGHT_FOOD);

        assertEquals("testMoveCurrentPlayer5", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMoveCurrentPlayerCogumelo() throws InvalidInitialJungleException {

        GameManager manager = new GameManager();

        String[][] arrayPlayers = {
                {"11", "abc", "L"},
                {"22", "Leão", "U"},
        };

        String[][] arrayalimentos = {
                {"b","6"},
                {"b","11"},
                {"b","16"},
        };

        manager.createInitialJungle(20, arrayPlayers, arrayalimentos);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(0, false);
        manager.moveCurrentPlayer(0, false);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(5, false);
        manager.moveCurrentPlayer(-5, false);
        manager.moveCurrentPlayer(-5, false);
        MovementResult resultadoReal = manager.moveCurrentPlayer(5, false);
        MovementResult resultadoEsperado = new MovementResult(NO_ENERGY);

        assertEquals("testMoveCurrentPlayer5", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testMoveCurrentPlayerCarne() throws InvalidInitialJungleException {

        GameManager manager = new GameManager();

        String[][] arrayPlayers = {
                {"11", "abc", "L"},
                {"22", "Leão", "L"},
        };

        String[][] arrayalimentos = {
                {"c","6"},
                {"c","11"},
                {"c","16"},
                {"c","21"},
        };

        manager.createInitialJungle(30, arrayPlayers, arrayalimentos);
        manager.moveCurrentPlayer(5, true);
        manager.moveCurrentPlayer(5, true);
        manager.moveCurrentPlayer(5, true);
        manager.moveCurrentPlayer(5, true);
        manager.moveCurrentPlayer(5, true);
        manager.moveCurrentPlayer(5, true);
        manager.moveCurrentPlayer(5, true);
        MovementResult resultadoReal = manager.moveCurrentPlayer(5, true);
        MovementResult resultadoEsperado = new MovementResult(CAUGHT_FOOD);

        assertEquals("testMoveCurrentPlayer5", resultadoEsperado, resultadoReal);
    }

    @Test
    public void testWinner1Novo() throws InvalidInitialJungleException {

        GameManager manager = new GameManager();

        String[][] arrayPlayers = {
                {"12", "abc", "P"},
                {"15", "Leão", "P"},
                {"33", "Dumbo", "E"}
        };

        String[][] arrayalimentos = {
                {"b","2"},
                {"c","5"},
                {"c","3"},
                {"c","4"},
        };

        manager.createInitialJungle(11, arrayPlayers, arrayalimentos);
        manager.moveCurrentPlayer(5, false);//1
        manager.moveCurrentPlayer(5, false);//2
        manager.moveCurrentPlayer(5, false);//3
        manager.moveCurrentPlayer(1, false);//1
        manager.moveCurrentPlayer(1, false);//2
        manager.moveCurrentPlayer(3, false);//3

        var b = manager.getWinnerInfo();
        var a = manager.getGameResults();
        System.out.println(Arrays.toString(b));
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }

    }
    @Test
    public void testWinner2Meta() throws InvalidInitialJungleException {

        GameManager manager = new GameManager();

        String[][] arrayPlayers = {
                {"11", "abc", "E"},
                {"22", "Leão", "U"},
                {"33", "Dumbo", "E"}


        };

        String[][] arrayalimentos = {
                {"c","6"},
                {"c","11"},
                {"c","16"},
                {"c","18"},
        };

        manager.createInitialJungle(20, arrayPlayers, arrayalimentos);
        manager.moveCurrentPlayer(5, true);//1
        manager.moveCurrentPlayer(19, true);//2
        manager.moveCurrentPlayer(6, true);//3
        manager.moveCurrentPlayer(0, true);//1
        manager.moveCurrentPlayer(0, true);//2
        manager.moveCurrentPlayer(0, true);//3
        System.out.println(manager.getMeta());
        var b = manager.getWinnerInfo();
        var a = manager.getGameResults();
        System.out.println(Arrays.toString(b));
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }

    }
    @Test
    public void testWinnerCapote() throws InvalidInitialJungleException {

        GameManager manager = new GameManager();

        String[][] arrayPlayers = {
                {"11", "abc", "E"},
                {"22", "Leão", "U"},
                {"33", "Dumbo", "E"}


        };

        String[][] arrayalimentos = {
                {"c","6"},
                {"c","11"},
                {"c","16"},
                {"c","18"},
        };

        manager.createInitialJungle(20, arrayPlayers, arrayalimentos);
        manager.moveCurrentPlayer(5, true);//1
        manager.moveCurrentPlayer(18, true);//2
        manager.moveCurrentPlayer(6, true);//3
        manager.moveCurrentPlayer(0, true);//1
        manager.moveCurrentPlayer(0, true);//2
        manager.moveCurrentPlayer(0, true);//3

        var b = manager.getWinnerInfo();
        var a = manager.getGameResults();
        System.out.println(Arrays.toString(b));
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }

    }

    @Test
    public void test() throws InvalidInitialJungleException {

        GameManager manager = new GameManager();

        String[][] arrayPlayers = {
                {"11", "abc", "E"},
                {"22", "Leão", "L"},
                {"33", "cba", "Z"},
        };

        String[][] arrayalimentos = {
                {"c","6"},
                {"c","11"},
                {"c","16"},
                {"c","21"},
        };

        manager.createInitialJungle(30, arrayPlayers);
        manager.moveCurrentPlayer(8, true);
        manager.moveCurrentPlayer(2, true);
        manager.moveCurrentPlayer(-10, true);
        manager.getCurrentPlayerInfo();


    }
}
