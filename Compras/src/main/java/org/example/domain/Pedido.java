package org.example.domain;

public class Pedido {

    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public Pedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        valorTotal = produto.getPrice() * quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
