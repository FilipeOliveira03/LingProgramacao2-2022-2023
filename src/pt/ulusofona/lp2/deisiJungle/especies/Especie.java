package pt.ulusofona.lp2.deisiJungle.especies;

public class Especie {

    protected String nomeSigla;
    protected int energia;
    protected int consumoEnergia;
    protected int ganhoEnerDescanso;
    protected String velocidade;
    protected String tipoAlimentacao;

    public Especie(){
    }

    public String getNomeSigla() {
        return nomeSigla;
    }

    public int getEnergia() {
        return energia;
    }

    public String getTipoAlimentacao() {
        return tipoAlimentacao;
    }

    public String getVelocidade() {
        return velocidade;
    }
    
    public int getConsumoEnergetico() {
            return consumoEnergia;
        }

    public int getGanhoEnerDescanso() {
        return ganhoEnerDescanso;
    }

    public int mudaEnergia(int energia){
        return this.energia = energia;
    }

    

}
