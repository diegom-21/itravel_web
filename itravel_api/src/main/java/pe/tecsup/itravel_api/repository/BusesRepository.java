package pe.tecsup.itravel_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.tecsup.itravel_api.model.Buses;

import java.util.Optional;

@Repository
public interface BusesRepository extends JpaRepository<Buses, Integer> {
    Optional<Buses> findByPlaca(String placa);
}
