package pt.ulusofona.lp2.deisiJungle.jogador;

import pt.ulusofona.lp2.deisiJungle.alimentos.Alimento;
import pt.ulusofona.lp2.deisiJungle.especies.Especie;

import java.util.ArrayList;

public class Player {
    private int id;
    private String nome;
    private int posicaoAtual = 1;
    private Especie especie;
    private int distanciaViajada;
    private ArrayList<Alimento> alimentosIngeridos;

    public Player(){
    }
    public Player(int id, String nome, Especie especie){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        alimentosIngeridos = new ArrayList<>();
    }

    public int getID() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getPosicaoAtual() {
        return posicaoAtual;
    }

    public void mudaPosicaoAtual(int posicaoAtualMudada){
        this.posicaoAtual = posicaoAtualMudada;
    }

    public Especie getEspecie() {
        return especie;
    }


}
