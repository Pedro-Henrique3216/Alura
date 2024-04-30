package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class CartaoDeCredito {

    private double limite;
    private double saldo;
    private final List<Produto> compras;

    public CartaoDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    private void addCompra(Produto produto){
        this.compras.add(produto);
    }

    public List<Produto> getCompras() {
        return compras;
    }

    public boolean lancaCompra(Produto produto){
        if(this.saldo > produto.getPrice()){
            this.saldo -= produto.getPrice();
            addCompra(produto);
            return true;
        } else {
            return false;
        }
    }

    public String saldoFormatado(){
        return String.format("%.2f", this.saldo);
    }
}
