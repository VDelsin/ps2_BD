package br.mack.sp.entities;

public class Computador {
    private Long id_computador;
    private String marca;
    private String processador;
    private int qtde_ram;
    private int tmn_disco;

    public Computador() {
        this.id_computador = null;
        this.marca = "Marca não inserida";
        this.processador = "Processador não inserido";
        this.qtde_ram = -1;
        this.tmn_disco = -1;
    }

    public Computador(long id_computador, String marca, String processador, int qtde_ram, int tmn_disco) {
        this.id_computador = id_computador;
        this.marca = marca;
        this.processador = processador;
        this.qtde_ram = qtde_ram;
        this.tmn_disco = tmn_disco;
    }

    public Long getId_computador() {
        return id_computador;
    }

    public void setId_computador(Long id_computador) {
        this.id_computador = id_computador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public int getQtde_ram() {
        return qtde_ram;
    }

    public void setQtde_ram(int qtde_ram) {
        this.qtde_ram = qtde_ram;
    }

    public int getTmn_disco() {
        return tmn_disco;
    }

    public void setTmn_disco(int tmn_disco) {
        this.tmn_disco = tmn_disco;
    }

    @Override
    public String toString() {
        return "Computador{" +
                "ID =" + id_computador +
                ", Marca = '" + marca + '\'' +
                ", Processador = '" + processador + '\'' +
                ", Quantidade de RAM = " + qtde_ram +
                ", Tamanho do disco = " + tmn_disco +
                '}';
    }
}
