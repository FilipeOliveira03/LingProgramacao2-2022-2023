package pt.ulusofona.lp2.deisiJungle;

public class Agua extends Alimento{

    public Agua() {
        super('a', "water.png");
    }

    @Override
    public void acontecimentoIngerir(Player jogador) {

        Especie especie = jogador.getEspecie();

        if(especie.tipoAlimentacao.equals("Carnívoro") || especie.tipoAlimentacao.equals("Herbívoro")){

            if(especie.energia > 185){
                especie.energia = 200;

            }else{
                especie.energia += 15;
            }
        }else if(especie.tipoAlimentacao.equals("Omnívoro")){

            int energiaAtual = especie.energia;
            int energiaAdicionar = (int) (especie.energia * 0.2); // não sei se arredonda
            int energiaFinal = energiaAtual + energiaAdicionar;

            if(energiaFinal > 200){
                especie.energia = 200;
            }else{
                especie.energia += energiaAdicionar;
            }
        }
    }

    @Override
    public String toString() {
        return "Agua : + 10U|20% energia";
    }
}
