package br.com.alura.screenfrases.model;

import jakarta.persistence.*;

@Entity
@Table(name = "frases")
public class Frase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String frase;
    private String personagem;
    private String poster;

    public Frase() {
    }

    public Frase(String titulo, String frase, String personagem, String poster) {
        this.titulo = titulo;
        this.frase = frase;
        this.personagem = personagem;
        this.poster = poster;
    }

}
