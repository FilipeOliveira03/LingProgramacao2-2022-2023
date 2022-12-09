package pt.ulusofona.lp2.deisiJungle.alimentos;

import pt.ulusofona.lp2.deisiJungle.jogador.Player;

public abstract class Alimento {
    protected String nome;

    public Alimento(String nome){
       this.nome = nome;
    }

    public abstract void acontecimentoIngerir(Player jogador);

}
