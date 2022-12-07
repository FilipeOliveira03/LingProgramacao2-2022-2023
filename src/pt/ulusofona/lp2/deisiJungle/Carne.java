package pt.ulusofona.lp2.deisiJungle;

public class Carne extends Alimento {

    private final int jogadaAtual = GameManager.getJogadasPassadas();

    public Carne() {
        super('c', "meat.png");
    }

    @Override
    public void acontecimentoIngerir(Player jogador) {

        Especie especie = jogador.getEspecie();

        if(!especie.tipoAlimentacao.equals("Herbívoro")){

            if(jogadaAtual >= 12){

                if(especie.tipoAlimentacao.equals("Carnívoro") || especie.tipoAlimentacao.equals("Omnívoro")){

                    if(especie.energia > 150){
                        especie.energia = 200;

                    }else{
                        especie.energia += 50;
                    }
                }
            }else{

                especie.energia = especie.energia / 2;

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
