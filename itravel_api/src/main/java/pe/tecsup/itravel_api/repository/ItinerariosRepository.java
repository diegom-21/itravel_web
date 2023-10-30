package pe.tecsup.itravel_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.tecsup.itravel_api.model.Itinerarios;

import java.util.Optional;

@Repository
public interface ItinerariosRepository extends JpaRepository<Itinerarios, Integer>{
    Optional<Itinerarios> findById(Integer integer);
}
