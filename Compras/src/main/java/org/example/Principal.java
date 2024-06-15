package org.example;

import org.example.domain.Compra;
import org.example.domain.Produto;
import org.example.domain.Usuario;
import org.example.exception.EnderecoNotFound;
import org.example.services.VerificaCep;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Começando cadastro de Usuario");
        System.out.println("Digite o nome do usuario");
        String nome = sc.nextLine();
        System.out.println("Digite o cpf do usuario");
        String cpf = sc.nextLine();
        System.out.println("Digite o email do usuario");
        String email = sc.nextLine();
        System.out.println("Digite o senha do usuario");
        String senha = sc.nextLine();

        Usuario usuario = null;
        while (usuario == null) {
            System.out.println("Digite o cep do usuario");
            String cep = sc.nextLine();
            System.out.println("Digite o numero da casa do usuario");
            String numero = sc.nextLine();

            try {
                usuario = new Usuario(nome, cpf, email, senha, VerificaCep.retornaEndereco(cep, numero));
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (EnderecoNotFound e) {
                System.out.println(e.getMessage());
            }
        }

        usuario.cadastrarCartao(1000);

        Produto produto = new Produto("Maçã", 20.00);
        Produto produto1 = new Produto("Laranja", 50.00);
        Produto produto2 = new Produto("Limão", 50.00);

        System.out.println("Adicione produto a sua compra");

        Compra compra = new Compra();
        while (true) {
            System.out.println("se quiser sair digite 1");
            String opcao = sc.next();
            if(opcao.equals("1")) {
                usuario.getCartaoDeCredito().lancaCompra(compra);
                compra = new Compra();
                break;
            }
            produtos();
            System.out.println("Digite o nome do produto");
            String produtoNome = sc.next();
            System.out.println("Digite a quantidade do produto");
            int produtoQuantidade = sc.nextInt();
            if (produtoNome.equalsIgnoreCase("maca")) {
                compra.lancaPedido(produto, produtoQuantidade);
            } else if (produtoNome.equalsIgnoreCase("laranja")) {
                compra.lancaPedido(produto1, produtoQuantidade);
            } else if (produtoNome.equalsIgnoreCase("limao")) {
                compra.lancaPedido(produto2, produtoQuantidade);
            } else {
                System.out.println("Fruta inexistente");
            }
            System.out.println(produtoNome + " adicionado com sucesso");
        }

        usuario.getCartaoDeCredito().comprasRealizadas();


        sc.close();
    }

    public static void produtos(){
        System.out.println("*".repeat(20));
        System.out.println("Frutas\n");
        System.out.println("maca");
        System.out.println("laranja");
        System.out.println("limao");
        System.out.println("\n" + "*".repeat(20));
    }

}

