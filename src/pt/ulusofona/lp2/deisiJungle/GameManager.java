package pt.ulusofona.lp2.deisiJungle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

// numeros impares - Henrique
// numeros pares - Filipe

public class GameManager {

    HashMap <Integer,ArrayList<Player>> tabuleiro = new HashMap<>();
    ArrayList<Player> jogadores = new ArrayList<>();

    int jogadoresMinimos = 2;
    int jogadoresMaximos = 4;
    int meta;
    int turno = 1;
// creditos


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

            if(playersInfo[countPlayer][1] == null || playersInfo[countPlayer][1].equals("")){ return false; }//nome null ou vazio

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

        for (int preencherHash = 1; preencherHash <= jungleSize; preencherHash++) {
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
            tabuleiro.get(1).add(jogador);
        }

        return true;
    }

    public int[] getPlayerIds(int squareNr) {

        if(squareNr > meta || squareNr < 1 || tabuleiro.get(squareNr) == null ){
            return new int[0];
        }

        int nrJogadoresCasa = tabuleiro.get(squareNr).size();
        int[] arrayFinal = new int[nrJogadoresCasa];

        for (int countJogadores = 0; countJogadores < nrJogadoresCasa; countJogadores++) {
            int id = tabuleiro.get(squareNr).get(countJogadores).id;
            arrayFinal[countJogadores] = id;
        }

        return arrayFinal;
    }

    public String[] getSquareInfo(int squareNr){ // falta qualquer coisa

        if(squareNr > meta || squareNr < 1 || tabuleiro.get(squareNr) == null){
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

        String[] array = new String[4];
        boolean verificar = false;

        for (Player jogador : jogadores) {

            if (playerId == jogador.id) {
                array[0] = String.valueOf(jogador.id);
                array[1] = jogador.nome;
                array[2] = jogador.especie;
                array[3] = String.valueOf(jogador.energiaAtual);
                verificar = true;
            }
        }

        if(!verificar){
            return null;
        }

        return array;
    }

    public String[] getCurrentPlayerInfo(){

        String[] jogador = new String[4];

        int pos = turno - 1 ;

        jogador[0] = String.valueOf(jogadores.get(pos).id);
        jogador[1] = jogadores.get(pos).nome;
        jogador[2] = jogadores.get(pos).especie;
        jogador[3] = String.valueOf(jogadores.get(pos).energiaAtual);

        return jogador;
    }

    public String[][] getPlayersInfo(){

        jogadores.sort(Comparator.comparing((Player jogador) -> jogador.id));

        String[][] array = new String[jogadores.size()][4];
        int count = 0;
        int posPodio = 1;

        for (Player jogadores : jogadores) {

            array[count][0] = String.valueOf(jogadores.id);
            array[count][1] = jogadores.nome;
            array[count][2] = jogadores.especie;
            array[count][3] = String.valueOf(jogadores.energiaAtual);

            jogadores.mudaPosicaoPodio(posPodio);

            count++;
        }

        return array;
    }

    public boolean moveCurrentPlayer(int nrSquares, boolean bypassValidations){

        if(!bypassValidations){
            if(nrSquares < 1 || nrSquares > 6){
                return false;
            }
        }

        int jogadorJoga = jogadores.get(turno - 1).id;

        int posJogadorTabuleiro = 1;
        int posJogadorCasaArray = 0;

        for (int countCasa = 1; countCasa <= tabuleiro.size(); countCasa++) {

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

        if(jogador.energiaAtual < 2){

            if(turno == jogadores.size()){
                turno = 1;
            }else{
                turno++;
            }

            return false;
        }

        int distanciaMeta = meta - posJogadorTabuleiro;

        tabuleiro.get(posJogadorTabuleiro).remove(posJogadorCasaArray);

        if(distanciaMeta > nrSquares){
            posJogadorTabuleiro += nrSquares;
        } else {
            posJogadorTabuleiro = meta;
        }

        tabuleiro.get(posJogadorTabuleiro).add(jogador);
        jogador.mudaPosicaoAtual(posJogadorTabuleiro);
        jogador.energiaAtual -= 2;

        int jogadorPodio = jogador.posicaoPodio;

        for (int countPodio = 0; countPodio < jogadores.size(); countPodio++) {

            if(jogadorPodio < jogadores.get(countPodio).posicaoPodio){

                int posAtual = jogadorPodio;

                jogadorPodio = jogadores.get(countPodio).posicaoPodio;
                jogadores.get(countPodio).posicaoPodio = posAtual;

            }
        }

        if(turno == jogadores.size()){
            turno = 1;
        }else{
            turno++;
        }

        return true;
    }

    public String[] getWinnerInfo(){
        ArrayList<Player> jogadoresPorOrdem= jogadores;
        jogadoresPorOrdem.sort(Comparator.comparing((Player jogador) -> jogador.posicaoAtual).reversed());

        String[] infojogadorvencedor= new String[4];
        infojogadorvencedor[0] = String.valueOf(jogadoresPorOrdem.get(0).id);
        infojogadorvencedor[1] = jogadoresPorOrdem.get(0).nome;
        infojogadorvencedor[2] = jogadoresPorOrdem.get(0).especie;
        infojogadorvencedor[3] = String.valueOf(jogadoresPorOrdem.get(0).energiaAtual);
        return infojogadorvencedor;
    }

    public ArrayList<String> getGameResults(){

        ArrayList<Player> jogadoresPorOrdem = jogadores;
        ArrayList<String> resultadoJogo= new ArrayList<>();

        jogadoresPorOrdem.sort(Comparator.comparing((Player jogador) -> jogador.posicaoPodio));

        for (int countJogadores = 1 ; countJogadores <= jogadoresPorOrdem.size() ; countJogadores++) {

            String especie = "";

            switch(jogadoresPorOrdem.get(countJogadores - 1).especie){
                case "L" -> especie = "Leão";
                case "E" -> especie = "Elefante";
                case "T" -> especie = "Tartaruga";
                case "P" -> especie = "Pássaro";
                case "Z" -> especie = "Tarzan";
            }

            Player jogador = jogadoresPorOrdem.get(countJogadores - 1);

            resultadoJogo.add("#" + countJogadores + " " + jogador.nome + ", " + especie + ", " + jogador.posicaoAtual);
        }

        return resultadoJogo;
    }

    public JPanel getAuthorsPanel() throws IOException {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        BufferedImage image = ImageIO.read(new File("deisi-jungle/src/creditos.png"));
        JLabel label = new JLabel(new ImageIcon(image));
        panel.add(label);

        return panel;

    }

    public String whoIsTaborda(){
        return "professional wrestling";
    }

}
