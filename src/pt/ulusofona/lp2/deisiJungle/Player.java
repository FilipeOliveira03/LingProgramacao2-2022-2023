package pt.ulusofona.lp2.deisiJungle;

import pt.ulusofona.lp2.deisiJungle.Alimentos.Alimento;
import pt.ulusofona.lp2.deisiJungle.Especies.Especie;

import java.util.ArrayList;

public class Player {
    int id;
    String nome;
    String especie;
    int energiaAtual;
    int posicaoAtual = 1;
    private Especie especiee;
    private int distanciaViajada;
    private final ArrayList<Alimento> alimentosIngeridos = new ArrayList<>();;

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

    public Especie getEspecie() {
        return especiee;
    }

    public int getId() {
        return id;
    }
}
