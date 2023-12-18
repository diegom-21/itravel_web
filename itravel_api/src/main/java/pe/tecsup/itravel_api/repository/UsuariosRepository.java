package pe.tecsup.itravel_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.tecsup.itravel_api.model.Usuarios;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

    Optional<Usuarios> findByUid(String uid);

    // Nuevo método para buscar un usuario por nombre completo y teléfono
    Optional<Usuarios> findByNombrecompletoAndDni(String nombrecompleto, String dni);

}
