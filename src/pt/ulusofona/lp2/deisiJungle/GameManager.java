package pt.ulusofona.lp2.deisiJungle;

import javax.swing.*;
import java.util.*;

// numeros impares - Henrique
// numeros pares - Filipe

public class GameManager {

    HashMap <Integer,ArrayList<Player>> tabuleiro = new HashMap<>();
    ArrayList<Player> jogadores = new ArrayList<>();

    int jogadoresMinimos = 2;
    int jogadoresMaximos = 4;
    int meta;
    int turno = 0;

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

       // jogadores.sort(Comparator.comparing((Player jogador) -> jogador.id));
        return true;
    }

    public int[] getPlayerIds(int squareNr) {
        if(squareNr > meta || squareNr < 0 || tabuleiro.get(squareNr) == null){
            return new int[0];
        }
        int countjogadores=0;
        int[] returnArray= new int[jogadores.size()];
        int count=0;
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).posicaoAtual == squareNr) {
                returnArray[count] = jogadores.get(i).id;
                count++;
                countjogadores++;
            }
        }
        if(countjogadores==0){
            return new int[0];
        }
        return  returnArray;
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
            info[0] = "finish.png";
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

    public ArrayList<String> ordemParaJogar(){

        return null;
    }

    public boolean moveCurrentPlayer(int nrSquares, boolean bypassValidations){

        if(!bypassValidations){
            if(nrSquares < 1 || nrSquares > 6){
                return false;
            }
        }

        int jogadorJoga = jogadores.get(turno).id;
        int posJogadorTabuleiro = 0;
        int posJogadorCasaArray = 0;

        for (int countCasa = 0; countCasa < tabuleiro.size(); countCasa++) {

            ArrayList<Player> array = tabuleiro.get(countCasa);

            for (int countPlayerPos = 0; countPlayerPos < array.size(); countPlayerPos++) {

                Player jogador = array.get(countPlayerPos);

                if(jogadorJoga == jogador.id){

                    posJogadorTabuleiro = countCasa;
                    posJogadorCasaArray = countPlayerPos;

                }
            }
        }

        Player jogador = tabuleiro.get(posJogadorTabuleiro).get(posJogadorCasaArray);

        tabuleiro.get(posJogadorTabuleiro).remove(posJogadorCasaArray);

        posJogadorTabuleiro += nrSquares;

        tabuleiro.get(posJogadorTabuleiro).add(jogador);

        if(turno == jogadores.size() - 1){
            turno = 0;
        }else{
            turno++;
        }

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
