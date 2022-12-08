package pt.ulusofona.lp2.deisiJungle.Alimentos;

import pt.ulusofona.lp2.deisiJungle.Especies.Especie;
import pt.ulusofona.lp2.deisiJungle.Player;

import java.util.ArrayList;

public class CachoBananas extends Alimento {

    private int countBanCacho = 3;
    private final ArrayList<Integer> idsJogadoresComeram = new ArrayList<>();

    public CachoBananas() {
        super("Cacho de Bananas");
    }

    @Override
    public void acontecimentoIngerir(Player jogador) {

        Especie especie = jogador.getEspecie();
        int energiaAtual = especie.getEnergia();

        if(countBanCacho > 0){
            countBanCacho--;
            boolean jogadorComeu = false;

            if(idsJogadoresComeram.contains(jogador.getId())){
                jogadorComeu = true;
            }

            if(!jogadorComeu){

                if(energiaAtual > 160){
                    especie.mudaEnergia(200);

                }else{
                    especie.mudaEnergia(energiaAtual + 40);
                }

            }else{

                if(energiaAtual > 40){
                    especie.mudaEnergia(0);

                }else{
                    especie.mudaEnergia(energiaAtual - 40);
                }
            }
        }

        idsJogadoresComeram.add(jogador.getId());
    }

    @Override
    public String toString() {
        return "Bananas : " + countBanCacho + " : + 40 energia" ;
    }
}