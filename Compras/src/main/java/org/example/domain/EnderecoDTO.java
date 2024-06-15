package org.example.domain;

public record EnderecoDTO(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        String ibge,
        String ddd
) {
    public Endereco toEndereco(String numero) {
        return new Endereco(cep, logradouro, complemento, bairro, localidade, uf, ibge, ddd, numero);
    }
}
