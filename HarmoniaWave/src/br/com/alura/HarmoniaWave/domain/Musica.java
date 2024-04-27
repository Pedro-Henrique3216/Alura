package br.com.alura.HarmoniaWave.domain;

public class Musica extends Audio {

    private String genero;
    private String album;
    private String cantor   ;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    @Override
    public int getClassificacao() {
        if (getTotalReproducao() > 2000){
            return 10;
        } else {
            return 8;
        }
    }

}
