package pt.ulusofona.lp2.deisiJungle.especies;

import java.util.ArrayList;

public class Especie {

    protected String nomeSigla;
    protected int energia;
    protected int consumoEnergia;
    protected int ganhoEnerDescanso;
    protected String velocidade;
    protected String tipoAlimentacao;
    private ArrayList<Especie> todasAsEspecies = new ArrayList<>();

    public Especie(){
        todasAsEspecies.add(new Elefante());
        todasAsEspecies.add(new Leao());
        todasAsEspecies.add(new Tartaruga());
        todasAsEspecies.add(new Passaro());
        todasAsEspecies.add(new Tarzan());
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

    public int mudaEnergia(int energia){
        return this.energia = energia;
    }

    public int getConsumoEnergetico() {
        return consumoEnergia;
    }

    public ArrayList<Especie> getTodasAsEspecies() {
        return todasAsEspecies;
    }
}
