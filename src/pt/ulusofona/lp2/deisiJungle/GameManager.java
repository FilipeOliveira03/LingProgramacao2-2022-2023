package pt.ulusofona.lp2.deisiJungle;

import pt.ulusofona.lp2.deisiJungle.alimentos.*;
import pt.ulusofona.lp2.deisiJungle.alimentos.Alimento;
import pt.ulusofona.lp2.deisiJungle.especies.*;
import static pt.ulusofona.lp2.deisiJungle.MovementResultCode.*;
import pt.ulusofona.lp2.deisiJungle.jogador.Player;
import pt.ulusofona.lp2.deisiJungle.outrasFuncoes.OtherFunctions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static pt.ulusofona.lp2.deisiJungle.InitializationErrorCode.*;

public class GameManager {

    private final HashMap <Integer,ArrayList<Player>> tabuleiro = new HashMap<>();
    private final HashMap <Integer,String> tabuleiroAlimentos = new HashMap<>();
    private final ArrayList<Player> jogadores = new ArrayList<>();
    private final ArrayList<Especie> todasAsEspecies = new ArrayList<>();

    private int meta;
    private int turno = 1;
    private static int jogadasPassadas = 0;

    public static int getJogadasPassadas() {
        return jogadasPassadas;
    }

    public void mudarTurno(){
        if(turno == jogadores.size()){
            turno = 1;
        }else{
            turno++;
        }
    }

    public String[][] getSpecies(){

        return new String[][]{
                { "E", "Elefante","elephant.png", "180", "4", "10", "1..6"},
                { "L", "Leão","lion.png", "80", "2", "10", "4..6" },
                { "T", "Tartaruga", "turtle.png" , "150", "1", "5", "1..3"},
                { "P", "Pássaro","bird.png" , "70", "4", "50", "5..6"},
                { "Z", "Tarzan","tarzan.png" , "70", "2", "20", "1..6"} };
    }

    public String[][] getFoodTypes(){
        return new String[][]{
                { "e", "Erva", "grass.png"},
                { "a", "Agua", "water.png"},
                { "c", "Carne", "meat.png"},
                { "b", "Cacho de Bananas", "bananas.png"},
                { "m", "Cogumelos magicos", "mushroom.png"} };
    }

    public InitializationError createInitialJungle(int jungleSize, String[][] playersInfo, String[][] foodsInfo){

        tabuleiroAlimentos.clear();

        boolean[] verificarComida = new boolean[foodsInfo.length];

        for (int countAlimentos = 0; countAlimentos < foodsInfo.length; countAlimentos++) {

            for (int countIdAlimento = 0; countIdAlimento < getFoodTypes().length; countIdAlimento++) {

                if(foodsInfo[countAlimentos][0].equals(getFoodTypes()[countIdAlimento][0])){
                    // verifica se o id da comida é do getFoodTypes()

                    verificarComida[countAlimentos] = true;
                }
            }

            if(!OtherFunctions.isNumeric(foodsInfo[countAlimentos][1])){
                return new InitializationError(INVALID_FOOD_POSITION_NOT_NUMBER);
            }

            int posicaoComida = Integer.parseInt(foodsInfo[countAlimentos][1]);

            if( posicaoComida <= 1 || posicaoComida >= jungleSize){
                return new InitializationError(INVALID_FOOD_POSITION);
            }



        }

        for (boolean verificar : verificarComida) { // verifica se a comida existe
            if (!verificar) {  return new InitializationError(INVALID_FOOD_DOES_NOT_EXIST); }
        }

         for (int countAlimentos = 0; countAlimentos < foodsInfo.length; countAlimentos++) { //meter comida no tabuleri
             int posAlimentos = Integer.parseInt(foodsInfo[countAlimentos][1]);
             tabuleiroAlimentos.put(posAlimentos, foodsInfo[countAlimentos][0]);
         }

         return createInitialJungle(jungleSize, playersInfo);
    }

    public InitializationError createInitialJungle(int jungleSize, String[][] playersInfo){

        int countNrTarzan = 0;

        boolean[] verificarEspecie = new boolean[playersInfo.length];

        for (int countPlayer1 = 0; countPlayer1 < playersInfo.length; countPlayer1++) {

            for (int countPlayer2 = 0; countPlayer2 < playersInfo.length; countPlayer2++) {

                if(countPlayer1 != countPlayer2){ // jogadores iguais

                    if(!OtherFunctions.isNumeric(playersInfo[countPlayer1][0]) || !OtherFunctions.isNumeric(playersInfo[countPlayer2][0])){
                        return new InitializationError(INVALID_ID_WITHOUT_NUMBERS);
                    } // se são numeros

                    int jogador1Int = Integer.parseInt(playersInfo[countPlayer1][0]);
                    if(jogador1Int < 0){ return new InitializationError(INVALID_ID_WITH_NEGATIVE_NUMBERS); } // false nao podem ser negativos

                    int jogador2Int = Integer.parseInt(playersInfo[countPlayer2][0]);
                    if(jogador2Int < 0){ return new InitializationError(INVALID_ID_WITH_NEGATIVE_NUMBERS);} // false nao podem ser negativos

                    if(jogador1Int == jogador2Int){ return new InitializationError(INVALID_PLAYERS_WITH_SAME_ID); }// false //verifica se o id é igual
                }
            }
        }

        for (int countPlayer = 0; countPlayer < playersInfo.length; countPlayer++) {

            if(playersInfo[countPlayer][1] == null || playersInfo[countPlayer][1].equals("")){
                return new InitializationError(INVALID_PLAYER_NAME); } // false //nome null ou vazio

            if(playersInfo[countPlayer][2].equals("Z")){ countNrTarzan++;}// so pode existir 1 tarzan

            for (int countEspecie = 0; countEspecie < getSpecies().length; countEspecie++) {

                if(playersInfo[countPlayer][2].equals(getSpecies()[countEspecie][0])){
                    // verifica se a especie é do getSpecies()

                    verificarEspecie[countPlayer] = true;
                }
            }
        }

        if(countNrTarzan > 1 || playersInfo.length * 2 > jungleSize){
             return new InitializationError(INVALID_JUST_ONE_TARZAN); }// false  // verifica se só há 1

        int jogadoresMinimos = 2;
        int jogadoresMaximos = 4;

        if(playersInfo.length < jogadoresMinimos || playersInfo.length > jogadoresMaximos) {
            return new InitializationError(INVALID_NUMBER_OF_PLAYERS); }// false // verifica o numero de jogadores

        for (boolean verificar : verificarEspecie) { // verifica se a especie existe
            if (!verificar) {  return new InitializationError(INVALID_SPECIE_INEXISTANTE); }// false
        }

        for (int preencherHash = 1; preencherHash <= jungleSize; preencherHash++) {
            ArrayList<Player> players = new ArrayList<>();
            tabuleiro.put(preencherHash, players);
        }

        meta = jungleSize;

        for (String[] info : playersInfo) {

            Especie especie = new Especie();

            switch (info[2]){
                case "E" -> especie = new Elefante();
                case "L" -> especie = new Leao();
                case "T" -> especie = new Tartaruga();
                case "P" -> especie = new Passaro();
                case "Z" -> especie = new Tarzan();
            }

            Player jogador = new Player(Integer.parseInt(info[0]),info[1], especie);

            jogadores.add(jogador);
            tabuleiro.get(1).add(jogador);
        }

        todasAsEspecies.add(new Elefante());
        todasAsEspecies.add(new Leao());
        todasAsEspecies.add(new Tartaruga());
        todasAsEspecies.add(new Passaro());
        todasAsEspecies.add(new Tarzan());

        return null;
    }

    public int[] getPlayerIds(int squareNr) {

        jogadores.sort(Comparator.comparing(Player::getID));

        if(squareNr > meta || squareNr < 1 || tabuleiro.get(squareNr) == null ){
            return new int[0];
        }

        int nrJogadoresCasa = tabuleiro.get(squareNr).size();
        int[] arrayFinal = new int[nrJogadoresCasa];

        for (int countJogadores = 0; countJogadores < nrJogadoresCasa; countJogadores++) {
            int id = tabuleiro.get(squareNr).get(countJogadores).getID();
            arrayFinal[countJogadores] = id;
        }

        return arrayFinal;
    }

    public String[] getSquareInfo(int squareNr){ // falta qualquer coisa

        jogadores.sort(Comparator.comparing(Player::getID));

        if(squareNr > meta || squareNr < 1 || tabuleiro.get(squareNr) == null){
            return null;
        }

        int nrJogadorAtual = 1;
        StringBuilder ids = new StringBuilder();

        String[] info = new String[3];

        ArrayList<Player> jogadores = tabuleiro.get(squareNr);

        for (Player jogador : jogadores) {

            String especie = jogador.getEspecie().getNomeSigla();

            switch (especie) {
                case "E" -> info[0] = "elephant.png";
                case "L" -> info[0] = "lion.png";
                case "T" -> info[0] = "turtle.png";
                case "P" -> info[0] = "bird.png";
                case "Z" -> info[0] = "tarzan.png";
            }

            String id = String.valueOf(jogador.getID());

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

        jogadores.sort(Comparator.comparing(Player::getID));

        String[] array = new String[5];
        boolean verificar = false;

        for (Player jogador : jogadores) {

            if (playerId == jogador.getID()) {
                array[0] = String.valueOf(jogador.getID());
                array[1] = jogador.getNome();
                array[2] = jogador.getEspecie().getNomeSigla();
                array[3] = String.valueOf(jogador.getEspecie().getEnergia());
                array[4] = jogador.getEspecie().getVelocidade();
                verificar = true;
            }
        }

        if(!verificar){
            return null;
        }

        return array;
    }

    public String[] getCurrentPlayerInfo(){

        jogadores.sort(Comparator.comparing(Player::getID));

        String[] jogador = new String[4];

        int pos = turno - 1 ;

        jogador[0] = String.valueOf(jogadores.get(pos).getID());
        jogador[1] = jogadores.get(pos).getNome();
        jogador[2] = jogadores.get(pos).getEspecie().getNomeSigla();
        jogador[3] = String.valueOf(jogadores.get(pos).getEspecie().getEnergia());

        return jogador;
    }

    public String[] getCurrentPlayerEnergyInfo(int nrPositions){
        return null;
    }

    public String[][] getPlayersInfo(){

        jogadores.sort(Comparator.comparing(Player::getID));

        String[][] array = new String[jogadores.size()][4];
        int count = 0;

        for (Player jogadores : jogadores) {

            array[count][0] = String.valueOf(jogadores.getID());
            array[count][1] = jogadores.getNome();
            array[count][2] = jogadores.getEspecie().getNomeSigla();
            array[count][3] = String.valueOf(jogadores.getEspecie().getEnergia());

            count++;
        }

        return array;
    }

    public MovementResult moveCurrentPlayer(int nrSquares, boolean bypassValidations){

        if(!bypassValidations){
            if(nrSquares < -6 || nrSquares > 6){
                mudarTurno();
                return new MovementResult(INVALID_MOVEMENT);
            }
        }

        int jogadorJoga = jogadores.get(turno - 1).getID();

        int posJogadorTabuleiro = 1;
        int posJogadorCasaArray = 0;

        for (int countCasa = 1; countCasa <= tabuleiro.size(); countCasa++) {

            ArrayList<Player> array = tabuleiro.get(countCasa);

            for (int countPlayerPos = 0; countPlayerPos < array.size(); countPlayerPos++) {

                Player jogador = array.get(countPlayerPos);

                if(jogadorJoga == jogador.getID()){

                    posJogadorTabuleiro = countCasa;
                    posJogadorCasaArray = countPlayerPos;

                }
            }
        }

        Player jogador = tabuleiro.get(posJogadorTabuleiro).get(posJogadorCasaArray);



        if(jogador.getPosicaoAtual() - nrSquares < 1){
            mudarTurno();
            return new MovementResult(INVALID_MOVEMENT);
        }

        Especie especie = new Especie();

        int energiaConsumida = 0;

        for (Especie todasAsEspecy : todasAsEspecies) {
            if (todasAsEspecy.getNomeSigla().equals(jogador.getEspecie().getNomeSigla())) {

                energiaConsumida = todasAsEspecy.getConsumoEnergetico();

            }
        }

        if(jogador.getEspecie().getEnergia() - energiaConsumida < 0 ){
            mudarTurno();
            return new MovementResult(NO_ENERGY);

        }

        int posicaoAtual = jogador.getPosicaoAtual();
        String alimentoTabu = tabuleiroAlimentos.get(posicaoAtual);

        Alimento alimento;

        if(alimentoTabu == "a"){

        }

        switch(alimentoTabu){
            case "a" -> alimento = new Agua();
            case "b" -> alimento = new CachoBananas();
            case "c" -> alimento = new Carne();
            case "m" -> alimento = new Cogumelo();
            case "e" -> alimento = new Erva();
            default -> alimento = null;
        }default -> alimento = null;

        if(alimento != null){
            alimento.acontecimentoIngerir(jogador);
            mudarTurno();
            MovementResult.mudaOutPutalimento(alimentoTabu);
            jogador.adicionaAlimentosIngeridos(alimentoTabu);
            return new MovementResult(CAUGHT_FOOD);

        }

        int distanciaMeta = meta - posJogadorTabuleiro;
        int energiaAtual = jogador.getEspecie().getEnergia();

//         if(distanciaMeta < nrSquares ){
//
//             mudarTurno();
//             return new MovementResult(INVALID_MOVEMENT);
//
//         }else {
//             tabuleiro.get(posJogadorTabuleiro).remove(posJogadorCasaArray);
//
//             posJogadorTabuleiro += nrSquares;
//
//             tabuleiro.get(posJogadorTabuleiro).add(jogador);
//
//             jogador.mudaPosicaoAtual(posJogadorTabuleiro);
//
//             if(nrSquares!=0){
//                 jogador.getEspecie().mudaEnergia(energiaAtual - energiaConsumida);
//             }
//
//             tabuleiro.get(posJogadorTabuleiro).sort(Comparator.comparing(Player::getID));
//
//             mudarTurno();
//             jogadasPassadas++;
//             return new MovementResult(VALID_MOVEMENT);
//         }

        tabuleiro.get(posJogadorTabuleiro).remove(posJogadorCasaArray);

        posJogadorTabuleiro += nrSquares;

        tabuleiro.get(posJogadorTabuleiro).add(jogador);

        jogador.mudaPosicaoAtual(posJogadorTabuleiro);

        if(nrSquares != 0 ){
            jogador.getEspecie().mudaEnergia(energiaAtual - energiaConsumida);
        }else{
            int energiaDescanso = jogador.getEspecie().getGanhoEnerDescanso();
            jogador.getEspecie().mudaEnergia(energiaAtual + energiaDescanso);
        }

        tabuleiro.get(posJogadorTabuleiro).sort(Comparator.comparing(Player::getID));
        jogador.adicionaDistanciaViajada(nrSquares);

        mudarTurno();
        jogadasPassadas++;

        return new MovementResult(VALID_MOVEMENT);
    }

    public String[] getWinnerInfo() {
        int countenergia = 0;
        int jogoacabado = 0;

        for (Player jogadore : jogadores) {

            if (jogadore.getPosicaoAtual() == meta) {
                jogoacabado++;
            }

            if (jogadore.getEspecie().getEnergia() == 0) {
                countenergia++;
            }
        }

        for (int countTabuleiro = 1; countTabuleiro <= tabuleiro.size(); countTabuleiro++) {
            tabuleiro.get(countTabuleiro).sort(Comparator.comparing((Player jogador2) -> jogador2.getID()));
        }

        if(countenergia == jogadores.size()|| jogoacabado != 0) {

            Player jogadorVencedor = new Player();

            int soUm = 0;
            for (int countJogadoresReverso = tabuleiro.size(); countJogadoresReverso >= 1; countJogadoresReverso--) {

                if(soUm == 0){
                    if(!tabuleiro.get(countJogadoresReverso).isEmpty() ){
                        jogadorVencedor = tabuleiro.get(countJogadoresReverso).get(0);
                        soUm++;
                    }
                }
            }

            String[] infojogadorvencedor = new String[4];

            infojogadorvencedor[0] = String.valueOf(jogadorVencedor.getID());
            infojogadorvencedor[1] = jogadorVencedor.getNome();
            infojogadorvencedor[2] = jogadorVencedor.getEspecie().getNomeSigla();
            infojogadorvencedor[3] = String.valueOf(jogadorVencedor.getEspecie().getEnergia());

            return infojogadorvencedor;
        }else{
            return null;
        }
    }

    public ArrayList<String> getGameResults(){

        ArrayList<String> resultadoJogo= new ArrayList<>();

        int pos = 1;

        for (int countJogadores = tabuleiro.size(); countJogadores >= 1; countJogadores--) {

            ArrayList<Player> array = tabuleiro.get(countJogadores);

            if(!array.isEmpty()){

                for (Player jogador : array) {

                    String especie = "";

                    switch (jogador.getEspecie().getNomeSigla()) {
                        case "L" -> especie = "Leao";
                        case "E" -> especie = "Elefante";
                        case "T" -> especie = "Tartaruga";
                        case "P" -> especie = "Passaro";
                        case "Z" -> especie = "Tarzan";
                    }

                    resultadoJogo.add("#" + pos + " " + jogador.getNome() + ", " + especie + ", " +
                    jogador.getPosicaoAtual() + ", " + jogador.getDistanciaViajada() +  ", "
                    + jogador.getAlimentosIngeridos().size());
                    pos++;
                }
            }
        }
        return resultadoJogo;
    }

    public JPanel getAuthorsPanel() throws IOException {

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().
                getResource("/creditos.png")));
        JLabel label = new JLabel(new ImageIcon(image));
        JLabel texto = new JLabel();
        texto.setText("Developers : Henrique Franco , Filipe Oliveira");
        panel.add(texto);
        panel.add(label);

        return panel;

    }

    public String whoIsTaborda(){
        return "professional wrestling";
    }

    public boolean saveGame(File file){
        return true;
    }

    public boolean loadGame(File file){
        return true;
    }

}