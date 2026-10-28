package br.edu.ifam.turismo.hotelservice.entity;

import jakarta.persistence.*;
@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String uf;

    // Usado para manter relação com o padrão geográfico real oficial do Brasil
    @Column(unique = true)
    private String codigoIBGE;
    public Cidade() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
    public String getCodigoIBGE() { return codigoIBGE; }
    public void setCodigoIBGE(String codigoIBGE) { this.codigoIBGE = codigoIBGE; }
}
