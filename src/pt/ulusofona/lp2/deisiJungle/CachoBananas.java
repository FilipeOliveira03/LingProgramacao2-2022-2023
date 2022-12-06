package pt.ulusofona.lp2.deisiJungle;

import java.util.ArrayList;

public class CachoBananas extends Alimento{

    private int countBanCacho = 3;
    private final ArrayList<Integer> idsJogadoresComeram = new ArrayList<>();

    public CachoBananas() {
        super('b', "bananas.png");
    }

    @Override
    public void acontecimentoIngerir(Player jogador) {

        Especie especie = jogador.getEspecie();

        if(countBanCacho > 0){
            countBanCacho--;
            boolean jogadorComeu = false;

            if(idsJogadoresComeram.contains(jogador.id)){
                jogadorComeu = true;
            }

            if(!jogadorComeu){

                if(especie.energia > 160){
                    especie.energia = 200;

                }else{
                    especie.energia += 40;
                }

            }else{

                if(especie.energia > 40){
                    especie.energia = 0;

                }else{
                    especie.energia -= 40;
                }
            }
        }

        idsJogadoresComeram.add(jogador.id);
    }

    @Override
    public String toString() {
        return "Bananas : " + countBanCacho + " : + 40 energia" ;
    }
}
