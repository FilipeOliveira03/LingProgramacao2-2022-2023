package pt.ulusofona.lp2.deisiJungle;

public class Erva extends Alimento{

    public Erva(){
        super('e', "grass.png");

    }

    public void acontecimentoIngerir(Especie especie){

        if(especie.tipoAlimentacao.equals("Herbívoro") || especie.tipoAlimentacao.equals("Omnívoro")){

            if(especie.energiaInicial > 180){
                especie.energiaInicial = 200;

            }else{
                especie.energiaInicial += 20;
            }

        }else if(especie.tipoAlimentacao.equals("Carnívoro")){

            if(especie.energiaInicial < 20){
                especie.energiaInicial = 0;

            }else {
                especie.energiaInicial -= 20;
            }
        }
    }

    @Override
    public void escreveTooltip() {
        //adicionar a tooltip
    }

    @Override
    public String toString() {
        return "Erva : +- 20 energia";
    }
}
