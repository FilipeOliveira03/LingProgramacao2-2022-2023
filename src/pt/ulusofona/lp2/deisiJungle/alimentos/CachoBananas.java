package pt.ulusofona.lp2.deisiJungle.alimentos;

import pt.ulusofona.lp2.deisiJungle.especies.Especie;
import pt.ulusofona.lp2.deisiJungle.jogador.Player;

import java.util.ArrayList;

public class CachoBananas extends Alimento {
    private int countBanCacho;
    private ArrayList<Integer> idsJogadoresComeram;

    public CachoBananas() {
        this.nome = "Bananas";
        this.idAlimento = "b";
        countBanCacho = 3;
        idsJogadoresComeram = new ArrayList<>();
    }

    public int getCountBanCacho() {
        return countBanCacho;
    }

    public ArrayList<Integer> getIdsJogadoresComeram() {
        return idsJogadoresComeram;
    }

    public void setCountBanCacho(int countBanCacho) {
        this.countBanCacho = countBanCacho;
    }

    public void setIdsJogadoresComeram(ArrayList<Integer> jog ) {
        this.idsJogadoresComeram = jog;
    }

    @Override
    public void acontecimentoIngerir(Player jogador) {

        Especie especie = jogador.getEspecie();
        int energiaAtual = especie.getEnergiaAtual();

        if(countBanCacho > 0){
            countBanCacho--;
            boolean jogadorComeu = jogador.isComeuBananas();

            if(!jogadorComeu){

                if(energiaAtual > 160){
                    especie.mudaEnergiaAtual(200);

                }else{
                    especie.mudaEnergiaAtual(energiaAtual + 40);
                }
            }else{

                if(energiaAtual < 40){
                    especie.mudaEnergiaAtual(0);

                }else{
                    especie.mudaEnergiaAtual(energiaAtual - 40);
                }
            }
            jogador.mudaEstadoBanana(true);
        }
    }

    @Override
    public String toString() {

        return "Bananas : " + countBanCacho + " : + 40 energia" ;
    }
}
