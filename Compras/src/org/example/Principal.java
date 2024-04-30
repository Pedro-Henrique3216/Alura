package org.example;

import org.example.domain.CartaoDeCredito;
import org.example.domain.Produto;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o limite do cartão");
        double limite = sc.nextDouble();

        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int opcao = 1;
        while (opcao != 0) {
            if (opcao != 1) {
                System.out.println("Digite uma opção valida");
                opcao = sc.nextInt();
            } else {
                System.out.println("Digite a descrição da compra:");
                String descricao = sc.next();

                System.out.println("Digite o valor da compra:");
                double valor = sc.nextDouble();

                Produto produto = new Produto(descricao, valor);

                if(cartao.lancaCompra(produto)){
                    System.out.println("Compra realizada!");
                    System.out.println("Digite 0 para sair ou 1 para continuar");
                    opcao = sc.nextInt();
                } else {
                    System.out.println("Compra não realizada!");
                    opcao = 0;
                }
            }
        }

        comprasRealizadas(cartao.getCompras(), cartao.saldoFormatado());
        sc.close();
    }

    public static void comprasRealizadas(List<Produto> lista, String limiteRestante) {
        System.out.println("*".repeat(20));
        System.out.println("COMPRAS REALIZADAS\n");
        Collections.sort(lista);
        for (Produto produto : lista) {
            System.out.println(produto);
        }
        System.out.println("\n" + "*".repeat(20));
        System.out.println("\nSaldo do Cartão: " + limiteRestante);
    }

}

