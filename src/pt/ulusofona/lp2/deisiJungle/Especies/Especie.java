package pt.ulusofona.lp2.deisiJungle.Especies;

public class Especie {

    protected int energia;
    protected int consumoEnergia;
    protected int ganhoEnerDescanso;
    protected String velocidade;
    protected String tipoAlimentacao;

    public Especie(int energia, int consumoEnergia, int ganhoEnerDescanso, String velocidade,String tipoAlimentacao){
        this.energia = energia;
        this.consumoEnergia = consumoEnergia;
        this.ganhoEnerDescanso = ganhoEnerDescanso;
        this.velocidade = velocidade;
        this.tipoAlimentacao = tipoAlimentacao;
    }

    public int getEnergia() {
        return energia;
    }

    public int mudaEnergia(int energia){
        return this.energia = energia;
    }

    public String getTipoAlimentacao() {
        return tipoAlimentacao;
    }
}
