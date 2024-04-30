package org.example.domain;

public class Produto implements Comparable<Produto>{

    private String descricao;
    private Double price;

    public Produto(String descricao, Double price) {
        this.descricao = descricao;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Produto o) {
        return this.price.compareTo(o.price);
    }

    @Override
    public String toString() {
        return this.descricao + " - " + String.format("%.2f", this.price);
    }
}
