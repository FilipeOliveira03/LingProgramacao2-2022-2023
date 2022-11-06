package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

// numeros impares - Henrique
// numeros pares - Filipe

public class GameManager {

    int nrJogadores;
    int energia;

    GameManager(int nrJogadores){
        this.nrJogadores = nrJogadores;
    }

    public String[][] getSpecies(){

        return new String[][]{ { "E", "Elefante","elefante.png" },{ "L", "Leão","leao.png" },{ "T", "Tartaruga","tartaruga.png" },{ "P", "Pássaro","passaro.png" },{ "Z", "Tarzan","tarzan.png" }, };
    }

    public boolean createInitialJungle(int jungleSize, int initialEnergy, String[][] playersInfo){

        boolean[] verificarEspecie = new boolean[playersInfo.length];
        Arrays.fill(verificarEspecie, false);

        for (int countPlayer1 = 0; countPlayer1 < playersInfo.length; countPlayer1++) {

            for (int countPlayer2 = 0; countPlayer2 < playersInfo.length; countPlayer2++) {

                if(countPlayer1 != countPlayer2){

                    if(Objects.equals(playersInfo[countPlayer1][0], playersInfo[countPlayer2][0])){ // nao percebo o que quer dizer com a gama esperada

                        return false;
                    }
                }

                if(playersInfo[countPlayer1][2].equals(getSpecies()[countPlayer2][1])){
                    verificarEspecie[countPlayer1] = true;
                }

            }

            if(playersInfo[countPlayer1][1].equals("") || playersInfo[countPlayer1][1] == null){

                return false;
            }
        }

        for (boolean b : verificarEspecie) {
            if (!b) {
                return false;
            }
        }

        if(playersInfo.length != nrJogadores){
            return false;
        }

        if(playersInfo.length * 2 >= jungleSize){
            return false;
        }

        energia = initialEnergy;

        return true;
    }

    public int[] getPlayerIds(int squareNr){
        return null;
    }

    public String[] getSquareInfo(int squareNr){
        return null;
    }

    public String[] getPlayerInfo(int playerId) {
        return null;
    }

    public String[] getCurrentPlayerInfo(){
        return null;
    }

    public String[][] getPlayersInfo(){
        return null;
    }

    public boolean moveCurrentPlayer(int nrSquares, boolean bypassValidations){
        return true;
    }

    public String[] getWinnerInfo(){
        return null;
    }

    public ArrayList<String> getGameResults(){
        return null;
    }

    public JPanel getAuthorsPanel(){
        return null;
    }

    public String whoIsTaborda(){
        return null;
    }

}
