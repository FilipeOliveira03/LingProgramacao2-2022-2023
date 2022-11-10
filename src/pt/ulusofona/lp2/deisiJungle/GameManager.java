package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// numeros impares - Henrique
// numeros pares - Filipe

public class GameManager {

    ArrayList<Player> jogadores = new ArrayList<>();
    HashMap <Integer,ArrayList<Player>> tabuleiro = new HashMap<>();

    int jogadoresMinimos = 2;
    int jogadoresMaximos = 4;
    int meta;

    public boolean isNumeric(String s) {
        if (s == null || s.equals("")) {
            return false;
        }

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public String[][] getSpecies(){

        return new String[][]{ { "E", "Elefante","elephant.png" },
                { "L", "Leão","lion.png" },
                { "T", "Tartaruga","turtle.png" },
                { "P", "Pássaro","bird.png" },
                { "Z", "Tarzan","tarzan.png" } };
    }

    public boolean createInitialJungle(int jungleSize, int initialEnergy, String[][] playersInfo){

        int countNrTarzan = 0;

        boolean[] verificarEspecie = new boolean[playersInfo.length];

        for (int countPlayer1 = 0; countPlayer1 < playersInfo.length; countPlayer1++) {

            for (int countPlayer2 = 0; countPlayer2 < playersInfo.length; countPlayer2++) {

                if(countPlayer1 != countPlayer2){ // jogadores iguais

                    if(!isNumeric(playersInfo[countPlayer1][0]) || !isNumeric(playersInfo[countPlayer2][0])){
                        return false;
                    }

                    int jogador1Int = Integer.parseInt(playersInfo[countPlayer1][0]);
                    if(jogador1Int < 0){ return false; }

                    int jogador2Int = Integer.parseInt(playersInfo[countPlayer2][0]);
                    if(jogador2Int < 0){ return false; }

                    if(jogador1Int == jogador2Int){ return false; }//verifica se o id é igual
                }
            }
        }

        for (int countPlayer = 0; countPlayer < playersInfo.length; countPlayer++) {

            if(playersInfo[countPlayer][1].equals("") || playersInfo[countPlayer][1] == null){ return false; }//nome null ou vazio

            if(playersInfo[countPlayer][2].equals("Z")){ countNrTarzan++;}// so pode existir 1 tarzan

            for (int countEspecie = 0; countEspecie < getSpecies().length; countEspecie++) {

                if(playersInfo[countPlayer][2].equals(getSpecies()[countEspecie][0])){
                    // verifica se a especie é do getSpecies()

                    verificarEspecie[countPlayer] = true;
                }
            }
        }

        if(countNrTarzan > 1 || playersInfo.length * 2 > jungleSize){ return false; } // verifica se só há 1


        if(playersInfo.length < jogadoresMinimos || playersInfo.length > jogadoresMaximos) { return false; }// verifica o numero de jogadores

        for (boolean verificar : verificarEspecie) { //
            if (!verificar) { return false; }
        }

        for (int preencherHash = 0; preencherHash < jungleSize; preencherHash++) {
            ArrayList<Player> players = new ArrayList<>();
            tabuleiro.put(preencherHash, players);
        }

        meta = jungleSize;

        for (String[] info : playersInfo) {

            Player jogador = new Player();

            jogador.adicionaId(Integer.parseInt(info[0]));
            jogador.adicionaNome(info[1]);
            jogador.adicionaEspecie(info[2]);
            jogador.adicionaEnergiaAtual(initialEnergy);


            jogadores.add(jogador);
            tabuleiro.get(0).add(jogador);
        }

        return true;
    }

    public int[] getPlayerIds(int squareNr) {
        int[]arrayvazio=new int[0];
        if(squareNr > meta || squareNr < 0 || tabuleiro.get(squareNr) == null){
            return arrayvazio;
        }
       int jogadorescount=0;
        ArrayList<Integer> nr = new ArrayList<>();
        for (int i = 0; i < jogadores.size(); i++) {
            Player jogador = jogadores.get(i);
            if (jogador.posicaoAtual == squareNr) {
                nr.add(jogador.id);
                jogadorescount++;
            }

        }

        if(jogadorescount==0){
            return arrayvazio;
        }

        int[] nrarray= new int[nr.size()];
        for (int i = 0; i < nr.size(); i++) {
            nrarray[i]=nr.get(i);
        }

        return  nrarray;

    }
    public String[] getSquareInfo(int squareNr){ // falta qualquer coisa

        if(squareNr > meta || squareNr < 0 || tabuleiro.get(squareNr) == null){
            return null;
        }
        int nrJogadorAtual = 1;
        StringBuilder ids = new StringBuilder();

        String[] info = new String[3];

        ArrayList<Player> jogadores = tabuleiro.get(squareNr);;

        for (Player jogador : jogadores) {

            String especie = jogador.especie;

            switch (especie) {
                case "E" -> info[0] = "elephant.png";
                case "L" -> info[0] = "lion.png";
                case "T" -> info[0] = "turtle.png";
                case "P" -> info[0] = "bird.png";
                case "Z" -> info[0] = "tarzan.png";
            }

            String id = String.valueOf(jogador.id);

            if(nrJogadorAtual == jogadores.size()){
                ids.append(id);
            }else{
                ids.append(id).append(",");
            }

            nrJogadorAtual++;
        }

        if(squareNr == meta){
            info[1] = "Meta";
        }else {
            info[1] = "Vazio";
        }

        info[2] = ids.toString();

        return info;
    }

    public String[] getPlayerInfo(int playerId) {

        String[] info = new String[4];
        for (Player jogador : jogadores) {
            if (jogador.id == playerId) {

                info[0] = "" + jogador.id + "";
                info[1] = "" + jogador.nome + "";
                info[2] = "" + jogador.especie + "";
                info[3] = "" + jogador.energiaAtual + "";
                return info;
            }

        }
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
        return "professional wrestling";
    }

}
