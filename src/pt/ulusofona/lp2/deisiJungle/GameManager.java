package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

// numeros impares - Henrique
// numeros pares - Filipe

public class GameManager {

    public String[][] getSpecies(){

        return new String[][]{ { "E", "Elefante","elefante.png" },{ "L", "Leão","leao.png" },{ "T", "Tartaruga","tartaruga.png" },{ "P", "Pássaro","passaro.png" },{ "Z", "Tarzan","tarzan.png" }, };
    }

    public boolean createInitialJungle(int jungleSize, int initialEnergy, String[][] playersInfo){

        for (int countPlayer = 0; countPlayer < playersInfo.length; countPlayer++) {

            for (int countIDs = 0; countIDs < playersInfo.length; countIDs++) {

                if(countPlayer != countIDs){

                    if(Objects.equals(playersInfo[countPlayer][0], playersInfo[countIDs][0])){ // nao percebo o que quer dizer com a gama esperada

                        return false;

                    }
                }


            }

        }

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
