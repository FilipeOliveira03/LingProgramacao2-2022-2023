package pt.ulusofona.lp2.deisiJungle.alimentos;

import pt.ulusofona.lp2.deisiJungle.jogador.Player;

public abstract class Alimento {
    protected String nome;
    protected String idAlimento;

    public Alimento(){
    }

    public String getNome() {
        return nome;
    }

    public Alimento(String nome, String idAlimento) {
        this.nome = nome;
        this.idAlimento = idAlimento;
    }

    public abstract void acontecimentoIngerir(Player jogador);

}
