package br.com.alura.fipefacil.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Teste(
        List<Dados> modelos
) {
}
