package br.edu.ifam.turismo.hotelservice.model;

import java.math.BigDecimal;

public class Hotel {

    private Long id;
    private String nome;
    private String cidade;
    private BigDecimal valorDiaria;
    private int estrelas;
    private boolean disponivel;

    public Hotel(){

    }

    public Hotel(Long id, String nome, String cidade, BigDecimal valorDiaria, int estrelas, boolean disponivel) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.valorDiaria = valorDiaria;
        this.estrelas = estrelas;
        this.disponivel = disponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public int getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(int estrelas) {
        this.estrelas = estrelas;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

