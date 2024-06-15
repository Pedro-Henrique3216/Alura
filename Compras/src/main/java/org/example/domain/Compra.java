package org.example.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Compra implements Comparable<Compra>{

    private LocalDate dataCompra;
    private List<Pedido> pedidos = new ArrayList<>();
    private Double valorTotal = 0.0;

    public Compra() {
        dataCompra = LocalDate.now();
    }

    public void lancaPedido(Produto produto, int quantidade){
        Pedido pedido = new Pedido(produto, quantidade);
        pedidos.add(pedido);
        valorTotal += pedido.getValorTotal();
    }

    public List<Pedido> getProdutos() {
        return pedidos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public String getDataCompra() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataCompra.format(dtf);
    }

    @Override
    public int compareTo(Compra o) {
        return this.getDataCompra().compareTo(o.getDataCompra());
    }

    @Override
    public String toString() {
        return "Compra{" +
                "dataCompra=" + getDataCompra() +
                ", pedidos=" + pedidos +
                ", valorTotal=" + valorTotal +
                '}';
    }
}

