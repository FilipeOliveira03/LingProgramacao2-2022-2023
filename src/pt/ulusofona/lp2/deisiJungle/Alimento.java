package pt.ulusofona.lp2.deisiJungle;

public class Alimento {
    protected String tipoAlimento;
    protected char identificador;
    protected String imagemPNG;

    Alimento(){
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    public void setIdentificador(char identificador) {
        this.identificador = identificador;
    }

    public void setImagemPNG(String imagemPNG) {
        this.imagemPNG = imagemPNG;
    }
}
