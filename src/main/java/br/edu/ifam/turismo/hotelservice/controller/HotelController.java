package br.edu.ifam.turismo.hotelservice.controller;

import br.edu.ifam.turismo.hotelservice.model.Hotel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hoteis")
public class HotelController {
    // Lista mutável em memória inicializada com dados mockados
    private static final List<Hotel> HOTEIS = new ArrayList<>(List.of(
            new Hotel(1L, "Tropical Executive Hotel", "Manaus", new BigDecimal("450.00"), 4, true),
            new Hotel(2L, "Hotel Juma Ópera", "Manaus", new BigDecimal("890.00"), 5, true),
            new Hotel(3L, "Blue Tree Premium", "Manaus", new BigDecimal("380.00"), 4, false),
            new Hotel(4L, "Ibis Manaus Aeroporto", "Manaus", new BigDecimal("260.00"), 3, true)
    ));
    /**
     * 1. Consulta todos os hotéis.
     * GET /hoteis
     */
    @GetMapping
    public ResponseEntity<List<Hotel>> listarTodos() {
        return ResponseEntity.ok(HOTEIS);
    }
    /**
     * 2. Consulta um hotel por ID.
     * GET /hoteis/{id}
     *
     * @PathVariable: Extrai o valor dinâmico passado na URL (ex: /hoteis/1).
     */
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> buscarPorId(@PathVariable Long id) {
        for (Hotel hotel : HOTEIS) {
            if (hotel.getId().equals(id)) {
                return ResponseEntity.ok(hotel); // 200 OK com o objeto encontrado
            }
        }
        return ResponseEntity.notFound().build(); // 404 Not Found caso não encontre
    }
    /**
     * 3. Cadastra um novo hotel.
     * POST /hoteis
     *
     * @RequestBody: Converte o JSON enviado no corpo da requisição em um objeto Java.
     */
    @PostMapping
    public ResponseEntity<Hotel> cadastrar(@RequestBody Hotel novoHotel) {
// Gera um ID simples baseado no tamanho atual da lista
        long novoId = HOTEIS.size() + 1L;
        novoHotel.setId(novoId);
        HOTEIS.add(novoHotel);
// 201 Created informando que o recurso foi criado com sucesso
        return ResponseEntity.status(HttpStatus.CREATED).body(novoHotel);
    }
    /**
     * 4. Remove um hotel por ID.
     * DELETE /hoteis/{id}

     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        boolean removido = HOTEIS.removeIf(hotel -> hotel.getId().equals(id));
        if (removido) {
// 204 No Content: Sucesso na remoção, sem corpo de resposta
            return ResponseEntity.noContent().build();
        }
// 404 Not Found caso o ID informado não exista na lista
        return ResponseEntity.notFound().build();
    }
}
