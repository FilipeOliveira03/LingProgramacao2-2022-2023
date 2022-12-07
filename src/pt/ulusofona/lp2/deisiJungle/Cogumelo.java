package pt.ulusofona.lp2.deisiJungle;

import java.util.Random;

public class Cogumelo extends Alimento {

    private int numRandom;
    private final int jogadaAtual = GameManager.getJogadasPassadas();


    public Cogumelo() {
        super('m', "mushroom.png");
    }

    @Override
    public void acontecimentoIngerir(Player jogador) {

        Especie especie = jogador.getEspecie();
        Random random = new Random();
        int numMin = 10;
        int numMax = 50;

        float numeroRandom = random.nextInt(numMax - numMin) + numMin;
        float numeroPercentagem = numeroRandom / 100;
        numRandom = (int) numeroRandom;

        int energiaAtual = especie.energia;
        int energiaPercentagem = (int) (especie.energia * numeroPercentagem);
        int energiaFinal;

        if(jogadaAtual % 2 == 0){
            energiaFinal = energiaAtual + energiaPercentagem;

        }else{
            energiaFinal = energiaAtual - energiaPercentagem;

        }

        if(energiaFinal > 200){
            especie.energia = 200;

        }else{
            especie.energia += energiaPercentagem;

        }
    }

    @Override
    public String toString() {
        return "Cogumelo Magico: +- "+ numRandom +"% energia";
    }
}
