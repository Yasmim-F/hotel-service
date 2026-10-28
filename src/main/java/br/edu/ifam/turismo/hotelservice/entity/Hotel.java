package br.edu.ifam.turismo.hotelservice.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal valorDiaria;
    private int estrelas;
    private boolean disponivel;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
    public Hotel() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public BigDecimal getValorDiaria() { return valorDiaria; }
    public void setValorDiaria(BigDecimal valorDiaria) { this.valorDiaria = valorDiaria; }
    public int getEstrelas() { return estrelas; }
    public void setEstrelas(int estrelas) { this.estrelas = estrelas; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    public Cidade getCidade() { return cidade; }
    public void setCidade(Cidade cidade) { this.cidade = cidade; }
}