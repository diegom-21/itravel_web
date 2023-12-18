package pe.tecsup.itravel_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.tecsup.itravel_api.model.Rutas;

import java.util.List;
import java.util.Optional;

@Repository

public interface RutasRepository extends JpaRepository<Rutas, Integer> {
    Optional<Rutas> findById(Integer integer);

    List<Rutas> findAllByOrigenciudadAndDestinociudad(String origen, String destino);

}
