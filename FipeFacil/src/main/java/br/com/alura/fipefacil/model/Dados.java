package br.com.alura.fipefacil.model;

public record Dados(
        String codigo,
        String nome
) {

    @Override
    public String toString() {
        return "codigo='" + codigo + '\'' +
                ", nome='" + nome;
    }
}
