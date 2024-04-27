package br.com.alura.HarmoniaWave.domain;

public class Audio {

    private String titulo;
    private int totalReproducao;
    private int curtidas;
    private int classificacao;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public int getTotalReproducao() {
        return totalReproducao;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void curtir(){
        curtidas++;
    }

    public void reproduzir(){
        totalReproducao++;
    }
}
