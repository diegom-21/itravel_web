package pe.tecsup.itravel_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.tecsup.itravel_api.model.Pasajes;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PasajesRepository extends JpaRepository<Pasajes, Integer> {
    Optional<Pasajes> findById(Integer integer);

    @Query("SELECT p FROM Pasajes p JOIN Rutas r ON r.id = p.rutasid WHERE p.fechahorasalida = :fechahorasalida AND r.origenciudad = :origenciudad AND r.destinociudad = :destinociudad")

    List<Pasajes> findByFechaHoraSalidaAndOrigenCiudadAndDestinoCiudad(@Param("fechahorasalida") Date fechahorasalida, @Param("origenciudad") String origenciudad, @Param("destinociudad") String destinociudad);
}