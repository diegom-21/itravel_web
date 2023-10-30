package pe.tecsup.itravel_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.tecsup.itravel_api.model.Choferes;

import java.util.Optional;

@Repository
public interface ChoferesRepository extends JpaRepository<Choferes, Integer> {

    Optional<Choferes> findById(Integer integer);
}
