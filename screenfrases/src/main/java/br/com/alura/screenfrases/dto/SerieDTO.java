package br.com.alura.screenfrases.dto;

public record SerieDTO(
        Long id,
        String titulo,
        String frase,
        String poster,
        String personagem
) {
}
