package org.example.domain;

public class Usuario {

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Endereco endereco;
    private CartaoDeCredito cartaoDeCredito;

    public Usuario(String nome, String cpf, String email, String senha, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }


    public void cadastrarCartao(double limite){
        this.cartaoDeCredito = new CartaoDeCredito(this, limite);
    }

    public CartaoDeCredito getCartaoDeCredito() {
        return cartaoDeCredito;
    }
}
