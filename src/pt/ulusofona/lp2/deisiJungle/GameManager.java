package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

// numeros impares - Henrique
// numeros pares - Filipe

public class GameManager {
    ArrayList<Players> jogadores = new ArrayList<>();

    public String[][] getSpecies(){

        return new String[][]{ { "E", "Elefante","elefante.png" },{ "L", "Leão","leao.png" },{ "T", "Tartaruga","tartaruga.png" },{ "P", "Pássaro","passaro.png" },{ "Z", "Tarzan","tarzan.png" }, };
    }

    public boolean createInitialJungle(int jungleSize, int initialEnergy, String[][] playersInfo){


        int countNrTarzan = 0;
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

            if(playersInfo[countPlayer1][2].equals("Z")){
                countNrTarzan++;
            }

        }

        if(countNrTarzan < 1){
            return false;
        }

        if(playersInfo.length * 2 >= jungleSize){
            return false;
        }

        for (boolean verificar : verificarEspecie) {
            if (!verificar) {
                return false;
            }
        }

        return true;
    }

    public int[] getPlayerIds(int squareNr) {

        int[] nr = new int[6];
        for (Players jogadore : jogadores) {
            if (jogadore.posicao == squareNr) {
                int a = 0;
                nr[a] = jogadore.id;
            }

        }
        return nr;
    }
    public String[] getSquareInfo(int squareNr){
        return null;
    }

    public String[] getPlayerInfo(int playerId) {

            String[] info = new String[4];
            for (Players jogadore : jogadores) {
                if (jogadore.id == playerId) {

                    info[0] = "" + jogadore.id + "";
                    info[1] = "" + jogadore.nome + "";
                    info[2] = "" + jogadore.especie + "";
                    info[3] = "" + jogadore.energia + "";
                }

            }
            return info;
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
