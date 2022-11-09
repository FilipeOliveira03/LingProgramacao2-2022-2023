package pt.ulusofona.lp2.deisiJungle;

import java.util.Objects;

public class Players {
    int id;
    String nome;
    String especie;
    int posicao;
    int energia;

    public Players(int id, String nome, String especie, int posicao,int energia) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.posicao = posicao;
        this.energia= energia;
    }

    public Players(int id, String nome, String especie){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
    }


}
