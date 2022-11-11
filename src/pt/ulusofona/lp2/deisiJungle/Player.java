package pt.ulusofona.lp2.deisiJungle;

public class Player {
    String id;
    String nome;
    String especie;
    int energiaAtual;
    int posicaoAtual = 1;
    boolean terminou = false;

    Player(){
    }

    public void adicionaId(String id){
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
        this.posicaoAtual += posicaoAtual;
    }

}
