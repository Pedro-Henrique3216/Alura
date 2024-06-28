package br.com.alura.aluramusic.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne
    private Artista artista;
    private LocalDate data;

    public Musica() {
    }

    public Musica(String titulo, Artista artista, LocalDate data) {
        this.titulo = titulo;
        this.artista = artista;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "titulo='" + titulo + '\'' +
                ", data=" + data;
    }
}
