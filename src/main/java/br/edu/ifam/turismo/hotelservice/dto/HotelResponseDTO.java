package br.edu.ifam.turismo.hotelservice.dto;

import br.edu.ifam.turismo.hotelservice.entity.Hotel;
import java.math.BigDecimal;

public class HotelResponseDTO {
    private Long id;
    private String nome;
    private BigDecimal valorDiaria;
    private int estrelas;
    private boolean disponivel;
    private String cidadeNome;
    private String cidadeUf;

    // Converte de Entidade para DTO achatado no construtor
    public HotelResponseDTO(Hotel hotel) {
        this.id = hotel.getId();
        this.nome = hotel.getNome();
        this.valorDiaria = hotel.getValorDiaria();
        this.estrelas = hotel.getEstrelas();
        this.disponivel = hotel.isDisponivel();
        if(hotel.getCidade() != null) {
            this.cidadeNome = hotel.getCidade().getNome();
            this.cidadeUf = hotel.getCidade().getUf();
        }
    }

    // Getters apenas (este objeto é apenas de resposta/leitura)
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public BigDecimal getValorDiaria() { return valorDiaria; }
    public int getEstrelas() { return estrelas; }
    public boolean isDisponivel() { return disponivel; }
    public String getCidadeNome() { return cidadeNome; }
    public String getCidadeUf() { return cidadeUf; }
}
