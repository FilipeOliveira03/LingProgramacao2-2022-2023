package pt.ulusofona.lp2.deisiJungle.alimentos;

import pt.ulusofona.lp2.deisiJungle.especies.Especie;
import pt.ulusofona.lp2.deisiJungle.GameManager;
import pt.ulusofona.lp2.deisiJungle.jogador.Player;

public class Carne extends Alimento {

    private final int jogadaAtual = GameManager.getJogadasPassadas();

    public Carne() {
        super("Carne");
    }

    @Override
    public void acontecimentoIngerir(Player jogador) {

        Especie especie = jogador.getEspecie();
        String tipoAlimen = especie.getTipoAlimentacao();
        int energiaAtual = especie.getEnergia();

        if(!tipoAlimen.equals("Herbívoro")){

            if(jogadaAtual >= 12){

                if(tipoAlimen.equals("Carnívoro") || tipoAlimen.equals("Omnívoro")){

                    if(energiaAtual > 150){
                        especie.mudaEnergia(200);

                    }else{
                        especie.mudaEnergia(energiaAtual + 50);

                    }
                }
            }else{
                especie.mudaEnergia(energiaAtual / 2);

            }
        }
    }

    @Override
    public String toString() {

        if(jogadaAtual >= 12){
            return "Carne : +- 50 energia : " + jogadaAtual + " jogadas";
        }else{
            return "Carne toxica";
        }

    }
}
