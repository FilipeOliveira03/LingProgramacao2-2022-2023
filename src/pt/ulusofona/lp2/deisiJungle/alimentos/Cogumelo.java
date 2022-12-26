package pt.ulusofona.lp2.deisiJungle.alimentos;

import pt.ulusofona.lp2.deisiJungle.especies.Especie;
import pt.ulusofona.lp2.deisiJungle.GameManager;
import pt.ulusofona.lp2.deisiJungle.jogador.Player;

import java.util.Random;

public class Cogumelo extends Alimento {

    private int numRandom;
    private final int jogadaAtual = GameManager.getJogadasPassadas();


    public Cogumelo() {
        this.nome = "Cogumelo Magico";
        this.idAlimento = "m";
    }

    @Override
    public void acontecimentoIngerir(Player jogador) {

        Especie especie = jogador.getEspecie();
        int energiaAtual = especie.getEnergiaAtual();

        Random random = new Random();
        int numMin = 10;
        int numMax = 50;

        float numeroRandom = random.nextInt(numMax - numMin) + numMin;
        float numeroPercentagem = numeroRandom / 100;
        numRandom = (int) numeroRandom;

        int energiaPercentagem = (int) (energiaAtual * numeroPercentagem);
        int energiaFinal;

        if(jogadaAtual % 2 == 0){
            energiaFinal = energiaAtual + energiaPercentagem;

        }else{
            energiaFinal = energiaAtual - energiaPercentagem;

        }

        if(energiaFinal > 200){
            especie.mudaEnergiaAtual(200);
        }else if(energiaFinal < 0){
            especie.mudaEnergiaAtual(0);
        }else{
            especie.mudaEnergiaAtual( energiaFinal);

        }
    }

    @Override
    public String toString() {
        return "Cogumelo Magico: +- "+ numRandom +"% energia";
    }
}
