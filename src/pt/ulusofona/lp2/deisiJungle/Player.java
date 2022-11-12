package pt.ulusofona.lp2.deisiJungle;

public class Player {
    int id;
    String nome;
    String especie;
    int energiaAtual;
    int posicaoAtual = 1;
    boolean temEnergia = true;

    Player(){
    }

    public void adicionaId(int id){
        this.id = id;
    }

    public void adicionaNome(String nome){
        this.nome = nome;
    }

    public void adicionaEspecie(String especie){
        this.especie = especie;
    }

    public void adicionaEnergiaAtual(int energiaAtual){
        this.energiaAtual = energiaAtual;
    }

    public void mudaPosicaoAtual(int posicaoAtual){
        this.posicaoAtual = posicaoAtual;
    }

    public void naoTemEnergia(boolean temEnergia){
        this.temEnergia = temEnergia;
    }
}
