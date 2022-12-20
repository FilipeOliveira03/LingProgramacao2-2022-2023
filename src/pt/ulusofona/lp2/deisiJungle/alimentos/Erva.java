package pt.ulusofona.lp2.deisiJungle.alimentos;

import pt.ulusofona.lp2.deisiJungle.especies.Especie;
import pt.ulusofona.lp2.deisiJungle.jogador.Player;

public class Erva extends Alimento {

    public Erva(){
        this.nome = "Erva";
        this.idAlimento = "e";
    }

    @Override
    public void acontecimentoIngerir(Player jogador){

        Especie especie = jogador.getEspecie();
        String tipoAlimen = especie.getTipoAlimentacao();
        int energiaAtual = especie.getEnergiaAtual();

        if(tipoAlimen.equals("Herbívoro") || tipoAlimen.equals("Omnívoro")){

            if(energiaAtual > 180){
                especie.mudaEnergiaAtual(200);

            }else{
                especie.mudaEnergiaAtual(energiaAtual + 20);
            }

        }else if(tipoAlimen.equals("Carnívoro")){

            if(energiaAtual < 20){
                especie.mudaEnergiaAtual(0);

            }else {
                especie.mudaEnergiaAtual(energiaAtual - 20);
            }
        }
    }


    @Override
    public String toString() {
        return "Erva : +- 20 energia";
    }
}
