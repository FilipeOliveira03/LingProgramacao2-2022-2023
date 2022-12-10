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
        int energiaAtual = especie.getEnergia();

        if(tipoAlimen.equals("Herbívoro") || tipoAlimen.equals("Omnívoro")){

            if(energiaAtual > 180){
                especie.mudaEnergia(200);

            }else{
                especie.mudaEnergia(energiaAtual + 20);
            }

        }else if(tipoAlimen.equals("Carnívoro")){

            if(energiaAtual < 20){
                especie.mudaEnergia(0);

            }else {
                especie.mudaEnergia(energiaAtual - 20);
            }
        }
    }


    @Override
    public String toString() {
        return "Erva : +- 20 energia";
    }
}
