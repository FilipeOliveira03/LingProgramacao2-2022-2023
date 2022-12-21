package pt.ulusofona.lp2.deisiJungle.alimentos;

import pt.ulusofona.lp2.deisiJungle.especies.Especie;
import pt.ulusofona.lp2.deisiJungle.GameManager;
import pt.ulusofona.lp2.deisiJungle.jogador.Player;

public class Carne extends Alimento {

    private final int jogadaAtual = GameManager.getJogadasPassadas();

    public Carne() {
        this.nome = "Carne";
        this.idAlimento = "c";
    }

    @Override
    public void acontecimentoIngerir(Player jogador) {

        Especie especie = jogador.getEspecie();
        String tipoAlimen = especie.getTipoAlimentacao();
        int energiaAtual = especie.getEnergiaAtual();

        if(!tipoAlimen.equals("Herbívoro")){

            if(jogadaAtual >= 12){

                if(tipoAlimen.equals("Carnívoro") || tipoAlimen.equals("Omnívoro")){

                    if(energiaAtual > 150){
                        especie.mudaEnergiaAtual(200);

                    }else{
                        especie.mudaEnergiaAtual(energiaAtual + 50);

                    }
                }
            }else{
                especie.mudaEnergiaAtual(energiaAtual / 2);

            }
        }
    }

    @Override
    public String toString() {

        if(jogadaAtual <= 12){
            return "Carne : +- 50 energia : " + jogadaAtual + " jogadas";
        }else{
            return "Carne toxica";
        }

    }
}
