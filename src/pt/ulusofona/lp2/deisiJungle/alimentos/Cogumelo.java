package pt.ulusofona.lp2.deisiJungle.alimentos;

import pt.ulusofona.lp2.deisiJungle.especies.Especie;
import pt.ulusofona.lp2.deisiJungle.GameManager;
import pt.ulusofona.lp2.deisiJungle.jogador.Player;

import java.util.Random;

public class Cogumelo extends Alimento {

    private int numRandom;
    private int jogadaAtual = GameManager.getJogadasPassadas();

    public Cogumelo() {
        this.nome = "Cogumelo Magico";
        this.idAlimento = "m";

        Random random = new Random();
        int numMin = 10;
        int numMax = 50;

        float numeroRandom = random.nextInt(numMax - numMin) + numMin;
        numRandom = (int) numeroRandom;
    }

    public int getNumRandom() {
        return numRandom;
    }

    public void setNumRandom(int numRandom) {
        this.numRandom = numRandom;
    }

    @Override
    public void acontecimentoIngerir(Player jogador) {

        jogadaAtual = GameManager.getJogadasPassadas();

        Especie especie = jogador.getEspecie();
        int energiaAtual = especie.getEnergiaAtual();

        float numeroPercentagem = numRandom / 100f;

        int energiaPercentagem = (int) (energiaAtual * numeroPercentagem);
        int energiaFinal;

        if(jogadaAtual % 2 == 0){
            energiaFinal = energiaAtual + energiaPercentagem;

        }else{
            energiaFinal = energiaAtual - energiaPercentagem;

        }

        if(energiaFinal > 200){
            especie.mudaEnergiaAtual(200);

        }else {
            especie.mudaEnergiaAtual(Math.max(energiaFinal, 0));
        }
    }

    @Override
    public String toString() {
        return "Cogumelo Magico: +- "+ numRandom +"% energia";
    }
}
