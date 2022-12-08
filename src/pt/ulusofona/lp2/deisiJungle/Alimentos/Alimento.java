package pt.ulusofona.lp2.deisiJungle.Alimentos;

import pt.ulusofona.lp2.deisiJungle.Player;

public abstract class Alimento {
    protected String nome;

    public Alimento(String nome){
       this.nome = nome;
    }

    public abstract void acontecimentoIngerir(Player jogador);

}
