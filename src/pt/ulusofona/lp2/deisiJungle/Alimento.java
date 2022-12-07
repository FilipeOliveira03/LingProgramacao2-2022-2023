package pt.ulusofona.lp2.deisiJungle;

import pt.ulusofona.lp2.deisiJungle.Player;

public abstract class Alimento {
    protected char identificador;
    protected String imagemPNG;

    public Alimento(char identificador, String imagemPNG){
        this.identificador = identificador;
        this.imagemPNG = imagemPNG;
    }

    public abstract void acontecimentoIngerir(Player jogador);


    //public abstract void escreveTooltip();

}
