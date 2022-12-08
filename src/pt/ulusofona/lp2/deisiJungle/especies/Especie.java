package pt.ulusofona.lp2.deisiJungle.especies;

public class Especie {

    protected String nomeSigla;
    protected int energia;
    protected int consumoEnergia;
    protected int ganhoEnerDescanso;
    protected String velocidade;
    protected String tipoAlimentacao;

    public Especie(String nomeSigla, int energia, int consumoEnergia, int ganhoEnerDescanso, String velocidade,String tipoAlimentacao){
        this.nomeSigla = nomeSigla;
        this.energia = energia;
        this.consumoEnergia = consumoEnergia;
        this.ganhoEnerDescanso = ganhoEnerDescanso;
        this.velocidade = velocidade;
        this.tipoAlimentacao = tipoAlimentacao;
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

    public int mudaEnergia(int energia){
        return this.energia = energia;
    }


}
