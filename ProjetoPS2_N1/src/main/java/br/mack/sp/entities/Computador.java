package br.mack.sp.entities;

public class Computador {
    private Long id;
    private String marca;
    private String processador;
    private int qtde_ram;
    private int tmn_disco;

    public Computador(){
        this.id = null;
        this.marca = "Marca não inserida";
        this.processador = "Processador não inserido";
        this.qtde_ram = -1;
        this.tmn_disco = -1;
    }
    public Computador (long id, String marca, String processador, int qtde_ram, int tmn_disco){
        this.id= id;
        this.marca = marca;
        this.processador = processador;
        this.qtde_ram = qtde_ram;
        this.tmn_disco = tmn_disco;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", processador='" + processador + '\'' +
                ", qtde_ram=" + qtde_ram +
                ", tmn_disco=" + tmn_disco +
                '}';
    }
}
