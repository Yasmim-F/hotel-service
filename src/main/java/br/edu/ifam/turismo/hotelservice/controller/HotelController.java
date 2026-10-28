package br.edu.ifam.turismo.hotelservice.controller;

import br.edu.ifam.turismo.hotelservice.dto.HotelRequestDTO;
import br.edu.ifam.turismo.hotelservice.dto.HotelResponseDTO;
import br.edu.ifam.turismo.hotelservice.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/hoteis")
public class HotelController {
    /*
     * 💡 Dúvida comum: Eu não deveria colocar @Autowired aqui no controller?
     *
     * Resposta:
     * Quanto ao @Autowired, desde a versão 4.3 do Spring, se a classe tiver apenas
     * UM construtor, a injeção de dependência é feita automaticamente.
     * Não precisamos escrever @Autowired em cima da variável (atributo)
     */
    private final HotelService service;
    public HotelController(HotelService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<HotelResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
    @PostMapping
    public ResponseEntity<HotelResponseDTO> cadastrar(@RequestBody HotelRequestDTO request) {
        HotelResponseDTO response = service.inserir(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
