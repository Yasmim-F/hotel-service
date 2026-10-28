package br.edu.ifam.turismo.hotelservice.dto;

import br.edu.ifam.turismo.hotelservice.entity.Cidade;
import br.edu.ifam.turismo.hotelservice.entity.Hotel;
import java.math.BigDecimal;
public class HotelRequestDTO {
    private String nome;
    private BigDecimal valorDiaria;
    private int estrelas;
    private boolean disponivel;
    private String codigoIBGE; // Usamos a referência padronizada do IBGE

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public BigDecimal getValorDiaria() { return valorDiaria; }
    public void setValorDiaria(BigDecimal valorDiaria) { this.valorDiaria = valorDiaria; }
    public int getEstrelas() { return estrelas; }
    public void setEstrelas(int estrelas) { this.estrelas = estrelas; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    public String getCodigoIBGE() { return codigoIBGE; }
    public void setCodigoIBGE(String codigoIBGE) { this.codigoIBGE = codigoIBGE; }

    // Converte de DTO para Entidade
    public Hotel build(Cidade cidadeEncontrada) {
        Hotel hotel = new Hotel();
        hotel.setNome(this.nome);
        hotel.setValorDiaria(this.valorDiaria);
        hotel.setEstrelas(this.estrelas);
        hotel.setDisponivel(this.disponivel);
        hotel.setCidade(cidadeEncontrada);
        return hotel;
    }
}
