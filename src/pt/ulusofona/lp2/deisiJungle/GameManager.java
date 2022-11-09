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

    public String[][] getSpecies(){

        return new String[][]{ { "E", "Elefante","elefante.png" },{ "L", "Leão","leao.png" },{ "T", "Tartaruga","tartaruga.png" },{ "P", "Pássaro","passaro.png" },{ "Z", "Tarzan","tarzan.png" }, };
    }

    public boolean createInitialJungle(int jungleSize, int initialEnergy, String[][] playersInfo){

        int countNrTarzan = 0;

        boolean[] verificarEspecie = new boolean[playersInfo.length];
        Arrays.fill(verificarEspecie, false);

        for (int countPlayer1 = 0; countPlayer1 < playersInfo.length; countPlayer1++) {

            for (int countPlayer2 = 0; countPlayer2 < playersInfo.length; countPlayer2++) {

                if(countPlayer1 != countPlayer2){ // jogadores iguais

                    if(playersInfo[countPlayer1][0].equals(playersInfo[countPlayer2][0])){ //verifica se o id é igual
                        return false;
                    }
                }
            }
        }

        for (int countPlayer = 0; countPlayer < playersInfo.length; countPlayer++) {

            if(playersInfo[countPlayer][1].equals("") || playersInfo[countPlayer][1] == null){ //nome null ou vazio
                return false;
            }

            if(playersInfo[countPlayer][2].equals("Z")){ // so pode existir 1 tarzan
                countNrTarzan++;
            }

            for (int countEspecie = 0; countEspecie < playersInfo[countPlayer].length; countEspecie++) {

                if(playersInfo[countPlayer][2].equals(getSpecies()[countEspecie][0])){
                    // verifica se a especie é do getSpecies()
                    verificarEspecie[countPlayer] = true;
                }
            }
        }

        if(countNrTarzan > 1){ // verifica se só há 1
            return false;
        }

        if(playersInfo.length < jogadoresMinimos && playersInfo.length > jogadoresMaximos) {// verifica o numero de jogadores
            return false;
        }

        if(playersInfo.length * 2 < jungleSize){ // verifica o mapa
            return false;
        }

        for (boolean verificar : verificarEspecie) { //
            if (!verificar) {
                return false;
            }
        }

        for (int preencherHash = 0; preencherHash < jungleSize; preencherHash++) {
            ArrayList<Player> players = new ArrayList<>();
            tabuleiro.put(preencherHash, players);
        }

        meta = jungleSize;

        for (String[] info : playersInfo) {

            Player jogador = new Player();

            int id = Integer.parseInt(info[0]);
            String nome = info[1];
            String especie = info[2];

            jogador.adicionaId(id);
            jogador.adicionaNome(nome);
            jogador.adicionaEspecie(especie);
            jogador.adicionaEnergiaAtual(initialEnergy);


            jogadores.add(jogador);
            tabuleiro.get(0).add(jogador);
        }

        return true;
    }

    public int[] getPlayerIds(int squareNr) {

        int[] nr = new int[6];
        for (Player jogador : jogadores) {
            if (jogador.posicaoAtual == squareNr) {
                int a = 0;
                nr[a] = jogador.id;
            }

        }
        return nr;
    }
    public String[] getSquareInfo(int squareNr){
        return null;
    }

    public String[] getPlayerInfo(int playerId) {

            String[] info = new String[4];
            for (Player jogador : jogadores) {
                if (jogador.id == playerId) {

                    info[0] = "" + jogador.id + "";
                    info[1] = "" + jogador.nome + "";
                    info[2] = "" + jogador.especie + "";
                    info[3] = "" + jogador.energiaAtual + "";
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
        return "professional wrestling";
    }

}
