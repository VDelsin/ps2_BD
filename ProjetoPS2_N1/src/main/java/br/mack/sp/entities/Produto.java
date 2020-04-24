package br.mack.sp.entities;

public class Produto {
    private Long id;
    private String descricao;
    private String marca;
    private double preco;

    public Produto(Long id, String descricao, String marca, double preco) {
        this.id = id;
        this.descricao = descricao;
        this.marca = marca;
        this.preco = preco;
    }

    public Produto() {

    }
    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", preco=" + preco +
                '}';
    }
}