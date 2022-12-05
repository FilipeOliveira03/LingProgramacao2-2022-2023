package pt.ulusofona.lp2.deisiJungle;

public class Erva extends Alimento{

    public Erva(){
        super('e', "grass.png");
    }

    @Override
    public void acontecimentoIngerir(Player jogador){

        Especie especie = jogador.getEspecie();

        if(especie.tipoAlimentacao.equals("Herbívoro") || especie.tipoAlimentacao.equals("Omnívoro")){

            if(especie.energia > 180){
                especie.energia = 200;

            }else{
                especie.energia += 20;
            }

        }else if(especie.tipoAlimentacao.equals("Carnívoro")){

            if(especie.energia < 20){
                especie.energia = 0;

            }else {
                especie.energia -= 20;
            }
        }
    }


    @Override
    public String toString() {
        return "Erva : +- 20 energia";
    }
}
