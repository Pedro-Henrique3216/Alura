package br.com.alura.screenfrases.dto;

public record FraseDTO(
        Long id,
        String titulo,
        String frase,
        String poster,
        String personagem
) {
}
