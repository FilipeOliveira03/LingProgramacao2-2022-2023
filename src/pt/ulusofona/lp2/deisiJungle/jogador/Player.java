package pt.ulusofona.lp2.deisiJungle.jogador;

import pt.ulusofona.lp2.deisiJungle.especies.Especie;

import java.util.ArrayList;

public class Player {
    private int id;
    private String nome;
    private int posicaoAtual = 1;
    private Especie especie;
    private int distanciaViajada = 0;
    private ArrayList<String> alimentosIngeridos;

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

    public Especie getEspecie() {
        return especie;
    }

    public ArrayList<String> getAlimentosIngeridos() {
        return alimentosIngeridos;
    }

    public int getDistanciaViajada() {
        return distanciaViajada;
    }

    public void adicionaAlimentosIngeridos(String nomeAlimento) {
        alimentosIngeridos.add(nomeAlimento);
    }

    public void mudaPosicaoAtual(int posicaoAtualMudada){
        this.posicaoAtual = posicaoAtualMudada;
    }

    public int adicionaDistanciaViajada(int distancia) {
        if(distancia < 0){
            return distanciaViajada -= distancia;
        }
        return distanciaViajada += distancia;
    }

    @Override
    public String toString() {
        return id + "|" + nome + "|" + posicaoAtual + "|" +
                distanciaViajada + "|" + alimentosIngeridos + "|" +
                especie.getNomeSigla() + "|" + especie.getEnergiaAtual();

    }
}
