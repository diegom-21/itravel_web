package pe.tecsup.itravel_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.tecsup.itravel_api.model.Boletos;

import java.util.Optional;

@Repository
public interface BoletosRepository extends JpaRepository<Boletos, Integer> {
    Optional<Boletos> findById(Integer integer);
}
