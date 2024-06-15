package org.example.domain;

import org.example.exception.CompraNegada;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartaoDeCredito {

    private Usuario titular;
    private double limite;
    private final List<Compra> compras = new ArrayList<>();;

    public CartaoDeCredito(Usuario titular, double limite) {
        this.titular = titular;
        this.limite = limite;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void lancaCompra(Compra compra){
        if(this.limite > compra.getValorTotal()){
            this.limite -= compra.getValorTotal();
            compras.add(compra);
        } else {
           throw new CompraNegada("Seu Limite é insuficiente");
        }
    }

    public void comprasRealizadas() {
        System.out.println("*".repeat(20));
        System.out.println("COMPRAS REALIZADAS\n");
        Collections.sort(compras);
        for (Compra compra : compras) {
            System.out.println(compra);
        }
        System.out.println("\n" + "*".repeat(20));
        System.out.println("\nLimite do Cartão: " + limiteFormatado());
    }

    public String limiteFormatado(){
        return String.format("%.2f", this.limite);
    }
}
