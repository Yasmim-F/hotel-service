package br.edu.ifam.turismo.hotelservice.repository;

import br.edu.ifam.turismo.hotelservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {


}
