package pt.ulusofona.lp2.deisiJungle;

import java.util.ArrayList;

public class Especie {

    protected int energiaInicial;
    protected int consumoEnergia;
    protected int descanso;
    protected String velocidade;
    protected String tipoAlimentacao;
    protected ArrayList<Alimento> alimentosIngeridos = new ArrayList<>();

    public Especie(){}

    public void setEnergiaInicial(int energiaInicial) {
        this.energiaInicial = energiaInicial;
    }

    public void setConsumoEnergia(int consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    public void setDescanso(int descanso) {
        this.descanso = descanso;
    }

    public void setVelocidade(String velocidade) {
        this.velocidade = velocidade;
    }

    public void setTipoAlimentacao(String tipoAlimentacao) {
        this.tipoAlimentacao = tipoAlimentacao;
    }

    public void adicionaAlimento(Alimento alimento){
        alimentosIngeridos.add(alimento);
    }
}
