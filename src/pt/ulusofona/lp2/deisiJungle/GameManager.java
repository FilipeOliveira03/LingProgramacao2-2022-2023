package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.util.ArrayList;
// numeros impares - Henrique o maior da aldeia
// numeros pares - Filipe
public class GameManager {
    ArrayList<Players> jogadores = new ArrayList<>();
    public String[][] getSpecies(){

        return new String[][]{ { "E", "Elefante","elefante.png" },{ "L", "Leão","leao.png" },{ "T", "Tartaruga","tartaruga.png" },{ "P", "Pássaro","passaro.png" },{ "Z", "Tarzan","tarzan.png" }, };
    }

    public boolean createInitialJungle(int jungleSize, int initialEnergy, String[][] playersInfo){
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
