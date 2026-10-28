package br.edu.ifam.turismo.hotelservice.repository;

import br.edu.ifam.turismo.hotelservice.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    // O Spring Data cria a query SQL automaticamente só lendo o nome do método!
    Optional<Cidade> findByCodigoIBGE(String codigoIBGE);
}
