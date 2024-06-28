package br.com.alura.aluramusic.models;

public enum Tipo {

    SOLO("solo"),
    DUPLA("dupla"),
    BANDA("banda");

    private String texto;

    Tipo(String texto){
        this.texto = texto;
    }

    public static Tipo textPortugue(String texto){
        for(Tipo tipo : values()){
            if(tipo.texto.equals(texto)){
                return tipo;
            }
        }
        throw new RuntimeException("Tipo no encontrado");
    }
}
