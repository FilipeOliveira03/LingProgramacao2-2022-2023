package pt.ulusofona.lp2.deisiJungle;

public abstract class Alimento {
    protected char identificador;
    protected String imagemPNG;

    public Alimento(char identificador, String imagemPNG){
        this.identificador = identificador;
        this.imagemPNG = imagemPNG;
    }

    public abstract void escreveTooltip();
}
