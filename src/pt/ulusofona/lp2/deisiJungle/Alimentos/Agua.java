package pt.ulusofona.lp2.deisiJungle.Alimentos;

import pt.ulusofona.lp2.deisiJungle.Especies.Especie;
import pt.ulusofona.lp2.deisiJungle.Player;

public class Agua extends Alimento {

    public Agua() {
        super("Agua");
    }

    @Override
    public void acontecimentoIngerir(Player jogador) {

        Especie especie = jogador.getEspecie();
        String tipoAlimen = especie.getTipoAlimentacao();
        int energiaAtual = especie.getEnergia();

        if(tipoAlimen.equals("Carnívoro") || tipoAlimen.equals("Herbívoro")){

            if(energiaAtual > 185){
                especie.mudaEnergia(200);

            }else{
                especie.mudaEnergia(energiaAtual + 15);
            }
        }else if(tipoAlimen.equals("Omnívoro")){

            int energiaAdicionar = (int) (energiaAtual * 0.2);
            int energiaFinal = energiaAtual + energiaAdicionar;

            if(energiaFinal > 200){
                especie.mudaEnergia(200);
            }else{
                especie.mudaEnergia(energiaAtual + energiaAdicionar);
            }
        }
    }

    @Override
    public String toString() {
        return "Agua : + 10U|20% energia";
    }
}
