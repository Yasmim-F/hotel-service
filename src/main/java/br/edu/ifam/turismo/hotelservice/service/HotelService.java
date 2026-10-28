package br.edu.ifam.turismo.hotelservice.service;

import br.edu.ifam.turismo.hotelservice.dto.HotelRequestDTO;
import br.edu.ifam.turismo.hotelservice.dto.HotelResponseDTO;
import br.edu.ifam.turismo.hotelservice.entity.Cidade;
import br.edu.ifam.turismo.hotelservice.entity.Hotel;
import br.edu.ifam.turismo.hotelservice.repository.CidadeRepository;
import br.edu.ifam.turismo.hotelservice.repository.HotelRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final CidadeRepository cidadeRepository;
    public HotelService(HotelRepository hotelRepository, CidadeRepository cidadeRepository) {
        this.hotelRepository = hotelRepository;
        this.cidadeRepository = cidadeRepository;
    }
    public List<HotelResponseDTO> listarTodos() {
        List<Hotel> hoteis = hotelRepository.findAll();
        List<HotelResponseDTO> resposta = new ArrayList<>();
        for (Hotel h : hoteis) {
            resposta.add(new HotelResponseDTO(h));
        }
        return resposta;
    }
    public HotelResponseDTO inserir(HotelRequestDTO request) {
// Regra de negócio: Busca cidade pelo código padrão do IBGE
        Cidade cidade = cidadeRepository.findByCodigoIBGE(request.getCodigoIBGE())
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada no sistema com o código fornecido"));
// Conversão encapsulada no DTO
                        Hotel novoHotel = request.build(cidade);
// Persistência
        Hotel hotelSalvo = hotelRepository.save(novoHotel);
// Retorna o response
        return new HotelResponseDTO(hotelSalvo);
    }
}
