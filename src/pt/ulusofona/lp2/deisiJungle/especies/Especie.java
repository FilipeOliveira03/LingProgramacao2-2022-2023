package pt.ulusofona.lp2.deisiJungle.especies;

public abstract class Especie {

    protected String nomeSigla;
    protected int energiaAtual;
    protected int consumoEnergetico;
    protected int ganhoEnerDescanso;
    protected String velocidade;
    protected String tipoAlimentacao;

    public Especie(){
    }

    public String getNomeSigla() {
        return nomeSigla;
    }

    public int getEnergiaAtual() {
        return energiaAtual;
    }

    public String getTipoAlimentacao() {
        return tipoAlimentacao;
    }

    public String getVelocidade() {
        return velocidade;
    }
    
    public int getConsumoEnergetico() {
            return consumoEnergetico;
        }

    public int getGanhoEnerDescanso() {
        return ganhoEnerDescanso;
    }

    public int mudaEnergiaAtual(int energia){
        return this.energiaAtual = energia;
    }

}
