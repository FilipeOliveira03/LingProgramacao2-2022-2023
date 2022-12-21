package pt.ulusofona.lp2.deisiJungle.alimentos;

import pt.ulusofona.lp2.deisiJungle.especies.Especie;
import pt.ulusofona.lp2.deisiJungle.jogador.Player;

public class Agua extends Alimento {

    public Agua() {
        this.nome = "Agua";
        this.idAlimento = "a";
    }

    @Override
    public void acontecimentoIngerir(Player jogador) {

        Especie especie = jogador.getEspecie();
        String tipoAlimen = especie.getTipoAlimentacao();
        int energiaAtual = especie.getEnergiaAtual();

        if(tipoAlimen.equals("Carnívoro") || tipoAlimen.equals("Herbívoro")){

            if(energiaAtual > 185){
                especie.mudaEnergiaAtual(200);

            }else{
                especie.mudaEnergiaAtual(energiaAtual + 15);
            }
        }else if(tipoAlimen.equals("Omnívoro")){

            int energiaAdicionar = (int) (energiaAtual * 0.2);
            int energiaFinal = energiaAtual + energiaAdicionar;

            if(energiaFinal > 200){
                especie.mudaEnergiaAtual(200);
            }else{
                especie.mudaEnergiaAtual(energiaAtual + energiaAdicionar);
            }
        }
    }

    @Override
    public String toString() {
        return "Agua : + 15U|20% energia";
    }
}
